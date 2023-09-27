package org.example.StepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class D03_currenciesStepDef {
    P03_homePage HomePage=new P03_homePage();
    @When("Select Euro currency from the dropdown list on the top left of home page")
    public void selectEuroCurrencyFromTheDropdownListOnTheTopLeftOfHomePage() {
        WebElement currency = HomePage.customerCurrency;
        Select seclectCurrency= new Select(currency);
        seclectCurrency.selectByIndex(1);
    }
    @Then("verify Euro Symbol € is shown on the four products displayed in Home page")
    public void verifyEuroSymbolIsShownOnTheFourProductsDisplayedInHomePage() {
        int i;
        for (i=0;i<HomePage.prices.size();i++){
         boolean result=  HomePage.prices.get(i).getText().contains("€");
            Assert.assertTrue(result);
        }
    }
}
