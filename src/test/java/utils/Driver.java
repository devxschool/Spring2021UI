package utils;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    //String str;
    static WebDriver driver;

    //We want our framework to be able to run all the tests that we have created on a browser of our choice (chrome, firefox, safari)
    // We want to make sure new WebDriver is initialized only if it's not been initialized already.
    public static WebDriver getDriver() {

        //We have to make the whole framework is using the same exact driver(browser window)
        //so we make sure we initialize the driver only if it's not been initialized.
        if (driver == null) {

            switch (ConfigReader.getProperty("dbank.browser").toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                     ChromeOptions options = new ChromeOptions();
                    options.addArguments("headless");
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    //Safari browser comes with the driver integrated.
                    driver = new SafariDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "saucelabs":
                    String platform = System.getProperty("dbank.saucelabs.platform");
                    String browser = System.getProperty("dbank.saucelabs.browser");
                    String browserVersion = System.getProperty("dbank.saucelabs.browser.version");
                    driver = loadSauceLabs(platform, browser, browserVersion);
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        return driver;
    }


    //Selenium is able to take screenshots when the test fails. So we have a visual prove of what went wrong
    public static void takeScreenshot() throws IOException {

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File abc = new File("src/test/resources/firstSeleniumScreenshot.png");
        FileUtils.copyFile(screenshotFile, abc);
    }


    public static void takeScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            //taking the screenshot and saving it in byte arrays.
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            scenario.embed(screenshot, "image/png");

        }
    }


    /**
     * Create a method that quits the driver
     * which should check if instance is already instantiated once
     */
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static WebDriver loadSauceLabs(String platform, String browserType, String browserVersion) {

        String USERNAME = ConfigReader.getProperty("dbank.saucelabs.username");
        String ACCESS_KEY = "9cacc66e-b2b4-4794-ae64-9e93c9f43d15";
        String HOST = ConfigReader.getProperty("dbank.saucelabs.host");


        //setup url to the hub which is running on saucelabs VMs.
        String url = "https://" + USERNAME + ":" + ACCESS_KEY + "@" + HOST;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platform);
        capabilities.setCapability("browserName",browserType);
        capabilities.setCapability("browserVersion", browserVersion);

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(url), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
