package hooks;

import config.ServerConfig;
import gherkin.formatter.model.Scenario;
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

public class Hooks {


    @Before
    public void setUp(){

        System.out.println("Запуск нового сценария");

        //WebDriverWait wait;
        Logger logger = LogManager.getLogger(Hooks.class);//подключили логгер
        ServerConfig cfg = ConfigFactory.create(ServerConfig.class);//теперь можно использовать owner


        WebDriverManager.chromedriver().setup();//используем WebDriverManager
        //WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //logger.info("Драйвер инициализирован");

        //open("https://github.com/");
        open(cfg.url());
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

