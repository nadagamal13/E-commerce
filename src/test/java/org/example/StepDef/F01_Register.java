package org.example.StepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.example.Pages.RegisterPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import static org.example.StepDef.Hooks.*;

public class F01_Register {
    HomePage HomePage=new HomePage();
    @Given("The user clicks on Register")
    public void NavigateToRegister ()
    {
        HomePage.RegisterNowBtn.click();
    }

    @When("User selects gender")
    public void userSelectsGender() {
        int random=randomNumber(0,1);
        RegisterPage.Gender().get(random).click();
    }

    @And("User enters first name, last name, and selects date of birth")
    public void userEntersFirstNameLastNameAndSelectsDateOfBirth() {
        RegisterPage.FirstNameField().sendKeys(fake.name().firstName());
        RegisterPage.LastNameField().sendKeys(fake.name().lastName());

        WebElement day = RegisterPage.DaySelect();
        Select selectDay = new Select(day);
        int randomDay= randomNumber(1,selectDay.getOptions().size()-1);
        selectDay.selectByIndex(randomDay);

        WebElement month = RegisterPage.MonthSelect();
        Select selectMonth = new Select(month);
        int randomMonth= randomNumber(1,selectMonth.getOptions().size()-1);
        selectMonth.selectByIndex(randomMonth);

        WebElement year = RegisterPage.YearSelect();
        Select selectYear= new Select(year);
        int randomYear= randomNumber(1,selectYear.getOptions().size()-1);
        selectYear.selectByIndex(randomYear);
    }

    @And("User enters a valid email")
    public void userEntersAValidEmail() {
        RegisterPage.EmailField().sendKeys(fake.internet().emailAddress());
    }

    @And("User enters company name")
    public void userEntersCompanyName() {
        RegisterPage.CompanyField().sendKeys(fake.company().name());
    }

    @And("User selects newsletter")
    public void userSelectsNewsletter() {
        if (!RegisterPage.NewsLetterBtn().isSelected()){
            RegisterPage.NewsLetterBtn().click();
        }
    }

    @And("User enters password and confirms it")
    public void userEntersPasswordAndConfirmsIt() {
        String password = fake.internet().password();
        RegisterPage.PasswordField().sendKeys(password);
        RegisterPage.ConfirmPasswordField().sendKeys(password);
    }

    @And("User clicks the register button")
    public void userClicksTheRegisterButton() throws InterruptedException {
        Thread.sleep(5000);
        RegisterPage.RegistrationBtn().click();
    }
    @Then("New account is created")
    public void newAccountIsCreated() {
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(RegisterPage.ConfirmationMsg().getText().toLowerCase(),"your registration completed".toLowerCase());
        soft.assertAll();
    }
}
