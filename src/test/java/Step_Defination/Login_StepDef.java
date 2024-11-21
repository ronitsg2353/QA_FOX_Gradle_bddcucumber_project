package Step_Definition;

import DriverFactory.DriverFactory;
import Pages.Homepage;
import Pages.loginPage;
import dev.failsafe.internal.util.Durations;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


public class Login_StepDef {
 WebDriver driver;
loginPage loginpage=new loginPage(driver);
Homepage homepage1=new Homepage(driver);

    public Login_StepDef() throws IOException {
    }


    @Given("user has navigated to login page")
    public void user_has_navigated_to_login_page() throws InterruptedException {
        driver= DriverFactory.getDriver();
    this.homepage1.clickonmyaccount();
       this.homepage1.loginclick();

    }
    @When("user enter valid email address {string} into email field")
    public void userEnterValidEmailAddressIntoEmailField(String Email1) throws IOException {
    loginpage.clickemail(Email1);
    }

    @When("user has enter valid password {string} into password field")
    public void user_has_enter_valid_password_into_password_field(String Password1) {
        this.loginpage.clickpassword(Password1);
    }

    @When("user click on login button")
    public void user_click_on_login_button() {
        this.loginpage.clicksubmit();

    }

    @Then("user should get succesfully logged in")
    public void user_should_get_succesfully_logged_in() {
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

    }


    @When("user enter invalid email address {string} into email field")
    public void userEnterInvalidEmailAddressIntoEmailField(String Email2) throws IOException {

    this.loginpage.invalidemail(Email2);
    }

    @And("user has enter invalid password {string} into password field")
    public void userHasEnterInvalidPasswordIntoPasswordField(String Password2) {
      this.loginpage.invalidpass(Password2);
        this.loginpage.clicksubmit();
    }

    @Then("user should get error message")
    public void userShouldGetErrorMessage() {
        this.loginpage.Displayerrorinvalidusrpass();
    }
}
