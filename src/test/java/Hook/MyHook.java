package Hook;

import DriverFactory.DriverFactory;
import Util.configReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class MyHook {
    public static WebDriver driver;

    @Before
    public void setup() throws IOException {
       Properties pro= configReader.intialzeProperties();
        DriverFactory.intializeBrowser(pro.getProperty("browser"));
        driver=DriverFactory.getDriver();
        driver.manage().deleteAllCookies();
        driver.get(pro.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    @After
    public void tearDown(Scenario sc) throws IOException {
        System.out.println("TearDown method executd");

        if(sc.isFailed()==true){
            String filepath="C:\\Users\\LENOVO\\IdeaProjects\\QA-fox_cucumber_hybrid_framework\\src\\test\\resources\\Screenshots\\test1.png";
            TakesScreenshot srnshot=((TakesScreenshot) driver);

               File srnfile= srnshot.getScreenshotAs(OutputType.FILE);

               File destfile=new File(filepath);

        }

        driver.quit();
    }
}
