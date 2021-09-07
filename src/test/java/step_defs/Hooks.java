package step_defs;

import cucumber.api.Scenario;
import cucumber.api.java.After;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;

public class Hooks {

    WebDriver driver = Driver.getDriver();
    //How do you take a screenshot in Selenium? Why would I want to have this capability in my framework?
    //How do you run your tests in different browsers?
    @After
    public void tearDown(Scenario scenario){
        driver.findElement(By.cssSelector("img[class=\"user-avatar rounded-circle\"]")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

//        Driver.takeScreenshot(scenario);
    }
}
