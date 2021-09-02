package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.AccountOwnership;
import utils.AccountType;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NewCheckingAccount {

    public NewCheckingAccount(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "home-menu-item")
    public WebElement homeMenu;

    @FindBy(id = "checking-menu")
    public WebElement checkingMenu;

    @FindBy(id = "new-checking-menu-item")
    public WebElement newCheckingAccount;

    @FindBy(id = "savings-menu")
    public WebElement savings;

    @FindBy(id = "credit-menu")
    public WebElement credit;

    @FindBy(id = "external-accounts-menu")
    public WebElement externalMenu;

    @FindBy(id = "deposit-menu-item")
    public WebElement depositMenu;

    @FindBy(id = "withdraw-menu-item")
    public WebElement withdrawMenu;

    @FindBy(id = "transfer-menu-item")
    public WebElement transferMenu;

    @FindBy(id = "visa-transfer-menu-item")
    public WebElement visaMenu;

    @FindBy(id = "Standard Checking")
    public WebElement checkingRadio;

    @FindBy(id = "Interest Checking")
    public WebElement interestRadio;

    @FindBy(id = "Individual")
    public WebElement individualRadio;

    @FindBy(id = "Joint")
    public WebElement joinRadio;

    @FindBy(id = "name")
    public WebElement nameTextBox;

    @FindBy(id = "openingBalance")
    public WebElement openingBalanceTextBox;


    @FindBy(id = "newCheckingSubmit")
    public WebElement newCheckingSubmitButton;

    @FindBy(id = "newCheckingReset")
    public WebElement newCheckingResetButton;


    @FindBy(xpath = "//ul[@class='sub-menu children dropdown-menu show']")
    public WebElement checkingMenuList;


    //expectedList [View Checking,New Checking] actual [New Checking, View Checking]
    //
    public void validateTheCheckingMenuList(List<String> expectedOptions) {
        List<WebElement> checkingMenuItems = checkingMenuList.findElements(By.xpath("li"));

        assertEquals(expectedOptions.size(), checkingMenuItems.size());

        for (WebElement element : checkingMenuItems) {
            for (String option : expectedOptions) {
                if (element.getText().toLowerCase().trim().equalsIgnoreCase(option.toLowerCase().trim())) {
                    assertEquals(option.toLowerCase().trim(), element.getText().toLowerCase().trim());
                }
            }
        }
    }

    public void validateAllMenuItemsAreDisplayed() {
        assertTrue("HomeButton is not displayed", homeMenu.isDisplayed());
        assertTrue("Checking is not displayed", checkingMenu.isDisplayed());
        assertTrue("Savings is not displayed", savings.isDisplayed());
        assertTrue("Credit is not displayed", credit.isDisplayed());
        assertTrue("External is not displayed", externalMenu.isDisplayed());
        assertTrue("Deposit is not displayed", depositMenu.isDisplayed());
        assertTrue("withdrawMenu is not displayed", withdrawMenu.isDisplayed());
        assertTrue("transferMenu is not displayed", transferMenu.isDisplayed());
        assertTrue("visaMenu is not displayed", visaMenu.isDisplayed());
    }


    public void createNewCheckingAccount(AccountType accountType, AccountOwnership ownership, String accountName, double initialBalance) {

        if (accountType.equals(AccountType.STANDARD)) {
            checkingRadio.click();
        } else {
            interestRadio.click();
        }

        if (ownership.equals(AccountOwnership.JOINT)) {
            joinRadio.click();
        } else {
            individualRadio.click();
        }

        nameTextBox.sendKeys(accountName);
        openingBalanceTextBox.sendKeys(initialBalance + "");

        newCheckingSubmitButton.click();
    }


    public void createNewCheckingAccountAndReset(AccountType accountType, AccountOwnership ownership, String accountName, double initialBalance) {

        if (accountType.equals(AccountType.STANDARD)) {
            checkingRadio.click();
        } else {
            interestRadio.click();
        }

        if (ownership.equals(AccountOwnership.JOINT)) {
            joinRadio.click();
        } else {
            individualRadio.click();
        }

        nameTextBox.sendKeys(accountName);
        openingBalanceTextBox.sendKeys(initialBalance + "");

        newCheckingResetButton.click();
    }
}

