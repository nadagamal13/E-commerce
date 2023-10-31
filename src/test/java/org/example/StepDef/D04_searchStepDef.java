package org.example.StepDef;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import static org.example.StepDef.Hooks.*;
public class D04_searchStepDef {
    SoftAssert soft=new SoftAssert();
    P03_homePage HomePage=new P03_homePage();
    @When("user could search using product {string}")
    public void userCouldSearchUsingProduct(String arg0) {
        HomePage.search.sendKeys(arg0);
        HomePage.searchButton.click();
        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/search?q="+arg0);
        soft.assertFalse(HomePage.productItems.isEmpty());
        int i;
        for(i=0;i<HomePage.products.size();i++){
           soft.assertTrue(HomePage.products.get(i).getText().toLowerCase().contains(arg0.toLowerCase()));
            soft.assertAll();
        }
        soft.assertAll();
    }
    @When("user could search for product using {string}")
    public void userCouldSearchForProductUsing(String arg0) {
        HomePage.search.sendKeys(arg0);
        HomePage.searchButton.click();
        HomePage.picture.click();
        Assert.assertTrue(HomePage.value.getText().toLowerCase().contains(arg0.toLowerCase()));
    }
}
