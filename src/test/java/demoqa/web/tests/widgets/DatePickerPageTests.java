package demoqa.web.tests.widgets;

import demoqa.pages.widgets.DatePickerPage;
import demoqa.web.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatePickerPageTests extends BaseTest {

    public static final String DATE_PICKER_URL = "date-picker";
    private DatePickerPage datePickerPage;

    @BeforeMethod
    public void goToDatePickerPage() {
        navigateToUrl(DATE_PICKER_URL);
        datePickerPage = new DatePickerPage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange
        String expectedDatePickerText = "Date Picker";
        String expectedSelectDateText = "Select Date";
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String expectedSelectDateAndTimeText = "Date And Time";
        String expectedDateAndTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a"));

        // Act
        String actualDatePickerText = datePickerPage.getDatePickerText();
        String actualSelectDateText = datePickerPage.getSelectDateText();
        String actualSelectDate = datePickerPage.getSelectedDate();
        String actualSelectDateAndTimeText = datePickerPage.getSelectedDateAndTimeText();
        String actualDateAndTime = datePickerPage.getSelectedDateAndTime();

        // Assert
        softAssert.assertEquals(actualDatePickerText, expectedDatePickerText, "\nWrong Date Picker.\n");
        softAssert.assertEquals(actualSelectDateText, expectedSelectDateText, "\nWrong date text.\n");
        softAssert.assertEquals(actualSelectDate, expectedDate, "\nWrong current date.\n");
        softAssert.assertEquals(actualSelectDateAndTimeText, expectedSelectDateAndTimeText, "\nWrong Date and time text.\n");
        softAssert.assertEquals(actualDateAndTime, expectedDateAndTime, "Wrong current date and time");
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select valid new date")
    public void selectNewDate() throws InterruptedException {
        // Arrange
        String expectedDate = "02/14/2025";

        // Act
        var dateInput = driver.findElement(By.id("datePickerMonthYearInput"));
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

        // Assert
        softAssert.assertEquals(actualDate, expectedDate, "\nWrong Date\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Try to select non existing date")
    public void tryToSelectNonExistingDate() {
        // Arrange
        String tryToAddDate = "14/32/2021";
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) + "14";

        // Act
        datePickerPage.selectDate(tryToAddDate);
        String actualDate = datePickerPage.getSelectedDate();

        // Assert
        softAssert.assertEquals(actualDate, expectedDate, "\nWrong Date.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select valid new date and time")
    public void selectValidNewDateAndTime() throws InterruptedException {
        // Arrange
        String expectedDateAndTime = "December 19, 2024 10:15 PM";
        datePickerPage.selectDateAndTime(expectedDateAndTime);

        // Act
        String actualDateAndTime = datePickerPage.getSelectedDateAndTime();

        // Assert
        softAssert.assertEquals(actualDateAndTime, expectedDateAndTime, "\nWrong Date and time.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Try to select no existing date and time")
    public void tryToSelectNoExistingDateAndTime() {
        // Arrange
        String tryToAddDate = "December 34, 2024 10:12 PM";
        String expectedDateAndTime = "December 20, 2034 12:00 AM";

        // Act
        datePickerPage.selectDateAndTime(tryToAddDate);
        String actualDate = datePickerPage.getSelectedDateAndTime();

        // Assert
        softAssert.assertEquals(actualDate, expectedDateAndTime, "\nWrong Date.\n");
        softAssert.assertAll();
    }
}
