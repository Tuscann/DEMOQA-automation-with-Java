package part2.com.saucedemo.base;

import com.pages.base.BasePage;
import com.pages.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private final String url = "https://www.saucedemo.com/";
    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;

    public BaseTest() {
        driver = new ChromeDriver();
    }

    @BeforeClass
    public void setUp() {
        driver.manage().window().maximize();
        driver.get(url);
        basePage = new BasePage();
        basePage.setDriver(driver);
        loginPage = new LoginPage();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
