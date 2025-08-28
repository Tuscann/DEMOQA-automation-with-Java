package demoqa.web.tests.widgets;

import demoqa.pages.widgets.DatePickerPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatePickerPageTests extends BaseTest {

    // Text Constants
    private static final String EXPECTED_DATE_PICKER_TEXT = "Date Picker";
    private static final String EXPECTED_SELECT_DATE_TEXT = "Select Date";
    private static final String EXPECTED_SELECT_DATE_AND_TIME_TEXT = "Date And Time";
    private static final String EXPECTED_NEW_DATE = "02/14/2025";
    private static final String EXPECTED_NEW_DATE_AND_TIME = "December 19, 2024 10:15 PM";
    private static final String EXPECTED_NON_EXISTING_DATE = "14/32/2021";

    // Error Message Constants
    private static final String WRONG_DATE_PICKER = "\nWrong Date Picker.\n";
    private static final String WRONG_DATE_TEXT = "\nWrong date text.\n";
    private static final String WRONG_CURRENT_DATE = "\nWrong current date.\n";
    private static final String WRONG_DATE_AND_TIME_TEXT = "\nWrong Date and time text.\n";
    private static final String WRONG_CURRENT_DATE_AND_TIME = "Wrong current date and time";
    private static final String WRONG_DATE = "\nWrong Date\n";
    private static final String WRONG_DATE_AND_TIME = "\nWrong Date and time.\n";

    public static final String DATE_PICKER_URL = "date-picker";
    private DatePickerPage datePickerPage;

    @BeforeMethod
    public void goToDatePickerPage() {
        navigateToUrl(DATE_PICKER_URL);
        datePickerPage = new DatePickerPage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange & Act
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String expectedDateAndTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a"));

        // Assert
        softAssert.assertEquals(datePickerPage.getDatePickerText(), EXPECTED_DATE_PICKER_TEXT, WRONG_DATE_PICKER);
        softAssert.assertEquals(datePickerPage.getSelectDateText(), EXPECTED_SELECT_DATE_TEXT, WRONG_DATE_TEXT);
        softAssert.assertEquals(datePickerPage.getSelectedDate(), expectedDate, WRONG_CURRENT_DATE);
        softAssert.assertEquals(datePickerPage.getSelectedDateAndTimeText(), EXPECTED_SELECT_DATE_AND_TIME_TEXT, WRONG_DATE_AND_TIME_TEXT);
        softAssert.assertEquals(datePickerPage.getSelectedDateAndTime(), expectedDateAndTime, WRONG_CURRENT_DATE_AND_TIME);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select valid new date")
    public void createNewSelectDate() throws InterruptedException {
        // Arrange & Act
        datePickerPage.createNewSelectDate();

        // Assert
        softAssert.assertEquals(datePickerPage.getSelectedDate(), EXPECTED_NEW_DATE, WRONG_DATE);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Try to select non existing date")
    public void createNonExistingSelectDate() {
        // Arrange
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) + "14";

        // Act
        datePickerPage.selectDate(EXPECTED_NON_EXISTING_DATE);

        // Assert
        softAssert.assertEquals(datePickerPage.getSelectedDate(), expectedDate, WRONG_DATE);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select valid new date and time")
    public void createNewDateAndTime() throws InterruptedException {
        // Arrange
        datePickerPage.selectDateAndTime(EXPECTED_NEW_DATE_AND_TIME);

        // Act
        String actualDateAndTime = datePickerPage.getSelectedDateAndTime();

        // Assert
        softAssert.assertEquals(actualDateAndTime, EXPECTED_NEW_DATE_AND_TIME, WRONG_DATE_AND_TIME);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Try to select no existing date and time")
    public void selectNoExistingDateAndTime() {
        // Arrange
        String tryToAddDate = "December 34, 2024 10:12 PM";
        String expectedDateAndTime = "December 20, 2034 12:00 AM";

        // Act
        datePickerPage.selectDateAndTime(tryToAddDate);

        // Assert
        softAssert.assertEquals(datePickerPage.getSelectedDateAndTime(), expectedDateAndTime, WRONG_DATE_AND_TIME);
        softAssert.assertAll();
    }
}
