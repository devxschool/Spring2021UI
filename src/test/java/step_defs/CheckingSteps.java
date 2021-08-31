package step_defs;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.NewCheckingAccount;
import utils.Driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckingSteps {


    WebDriver driver = Driver.getDriver();

    NewCheckingAccount newCheckingAccount = new NewCheckingAccount(driver);

    @Then("^Verify that \"([^\"]*)\" welcoming message is displayed$")
    public void verify_that_welcoming_message_is_displayed(String expectedWelcomeMessage) {

        WebElement welcomeMessage = driver.findElement(By.xpath("//li[contains(text(),'Welcome')]"));
        assertTrue("Welcome Message is not displayed", welcomeMessage.isDisplayed());
        assertEquals("Welcome Message mismatch", expectedWelcomeMessage, welcomeMessage.getText());

    }


    @Then("^Verify that home page panel with account info is displayed$")
    public void verify_that_home_page_panel_with_account_info_is_displayed() throws Throwable {
        newCheckingAccount.validateAllMenuItemsAreDisplayed();
    }





}
