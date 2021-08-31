package selenium.advancedLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class PracticeAdvancedLocators {

//Tag is definition of a WebElement
//One tag is one webElement.


    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        //STAR ->
        //Instead of System.setProperty("driver.chrome", "Path")
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }


    //a -> anchortext
    @Test
    public void locateByTag() {
        driver.get("https://demostore.x-cart.com/");
        //Difference between findElement vs findElements
        //Find element returns just one unique element.
        //if the locators points to multiple elements
        //findElement method return the first element in the page.

        //FindElements return List<WebElements>
        //if the locator is unique then it will just return List<WebElements> with just one
        //WebElement in it.

        //If the locators points to multiple webElements it will return list of all of those elements


        //NoElementFound
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        for (WebElement link : links) {
            System.out.println(link.getAttribute("href"));
        }

//        System.out.println(links.get(0).getAttribute("href"));
    }


    @Test
    public void byTag2() {
        driver.get("https://demostore.x-cart.com/");


        List<WebElement> links = driver.findElements(By.tagName("button"));
        System.out.println(links.size());

        for (WebElement link : links) {
            System.out.println(link.getText());
        }
    }


    @Test
    public void byCssSelector() throws InterruptedException {
        driver.get("https://www.amazon.com/");
//        driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBox.sendKeys("Iphone" + Keys.ENTER);

        WebElement appleBrand = driver.findElement(By.cssSelector("li[id='p_89/Apple']"));

        System.out.println(appleBrand.getText());
    }


    @Test
    public void byCssSelectorWildcards() throws InterruptedException {

        driver.get("https://www.amazon.com/");
//        driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBox.sendKeys("Iphone" + Keys.ENTER);


        Thread.sleep(5000);
        List<WebElement> allBrands = driver.findElements(By.cssSelector("li[id^='p_89']"));

        for (WebElement brand : allBrands) {
            System.out.println(brand.getText());
        }
    }


    @Test
    public void cssSelectorChild() {
        driver.get("https://www.amazon.com/");
//        driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBox.sendKeys("Iphone" + Keys.ENTER);

        WebElement appleBrand = driver.findElement(By.cssSelector(" li[id='p_89/Apple']>*>*"));
        appleBrand.click();
    }


    @Test
    public void xPath() {


        driver.get("https://www.amazon.com/");
//        driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchBox = driver.findElement(By.xpath(" /html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input"));
        searchBox.sendKeys("Iphone" + Keys.ENTER);
    }


    @Test
    public void xPath2() {
        driver.get("https://www.amazon.com/");
//        driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Iphone" + Keys.ENTER);

        List<WebElement> allBrands = driver.findElements(By.xpath("//li[starts-with(@id, 'p_89')]"));

        for (WebElement brand : allBrands) {
            System.out.println(brand.getText());
        }
    }


    @Test
    public void xPath3() {
        //ul[contains(@aria-labelledby,'p_89')]

        driver.get("https://www.amazon.com/");
        //        driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Iphone" + Keys.ENTER);

        WebElement unOrderedListForBrands = driver.findElement(By.xpath("//ul[contains(@aria-labelledby,'p_89')]"));

        System.out.println(unOrderedListForBrands.getText());
    }


    @Test
    public void xPathIndex() {
        //div[@class='s-main-slot s-result-list s-search-results sg-row']/div[3]

        driver.get("https://www.amazon.com/");
        //        driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Iphone" + Keys.ENTER);

        WebElement apple = driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[3]"));

        WebElement price = apple.findElement(By.xpath("//span[@class='a-price']"));

        System.out.println(price.getText());

        System.out.println(apple.getText());

        validateIphones(apple, "599.00", "Yellow", "Apple");
    }


    @Test
    public void elementNotFound(){
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("HelloWorld"));
    }


    @Test
    public void elementNotFoundWithFindElementS() {
        driver.get("https://www.amazon.com/");
       List<WebElement> elements =  driver.findElements(By.id("HelloWorld"));
       System.out.println(elements.size());
    }

//write a helper method which will help us validate Iphone search result details.

//This method should accept a WebElement that is a Iphone div.
//and expected results for price, Color, and Brand.


    public static void validateIphones(WebElement webElement, String expectedPrice, String expectedColor, String expectedBrand) {

    }

}
