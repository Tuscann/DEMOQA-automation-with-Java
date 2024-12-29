package com.pages.demo.pages.widgets;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DatePickerPage extends BasePage {
    private final By sectionOneHeading = By.id("datePickerMonthYearInput");
    private final By sectionTwoHeading = By.id("dateAndTimePickerInput");
    private final By datePickerText = By.xpath("//h1[contains(.,'Date Picker')]");
    private final By selectDateText = By.xpath("(//div[@class='col-md-3 col-sm-12'])[1]");
    private final By dateAndTimeText = By.xpath("(//div[@class='col-md-3 col-sm-12'])[2]");

    public String getSelectDateText() {
        return find(selectDateText).getText();
    }

    public String getSelectedDateAndTimeText() {
        return find(dateAndTimeText).getText();
    }

    public String getDatePickerText() {
        return find(datePickerText).getText();
    }

    public String getSelectedDate() {
        return find(sectionOneHeading).getDomAttribute("value");
    }

    public String getSelectedDateAndTime() {
        return find(sectionTwoHeading).getDomAttribute("value");
    }

    public void selectDate(String enterDate) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        wait.until(ExpectedConditions.visibilityOfElementLocated(sectionOneHeading))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), enterDate, Keys.chord(Keys.ENTER));
    }

    public void selectDateAndTime(String expectedDate) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        wait.until(ExpectedConditions.visibilityOfElementLocated(sectionTwoHeading))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), expectedDate, Keys.chord(Keys.ENTER));
    }
}
