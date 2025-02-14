package demoqa.web.base;

import demoqa.base.BasePage;
import demoqa.pages.home.HomePage;
import demoqa.pages.alerts.*;
import demoqa.pages.bookstore.BooksLoginPage;
import demoqa.pages.bookstore.BooksPage;
import demoqa.pages.bookstore.BooksProfilePage;
import demoqa.pages.bookstore.BooksRegisterPage;
import demoqa.pages.elements.*;
import demoqa.pages.forms.FormsPage;
import demoqa.pages.forms.PracticeFormPage;
import demoqa.pages.interactions.*;
import demoqa.pages.widgets.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

import static demoqa.base.BasePage.delay;
import static utilities.Utility.setUtilityDriver;

public class BaseTest {

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    private final String DEMOQA_URL = "http://demoqa.com/";
    public WebDriver driver;
    public PracticeFormPage practiceFormPage;
    public FormsPage formsPage;
    public WidgetsPage widgetsPage;
    public SortablePage sortablePage;
    public AccordianPage accordianPage;
    public AutoCompletePage autoCompletePage;
    public DatePickerPage datePickerPage;
    public SliderPage sliderPage;
    public ProgressBarPage progressBarPage;
    public TabsPage tabsPage;
    public ToolTipsPage toolTipsPage;
    public MenuPage menuPage;
    public SelectMenuPage selectMenuPage;
    public BooksProfilePage booksProfilePage;
    public ElementsPage elementsPage;
    public SelectablePage selectablePage;
    public ResizablePage resizablePage;
    public DroppablePage droppablePage;
    public DraggablePage draggablePage;
    public InteractionsPage interactionsPage;
    public SoftAssert softAssert;
    protected BasePage basePage;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp() {
        if (threadDriver.get() == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1440,900");

            driver = new ChromeDriver(options);
            threadDriver.set(driver);
            softAssert = new SoftAssert();
            basePage = new BasePage(driver);
            setUtilityDriver();
        }
        driver.get(DEMOQA_URL);
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
        String url = DEMOQA_URL + path;
        driver.navigate().to(url);
    }
}