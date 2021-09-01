package selenium.iframes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PraticeIframes {

    WebDriver driver;


    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void test1(){
        driver.navigate().to("https://demoqa.com/frames");
        //in order to locate elements inside an iframe we have to switch the driver to that iframe
        //first locate the iframe webElement by id or xpath.
        WebElement iframe1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(iframe1);


        //work with IFrame Elements.
        WebElement iframeHeader = driver.findElement(By.id("sampleHeading"));
        System.out.println(iframeHeader.getText());


        //in order to switch back to the main content call switch to defaultContent.
        driver.switchTo().defaultContent();

        WebElement framesText = driver.findElement(By.xpath("//div[text()='Frames']"));
        System.out.println(framesText.getText());
    }
    //How do you work with Iframes
    //How to switch back to main page.


    @Test
    public void test2(){

        driver.navigate().to("https://demoqa.com/frames");
        driver.switchTo().frame(2);
       String text =  driver.findElement(By.xpath("//h1")).getText();
       System.out.println(text);
    }

    @Test
    public void test3(){

        driver.navigate().to("https://demoqa.com/frames");
        //in order to locate elements inside an iframe we have to switch the driver to that iframe
        //swirch by id or name.
        driver.switchTo().frame("frame1");


        //work with IFrame Elements.
        WebElement iframeHeader = driver.findElement(By.id("sampleHeading"));
        System.out.println(iframeHeader.getText());


        //in order to switch back to the main content call switch to defaultContent.
        driver.switchTo().defaultContent();

        WebElement framesText = driver.findElement(By.xpath("//div[text()='Frames']"));
        System.out.println(framesText.getText());
    }
}
