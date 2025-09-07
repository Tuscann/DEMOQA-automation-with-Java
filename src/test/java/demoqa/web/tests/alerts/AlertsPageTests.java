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
    private static final String CLICK_ME_BUTTON_TEXT = "Click me";

    // Alert Message Constants
    private static final String INFO_ALERT_MESSAGE = "You clicked a button";
    private static final String TIMED_ALERT_MESSAGE = "This alert appeared after 5 seconds";

    // Alert Response Constants
    private static final String CANCEL_RESULT = "You selected Cancel";
    private static final String OK_RESULT = "You selected Ok";

    // Color Constants
    private static final String EXPECTED_BLUE_COLOR = "rgba(0, 123, 255, 1)";
    private static final String EXPECTED_GREEN_COLOR = "rgba(40, 167, 69, 1)";

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
    private static final String CLICK_ME_FIRST_BUTTON_TEXT_ERROR = "Wrong text on first button click me";
    private static final String CLICK_ME_SECOND_BUTTON_TEXT_ERROR = "Wrong text on second button click me";
    private static final String CLICK_ME_THIRD_BUTTON_TEXT_ERROR = "Wrong text on third button click me";
    private static final String CLICK_ME_FOURTH_BUTTON_TEXT_ERROR = "Wrong text on four button click me";
    private static final String CLICK_ME_FIRST_BUTTON_BACKGROUND_COLOR_ERROR = "Wrong background color on first button click me";
    private static final String CLICK_ME_SECOND_BUTTON_BACKGROUND_COLOR_ERROR = "Wrong background color on second button click me";
    private static final String CLICK_ME_THIRD_BUTTON_BACKGROUND_COLOR_ERROR = "Wrong background color on third button click me";
    private static final String CLICK_ME_FOURTH_BUTTON_BACKGROUND_COLOR_ERROR = "Wrong background color on four button click me";
    private static final String RESULT_BACKGROUND_COLOR_ERROR = "Wrong background color of result message";

    private static final String ALERTS_PAGE_URL = "alerts";
    private AlertsPage alertsPage;
    private SwitchToUtility switchToUtility;

    @BeforeMethod
    public void goToAlertsWindowsPage() {
        alertsPage = new AlertsPage(driver);
        navigateToUrl(ALERTS_PAGE_URL);

        switchToUtility = new SwitchToUtility(driver);
    }

    @Test(enabled = true, description = "Verify all static texts on alerts page")
    public void verifyAllTextOnPage() {
        // Arrange & Act
        softAssert.assertEquals(alertsPage.getAlertsHeaderText(), HEADER_TEXT, HEADER_MISMATCH_ERROR);

        softAssert.assertEquals(alertsPage.getFirstAlertTitle(), FIRST_ALERT_TEXT, FIRST_TEXT_MISMATCH_ERROR);
        softAssert.assertEquals(alertsPage.getSecondAlertTitle(), SECOND_ALERT_TEXT, SECOND_TEXT_MISMATCH_ERROR);
        softAssert.assertEquals(alertsPage.getThirdAlertTitle(), THIRD_ALERT_TEXT, THIRD_TEXT_MISMATCH_ERROR);
        softAssert.assertEquals(alertsPage.getFourthAlertTitle(), FOURTH_ALERT_TEXT, FOURTH_TEXT_MISMATCH_ERROR);

        softAssert.assertEquals(alertsPage.getFirstClickMeButtonBackGroundColor(), EXPECTED_BLUE_COLOR, CLICK_ME_FIRST_BUTTON_BACKGROUND_COLOR_ERROR);
        softAssert.assertEquals(alertsPage.getSecondClickMeButtonBackGroundColor(), EXPECTED_BLUE_COLOR, CLICK_ME_SECOND_BUTTON_BACKGROUND_COLOR_ERROR);
        softAssert.assertEquals(alertsPage.getThirdClickMeButtonBackGroundColor(), EXPECTED_BLUE_COLOR, CLICK_ME_THIRD_BUTTON_BACKGROUND_COLOR_ERROR);
        softAssert.assertEquals(alertsPage.getFourthClickMeButtonBackGroundColor(), EXPECTED_BLUE_COLOR, CLICK_ME_FOURTH_BUTTON_BACKGROUND_COLOR_ERROR);

        softAssert.assertEquals(alertsPage.getFirstClickMeButtonText(), CLICK_ME_BUTTON_TEXT, CLICK_ME_FIRST_BUTTON_TEXT_ERROR);
        softAssert.assertEquals(alertsPage.getSecondClickMeButtonText(), CLICK_ME_BUTTON_TEXT, CLICK_ME_SECOND_BUTTON_TEXT_ERROR);
        softAssert.assertEquals(alertsPage.getThirdClickMeButtonText(), CLICK_ME_BUTTON_TEXT, CLICK_ME_THIRD_BUTTON_TEXT_ERROR);
        softAssert.assertEquals(alertsPage.getFourClickButtonText(), CLICK_ME_BUTTON_TEXT, CLICK_ME_FOURTH_BUTTON_TEXT_ERROR);

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify text on see alert")
    public void verifyPromptAlertTextAndClickOk() {
        // Arrange & Act
        alertsPage.clickInformationAlertButton();
        String actualAlertMessage = switchToUtility.getAlertText();
        switchToUtility.ClickOKButton();

        // Assert
        softAssert.assertEquals(actualAlertMessage, INFO_ALERT_MESSAGE, INFO_ALERT_MISMATCH_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify text of prompt alert after 5 seconds")
    public void verifyTextOfPromptAlertAfter5seconds() {
        // Arrange & Act
        alertsPage.clickConfirmationTimeAlertButton();
        String actualAlertMessage = switchToUtility.getAlertText();
        switchToUtility.ClickOKButton();

        // Assert
        softAssert.assertEquals(actualAlertMessage, TIMED_ALERT_MESSAGE, TIMED_ALERT_MISMATCH_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify selected OK on confirmation alert")
    public void verifyTextOfConfirmationAlertOk() {
        // Arrange & Act
        alertsPage.clickConfirmationAlertButton();
        switchToUtility.acceptAlert();
        String resultBackgroundColor = alertsPage.getConfirmationResultBackgroundColor();

        // Assert
        softAssert.assertEquals(resultBackgroundColor, EXPECTED_GREEN_COLOR, RESULT_BACKGROUND_COLOR_ERROR);
        softAssert.assertEquals(alertsPage.getConfirmationResult(), OK_RESULT, OK_SELECTION_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify Cancel option on confirmation alert")
    public void verifyTextOfConfirmationAlertCancel() {
        // Arrange & Act
        alertsPage.clickConfirmationAlertButton();
        switchToUtility.dismissAlert();
        String resultBackgroundColor = alertsPage.getConfirmationResultBackgroundColor();

        // Assert
        softAssert.assertEquals(resultBackgroundColor, EXPECTED_GREEN_COLOR, RESULT_BACKGROUND_COLOR_ERROR);
        softAssert.assertEquals(alertsPage.getConfirmationResult(), CANCEL_RESULT, CANCEL_SELECTION_ERROR);
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

    @Test(enabled = true, description = "Verify text of message after of prompt alert")
    public void verifyTextOfPromptAlertAccept() {
        // Arrange & Act
        alertsPage.clickPromptAlertButton();
        switchToUtility.setAlertText(PROMPT_INPUT_TEXT);
        switchToUtility.acceptAlert();
        String actualResultMessage = alertsPage.getPromptAlertResult();
        String actualResultMessageBackgroundColor = alertsPage.getPromptResultBackgroundColor();

        // Assert
        softAssert.assertEquals(actualResultMessage, PROMPT_RESULT_PREFIX + PROMPT_INPUT_TEXT, PROMPT_RESULT_MISMATCH_ERROR);
        softAssert.assertEquals(actualResultMessageBackgroundColor, EXPECTED_GREEN_COLOR, RESULT_BACKGROUND_COLOR_ERROR);
        softAssert.assertAll();
    }
}