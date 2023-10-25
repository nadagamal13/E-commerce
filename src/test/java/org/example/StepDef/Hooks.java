package org.example.StepDef;
import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
public class Hooks {
    public static WebDriver driver;
    @Before
    public void OpenBrowser (){
        driver= new ChromeDriver();
//        String browseName=configuration.get("browserName");
//        if (browseName.equals("chrome")){
//            driver= new ChromeDriver();
//        }else if (browseName.equals("fireFox")){
//            driver=new FirefoxDriver();
//        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demo.nopcommerce.com/");
    }

    @After
    public void CloseBrowser ()throws InterruptedException
    {
        Thread.sleep(3000);
        driver.quit();
    }

    public static Faker fake=new Faker();
    public static int randomNumber(int min,int max){
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }
    public static SoftAssert soft=new SoftAssert();

}
