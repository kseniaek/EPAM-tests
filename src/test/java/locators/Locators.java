package locators;

import org.openqa.selenium.By;

public class Locators {
    public String cartButtonByGoodText = "//span[text()='%s']/ancestor::div[@class= 'good']/div[@class='serving']//div[text()='%s']/following-sibling::a";
    public String categoriesMenuByClassAndText = "//div[@class='categories_menu']//a[text()='%s']";

    //input in cart
    public String inputByPlaceholder = "//textarea[@placeholder='%s']";


}
