package step_defs;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pojo.LoginDataContainer;
import utils.ConfigReader;
import utils.Driver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LoginSteps {

    //intance variables are initialized once per one test scenario.
    WebDriver driver = Driver.getDriver();

    @Given("^User navigates to Digital Bank login page$")
    public void user_navigates_to_Digital_Bank_login_page() {
        driver.get(ConfigReader.getProperty("dbank.env.login"));
        assertEquals("Login page title mismatch", "Digital Bank", driver.getTitle());
    }

    @When("^User logs in with following credentials$")
    public void user_logs_in_with_following_credentials(List<LoginDataContainer> loginData) {
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
        assertEquals("Home", actualPage); // "Home"
        driver.get(ConfigReader.getProperty("dbank.env.logout"));
    }


    @Then("^User should be displayed with the error message \"([^\"]*)\"$")
    public void user_should_be_displayed_with_the_error_message(String expectedErrorMessage) {
        WebElement actualErrorMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]"));

        String actualErrorMessageStr = actualErrorMessage.getText().trim().replaceAll("[^a-zA-Z-' .]", "");
        Assert.assertEquals("Login error message mismatch", expectedErrorMessage.trim(), actualErrorMessageStr);
    }
}
