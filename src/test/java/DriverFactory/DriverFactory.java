package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class DriverFactory {
static WebDriver driver=null;
    public static WebDriver intializeBrowser(String browserName) {
        if(browserName.equals("chrome"))
        {
        driver = new ChromeDriver();


    } else if (browserName.equals("firefox")) {
            driver=new FirefoxDriver();
        }
        else {
            System.out.println("please choose between chrome and firefox");
        }

        return driver;
    }

        public static WebDriver getDriver(){

        return driver;
        }
    }