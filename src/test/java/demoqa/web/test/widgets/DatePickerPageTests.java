package demoqa.web.test.widgets;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatePickerPageTests extends BaseTest {

    @Test(enabled = true)
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

        Assert.assertEquals(actualDatePickerText, expectedDatePickerText, "\nWrong Date Picker.\n");
        Assert.assertEquals(actualSelectDateText, expectedSelectDateText, "\nWrong date text.\n");
        Assert.assertEquals(actualSelectDate, expectedDate, "\nWrong current date.\n");
        Assert.assertEquals(actualSelectDateAndTimeText, expectedSelectDateAndTimeText, "\nWrong Date and time text.\n");

        String expectedDateAndTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a"));
        Assert.assertEquals(actualDateAndTime, expectedDateAndTime, "Wrong current date and time");
    }

    @Test(enabled = true)
    public void SelectNewDate() {
        navigateToUrl("date-picker");
        String expectedDate = "10/26/2024";
        datePickerPage.selectDate(expectedDate);

        String actualDate = datePickerPage.getSelectedDate();

        Assert.assertEquals(actualDate, expectedDate, "\nWrong Date\n");
    }

    @Test(enabled = true)
    public void TryToSelectNoExistingDate() {
        navigateToUrl("date-picker");
        String tryToAddDate = "14/32/2021";
        datePickerPage.selectDate(tryToAddDate);

        String actualDate = datePickerPage.getSelectedDate();
        String expectedDate = "01/01/2025";

        Assert.assertEquals(actualDate, expectedDate, "\nWrong Date.\n");
    }

    @Test(enabled = true)
    public void SelectValidNewDateAndTime() {
        navigateToUrl("date-picker");
        String expectedDateAndTime = "December 19, 2024 10:12 PM";
        datePickerPage.selectDateAndTime(expectedDateAndTime);
        String actualDateAndTime = datePickerPage.getSelectedDateAndTime();

        Assert.assertEquals(actualDateAndTime, expectedDateAndTime, "\nWrong Date and time.\n");
    }

    @Test(enabled = true)
    public void TryToSelectNoExistingDateAndTime() {
        navigateToUrl("date-picker");
        String tryToAddDate = "December 34, 2024 10:12 PM";
        datePickerPage.selectDateAndTime(tryToAddDate);

        String actualDate = datePickerPage.getSelectedDateAndTime();
        String expectedDateAndTime = "December 20, 2034 12:00 AM";

        Assert.assertEquals(actualDate, expectedDateAndTime, "\nWrong Date.\n");
    }
}
