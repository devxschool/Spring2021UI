package selenium.basicLacators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicLocatorsTest {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        //STAR ->
        //Instead of System.setProperty("driver.chrome", "Path")
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Before
    public void goToHomepage() {
        driver.get("https://google.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void findById() {
        //findElement is a method that looks up for an element in the page source
        //by using different locators.
        //there many different locators like By.ID, by.name etc.
        WebElement feelingLuckyButton = driver.findElement(By.id("gbqfbb"));
        Assert.assertEquals("Wrong text value on feelingLucky Button",
                "I'm Feeling Lucky", feelingLuckyButton.getAttribute("value"));
        //getText() -> return the text that's displayed on the webElement
        //getAttribute(String atributeName);
    }

    @Test
    public void findByName() {
        WebElement searchButton = driver.findElement(By.name("btnK"));
        Assert.assertEquals("Wrong text value on Search Button",
                "Google Search", searchButton.getAttribute("value"));
    }


    @Test
    public void findByLinkText() {
        System.out.println("Navigated to google.com");
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        System.out.println("Located Gmail link");
        Assert.assertEquals("Gmail link text is invalid", "Gmail", gmailLink.getText());
        System.out.println("Assertion for link text passed");
        gmailLink.click();
        System.out.println("Clicked on gmail link");
        //What is URL? -> webAddress
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals("Gmail link on google.com is not taking to the right page",
                "https://www.google.com/gmail/about/#", driver.getCurrentUrl());


    }


    @Test
    public void partialLinkText() {
        //Timer start
        WebElement howSearchWorksLink = driver.findElement(By.partialLinkText("How Search"));
        howSearchWorksLink.click();
        Assert.assertEquals("Google Search - Discover How Google Search Works", driver.getTitle());
        //timer stop
        //log the duration.
    }

    //NoSuchElementException ->
    //checked vs unchecked ->


    @Test
    public void className() {

        //When using className you have to make it's a unique classname used by just one element

        WebElement youtubeShorts = driver.findElement(By.className("NKcBbd"));
        youtubeShorts.click();
        Assert.assertEquals("Introducing the shorter side of YouTube - YouTube", driver.getTitle());
    }

        //Go to https://demostore.x-cart.com/
        //validate if the paypal icon with text is displaye or not?


            //Go to https://demostore.x-cart.com/
            //Click on Fashion
            //
}
