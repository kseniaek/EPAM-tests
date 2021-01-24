package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"html:target/cucumber-report/smoke", "json:target/cucumber.json"},
        features = "src/test/java/features",
        glue = {"src/test/java/steps", "src/test/java/hooks"},
        tags = "@test",
        dryRun = false,
        strict = false,
        snippets = SnippetType.UNDERSCORE

//        name = "^Успешное|Успешная.*"
)

public class RunnerTest {

}
