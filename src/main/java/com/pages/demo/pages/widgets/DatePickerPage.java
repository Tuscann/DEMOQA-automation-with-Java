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

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void selectDate(String enterDate) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(sectionOneHeading))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), enterDate, Keys.chord(Keys.ENTER));
    }

    public String getSelectedDate() {
        return find(sectionOneHeading).getAttribute("value");
    }

    public void selectDateAndTime(String expectedDate) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sectionTwoHeading))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), expectedDate, Keys.chord(Keys.ENTER));
    }

    public String getSelectedDateAndTime() {
        return find(sectionTwoHeading).getAttribute("value");
    }
}
