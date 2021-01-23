package steps;

import config.ServerConfig;
import io.cucumber.java.ru.Дано;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Login {
    ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Дано("Авторизованный пользователь")
    public void авторизованныйПользователь() {

        //driver.get(cfg.login());
        //open("https://freshroll-tomsk.ru/login");
        $(byText("Войти")).click();
        $(By.name("email")).sendKeys(cfg.login());
        $(By.name("password")).sendKeys(cfg.password());
        $(By.xpath("//input[@type='submit']")).click();

    }
}
