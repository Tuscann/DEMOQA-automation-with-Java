package demoqa.web.tests.alerts;

import demoqa.pages.alerts.AlertsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.SwitchToUtility;

public class AlertsPageTests extends BaseTest {
    // Page Text Constants
    private static final String HEADER_TEXT = "Alerts";
    private static final String FIRST_ALERT_TEXT = "Click Button to see alert";
    private static final String SECOND_ALERT_TEXT = "On button click, alert will appear after 5 seconds";
    private static final String THIRD_ALERT_TEXT = "On button click, confirm box will appear";
    private static final String FOURTH_ALERT_TEXT = "On button click, prompt box will appear";

    // Alert Message Constants
    private static final String INFO_ALERT_MESSAGE = "You clicked a button";
    private static final String TIMED_ALERT_MESSAGE = "This alert appeared after 5 seconds";

    // Alert Response Constants
    private static final String CANCEL_RESULT = "You selected Cancel";
    private static final String OK_RESULT = "You selected Ok";

    // Prompt Alert Constants
    private static final String PROMPT_INPUT_TEXT = "Selenium With Java";
    private static final String PROMPT_RESULT_PREFIX = "You entered ";

    // Error Messages Constants
    private static final String HEADER_MISMATCH_ERROR = "Incorrect header text";
    private static final String FIRST_TEXT_MISMATCH_ERROR = "First alert text mismatch";
    private static final String SECOND_TEXT_MISMATCH_ERROR = "Second alert text mismatch";
    private static final String THIRD_TEXT_MISMATCH_ERROR = "Third alert text mismatch";
    private static final String FOURTH_TEXT_MISMATCH_ERROR = "Fourth alert text mismatch";
    private static final String INFO_ALERT_MISMATCH_ERROR = "Information alert text mismatch";
    private static final String TIMED_ALERT_MISMATCH_ERROR = "Timed alert message mismatch";
    private static final String CANCEL_SELECTION_ERROR = "Cancel selection result mismatch";
    private static final String OK_SELECTION_ERROR = "OK selection result mismatch";
    private static final String PROMPT_RESULT_MISMATCH_ERROR = "Prompt alert result mismatch";
    private static final String ALERT_RESULT_VISIBILITY_ERROR = "Alert result visibility mismatch";

    private static final String ALERTS_PAGE_URL = "alerts";
    private AlertsPage alertsPage;
    private SwitchToUtility switchToUtility;

    @BeforeMethod
    public void goToAlertsWindowsPage() {
        navigateToUrl(ALERTS_PAGE_URL);
        alertsPage = new AlertsPage(driver);
        switchToUtility = new SwitchToUtility(driver);
    }

    @Test(enabled = true, description = "Verify all static texts on alerts page")
    public void verifyAllTextOnPage() {
        // Arrange & Act
        softAssert.assertEquals(alertsPage.getHeaderText(), HEADER_TEXT, HEADER_MISMATCH_ERROR);
        softAssert.assertEquals(alertsPage.getFirstAlertTitle(), FIRST_ALERT_TEXT, FIRST_TEXT_MISMATCH_ERROR);
        softAssert.assertEquals(alertsPage.getSecondAlertTitle(), SECOND_ALERT_TEXT, SECOND_TEXT_MISMATCH_ERROR);
        softAssert.assertEquals(alertsPage.getThirdAlertTitle(), THIRD_ALERT_TEXT, THIRD_TEXT_MISMATCH_ERROR);
        softAssert.assertEquals(alertsPage.getFourthAlertTitle(), FOURTH_ALERT_TEXT, FOURTH_TEXT_MISMATCH_ERROR);

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify text of Information alert")
    public void verifyPromptAlertWithTextInputAndAccept() {
        // Arrange & Act
        alertsPage.clickInformationAlertButton();
        String actualAlertMessage = switchToUtility.getAlertText();

        // Assert
        softAssert.assertEquals(actualAlertMessage, INFO_ALERT_MESSAGE, INFO_ALERT_MISMATCH_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify text of prompt alert after 5 seconds")
    public void verifyTextOfPromptAlertAfter5seconds() {
        // Arrange & Act
        alertsPage.clickConfirmationTimeAlertButton();
        String actualAlertMessage = switchToUtility.getAlertText();

        // Assert
        softAssert.assertEquals(actualAlertMessage, TIMED_ALERT_MESSAGE, TIMED_ALERT_MISMATCH_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify Cancel option on confirmation alert")
    public void verifyTextOfConfirmationAlertCancel() {
        // Arrange & Act
        alertsPage.clickConfirmationAlertButton();
        switchToUtility.dismissAlert();
        String actualResult = alertsPage.getConfirmationResult();

        // Assert
        softAssert.assertEquals(actualResult, CANCEL_RESULT, CANCEL_SELECTION_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify you selected ok on confirmation alert")
    public void verifyTextOfConfirmationAlertYes() {
        // Arrange & Act
        alertsPage.clickConfirmationAlertButton();
        switchToUtility.acceptAlert();
        String actualResult = alertsPage.getConfirmationResult();

        // Assert
        softAssert.assertEquals(actualResult, OK_RESULT, OK_SELECTION_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify text of message after of prompt alert")
    public void verifyTextOfPromptAlertAccept() {
        // Arrange
        String expectedResult = PROMPT_RESULT_PREFIX + PROMPT_INPUT_TEXT;

        // Act
        alertsPage.clickPromptAlertButton();
        switchToUtility.setAlertText(PROMPT_INPUT_TEXT);
        switchToUtility.acceptAlert();
        String actualResult = alertsPage.getPromptAlertResult();

        // Assert
        softAssert.assertEquals(actualResult, expectedResult, PROMPT_RESULT_MISMATCH_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify text of message after ok of prompt alert")
    public void verifyTextOfPromptAlertOK() {
        // Arrange & Act
        alertsPage.clickPromptAlertButton();
        switchToUtility.acceptAlert();
        boolean isResultMissing = alertsPage.verifyNoAlertResult();

        // Assert
        softAssert.assertTrue(isResultMissing, ALERT_RESULT_VISIBILITY_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify text of message after close prompt alert")
    public void verifyTextOfPromptAlertCancel() {
        // Arrange & Act
        alertsPage.clickPromptAlertButton();
        switchToUtility.dismissAlert();
        boolean isResultMissing = alertsPage.verifyNoAlertResult();

        // Assert
        softAssert.assertTrue(isResultMissing, ALERT_RESULT_VISIBILITY_ERROR);
        softAssert.assertAll();
    }
}