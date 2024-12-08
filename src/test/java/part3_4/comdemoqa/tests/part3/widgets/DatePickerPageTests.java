package part3_4.comdemoqa.tests.part3.widgets;

import com.pages.demo.pages.widgets.DatePickerPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

public class DatePickerPageTests extends BaseTest {

    @Test
    public void selectNewDate() {
        DatePickerPage datePickerPage = homePage.goToWidgets().clickDatePicker();

        String expectedDate = "10/26/2024";
        datePickerPage.selectDate(expectedDate);

        String actualDate = datePickerPage.getSelectedDate();

        Assert.assertEquals(actualDate, expectedDate, "Wrong Date");
    }

    @Test
    public void selectNewDateAndTime() {
        DatePickerPage datePickerPage = homePage.goToWidgets().clickDatePicker();

        String expectedDateAndTime = "December 19, 2024 10:12 PM";
        datePickerPage.selectDateAndTime(expectedDateAndTime);
        String actualDateAndTime = datePickerPage.getSelectedDateAndTime();

        Assert.assertEquals(actualDateAndTime, expectedDateAndTime, "Wrong Date and time");
    }
}
