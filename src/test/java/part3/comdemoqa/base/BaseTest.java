package part3.comdemoqa.base;

import com.pages.base.BasePage;
import com.pages.demo.pages.HomePage;
import com.pages.demo.pages.Intereactions.DroppablePage;
import com.pages.demo.pages.Intereactions.ResizablePage;
import com.pages.demo.pages.Intereactions.SelectablePage;
import com.pages.demo.pages.Intereactions.SortablePage;
import com.pages.demo.pages.alerts_frames_windows.AlertsPage;
import com.pages.demo.pages.alerts_frames_windows.FramesPage;
import com.pages.demo.pages.alerts_frames_windows.ModalDialogsPage;
import com.pages.demo.pages.alerts_frames_windows.NestedFramesPage;
import com.pages.demo.pages.bookStoreApplication.ProfilePage;
import com.pages.demo.pages.elements.*;
import com.pages.demo.pages.forms.FormsPage;
import com.pages.demo.pages.forms.PracticeFormPage;
import com.pages.demo.pages.widgets.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import static com.pages.base.BasePage.delay;
import static utilities.Utility.setUtilityDriver;

public class BaseTest {
    private final String DEMOQA_URL = "http://demoqa.com/";
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
    public AlertsPage alertsPage;
    public FramesPage framesPage;
    public NestedFramesPage nestedFramesPage;
    public ModalDialogsPage modalDialogsPage;
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
    public ProfilePage profilePage;
    public SelectablePage selectablePage;
    public ResizablePage resizablePage;
    public DroppablePage droppablePage;

    public WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(DEMOQA_URL);  // Add
        basePage = new BasePage();
        homePage = new HomePage();
        practiceFormPage = new PracticeFormPage();
        formsPage = new FormsPage();
        textBoxPage = new TextBoxPage();
        radioButtonPage = new RadioButtonPage();
        linksPage = new LinksPage();
        checkBoxPage = new CheckBoxPage();
        droppablePage = new DroppablePage();
        resizablePage = new ResizablePage();
        selectablePage = new SelectablePage();
        selectMenuPage = new SelectMenuPage();
        menuPage = new MenuPage();
        toolTipsPage = new ToolTipsPage();
        profilePage = new ProfilePage();
        tabsPage = new TabsPage();
        webTablesPage = new WebTablesPage();
        alertsPage = new AlertsPage();
        framesPage = new FramesPage();
        nestedFramesPage = new NestedFramesPage();
        modalDialogsPage = new ModalDialogsPage();
        sortablePage = new SortablePage();
        accordianPage = new AccordianPage();
        autoCompletePage = new AutoCompletePage();
        datePickerPage = new DatePickerPage();
        sliderPage = new SliderPage();
        progressBarPage = new ProgressBarPage();
        uploadAndDownloadPage = new UploadAndDownloadPage();
        dynamicPropertiesPage = new DynamicPropertiesPage();
        buttonsPage = new ButtonsPage();
        brokenLinksImagesPage = new BrokenLinksImagesPage();

        basePage.setDriver(driver);
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

    @AfterClass
    public void tearDown() {
        delay(1000);
        driver.quit();
    }

    public void navigateToUrl(String path) {
        String url = "https://demoqa.com/" + path;
        driver.navigate().to(url);
    }
}