
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class FormTest extends BaseTest {


    @Test(dataProvider = "dp")
    public void formtest(String data){
        String user[] = data.split(",");
        WebDriver driver =getDriver();
        HomePage homePage = new HomePage(driver,user[0],user[1],user[2],user[3],user[4]);
        homePage.fillform();
        driver.quit();
    }


    @DataProvider(name ="dp")
    public Object[][] readJson() throws IOException, ParseException {
        JSONParser jsonparse = new JSONParser();

            JSONObject jsonobj = (JSONObject) jsonparse.parse(new FileReader("src/main/resources/Json files/Info" + ".json"));
            JSONArray key =(JSONArray) jsonobj.get("FormData");
            String arr[][] = new String[key.size()][1];
            System.out.println(key.size());
            for(int i=0;i<key.size();i++){
                JSONObject user = (JSONObject) key.get(i);
                arr[i][0]=
                        user.get("FirstName").toString()+","+user.get("LastName").toString()+","+user.get("Gender").toString().toString()+","+user.get("email")+
                        ","+user.get("number").toString();
            }
        System.out.println(arr);
            return arr;

    }
}
