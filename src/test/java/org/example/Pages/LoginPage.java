package org.example.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage extends pageBase {
    @FindBy(id = "Email")
    public WebElement email;
@FindBy(id = "Password")
    public WebElement password;
@FindBy(className = "login-button")
    public WebElement loginButton;
@FindBy(className = "message-error")
    public WebElement errorMsg;
}
