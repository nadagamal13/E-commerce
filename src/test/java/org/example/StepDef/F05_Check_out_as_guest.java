package org.example.StepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.CheckOutPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import static org.example.StepDef.Hooks.*;


public class F05_Check_out_as_guest {
    @Given("The guest add product to the shopping cart")
    public void theGuestAddProductToTheShoppingCart() {
        CheckOutPage.CartButton().get(1).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement addToCart = CheckOutPage.CartButton2();
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
    }

    @And("The guest user navigate to the shopping cart")
    public void theGuestUserNavigateToTheShoppingCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement navCart = CheckOutPage.CartIcon();
        wait.until(ExpectedConditions.elementToBeClickable(navCart)).click();
    }

    @When("The guest user agrees to the terms and conditions and click on the Check out button")
    public void theGuestUserAgreesToTheTermsAndConditionsAndClickOnTheCheckOutButton() {
        if (!CheckOutPage.TermsOfService().isSelected()){
            CheckOutPage.TermsOfService().click();
        }

        CheckOutPage.Checkout().click();
        CheckOutPage.CheckoutButton().click();
    }
    @And("The guest user add his details:First Name,Last Name and Email")
    public void theGuestUserAddHisDetailsFirstNameLastNameAndEmail() {
        CheckOutPage.FirstName().sendKeys(fake.name().firstName());
        CheckOutPage.LastName().sendKeys(fake.name().lastName());
        CheckOutPage.Email().sendKeys(fake.internet().emailAddress());
        CheckOutPage.Company().sendKeys(fake.company().name());
    }

    @And("The guest user select the country and state")
    public void theGuestUserSelectTheCountryAndState() throws InterruptedException{

        WebElement country = CheckOutPage.CountryId();
        Select selectCountry = new Select(country);
       int num= randomNumber(0,selectCountry.getOptions().size()-1);
        selectCountry.selectByIndex(num);

        Thread.sleep(4000);
        WebElement state = CheckOutPage.StateProvinceId();
        Select selectState = new Select(state);
        int num1= randomNumber(0,selectState.getOptions().size()-1);
        selectState.selectByIndex(num1);
    }

    @And("The guest user add city and address details")
    public void theGuestUserAddCityAndAddressDetails() {
        CheckOutPage.City().sendKeys(fake.address().city());
        CheckOutPage.Address1().sendKeys(fake.address().fullAddress());
        CheckOutPage.Address2().sendKeys(fake.address().fullAddress());
        CheckOutPage.ZipPostalCode().sendKeys(fake.address().zipCode());
    }

    @And("The user adds Phone number and Fax")
    public void theUserAddsPhoneNumberAndFax() {
        CheckOutPage.PhoneNumber().sendKeys(fake.phoneNumber().phoneNumber());
        CheckOutPage.FaxNumber().sendKeys(fake.phoneNumber().phoneNumber());
    }

    @And("The user clicks on Continue")
    public void theUserClicksOnContinue() {
       CheckOutPage.Continue().get(0).click();
    }

    @And("The user selects the shipping method and clicks on Continue")
    public void theUserSelectsTheShippingMethodAndClicksOnContinue(){
        int max= CheckOutPage.ShippingOptions().size()-1;
        int random=randomNumber(0,max);
        CheckOutPage.ShippingOptions().get(random).click();
        CheckOutPage.ShippingNext().click();
    }

    @And("The user selects card payment method and clicks on Continue")
    public void theUserSelectsCardPaymentMethodAndClicksOnContinue() {
        CheckOutPage.PaymentMethod_1().click();
        CheckOutPage.PaymentNext().click();
    }

    @And("The user add the payment method details {string}")
    public void theUserAddThePaymentMethodDetails(String arg0) {
        WebElement creditCardType = CheckOutPage.CreditCardType();
        Select selectCreditCardType = new Select(creditCardType);
        int max =selectCreditCardType.getOptions().size()-1;
        int random= randomNumber(0,max);
        selectCreditCardType.selectByIndex(random);

        CheckOutPage.CardholderName().sendKeys(fake.name().fullName());

        CheckOutPage.CardNumber().sendKeys(arg0);
        WebElement expireMonth = CheckOutPage.ExpireMonth();

        int mon= randomNumber(0,11);
        Select selectExpireMonth = new Select(expireMonth);
        selectExpireMonth.selectByIndex(mon);

        int year=randomNumber(0,7);
        WebElement expireYear = CheckOutPage.ExpireYear();
        Select selectExpireYear = new Select(expireYear);
        selectExpireYear.selectByIndex(year);

        CheckOutPage.CardCode().sendKeys(fake.number().digits(3));
    }

    @And("The guest user clicks on Confirm")
    public void theGuestUserClicksOnConfirm() {
       CheckOutPage.PaymentInfoNext().click();
    }

    @Then("The order is confirmed and the user can navigate to order details")
    public void theOrderIsConfirmedAndTheUserCanNavigateToOrderDetails() {
        CheckOutPage.ConfirmNext().click();

        SoftAssert soft=new SoftAssert();
        boolean result = CheckOutPage.OrderNumber().getText().toLowerCase().contains("order number:");
        soft.assertTrue(result);

        CheckOutPage.CartIcon().click();
        soft.assertEquals(CheckOutPage.CartEmpty().getText().toLowerCase(),"your shopping cart is empty!".toLowerCase());
        soft.assertAll();
    }

    @And("The user selects the check payment method and clicks on Continue")
    public void theUserSelectsTheCheckPaymentMethodAndClicksOnContinue() {
        CheckOutPage.PaymentMethod_0().click();
        CheckOutPage.PaymentNext().click();
    }
}
