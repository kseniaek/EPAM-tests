package steps;

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
import org.openqa.selenium.By;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class Main extends Locators{

    Logger logger = LogManager.getLogger(Main.class);//подключили логгер
    ServerConfig cfg = ConfigFactory.create(ServerConfig.class);//теперь можно использовать owner


    @Given("^main page open$")
    public void mainPageOpen() {
        open(cfg.url());
    }

    @When("^User navigates to the \"([^\"]*)\" tab$")
    public void userNavigatesToTheTab(String MenuPointText) {
        $(By.xpath(String.format(mainMenuElements, MenuPointText))).click();

    }

    @And("^User clicks on \"([^\"]*)\" button$")
    public void userClicksOnButton(String arg0) {

    }

    @Then("^Page displays cards$")
    public void pageDisplaysCards() {
    }

    @Then("^Number of cards is equal to the counter on the \"([^\"]*)\" button$")
    public void numberOfCardsIsEqualToTheCounterOnTheButton(String arg0) {

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
