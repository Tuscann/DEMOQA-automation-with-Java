package demoqa.web.base;

import demoqa.base.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

import static demoqa.base.BasePage.delay;

public class BaseTest {

    public static final String DEMO_QA_URL = "https://demoqa.com/";
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public WebDriver driver;
    public SoftAssert softAssert;
    protected BasePage basePage;

    @BeforeMethod
    public void setUp() {
        if (threadDriver.get() == null) {
            ChromeOptions options = new ChromeOptions();

            // In headless mode, Chrome ignores maximize and instead requires you to explicitly set a window size.
            boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "true"));
            if (isHeadless) {
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080"); // required in headless
            } else {
                options.addArguments("--start-maximized"); // works only with UI mode
            }
            options.addArguments("--disable-gpu");

            driver = new ChromeDriver(options);
            threadDriver.set(driver);
            softAssert = new SoftAssert();
            basePage = new BasePage(driver);
        }
        driver.get(DEMO_QA_URL);
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {
        // Take screenshot if test failed
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshots/(" +
                    java.time.LocalDate.now() + ") " +
                    testResult.getName() + ".png");
            try {
                FileHandler.copy(source, destination);
                System.out.println("Screenshot Located At " + destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @AfterMethod
    public void tearDownClass() {
        if (driver != null) {
            delay(1000);
            driver.quit();
            threadDriver.remove();
        }
    }

    public void navigateToUrl(String path) {
        String url = DEMO_QA_URL + path;
        driver.navigate().to(url);
    }
}