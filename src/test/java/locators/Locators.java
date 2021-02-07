package locators;

import org.openqa.selenium.By;

public class Locators {

    public String mainMenuElements = "//ul[@class='evnt-navigation navbar-nav']//a[text()='%s']";
    public String buttonEventsByDate = "//span[@class='evnt-tab-text desktop' and text()='%s']";
    public String buttonEventsByDateForStatus = "//span[@class='evnt-tab-text desktop' and text()='%s']/parent::a";
    public String countByButtonEventsByDate = "//span[text()='%s']/following-sibling::span[2]";
    public String cardElementByText = "//div[@class = 'evnt-card-wrapper']//*[@class='%s'] | //div[@class = 'evnt-card-wrapper']//*[contains(text(), '%s')]";
    public String filterByText = "//span[@class='evnt-filter-text' and text()='%s']";
    public String dropdownElementByText = "//div[@class='evnt-filter-menu-scroll']//label[text()='%s']";









}
