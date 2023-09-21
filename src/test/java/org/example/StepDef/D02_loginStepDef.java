package org.example.StepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.example.Pages.P02_login;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import static org.example.StepDef.Hooks.*;
public class D02_loginStepDef {
    P02_login login=new P02_login();
    HomePage HomePage=new HomePage();
    @Given("user go to login page")
    public void userGoToLoginPage() {
        HomePage.Login.click();
    }
    @When("User enters valid email and password")
    public void userEntersValidEmailAndPassword() throws IOException {
String email=configuration.get("email");
String password=configuration.get("password");
login.email.sendKeys(email);
login.password.sendKeys(password);
    }
    @And("User clicks on Login")
    public void userClicksOnLogin() {
        login.loginButton.click();
    }
    @Then("User login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        boolean myAccount= login.myAccount.isDisplayed();
        soft.assertTrue(myAccount);
        soft.assertAll();
    }
    @When("User enters invalid email")
    public void userEntersInvalidEmail() {
        login.email.sendKeys(fake.internet().emailAddress());
    }
    @And("User enters random password")
    public void userEntersRandomPassword() {
        login.password.sendKeys(fake.internet().password());
    }
    @Then("User could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        SoftAssert soft=new SoftAssert();
        boolean Msg=login.errorMsg.getText().toLowerCase().contains("login was unsuccessful".toLowerCase());
        soft.assertTrue(Msg);
        soft.assertEquals(login.errorMsg.getCssValue("color"),"rgba(228, 67, 75, 1)");
        soft.assertAll();
    }
}
