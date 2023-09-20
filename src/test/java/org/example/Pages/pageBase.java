package org.example.Pages;
import org.openqa.selenium.support.PageFactory;
import static org.example.StepDef.Hooks.*;
public class pageBase {
    public pageBase(){
        PageFactory.initElements(driver,this);
    }
}
