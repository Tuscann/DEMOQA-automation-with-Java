package demoqa.web.tests.forms;

import demoqa.pages.forms.FormsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormsPageTests extends BaseTest {
    public static final String FORMS_URL = "forms";
    // Expected Text Constants
    private static final String EMPTY_STATE_MESSAGE = "Please select an item from left to start practice.";
    // URL Constants
    private static final String PRACTICE_FORM_FULL_URL = DEMO_QA_URL + "automation-practice-form";
    // Error Messages Constants
    private static final String EMPTY_STATE_ERROR = "Empty state message mismatch";
    private static final String URL_NAVIGATION_ERROR = "Practice form URL navigation failed";
    private static final String HOME_ADDRESS_ERROR = "Wrong home address";
    private FormsPage formsPage;

    @BeforeMethod
    public void goToFormsPage() {
        navigateToUrl(FORMS_URL);
        formsPage = new FormsPage(driver);
    }

    @Test(enabled = true, description = "Verify practice form link")
    public void verifyPracticeFormLinkAndAllTextOnPage() {
        // Arrange & Act
        softAssert.assertEquals(formsPage.getText(), EMPTY_STATE_MESSAGE, EMPTY_STATE_ERROR);
        formsPage.clickPracticeFormLink();
        String actualUrl = formsPage.getCurrentUrl();
        formsPage.clickTopImage();
        String url = formsPage.getCurrentUrl();

        // Assert
        softAssert.assertEquals(actualUrl, PRACTICE_FORM_FULL_URL, URL_NAVIGATION_ERROR);
        softAssert.assertEquals(url, DEMO_QA_URL, HOME_ADDRESS_ERROR);
        softAssert.assertAll();
    }
}
