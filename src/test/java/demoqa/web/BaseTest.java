package demoqa.web;

import demoqa.base.BasePage;
import demoqa.pages.HomePage;
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
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

import static demoqa.base.BasePage.delay;
import static utilities.Utility.setUtilityDriver;

public class BaseTest {

    public WebDriver driver;
    public ButtonsPage buttonsPage;
    public RadioButtonPage radioButtonPage;
    public BrokenLinksImagesPage brokenLinksImagesPage;
    public CheckBoxPage checkBoxPage;
    public LinksPage linksPage;
    public UploadAndDownloadPage uploadAndDownloadPage;
    public DynamicPropertiesPage dynamicPropertiesPage;
    public PracticeFormPage practiceFormPage;
    public FormsPage formsPage;
    public TextBoxPage textBoxPage;
    public WebTablesPage webTablesPage;
    public Alerts_Frames_WindowsPage alerts_frames_windowsPage;
    public BrowserWindowsPage browserWindowsPage;
    public AlertsPage alertsPage;
    public FramesPage framesPage;
    public NestedFramesPage nestedFramesPage;
    public ModalDialogsPage modalDialogsPage;
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
    public BooksLoginPage booksLoginPage;
    public BooksPage booksPage;
    public BooksRegisterPage booksRegisterPage;
    public InteractionsPage interactionsPage;
    public SoftAssert softAssert;
    protected BasePage basePage;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
 //       options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
//        options.addArguments("--window-size=1920,1080"); // Set the window size

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        String DEMOQA_URL = "http://demoqa.com/";
        driver.get(DEMOQA_URL);
        softAssert = new SoftAssert();

        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
        textBoxPage = new TextBoxPage(driver);
        checkBoxPage = new CheckBoxPage(driver);
        radioButtonPage = new RadioButtonPage(driver);
        webTablesPage = new WebTablesPage(driver);
        buttonsPage = new ButtonsPage(driver);
        linksPage = new LinksPage(driver);
        brokenLinksImagesPage = new BrokenLinksImagesPage(driver);
        uploadAndDownloadPage = new UploadAndDownloadPage(driver);
        dynamicPropertiesPage = new DynamicPropertiesPage(driver);
        formsPage = new FormsPage(driver);
        practiceFormPage = new PracticeFormPage(driver);
        alerts_frames_windowsPage = new Alerts_Frames_WindowsPage(driver);
        browserWindowsPage = new BrowserWindowsPage(driver);
        alertsPage = new AlertsPage(driver);
        framesPage = new FramesPage(driver);
        nestedFramesPage = new NestedFramesPage(driver);
        modalDialogsPage = new ModalDialogsPage(driver);
        widgetsPage = new WidgetsPage(driver);
        interactionsPage = new InteractionsPage(driver);
        droppablePage = new DroppablePage(driver);
        draggablePage = new DraggablePage(driver);
        resizablePage = new ResizablePage(driver);
        selectablePage = new SelectablePage(driver);
        selectMenuPage = new SelectMenuPage(driver);
        menuPage = new MenuPage(driver);
        toolTipsPage = new ToolTipsPage(driver);
        booksPage = new BooksPage(driver);
        booksLoginPage = new BooksLoginPage(driver);
        booksProfilePage = new BooksProfilePage(driver);
        booksRegisterPage = new BooksRegisterPage(driver);
        tabsPage = new TabsPage(driver);
        sortablePage = new SortablePage(driver);
        accordianPage = new AccordianPage(driver);
        autoCompletePage = new AutoCompletePage(driver);
        datePickerPage = new DatePickerPage(driver);
        sliderPage = new SliderPage(driver);
        progressBarPage = new ProgressBarPage(driver);

//        basePage.setDriver(driver);
        setUtilityDriver();
    }

    @AfterMethod
    public void takeFailedResultScreenshot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshots/(" +
                    java.time.LocalDate.now() + ") " +
                    testResult.getName() + ".png");
            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Screenshot Located At " + destination);
        }
    }

    @AfterMethod
    public void tearDown() {
        delay(1000);
        driver.quit();
    }

    public void navigateToUrl(String path) {
        String url = "https://demoqa.com/" + path;
        driver.navigate().to(url);
    }
}