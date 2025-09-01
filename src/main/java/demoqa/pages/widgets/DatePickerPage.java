package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
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
    private final JavaScriptUtility javaScriptUtility;
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
        wait.until(ExpectedConditions.elementToBeClickable(sectionOneHeading));

//        String osName = System.getProperty("os.name").toLowerCase();
//        if (osName.contains("mac")) {
//            sectionOneHeading.sendKeys(Keys.COMMAND + "a");
//            sectionOneHeading.clear();
//        } else {
//            sectionOneHeading.sendKeys(Keys.CONTROL + "a");
//        }
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

    public void createNewSelectDate() throws InterruptedException {
        WebElement dateInput = driver.findElement(By.id("datePickerMonthYearInput"));
        dateInput.click();
        Thread.sleep(500); // Wait for date picker to open

        // Click the month dropdown and select February
        driver.findElement(By.className("react-datepicker__month-select")).click();
        driver.findElement(By.xpath("//option[@value='1']")).click(); // February is value 1 (0-based)

        // Click the year dropdown and select 2025
        driver.findElement(By.className("react-datepicker__year-select")).click();
        driver.findElement(By.xpath("//option[@value='2025']")).click();

        // Click the specific date (14th)
        driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day--014')][@role='option']")).click();
        Thread.sleep(500); // Wait for date picker to update
    }
}
