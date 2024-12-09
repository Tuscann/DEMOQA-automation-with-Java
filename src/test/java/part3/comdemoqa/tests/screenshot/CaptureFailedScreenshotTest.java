package part3.comdemoqa.tests.screenshot;

import com.pages.demo.pages.forms.PracticeFormPage;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class CaptureFailedScreenshotTest extends BaseTest {

    @Test
    public void testClickingSubmitButtonWithoutJavaScriptExecutor() {
        PracticeFormPage practiceFormPage = homePage.goToForms().clickPracticeForm();
        practiceFormPage.clickSubmitButton();
    }
}
