package selenium.advancedMouseInterations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PracticeActions {

    WebDriver driver;


    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
    }


    @Test
    public void test1(){
        driver.navigate().to("https://demoqa.com/buttons");
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        WebElement clickMe = driver.findElement(By.xpath("//button[text()='Click Me']"));

        //in order to use Actions class
        //how to create an object in java.
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();

        actions.contextClick(rightClickBtn).click(clickMe).perform();
    }



    @Test
    public void hoverOver(){
        driver.navigate().to("https://demoqa.com/tool-tips");
        WebElement element = driver.findElement(By.id("toolTipButton"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        WebElement toolTip = driver.findElement(By.id("buttonToolTip"));
        Assert.assertTrue(toolTip.isDisplayed());
        Assert.assertEquals("You hovered over the Button",toolTip.getText());

//        WebElement textBox  = driver.findElement(By.id("toolTipTextField"));
//        actions.moveToElement(textBox).perform();

    }

    @Test
    public void slider(){
        driver.navigate().to("https://demoqa.com/slider");

        WebElement slider = driver.findElement(By.xpath("//input[@class='range-slider range-slider--primary']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(90,0).release().perform();


    }

    @Test
    public void draggable() {
        driver.navigate().to("https://demoqa.com/droppable");

        WebElement webElement = driver.findElement(By.id("draggable"));
        WebElement droppableTarget = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);


       Point point =  droppableTarget.getLocation();
//        actions.clickAndHold(webElement).moveToElement(droppableTarget).perform();

        actions.clickAndHold(webElement).moveByOffset(240, 25).perform();
    }


    @Test
    public void progressBar(){
        driver.navigate().to("https://demoqa.com/progress-bar");
        WebElement start = driver.findElement(By.id("startStopButton"));

        WebElement progressbar = driver.findElement(By.xpath("//div[@role='progressbar']"));
        start.click();

        new WebDriverWait(driver,15)
                .until(ExpectedConditions.attributeToBe(progressbar,"aria-valuenow", "100"));

        Assert.assertEquals("100%", progressbar.getText());

    }


    @Test
    public void submenu(){
        driver.navigate().to("https://demoqa.com/menu#");

        WebElement menu = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        Actions actions = new Actions(driver);

        actions.moveToElement(menu).perform();

        WebElement subList = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        actions.moveToElement(subList).perform();

        WebElement subItem2= driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']"));
        subItem2.click();
    }


    @Test
    public void form(){
        driver.navigate().to("https://demoqa.com/automation-practice-form");
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
//        WebElement lastNameInput = driver.findElement(By.id("lastName"));

        firstNameInput.sendKeys("John Doe");
        Actions actions  = new Actions(driver);
        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
        actions.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();

        actions.sendKeys(Keys.TAB).perform();
        actions.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();
    }
}
