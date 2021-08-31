package selenium.pageNavigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageNavigation {


    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void pageNavigation(){
            driver.get("http://www.practiceselenium.com/");

//        driver.findElement(By.linkText("Let's Talk Tea"));
            //          //a[contains(@data-title, 'Tea')]
           WebElement teaLink =  driver.findElement(By.xpath("//a[@href='let-s-talk-tea.html']"));
           teaLink.click();
           //when a page updates itself for any reason.
        //after clicking to some buttons or links.
        //clicking on refresh
        //maybe your app has some mechanism where it updates itself at certain period.

        //We get a StaleElementReferenceException.
        //We need to relocate the element in an updated html pagesource.
        teaLink =  driver.findElement(By.xpath("//a[@href='let-s-talk-tea.html']"));

        WebElement liElementOfA = teaLink.findElement(By.xpath("./..")); // ./.. -> go to parent

        Assert.assertEquals("active", liElementOfA.getAttribute("class"));

        driver.navigate().back();
//        driver.navigate().forward();
//        driver.navigate().refresh();

    }


    @Test
    public void waits() throws InterruptedException {
        Thread.sleep(10000); //=> hard sleep.
        //this not a good type wait.



    }





}
