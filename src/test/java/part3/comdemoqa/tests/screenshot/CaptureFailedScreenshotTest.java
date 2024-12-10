package part3.comdemoqa.tests.screenshot;

import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class CaptureFailedScreenshotTest extends BaseTest {

    @Test
    public void testClickingSubmitButtonWithoutJavaScriptExecutor() {
        navigateToUrl("automation-practice-form");
        practiceFormPage.clickSubmitButton();
    }
}
