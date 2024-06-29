package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(


        plugin = {

                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-reports/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },


        features = "./src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        dryRun = false,    // no need to go and open the browser. Generates the missing step definitions.
        tags = "@api"

)
public class Runner {
}

    /*
            In Cucumber, mostly focus is on reusable steps.
            ADD: Reports plugins
     */