package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    //In order to create a page object model we need to create a PageFactory in the constructor
    public HomePage(WebDriver driver) {
        //Page Factory class will link this class with the driver that's being currently used.
        PageFactory.initElements(driver, this);
    }

    //@FindBy annotation is equivalent to driver.findElement()
    //@FindBy(xpath = "//div");
//    @FindBy(id="someId")
//    @FindBy(name = "someName")

    //Annotations can only be used on top of a method, variable, Constructor, or method param

    @FindBy(id = "home-menu-item")
    public WebElement homeMenu;
}
