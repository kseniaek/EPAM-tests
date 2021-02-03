package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
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
import java.util.List;

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
    }

    @When("^User navigates to the \"([^\"]*)\" tab$")
    public void userNavigatesToTheTab(String elementText) {
        sleep(5000);

        $(By.xpath(String.format(mainMenuElements, elementText))).click();
        logger.info("Click to "+elementText);

    }

    @And("^User clicks on \"([^\"]*)\" button$")
    public void userClicksOnButton(String elementText) {
        sleep(5000);
        SelenideElement element = $(By.xpath(String.format(buttonEventsByDate, elementText)));
        String value = $(By.xpath(String.format(buttonEventsByDateForStatus, elementText))).getAttribute("class").toString();//получаем значение класса, чтобы увидеть активна ли кнопка

        boolean status = value.contains("active");

        if(status){
            System.out.println("Button "+elementText+" is selected");
        }
        else element.click();
        logger.info("Click to "+elementText);
    }

    @Then("^Page displays cards$")
    public void pageDisplaysCards() {
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
    public void theCardContainsInformationAboutTheEvent() {
    }

    @Then("^In the \"([^\"]*)\" block the dates of events are greater than or equal to the current date$")
    public void inTheBlockTheDatesOfEventsAreGreaterThanOrEqualToTheCurrentDate(String arg0) {

    }

    @Then("^Dates are within the current week$")
    public void datesAreWithinTheCurrentWeek() {
    }

    @Then("^The user clicks on \"([^\"]*)\" in the filter box and selects \"([^\"]*)\" in the dropdown$")
    public void theUserClicksOnInTheFilterBoxAndSelectsInTheDropdown(String arg0, String arg1) {

    }

    @And("^User clicks on \"([^\"]*)\" card$")
    public void userClicksOnCard(String arg0)  {

    }

    @Then("^Goes to a page with detailed information about the event$")
    public void goesToAPageWithDetailedInformationAboutTheEvent() {
    }

    @Then("^Page displays blocks with$")
    public void pageDisplaysBlocksWith() {
    }
}
