package org.example.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class HomePage extends pageBase{
    @FindBy(className ="ico-register")
    public WebElement RegisterNowBtn;
    @FindBy(className = "ico-login")
    public WebElement Login;
}
