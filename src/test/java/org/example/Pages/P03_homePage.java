package org.example.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
public class P03_homePage extends pageBase{
    @FindBy(className ="ico-register")
    public WebElement RegisterNowBtn;
    @FindBy(className = "ico-login")
    public WebElement Login;
    @FindBy(id = "customerCurrency")
    public WebElement customerCurrency;

    @FindBy(className = "actual-price")
    public List<WebElement> prices;
}
