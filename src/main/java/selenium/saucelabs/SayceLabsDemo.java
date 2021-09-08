package selenium.saucelabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SayceLabsDemo {


    public static void main(String[] args) throws MalformedURLException {

//        WebDriverManager.chromedriver().setup();

        //how to use SauceLabs?
        //first get sauceLabs userName and password.
        String USERNAME = "oauth-karakol1994-ac089";
        String ACCESS_KEY = "9cacc66e-b2b4-4794-ae64-9e93c9f43d15";


        //setup url to the hub which is running on saucelabs VMs.
        String url = "https://oauth-karakol1994-ac089:9cacc66e-b2b4-4794-ae64-9e93c9f43d15@ondemand.us-west-1.saucelabs.com:443/wd/hub";


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", Platform.WIN10);
        capabilities.setCapability("browserName", BrowserType.FIREFOX);
        capabilities.setCapability("browserVersion", "latest");

        WebDriver driver = new RemoteWebDriver(new URL(url), capabilities);

        driver.get("https://www.amazon.com/");
//        driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBox.sendKeys("Iphone" + Keys.ENTER);

        WebElement appleBrand = driver.findElement(By.cssSelector("li[id='p_89/Apple']"));

        System.out.println(appleBrand.getText());
    }
}
