package part3.comdemoqa.tests.widgets;

import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class AutoCompletePageTests extends BaseTest {
    @Test
    public void selectTwoColors() {
        navigateToUrl("auto-complete");

        String expectedColor = "Red";
        autoCompletePage.multiAutoComplete(expectedColor);

        // String actualDate = datePickerPage.getSelectedDate();

        //Assert.assertEquals(actualDate, expectedDate, "Wrong Date");
    }
}
