package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.ServerConfig;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.Locators;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class Main extends Locators{

    final static Logger logger = LogManager.getLogger(Main.class);//подключили логгер
    ServerConfig cfg = ConfigFactory.create(ServerConfig.class);//теперь можно использовать owner


    @Given("^main page open$")
    public void mainPageOpen() {
        open(cfg.url());
        logger.info("Page "+cfg.url()+ " opened");
        $(byText("Принять")).click();
    }

    @When("^User navigates to the \"([^\"]*)\" tab$")
    public void userNavigatesToTheTab(String elementText) {
        sleep(5000);

        $(By.xpath(String.format(mainMenuElements, elementText))).click();
        logger.info("Click to "+elementText);

    }

    @And("^User clicks on \"([^\"]*)\" button$")
    public void userClicksOnButton(String elementText) {

        SelenideElement element = $(By.xpath(String.format(buttonEventsByDate, elementText)));
        element.shouldBe(Condition.exist);
        String value = $(By.xpath(String.format(buttonEventsByDateForStatus, elementText))).getAttribute("class").toString();//получаем значение класса, чтобы увидеть активна ли кнопка

        boolean status = value.contains("active");

        if(status){
            System.out.println("Button "+elementText+" is selected");
        }
        else element.click();
        logger.info("Click to "+elementText);
    }

    @Then("^Number of cards is equal to the counter on the \"([^\"]*)\" button$")
    public void numberOfCardsIsEqualToTheCounterOnTheButton(String elementText) {
        int countByButton = Integer.parseInt($(By.xpath(String.format(countByButtonEventsByDate, elementText))).getText());
        //получаем значение рядом с кнопкой в виде текста и преобразуем в число
        System.out.println(countByButton);

        ElementsCollection elements = $$(By.xpath("//h3[text()='All Events']//following-sibling::div//div[@class='evnt-card-wrapper']"));
        int countByCards = elements.size();
        Assert.assertEquals("Значения не совпадают", countByButton, countByCards);

    }

    @Then("^The card contains information about the event$")
    public void theCardContainsInformationAboutTheEvent(DataTable dataTable) {
        int size = dataTable.cells().size();
        List<List<String>> table = dataTable.asLists(String.class);

        for(int i =1; i < size; i++ ) {
            String elementType = table.get(i).get(0);
            //String elementNumber = table.get(i).get(1);
            $(By.xpath(String.format(cardElementByText, elementType, elementType))).shouldBe(Condition.exist);
        }

    }

    @Then("^Dates are within the current week$")
    public void datesAreWithinTheCurrentWeek() throws ParseException {
        String date = $(By.xpath("//span[@class='date']")).getText();
        String[] dates = date.split("- ");
        Date dateOfEvent = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(dates[1]);
        Date currentDate = new Date();
        Assert.assertTrue((currentDate.before(dateOfEvent))||(currentDate.equals(dateOfEvent)));
        //проверяем, что текущая дата раньше, чем дата ивента
    }

    @Then("^The user clicks on \"([^\"]*)\" in the filter box and selects \"([^\"]*)\" in the dropdown$")
    public void theUserClicksOnInTheFilterBoxAndSelectsInTheDropdown(String filterText, String dropdownElement) {
        $(By.xpath(String.format(filterByText, filterText))).click();
        $(By.xpath(String.format(dropdownElementByText, dropdownElement))).click();
        $(byText("All Events"));
    }

    @Then("Event dates are greater than or equal to the current date")
    public void eventDatesAreGreaterThanOrEqualToTheCurrentDate() throws ParseException {
        ElementsCollection allDates = $$(By.xpath("//span[@class='date']"));
        for(int i=0; i < allDates.size(); i++) {
            String date = allDates.get(i).getText();
            String[] dates = date.split("- ");
            Date dateOfEvent = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(dates[1]);
            Date currentDate = new Date();
            Assert.assertTrue((currentDate.before(dateOfEvent)) || (currentDate.equals(dateOfEvent)));
            //проверяем, что текущая дата раньше, чем дата ивента
        }
    }

    @Then("Event dates are less than or equal to the current date")
    public void eventDatesAreLessThanOrEqualToTheCurrentDate() throws ParseException {
        sleep(5000);
        ElementsCollection allDates = $$(By.xpath("//span[@class='date']"));

        for(int i=0; i < allDates.size(); i++) {
            String date = allDates.get(i).getText();
            String[] dates = date.split("- ");
            Date dateOfEvent = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(dates[1]);
            Date currentDate = new Date();
            Assert.assertTrue((currentDate.after(dateOfEvent)) || (currentDate.equals(dateOfEvent)));
            //проверяем, что текущая дата раньше, чем дата ивента
        }
    }

    @And("User clicks on {int} card")
    public void userClicksOnCard(int number) {
        ElementsCollection cardsOfEvents = $$(byClassName("evnt-event-name"));

        if(cardsOfEvents.size()<number){
            System.out.println("карточек на странице меньше, чем "+number);
        }
        else cardsOfEvents.get(number+1).click();
    }
}
