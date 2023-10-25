package org.example.StepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_check_out_as_guest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import static org.example.StepDef.Hooks.*;
public class D03_Check_out_as_guest {
    @Given("The guest add product to the shopping cart")
    public void theGuestAddProductToTheShoppingCart() {
        P03_check_out_as_guest.CartButton().get(1).click();
        WebElement addToCart = P03_check_out_as_guest.CartButton2();
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
    }

    @And("The guest user navigate to the shopping cart")
    public void theGuestUserNavigateToTheShoppingCart() {
        WebElement navCart = P03_check_out_as_guest.CartIcon();
        wait.until(ExpectedConditions.elementToBeClickable(navCart)).click();
    }

    @When("The guest user agrees to the terms and conditions and click on the Check out button")
    public void theGuestUserAgreesToTheTermsAndConditionsAndClickOnTheCheckOutButton() {
        if (!P03_check_out_as_guest.TermsOfService().isSelected()){
            P03_check_out_as_guest.TermsOfService().click();
        }

        P03_check_out_as_guest.Checkout().click();
        P03_check_out_as_guest.CheckoutButton().click();
    }
    @And("The guest user add his details:First Name,Last Name and Email")
    public void theGuestUserAddHisDetailsFirstNameLastNameAndEmail() {
        P03_check_out_as_guest.FirstName().sendKeys(fake.name().firstName());
        P03_check_out_as_guest.LastName().sendKeys(fake.name().lastName());
        P03_check_out_as_guest.Email().sendKeys(fake.internet().emailAddress());
        P03_check_out_as_guest.Company().sendKeys(fake.company().name());
    }

    @And("The guest user select the country and state")
    public void theGuestUserSelectTheCountryAndState() throws InterruptedException{

        WebElement country = P03_check_out_as_guest.CountryId();
        Select selectCountry = new Select(country);
       int num= randomNumber(0,selectCountry.getOptions().size()-1);
        selectCountry.selectByIndex(num);

        Thread.sleep(4000);
        WebElement state = P03_check_out_as_guest.StateProvinceId();
        Select selectState = new Select(state);
        int num1= randomNumber(0,selectState.getOptions().size()-1);
        selectState.selectByIndex(num1);
    }

    @And("The guest user add city and address details")
    public void theGuestUserAddCityAndAddressDetails() {
        P03_check_out_as_guest.City().sendKeys(fake.address().city());
        P03_check_out_as_guest.Address1().sendKeys(fake.address().fullAddress());
        P03_check_out_as_guest.Address2().sendKeys(fake.address().fullAddress());
        P03_check_out_as_guest.ZipPostalCode().sendKeys(fake.address().zipCode());
    }

    @And("The user adds Phone number and Fax")
    public void theUserAddsPhoneNumberAndFax() {
        P03_check_out_as_guest.PhoneNumber().sendKeys(fake.phoneNumber().phoneNumber());
        P03_check_out_as_guest.FaxNumber().sendKeys(fake.phoneNumber().phoneNumber());
    }

    @And("The user clicks on Continue")
    public void theUserClicksOnContinue() {
       P03_check_out_as_guest.Continue().get(0).click();
    }

    @And("The user selects the shipping method and clicks on Continue")
    public void theUserSelectsTheShippingMethodAndClicksOnContinue(){
        int max= P03_check_out_as_guest.ShippingOptions().size()-1;
        int random=randomNumber(0,max);
        P03_check_out_as_guest.ShippingOptions().get(random).click();
        P03_check_out_as_guest.ShippingNext().click();
    }

    @And("The user selects card payment method and clicks on Continue")
    public void theUserSelectsCardPaymentMethodAndClicksOnContinue() {
        P03_check_out_as_guest.PaymentMethod_1().click();
        P03_check_out_as_guest.PaymentNext().click();
    }

    @And("The user add the payment method details {string}")
    public void theUserAddThePaymentMethodDetails(String arg0) {
        WebElement creditCardType = P03_check_out_as_guest.CreditCardType();
        Select selectCreditCardType = new Select(creditCardType);
        int max =selectCreditCardType.getOptions().size()-1;
        int random= randomNumber(0,max);
        selectCreditCardType.selectByIndex(random);

        P03_check_out_as_guest.CardholderName().sendKeys(fake.name().fullName());

        P03_check_out_as_guest.CardNumber().sendKeys(arg0);
        WebElement expireMonth = P03_check_out_as_guest.ExpireMonth();

        int mon= randomNumber(0,11);
        Select selectExpireMonth = new Select(expireMonth);
        selectExpireMonth.selectByIndex(mon);

        int year=randomNumber(0,7);
        WebElement expireYear = P03_check_out_as_guest.ExpireYear();
        Select selectExpireYear = new Select(expireYear);
        selectExpireYear.selectByIndex(year);

        P03_check_out_as_guest.CardCode().sendKeys(fake.number().digits(3));
    }

    @And("The guest user clicks on Confirm")
    public void theGuestUserClicksOnConfirm() {
       P03_check_out_as_guest.PaymentInfoNext().click();
    }

    @Then("The order is confirmed and the user can navigate to order details")
    public void theOrderIsConfirmedAndTheUserCanNavigateToOrderDetails() {
        P03_check_out_as_guest.ConfirmNext().click();

        boolean result = P03_check_out_as_guest.OrderNumber().getText().toLowerCase().contains("order number:");
        soft.assertTrue(result);

        P03_check_out_as_guest.CartIcon().click();
        soft.assertEquals(P03_check_out_as_guest.CartEmpty().getText().toLowerCase(),"your shopping cart is empty!".toLowerCase());
        soft.assertAll();
    }

    @And("The user selects the check payment method and clicks on Continue")
    public void theUserSelectsTheCheckPaymentMethodAndClicksOnContinue() {
        P03_check_out_as_guest.PaymentMethod_0().click();
        P03_check_out_as_guest.PaymentNext().click();
    }
}
