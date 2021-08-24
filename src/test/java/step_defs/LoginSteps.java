package step_defs;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pojo.LoginDataContainer;
import utils.Driver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LoginSteps {
    WebDriver driver = Driver.getDriver();



    @Given("^User navigates to Digital Bank login page$")
    public void user_navigates_to_Digital_Bank_login_page()  {
        driver.get("http://3.131.35.165:8080/bank/login");
        assertEquals("Login page title mismatch","Digital Bank", driver.getTitle());
    }

    @When("^User logs in with following credentials$")
    public void user_logs_in_with_following_credentials(List<LoginDataContainer> loginData ) {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submit = driver.findElement(By.id("submit"));

        username.sendKeys(loginData.get(0).getUsername());
        password.sendKeys(loginData.get(0).getPassword());
        submit.click();
    }

    @Then("^User should successfully be logged in to home page$")
    public void user_should_successfully_be_logged_in_to_home_page() {
        String actualPage = driver.findElement(By.xpath("//a[contains(@id, 'home')]")).getText();
        assertEquals("Home",actualPage); // "Home"
        driver.get("http://3.131.35.165:8080/bank/logout");
    }







}