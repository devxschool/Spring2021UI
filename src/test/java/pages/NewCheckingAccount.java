package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class NewCheckingAccount {

    public NewCheckingAccount(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "home-menu-item")
    public WebElement homeMenu;

    @FindBy(id = "checking-menu")
    public WebElement checkingMenu;

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
}
