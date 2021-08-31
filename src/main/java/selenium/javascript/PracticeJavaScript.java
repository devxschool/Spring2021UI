package selenium.javascript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PracticeJavaScript {


    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    @Test
    public void test1() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.location='https://www.etsy.com'");

        js.executeScript("window.scrollBy(0,500)");
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Help Center')]"));
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(3000);
        WebElement signInButton = driver.findElement(By.xpath("//button[contains(@class,'select-signin')]"));
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", signInButton, "border: 2px solid green");

        js.executeScript("arguments[0].click()", signInButton);

        Thread.sleep(3000);
        //join_neu_email_field
        js.executeScript("document.getElementById('join_neu_email_field').value=arguments[0];", "hello@gmail.com");
        WebElement continueButton = driver.findElement(By.name("submit_attempt"));

        js.executeScript("arguments[0].click()", continueButton);

        Thread.sleep(3000);
//  WebElement signInButton2 = driver.findElement(By.xpath("//input[@name='password']"));
        js.executeScript("document.getElementsByName('password')[0].value=arguments[0];", "12345");
        js.executeScript("document.getElementsByName('submit_attempt')[0].click();");
    }


}
