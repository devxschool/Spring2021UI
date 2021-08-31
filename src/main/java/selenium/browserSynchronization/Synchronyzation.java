package selenium.browserSynchronization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Synchronyzation {



    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void amazonTest(){
        driver.get("https://www.amazon.com/");
    }


    @Test
    public void testEtsy() {
        driver.get("https://www.etsy.com/");
        WebElement signIn = driver.findElement(By.xpath("//button[contains(@class,'select-signin')]"));
        signIn.click();


        //Implicit vs  automatic
        //Explicit -> manual
        WebDriverWait wait = new WebDriverWait(driver, 3);
        ////button[@data-google-button]
        WebElement googleButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-google-button]")));

        googleButton.click();

        googleButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-google-button]")));
        googleButton.click();
    }


    @Test
    public void visibleTest(){

        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("visibleAfter")));
//        WebElement button = driver.findElement(By.id("visibleAfter"));
        button.click();
    }


    @Test
    public void test2() {
        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver, 5);

       wait.until(ExpectedConditions.attributeContains(By.id("colorChange"), "class", "text-danger"));
       WebElement colorChangeButton = driver.findElement(By.id("colorChange"));

       assertTrue(colorChangeButton.getAttribute("class").contains("text-danger"));
       assertEquals("hello", "hello");
    }


}
