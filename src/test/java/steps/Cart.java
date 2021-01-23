package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import locators.Locators;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Cart extends Locators {
    @И("Пользователь хочет добавить")
    public void пользовательХочетДобавить(DataTable dataTable) {
        int size = dataTable.cells().size();
        List<List<String>> table = dataTable.asLists(String.class);

        for(int i =0; i < size; i++ ) {

            String placeholderText = table.get(i).get(0);
            System.out.println(placeholderText);
            String inputText = table.get(i).get(1);
            System.out.println(inputText);

            $(By.xpath(String.format(inputByPlaceholder, placeholderText))).sendKeys(inputText);

            sleep(5000000);
        }
    }

    @И("Пользователь хочет нажать на кнопку {string}")
    public void пользовательХочетНажатьНаКнопку(String buttonText) {
        $(byText(buttonText)).scrollIntoView(true).click();
    }

    @Тогда("Пользователь ожидает сообщение {string}")
    public void пользовательОжидаетСообщение(String message) {
        $(byText("Ваш заказ принят!")).shouldBe(Condition.visible);
        sleep(5000);
    }
}
