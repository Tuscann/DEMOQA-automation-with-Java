package part3_4.comdemoqa.tests.part3.widgets;

import com.pages.demo.pages.widgets.AutoCompletePage;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

public class AutoCompletePageTests extends BaseTest {
    @Test
    public void selectTwoColors() {
        AutoCompletePage autoCompletePage = homePage.goToWidgets().clickAutoComplete();

        String expectedColor = "Red";
        autoCompletePage.multiAutoComplete(expectedColor);

        // String actualDate = datePickerPage.getSelectedDate();

        //Assert.assertEquals(actualDate, expectedDate, "Wrong Date");
    }
}
