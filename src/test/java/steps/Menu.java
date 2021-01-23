package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import locators.Locators;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Menu extends Locators {
    @И("Пользователь нажимает пункт верхнего меню {string}")
    public void пользовательНажимаетПунктВерхнегоМеню(String elementText) {

        $(byText(elementText)).scrollIntoView(true).click();
    }

    @И("Пользователь нажимает категорию меню {string}")
    public void пользовательНажимаетКатегориюМеню(String elementText) {
        $(By.xpath(String.format(categoriesMenuByClassAndText, elementText))).scrollIntoView(false).click();
    }

    @И("Пользователь хочет добавить в корзину")
    public void пользовательХочетДобавитьВКорзину(DataTable dataTable) {


        int size = dataTable.cells().size();
        List<List<String>> table = dataTable.asLists(String.class);

        for(int i =1; i < size; i++ ) {

            /*String cartCount =$(By.xpath("//a[@class='cart']/span[@class='count']")).getText();
            int count = Integer.parseInt(cartCount);
            System.out.println(count);*/

            String elementText = table.get(i).get(0);
            System.out.println(elementText);
            String elementNumber = table.get(i).get(1);
            System.out.println(elementNumber);

            $(By.xpath(String.format(cartButtonByGoodText, elementText, elementNumber+" шт."))).scrollIntoView(false).click();

            /*String cartCountAfter = $("count").getText();
            int count2 = Integer.parseInt(cartCount);
            System.out.println(count2);
            Assert.assertTrue(count+1==count2);*/
        }



    }

}
