package selenium.dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownPractice {


    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void test1() {
        driver.get("https://www.devxschool.com/enrollment/");
        WebElement howDidYouHearAboutUsDropdown = driver.findElement(By.id("00N5Y00000FBDWL"));

        Select dropDown = new Select(howDidYouHearAboutUsDropdown);
        List<WebElement> options = dropDown.getOptions();

        for (WebElement option: options) {
            System.out.println(option.getText());
        }

        //dropDown.selectByIndex(3);
        //dropDown.selectByValue("Instagram");
        dropDown.selectByVisibleText("Instagram");

        List<WebElement> selectedOptions = dropDown.getAllSelectedOptions();

        System.out.println(selectedOptions.size());
        for (WebElement option: selectedOptions) {
            System.out.println(option.getText());
        }
    }


    @Test
    public void testMutiple(){
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        WebElement dd = driver.findElement(By.id("option-droup-demo"));

        Select multipleSelectDropDown = new Select(dd);
            multipleSelectDropDown.deselectAll();

        multipleSelectDropDown.selectByVisibleText("HTML");
        multipleSelectDropDown.selectByValue("MSSQL");

        List<WebElement> selectedOptions = multipleSelectDropDown.getAllSelectedOptions();


        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }
    }


}
