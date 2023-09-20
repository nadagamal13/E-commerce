package org.example.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.example.StepDef.Hooks.*;
public class CheckOutPage{
    public static List<WebElement> CartButton(){
        return driver.findElements(By.className("product-box-add-to-cart-button"));
    }
   public static WebElement CartButton2(){
       return driver.findElement(By.cssSelector("button[class=\"button-1 add-to-cart-button\"]"));
   }
   public static WebElement CartIcon(){
        return driver.findElement(By.className("ico-cart"));
   }
public static WebElement TermsOfService(){
    return driver.findElement(By.id("termsofservice"));
}
public static WebElement Checkout(){
        return driver.findElement(By.id("checkout"));
}
public static WebElement CheckoutButton(){

        return driver.findElement(By.className("checkout-as-guest-button"));
}
public static WebElement CountryId(){
        return driver.findElement(By.id("BillingNewAddress_CountryId"));
}
public static WebElement StateProvinceId(){
        return driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
}
public static List<WebElement> Continue(){
        return driver.findElements(By.name("save"));
}
public static List<WebElement> ShippingOptions(){
        return driver.findElements(By.className("method-name"));
}
public static WebElement ShippingNext(){
        return driver.findElement(By.className("shipping-method-next-step-button"));
}
public static WebElement PaymentMethod_1(){
        return driver.findElement(By.id("paymentmethod_1"));
}
public static WebElement PaymentNext(){
        return driver.findElement(By.className("payment-method-next-step-button"));
}
public static WebElement PaymentInfoNext(){
        return driver.findElement(By.className("payment-info-next-step-button"));
}
public static WebElement ConfirmNext(){
        return driver.findElement(By.className("confirm-order-next-step-button"));
}
public static WebElement FirstName(){
        return driver.findElement(By.id("BillingNewAddress_FirstName"));
}
public static WebElement LastName(){
        return driver.findElement(By.id("BillingNewAddress_LastName"));
}
public static WebElement Email(){
        return driver.findElement(By.id("BillingNewAddress_Email"));
}
public static WebElement Company(){
        return driver.findElement(By.id("BillingNewAddress_Company"));
}
public static WebElement City(){
        return driver.findElement(By.id("BillingNewAddress_City"));
}
public static WebElement Address1(){
        return driver.findElement(By.id("BillingNewAddress_Address1"));
}
public static WebElement Address2(){
        return driver.findElement(By.id("BillingNewAddress_Address2"));
}
public static WebElement ZipPostalCode(){
        return driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
}
public static WebElement PhoneNumber(){
        return driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
}
public static WebElement FaxNumber(){
        return driver.findElement(By.id("BillingNewAddress_FaxNumber"));
}
public static WebElement CreditCardType(){
        return driver.findElement(By.id("CreditCardType"));
}
public static WebElement CardholderName(){
        return driver.findElement(By.id("CardholderName"));
}
public static WebElement CardNumber(){
        return driver.findElement(By.id("CardNumber"));
}
public static WebElement ExpireMonth(){
        return driver.findElement(By.id("ExpireMonth"));
}
public static WebElement ExpireYear(){
        return driver.findElement(By.id("ExpireYear"));
}
public static WebElement CardCode(){
        return driver.findElement(By.id("CardCode"));
}
public static WebElement OrderNumber(){
    return driver.findElement(By.className("order-number"));
}
public static WebElement CartEmpty(){
    return driver.findElement(By.className("no-data"));
}
public static WebElement PaymentMethod_0(){
        return driver.findElement(By.id("paymentmethod_0"));
    }
}
