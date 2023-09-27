package org.example.StepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;
import org.example.Pages.P01_register;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import static org.example.StepDef.Hooks.*;
public class D01_registerStepDef {
    P03_homePage HomePage=new P03_homePage();
    @Given("user go to register page")
    public void userGoToRegisterPage() {
        HomePage.RegisterNowBtn.click();
    }
    @When("user select gender type")
    public void userSelectGenderType() {
        int random=randomNumber(0,1);
        P01_register.Gender().get(random).click();
    }
    @And("User enters first name, last name, and selects date of birth")
    public void userEntersFirstNameLastNameAndSelectsDateOfBirth() {
        P01_register.FirstNameField().sendKeys(fake.name().firstName());
        P01_register.LastNameField().sendKeys(fake.name().lastName());

        WebElement day = P01_register.DaySelect();
        Select selectDay = new Select(day);
        int randomDay= randomNumber(1,selectDay.getOptions().size()-1);
        selectDay.selectByIndex(randomDay);

        WebElement month = P01_register.MonthSelect();
        Select selectMonth = new Select(month);
        int randomMonth= randomNumber(1,selectMonth.getOptions().size()-1);
        selectMonth.selectByIndex(randomMonth);

        WebElement year = P01_register.YearSelect();
        Select selectYear= new Select(year);
        int randomYear= randomNumber(1,selectYear.getOptions().size()-1);
        selectYear.selectByIndex(randomYear);
    }
    @And("User enters a valid email")
    public void userEntersAValidEmail() throws IOException {
        String email= fake.internet().safeEmailAddress();
        P01_register.EmailField().sendKeys(email);
        configuration.set("email",email);
    }
    @And("User enters company name")
    public void userEntersCompanyName() {
        P01_register.CompanyField().sendKeys(fake.company().name());
    }
    @And("User selects newsletter")
    public void userSelectsNewsletter() {
        if (!P01_register.NewsLetterBtn().isSelected()){
            P01_register.NewsLetterBtn().click();
        }
    }
    @And("User enters password and confirms it")
    public void userEntersPasswordAndConfirmsIt() throws IOException {
        String password = fake.internet().password();
        P01_register.PasswordField().sendKeys(password);
        P01_register.ConfirmPasswordField().sendKeys(password);
        configuration.set("password",password);
    }
    @And("User clicks on register button")
    public void userClicksOnRegisterButton() throws InterruptedException {
        Thread.sleep(5000);
        P01_register.RegistrationBtn().click();
    }
    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(P01_register.ConfirmationMsg().getText().toLowerCase(),"your registration completed".toLowerCase());
        soft.assertEquals(P01_register.ConfirmationMsg().getCssValue("color"),"rgba(76, 177, 124, 1)");
        soft.assertAll();
    }
}
