package demoqa.web.tests.elements;

import demoqa.pages.elements.RadioButtonPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonPageTests extends BaseTest {
    // Text Constants
    private static final String EXPECTED_RADIO_BUTTON_HEADER = "Radio Button";
    private static final String EXPECTED_QUESTION_TEXT = "Do you like the site?";
    private static final String YES_ANSWER = "Yes";
    private static final String IMPRESSIVE_ANSWER = "Impressive";
    private static final String NO_ANSWER = "No";

    // Message Constants
    private static final String EXPECTED_YES_SELECTION_MESSAGE = "You have selected Yes";
    private static final String EXPECTED_IMPRESSIVE_SELECTION_MESSAGE = "You have selected Impressive";

    // Color Constants
    private static final String EXPECTED_GREEN_COLOR = "rgba(40, 167, 69, 1)";

    // Error Message Constants
    private static final String HEADER_TEXT_MISMATCH = "Radio button header text mismatch";
    private static final String QUESTION_TEXT_MISMATCH = "Question text mismatch";
    private static final String YES_ANSWER_LABEL_MISMATCH = "Yes answer label mismatch";
    private static final String IMPRESSIVE_ANSWER_LABEL_MISMATCH = "Impressive answer label mismatch";
    private static final String NO_ANSWER_LABEL_MISMATCH = "No answer label mismatch";
    private static final String YES_ANSWER_NOT_CHOSEN_ERROR = "Yes answer not chosen properly";
    private static final String IMPRESSIVE_ANSWER_NOT_CHOSEN_ERROR = "Impressive answer not chosen properly";
    private static final String GREEN_COLOR_IMPRESSIVE_ERROR = "Green color not displayed for Impressive answer";
    private static final String GREEN_COLOR_YES_ERROR = "Green color not displayed for Yes answer";
    private static final String RADIO_BUTTON_URL = "radio-button";
    private RadioButtonPage radioButtonPage;

    @BeforeMethod
    public void goToRadioButtonPage() {
        navigateToUrl(RADIO_BUTTON_URL);
        radioButtonPage = new RadioButtonPage(driver);
    }

    @Test(enabled = true, description = "Verify all text elements on the radio button page")
    public void verifyAllTextOnPage() {
        // Arrange & Act & Assert
        softAssert.assertEquals(radioButtonPage.getHeaderText(), EXPECTED_RADIO_BUTTON_HEADER, HEADER_TEXT_MISMATCH);
        softAssert.assertEquals(radioButtonPage.getQuestionText(), EXPECTED_QUESTION_TEXT, QUESTION_TEXT_MISMATCH);
        softAssert.assertEquals(radioButtonPage.getYesAnswerLabel(), YES_ANSWER, YES_ANSWER_LABEL_MISMATCH);
        softAssert.assertEquals(radioButtonPage.getImpressiveAnswerLabel(), IMPRESSIVE_ANSWER, IMPRESSIVE_ANSWER_LABEL_MISMATCH);
        softAssert.assertEquals(radioButtonPage.getNoAnswerLabel(), NO_ANSWER, NO_ANSWER_LABEL_MISMATCH);
        softAssert.assertFalse(radioButtonPage.isResultMessageDisplayed());
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify that the No answer option is disabled")
    public void verifyAnswerNoIsDisabled() {
        // Arrange & Act & Assert
        softAssert.assertFalse(radioButtonPage.isAnswerEnabled(NO_ANSWER));
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify that the Yes And Impressive  answers option are enabled")
    public void verifyAnswerYesAndImpressiveAreEnabled() {
        // Arrange & Act & Assert
        softAssert.assertTrue(radioButtonPage.isAnswerEnabled(IMPRESSIVE_ANSWER));
        softAssert.assertTrue(radioButtonPage.isAnswerEnabled(YES_ANSWER));
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Choose Yes answer and Impressive and verify selection message")
    public void chooseAnswerYesAndImpressiveAnswer() {
        // Arrange & Act
        radioButtonPage.clickAnswer(YES_ANSWER);
        String currentResultMessage = radioButtonPage.getResultMessage();
        radioButtonPage.clickAnswer(IMPRESSIVE_ANSWER);
        String currentResultMessage2 = radioButtonPage.getResultMessage();

        // Assert
        softAssert.assertEquals(currentResultMessage, EXPECTED_YES_SELECTION_MESSAGE, YES_ANSWER_NOT_CHOSEN_ERROR);
        softAssert.assertEquals(currentResultMessage2, EXPECTED_IMPRESSIVE_SELECTION_MESSAGE, IMPRESSIVE_ANSWER_NOT_CHOSEN_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify green color of result message for different answers")
    public void verifyGreenColorOfResultMessage() {
        // Arrange & Act &  Assert
        radioButtonPage.clickAnswer(IMPRESSIVE_ANSWER);
        softAssert.assertEquals(radioButtonPage.getResultMessageColor(), EXPECTED_GREEN_COLOR, GREEN_COLOR_IMPRESSIVE_ERROR);

        radioButtonPage.clickAnswer(YES_ANSWER);
        softAssert.assertEquals(radioButtonPage.getResultMessageColor(), EXPECTED_GREEN_COLOR, GREEN_COLOR_YES_ERROR);
        softAssert.assertAll();
    }
}
