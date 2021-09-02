package selenium.alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeAlerts {


    WebDriver driver;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void testSimpleAlert() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/alerts");
        WebElement simpleAlertButton = driver.findElement(By.id("alertButton"));
        simpleAlertButton.click();
        //switch to alert
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();

        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();

        Alert alert2 = driver.switchTo().alert();
        Thread.sleep(4000);
        alert2.accept();
    }

    @Test
    public void testSimpleAlert2() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/alerts");
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();

        Alert alert2 = driver.switchTo().alert();
        Thread.sleep(4000);
        alert2.dismiss();
    }


    @Test
    public void testSimpleAlert3() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/alerts");
        WebElement promtButton = driver.findElement(By.id("promtButton"));
        promtButton.click();

        Alert alert2 = driver.switchTo().alert();
        Thread.sleep(4000);
        alert2.sendKeys("Hello World");
        Thread.sleep(2000);
        alert2.accept();
    }


    @Test
    public void testAlertWait(){
        driver.navigate().to("https://demoqa.com/alerts");
        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        timerAlertButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();
    }







}
