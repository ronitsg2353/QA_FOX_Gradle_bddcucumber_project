package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature",
                    dryRun = false,
                    monochrome = true,
                    tags = "@Ronit",
                    glue = {"Step_Defination","Hook"},
                  plugin = { "pretty","html:Target/cucumber_report/cucumberReport7.html"}
)
public class MyRun {

}
