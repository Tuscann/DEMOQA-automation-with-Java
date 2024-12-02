package part3_4.comdemoqa.base;


import com.pages.base.BasePage;
import com.pages.demo.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.pages.base.BasePage.delay;
import static utilities.Utility.setUtilityDriver;

public class BaseTest {
    private final String DEMOQA_URL = "http://demoqa.com/";
    protected BasePage basePage;
    protected HomePage homePage;
    private WebDriver driver;

    @BeforeMethod
    public void loadApplication() {
        driver.get(DEMOQA_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtilityDriver();
        homePage = new HomePage();
    }

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        delay(3000);
        driver.quit();
    }
}
