package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.JavaScriptUtility;

import java.time.Duration;

public class DatePickerPage extends BasePage {
    @FindBy(id = "datePickerMonthYearInput")
    private WebElement sectionOneHeading;

    @FindBy(id = "dateAndTimePickerInput")
    private WebElement sectionTwoHeading;

    @FindBy(xpath = "//h1[contains(.,'Date Picker')]")
    private WebElement datePickerText;

    @FindBy(xpath = "(//div[@class='col-md-3 col-sm-12'])[1]")
    private WebElement selectDateText;

    @FindBy(xpath = "(//div[@class='col-md-3 col-sm-12'])[2]")
    private WebElement dateAndTimeText;

    private final JavaScriptUtility javaScriptUtility;

    public DatePickerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.javaScriptUtility = new JavaScriptUtility(driver);
    }

    public String getSelectDateText() {
        return selectDateText.getText();
    }

    public String getSelectedDateAndTimeText() {
        return dateAndTimeText.getText();
    }

    public String getDatePickerText() {
        return datePickerText.getText();
    }

    public String getSelectedDate() {
        return sectionOneHeading.getDomAttribute("value");
    }

    public String getSelectedDateAndTime() {
        return sectionTwoHeading.getDomAttribute("value");
    }

    public void selectDate(String expectedDate) {
        javaScriptUtility.scrollToElementJS(sectionOneHeading);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(sectionOneHeading));

        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            sectionOneHeading.sendKeys(Keys.COMMAND + "a");
            sectionOneHeading.clear();
        } else {
            sectionOneHeading.sendKeys(Keys.CONTROL + "a");
        }
        sectionOneHeading.sendKeys(expectedDate);
        sectionOneHeading.sendKeys(Keys.chord(Keys.ENTER));
    }

    public void selectDateAndTime(String expectedDate) {
        javaScriptUtility.scrollToElementJS(sectionTwoHeading);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(sectionTwoHeading));

        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            sectionTwoHeading.sendKeys(Keys.COMMAND + "a");
        } else {
            sectionTwoHeading.sendKeys(Keys.CONTROL + "a");
        }
        sectionTwoHeading.sendKeys(expectedDate);
        sectionTwoHeading.sendKeys(Keys.chord(Keys.ENTER));
    }
}
