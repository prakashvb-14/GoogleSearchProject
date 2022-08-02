package cucumberOptions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/SearchFunctionalityFlow.feature",
        glue = "stepDefinitions",
        plugin = { "pretty", "json:target/cucumber/report.json",
                "junit:target/cucumber/report.xml",
                "html:target/cucumber/report.html"},
        tags = "@Sanity and @Regression")

public class TestRunner {

}

