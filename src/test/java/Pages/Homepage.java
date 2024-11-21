package Pages;

import Hook.MyHook;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Homepage {

     WebDriver driver;
    public Homepage(WebDriver driver){
        this.driver= MyHook.driver;
        PageFactory.initElements(this.driver, this);
    }
    @FindBy(xpath ="//span[text()='My Account']")
     WebElement myaccount;

    @FindBy(linkText ="Login")
    WebElement loginbtn;
public void clickonmyaccount(){
       myaccount.click();
}
    public void loginclick(){
        this.loginbtn.click();
    }
}