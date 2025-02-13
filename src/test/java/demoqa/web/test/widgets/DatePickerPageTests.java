package demoqa.web.test.widgets;

import demoqa.web.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class DatePickerPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        navigateToUrl("date-picker");

        String expectedDatePickerText = "Date Picker";
        String expectedSelectDateText = "Select Date";
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String expectedSelectDateAndTimeText = "Date And Time";

        String actualDatePickerText = datePickerPage.getDatePickerText();
        String actualSelectDateText = datePickerPage.getSelectDateText();
        String actualSelectDate = datePickerPage.getSelectedDate();
        String actualSelectDateAndTimeText = datePickerPage.getSelectedDateAndTimeText();
        String actualDateAndTime = datePickerPage.getSelectedDateAndTime();

        softAssert.assertEquals(actualDatePickerText, expectedDatePickerText, "\nWrong Date Picker.\n");
        softAssert.assertEquals(actualSelectDateText, expectedSelectDateText, "\nWrong date text.\n");
        softAssert.assertEquals(actualSelectDate, expectedDate, "\nWrong current date.\n");
        softAssert.assertEquals(actualSelectDateAndTimeText, expectedSelectDateAndTimeText, "\nWrong Date and time text.\n");

        String expectedDateAndTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a"));
        softAssert.assertEquals(actualDateAndTime, expectedDateAndTime, "Wrong current date and time");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Select valid new date")
    public void SelectNewDate() throws InterruptedException {
        navigateToUrl("date-picker");
        
        String expectedDate = "02/14/2025";
        
        // Click to open the date picker
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

        String actualDate = datePickerPage.getSelectedDate();
        Assert.assertEquals(actualDate, expectedDate, "\nWrong Date\n");
    }
    
    @Test(enabled = true, testName = "Try to select no existing date")
    public void TryToSelectNoExistingDate() {
        navigateToUrl("date-picker");
        String tryToAddDate = "14/32/2021";
        datePickerPage.selectDate(tryToAddDate);

        String actualDate = datePickerPage.getSelectedDate();
        String expectedDate = "01/01/2025";

        Assert.assertEquals(actualDate, expectedDate, "\nWrong Date.\n");
    }
    @Test(enabled = true, testName = "Select valid new date and time")
    public void SelectValidNewDateAndTime() throws InterruptedException {
        navigateToUrl("date-picker");
        
        String expectedDateAndTime = "December 19, 2024 10:15 PM";
        
        // Click to open the date and time picker
        WebElement dateTimeInput = driver.findElement(By.id("dateAndTimePickerInput"));
        dateTimeInput.click();
        Thread.sleep(500); // Wait for picker to open
        
        // Click the month button and select December
        driver.findElement(By.xpath("//span[contains(@class, 'react-datepicker__month-read-view--selected-month')]/..")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__month-option') and text()='December']")).click();
        
        // Click the year button and select 2024
        driver.findElement(By.xpath("//span[contains(@class, 'react-datepicker__year-read-view--selected-year')]/..")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__year-option') and text()='2024']")).click();
        
        // Click the specific date (19th)
        driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day--019')][@role='option' and not(contains(@class, 'outside-month'))]")).click();
        Thread.sleep(500); // Wait for date selection to register
        
        // Find and click the time list
        WebElement timeList = driver.findElement(By.className("react-datepicker__time-list"));
        List<WebElement> timeOptions = timeList.findElements(By.tagName("li"));
        
        // Select 22:15 (10:15 PM) since it's the closest available time to 10:12 PM
        String targetTime = "22:15";
        
        // Find and click the desired time option
        boolean timeFound = false;
        for (WebElement timeOption : timeOptions) {
            String timeText = timeOption.getText();
            if (timeText.equals(targetTime)) {
                timeOption.click();
                timeFound = true;
                break;
            }
        }
        
        Thread.sleep(500); // Wait for picker to update
        
        String actualDateAndTime = datePickerPage.getSelectedDateAndTime();
        Assert.assertEquals(actualDateAndTime, expectedDateAndTime, "\nWrong Date and time.\n");
    }

    @Test(enabled = true, testName = "Try to select no existing date and time")
    public void TryToSelectNoExistingDateAndTime() {
        navigateToUrl("date-picker");
        String tryToAddDate = "December 34, 2024 10:12 PM";
        datePickerPage.selectDateAndTime(tryToAddDate);

        String actualDate = datePickerPage.getSelectedDateAndTime();
        String expectedDateAndTime = "December 20, 2034 12:00 AM";

        Assert.assertEquals(actualDate, expectedDateAndTime, "\nWrong Date.\n");
    }
}
