package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstSeleniumTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLoggingIntoApplication() throws InterruptedException {
        Thread.sleep(2000);
        var username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        var password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        var button = driver.findElement(By.tagName("button"));
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        
        String actualResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h6"))).getText();

        //  Thread.sleep(2000);
        // String actualResult = driver.findElement(By.tagName("h6")).getText();

        String expectedResult = "Dashboard";
        Assert.assertEquals(actualResult, expectedResult, "Found Dashboard");

    }

}
