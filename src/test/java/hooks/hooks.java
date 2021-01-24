package hooks;

import config.ServerConfig;
import io.cucumber.java.*;
import io.cucumber.plugin.event.Node;
import io.cucumber.plugin.event.Step;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;


public class hooks {
    @Before
    public void setUp(Scenario scenario){

        System.out.println("Запуск нового сценария");

        WebDriverManager.chromedriver().setup();//используем WebDriverManager
        //WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //logger.info("Драйвер инициализирован");

        System.out.println("Запуск выполнения сценария: " + scenario.getName());

        //open("https://github.com/");
        //open(cfg.url());
        //logger.info("Открыта страница freshroll");
        //driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        clearBrowserLocalStorage();
        clearBrowserCookies();
        System.out.println("Сценарий завершен");
    }
}
