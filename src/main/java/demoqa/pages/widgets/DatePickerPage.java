package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.JavaScriptUtility.scrollToElementJS;

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

    public DatePickerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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
        scrollToElementJS(sectionOneHeading);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(sectionOneHeading));

        sectionOneHeading.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        sectionOneHeading.sendKeys(expectedDate);
        sectionOneHeading.sendKeys(Keys.chord(Keys.ENTER));
    }

    public void selectDateAndTime(String expectedDate) {
        scrollToElementJS(sectionTwoHeading);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(sectionTwoHeading));

        sectionTwoHeading.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        sectionTwoHeading.sendKeys(expectedDate);
        sectionTwoHeading.sendKeys(Keys.chord(Keys.ENTER));
    }
}
