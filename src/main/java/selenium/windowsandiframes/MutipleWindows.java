package selenium.windowsandiframes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MutipleWindows {


    WebDriver driver;


    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
    }

    @Test
    public void test1() {

        driver.get("https://amazon.com");

        //getWindowHandle method return a unique window(tab) id.
        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);
//        "CDwindow-1DCCA2EDB3AE522BC28A288415D3E818"
        //CDwindow-0AB2B06BBA91DE5E869A8ACC5BB13485
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://www.practiceselenium.com/");

        WebElement link = driver.findElement(By.xpath("//a[text()='seleniumframework.com']"));
        link.click();

        Thread.sleep(3000);
        //driver doesnt switch tabs automatically like real end users.
        //so we have switch the tabs in the code

        //step 1 -> save the main page id
        String mainPage = driver.getWindowHandle();
        System.out.println("Main: " + mainPage);

        Set<String> allOpenTabs = driver.getWindowHandles();

        System.out.println(allOpenTabs);
        //find new tab id
        for (String tabID : allOpenTabs) {
            if (!tabID.equals(mainPage)) {
                System.out.println("second tab:" + tabID);
                driver.switchTo().window(tabID);
            }
        }



        //driver swithced to new tab
        assertEquals("Selenium Framework | Selenium, Cucumber, Ruby, Java et al.", driver.getTitle());
        //saving all tab ids so we can use them to switch between tabs

        //driver can now locate elements from new tab
        WebElement python = driver.findElement(By.xpath("//span[text()='PYTHON']/.."));
        python.click();


        //switch back to main tab
        driver.switchTo().window(mainPage);

        //validate it switched
        assertEquals("Welcome", driver.getTitle());

        //switch to new tab again
        for (String tabID : allOpenTabs) {
            if (!tabID.equals(mainPage)) {
                System.out.println("second tab:" + tabID);
                driver.switchTo().window(tabID);
            }
        }

        //close the new tab
        driver.close();

        //switch to main tab again bc driver doenst switch automatically after closing.
        driver.switchTo().window(mainPage);
        assertEquals("Welcome", driver.getTitle());
    }

}
