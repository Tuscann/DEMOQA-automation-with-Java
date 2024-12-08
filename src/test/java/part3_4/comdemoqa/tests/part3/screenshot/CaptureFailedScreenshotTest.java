package part3_4.comdemoqa.tests.part3.screenshot;


import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

public class CaptureFailedScreenshotTest extends BaseTest {

    @Test
    public void testClickingSubmitButtonWithoutJavaScriptExecutor() {
        var practiceFormPage = homePage.goToForms().clickPracticeForm();
        practiceFormPage.clickSubmitButton();
    }
}
