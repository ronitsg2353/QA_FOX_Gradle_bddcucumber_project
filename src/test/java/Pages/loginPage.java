package Pages;

import Constant.constants;
import Hook.MyHook;
import Util.configReader;
import io.cucumber.core.options.Constants;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Properties;

public class loginPage {
    WebDriver driver;

    Properties prop= configReader.TestDataReader();


    public loginPage(WebDriver driver) throws IOException {
        this.driver= MyHook.driver;
        PageFactory.initElements(this.driver,this);
    }

@FindBy(id="input-email")
WebElement emailinput;

@FindBy(id="input-password")
WebElement passwordinput;

@FindBy(xpath ="//input[@type='submit']")
WebElement submitbtn;

@FindBy(xpath ="//div[@class='alert alert-danger alert-dismissible']")
WebElement errorinvalidusrpass;

public void clickemail(String validemail) throws IOException{
  String Email1=  prop.getProperty("validemail");
    this.emailinput.sendKeys(Email1);
}

public void clickpassword(String validpass){
    String Password1=prop.getProperty("validpass");
    this.passwordinput.sendKeys(Password1);
}

public void clicksubmit(){
this.submitbtn.click();
}

public void Displayerrorinvalidusrpass(){
    this.errorinvalidusrpass.isDisplayed();
    String invlidalert="Warning: No match for E-Mail Address and/or Password.";
    Assert.assertEquals(constants.invusrpass, invlidalert);
}

public void invalidemail(String invalidemail){

  String invemail=  prop.getProperty("invalidemail");
  this.emailinput.sendKeys(invemail);
}

public void invalidpass(String invalidpass){
    String invpass=prop.getProperty("invalidpass");
    this.passwordinput.sendKeys(invpass);
}

}
