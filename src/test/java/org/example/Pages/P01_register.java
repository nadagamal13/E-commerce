package org.example.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.example.StepDef.Hooks.*;
public class P01_register {
    public static List<WebElement> Gender(){
        return driver.findElements(By.name("Gender"));
    }
    public static WebElement FirstNameField ()
    {
        return driver.findElement(By.id("FirstName"));
    }
    public static WebElement LastNameField ()
    {
        return driver.findElement(By.id("LastName"));
    }
    public static WebElement DaySelect ()
    {
        return driver.findElement(By.name("DateOfBirthDay"));
    }
    public static WebElement MonthSelect ()
    {
        return driver.findElement(By.name("DateOfBirthMonth"));
    }
    public static WebElement YearSelect ()
    {
        return driver.findElement(By.name("DateOfBirthYear"));
    }
    public static WebElement EmailField ()
    {
        return driver.findElement(By.id("Email"));
    }
    public static WebElement CompanyField ()
    {
        return driver.findElement(By.id("Company"));
    }
    public static WebElement NewsLetterBtn ()
    {
        return driver.findElement(By.id("Newsletter"));
    }
    public static WebElement PasswordField ()
    {
        return driver.findElement(By.id("Password"));
    }
    public static WebElement ConfirmPasswordField ()
    {
        return driver.findElement(By.id("ConfirmPassword"));
    }
    public static WebElement RegistrationBtn ()
    {
        return driver.findElement(By.id("register-button"));
    }
    public static WebElement ConfirmationMsg(){
        return driver.findElement(By.className("result"));
    }
}
