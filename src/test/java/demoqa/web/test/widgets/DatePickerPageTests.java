package demoqa.web.test.widgets;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatePickerPageTests extends BaseTest {

    @Test
    public void VerifyAllTextOnPage() {
        navigateToUrl("date-picker");

        String expectedDatePickerText = "Date Picker";
        String expectedSelectDateText = "Select Date";
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String expectedSelectDateAndTimeText = "Date And Time";
        String expectedDateAndTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy h:mm a"));

        String actualDatePickerText = datePickerPage.getDatePickerText();
        String actualSelectDateText = datePickerPage.getSelectDateText();
        String actualSelectDate = datePickerPage.getSelectedDate();
        String actualSelectDateAndTimeText = datePickerPage.getSelectedDateAndTimeText();
        String actualDateAndTime = datePickerPage.getSelectedDateAndTime();

        Assert.assertEquals(actualDatePickerText, expectedDatePickerText, "Wrong Date Picker");
        Assert.assertEquals(actualSelectDateText, expectedSelectDateText, "Wrong date text");
        Assert.assertEquals(actualSelectDate, expectedDate, "Wrong current date ");
        Assert.assertEquals(actualSelectDateAndTimeText, expectedSelectDateAndTimeText, "Wrong Date and time text");
        Assert.assertEquals(actualDateAndTime, expectedDateAndTime, "Wrong current date and time");
    }

    @Test
    public void SelectNewDate() {
        navigateToUrl("date-picker");
        String expectedDate = "10/26/2024";
        datePickerPage.selectDate(expectedDate);

        String actualDate = datePickerPage.getSelectedDate();

        Assert.assertEquals(actualDate, expectedDate, "Wrong Date");
    }

    @Test
    public void TryToSelectNoExistingDate() {
        navigateToUrl("date-picker");
        String tryToAddDate = "14/32/2021";
        datePickerPage.selectDate(tryToAddDate);

        String actualDate = datePickerPage.getSelectedDate();
        String expectedDate = "01/01/2024";

        Assert.assertEquals(actualDate, expectedDate, "Wrong Date");
    }

    @Test
    public void SelectValidNewDateAndTime() {
        navigateToUrl("date-picker");
        String expectedDateAndTime = "December 19, 2024 10:12 PM";
        datePickerPage.selectDateAndTime(expectedDateAndTime);
        String actualDateAndTime = datePickerPage.getSelectedDateAndTime();

        Assert.assertEquals(actualDateAndTime, expectedDateAndTime, "Wrong Date and time");
    }

    @Test
    public void TryToSelectNoExistingDateAndTime() {
        navigateToUrl("date-picker");
        String tryToAddDate = "December 34, 2024 10:12 PM";
        datePickerPage.selectDateAndTime(tryToAddDate);

        String actualDate = datePickerPage.getSelectedDateAndTime();
        String expectedDateAndTime = "December 20, 2034 12:00 AM";

        Assert.assertEquals(actualDate, expectedDateAndTime, "Wrong Date");
    }
}
