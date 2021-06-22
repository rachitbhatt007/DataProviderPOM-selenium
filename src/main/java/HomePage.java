import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileReader;
import java.io.IOException;

public class HomePage {
    WebDriver driver;
    String fn,ln,g,em,num;

    @FindBy(css = "#vfb-5")
    WebElement FirstName;

    @FindBy(css = "#vfb-7")
    WebElement LastName;

    @FindBy(css = "#vfb-8-1")
    WebElement GenderMale;

    @FindBy(css = "#vfb-8-2")
    WebElement GenderFemale;

    @FindBy(css = "#vfb-14")
    WebElement email;

    @FindBy(css="#vfb-3")
    WebElement TwoDigits;

    @FindBy(css = "#vfb-4")
    WebElement submitButton;


    public HomePage(WebDriver driver,String fn,String ln,String g,String e,String a){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        this.fn=fn;
        this.ln=ln;
        this.g=g;
        this.em=e;
        this.num=a;
    }

    public void fillform(){
        FirstName.sendKeys(fn);
        LastName.sendKeys(ln);
        if(g.equals("Male")){
            GenderMale.click();
        }
        else if(g.equals("Female")){
            GenderFemale.click();
        }
        email.sendKeys(em);
        TwoDigits.sendKeys(num);
        submitButton.click();

    }
}
