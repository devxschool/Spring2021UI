package selenium.fileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FileUploadPractice {


    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        driver.get("https://demoqa.com/upload-download");
        WebElement fileUpload = driver.findElement(By.id("uploadFile"));

//       selenium.fileUpload.click();
        //sendKeys on upload buttons will click and send keys.
        fileUpload.sendKeys("/Users/askarmusakunov/Desktop/logo.png");


    }

    @Test
    public void googleImage(){

        //go to https://images.google.com/
        //click on camera icon
        //click on upload an image
        //verify that current page title is Google Search.

        driver.get("https://images.google.com/");

        WebElement photoUploadButton= driver.findElement(By.xpath("//div[@jscontroller='vCzgHd']"));
        photoUploadButton.click();
        WebElement uploadImageButton=driver.findElement(By.xpath("//a[text()='Upload an image']"));
        uploadImageButton.click();
        WebElement fileNameButton= driver.findElement(By.id("awyMjb"));
        fileNameButton.sendKeys("/Users/askarmusakunov/Desktop/logo.png");

        fileNameButton.isSelected();
        driver.getTitle(); //actual result
        String actual=driver.getTitle();

        Assert.assertEquals("Google Search", actual);
    }






}
