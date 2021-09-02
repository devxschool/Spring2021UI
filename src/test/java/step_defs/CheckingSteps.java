package step_defs;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.NewCheckingAccount;
import pojo.NewCheckingDataContainer;
import utils.Driver;

import java.util.List;

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


    @Given("^User clicks on new \"([^\"]*)\" account$")
    public void user_clicks_on_new_account(String arg1) throws Throwable {
        newCheckingAccount.checkingMenu.click();
        newCheckingAccount.newCheckingAccount.click();
    }

    @When("^User creates Checking account with the following info$")
    public void user_creates_Checking_account_with_the_following_info(List<NewCheckingDataContainer> checkingDataList) {
        NewCheckingDataContainer data = checkingDataList.get(0);
        newCheckingAccount.createNewCheckingAccount(data.getAccountType(), data.getAccountOwnership(), data.getAccountName(), data.getInitialDeposit());
    }

    @Then("^verify newly created account information contains$")
    public void verify_newly_created_account_information_contains(List<NewCheckingDataContainer> checkingDataList ) {

    }


    @Then("^Verify that \"([^\"]*)\" dropdown has following options$")
    public void verify_that_dropdown_has_following_options(String accountType, List<String> views) throws Throwable {
        if (accountType.equalsIgnoreCase("checking")) {
            newCheckingAccount.checkingMenu.click();
            newCheckingAccount.validateTheCheckingMenuList(views);
        }
    }


}

