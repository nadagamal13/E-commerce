package org.example.StepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import org.testng.asserts.SoftAssert;
import static org.example.StepDef.Hooks.*;

public class F02_Login {
    LoginPage login=new LoginPage();
    HomePage HomePage=new HomePage();

    @Given("The user clicks on Login")
    public void theUserClicksOnLogin() {
        HomePage.Login.click();
    }

    @When("User enters valid email {string} and password {string}")
    public void userEntersValidEmailAndPassword(String arg0, String arg1) {

    }

    @And("User clicks on Login")
    public void userClicksOnLogin() {
        login.loginButton.click();
    }

    @Then("User login function is succeed")
    public void userLoginFunctionIsSucceed() {
    }

    @When("User enters invalid email")
    public void userEntersInvalidEmail() {
        login.email.sendKeys(fake.internet().emailAddress());
    }

    @And("User enters random password")
    public void userEntersRandomPassword() {
        login.password.sendKeys(fake.internet().password());
    }

    @Then("User login function is Failed")
    public void userLoginFunctionIsFailed() {
        SoftAssert soft=new SoftAssert();
        boolean Msg=login.errorMsg.getText().toLowerCase().contains("login was unsuccessful".toLowerCase());
        soft.assertTrue(Msg);
        soft.assertAll();
    }
}
