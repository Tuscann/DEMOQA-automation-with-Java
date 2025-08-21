package demoqa.web.tests.forms;

import demoqa.pages.forms.FormsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormsPageTests extends BaseTest {
    // Expected Text Constants
    private static final String EMPTY_STATE_MESSAGE = "Please select an item from left to start practice.";

    // URL Constants
    private static final String PRACTICE_FORM_FULL_URL = DEMO_QA_URL + "automation-practice-form";

    // Error Messages Constants
    private static final String EMPTY_STATE_ERROR = "Empty state message mismatch";
    private static final String URL_NAVIGATION_ERROR = "Practice form URL navigation failed";

    public static final String FORMS_URL = "forms";
    private FormsPage formsPage;

    @BeforeMethod
    public void goToFormsPage() {
        navigateToUrl(FORMS_URL);
        formsPage = new FormsPage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void checkAllTextOnPage() {
        // Arrange & Act
        String actualText = formsPage.getText();

        // Assert
        softAssert.assertEquals(actualText, EMPTY_STATE_MESSAGE, EMPTY_STATE_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify practice form link")
    public void verifyPracticeFormLink() {
        // Arrange & Act
        formsPage.clickPracticeFormLink();
        String actualUrl = formsPage.checkUrl();

        // Assert
        softAssert.assertEquals(actualUrl, PRACTICE_FORM_FULL_URL, URL_NAVIGATION_ERROR);
        softAssert.assertAll();
    }
}
