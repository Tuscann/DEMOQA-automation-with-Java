package demoqa.web.tests.elements;

import demoqa.pages.elements.RadioButtonPage;
import demoqa.web.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonPageTests extends BaseTest {

    @Test(enabled = true, testName = "Check all text on page")
    public void CheckAllTextOnPage() {
        // Arrange
        navigateToUrl("radio-button");

        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);

        String expectedRadioButtonText = "Radio Button";
        String expectedActualQuestionText = "Do you like the site?";
        String expectedYesAnswerLabel = "Yes";
        String expectedImpressiveAnswerLabel = "Impressive";
        String expectedNoAnswerLabel = "No";

        String actualRadioButtonText = radioButtonPage.getHeaderText();
        String actualQuestionText = radioButtonPage.getQuestionText();
        String actualYesAnswerLabelText = radioButtonPage.getYesAnswerLabel();
        String actualImpressiveAnswerLabel = radioButtonPage.getImpressiveAnswerLabel();
        String actualNoAnswerLabel = radioButtonPage.getNoAnswerLabel();

        // Assert
        softAssert.assertEquals(actualRadioButtonText, expectedRadioButtonText, "\nNot found " + expectedRadioButtonText + ".\n");
        softAssert.assertEquals(actualYesAnswerLabelText, expectedYesAnswerLabel, "\nNot found " + expectedYesAnswerLabel + ".\n");
        softAssert.assertEquals(actualNoAnswerLabel, expectedNoAnswerLabel, "\nNot found " + expectedNoAnswerLabel + ".\n");
        softAssert.assertEquals(actualQuestionText, expectedActualQuestionText, "\nNot found " + expectedActualQuestionText + ".\n");
        softAssert.assertEquals(actualImpressiveAnswerLabel, expectedImpressiveAnswerLabel, "\nNot found " + expectedImpressiveAnswerLabel + ".\n");
        softAssert.assertFalse(radioButtonPage.isResultMessageDisplayed());
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify answer no is disabled")
    public void VerifyAnswerNoIsDisabled() {
        // Arrange
        navigateToUrl("radio-button");
        String expectedNoAnswer = "No";

        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);

        // Assert
        Assert.assertTrue(radioButtonPage.isAnswerDisable(expectedNoAnswer));
    }

    @Test(enabled = true, testName = "Choose answer yes")
    public void ChooseAnswerYes() {
        // Arrange
        navigateToUrl("radio-button");

        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);

        String expectedAnswer = "Yes";
        radioButtonPage.clickAnswer(expectedAnswer);

        String actualYesAnswer = radioButtonPage.getResultMessage();
        String expectedYesAnswer = "You have selected " + expectedAnswer;

        // Assert
        softAssert.assertTrue(radioButtonPage.isResultMessageDisplayed());
        softAssert.assertEquals(actualYesAnswer, expectedYesAnswer, "\nNot chosen yes answer.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Choose answer impressive")
    public void ChooseAnswerImpressive() {
        // Arrange
        navigateToUrl("radio-button");
        String expectedAnswer = "Impressive";

        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);

        radioButtonPage.clickAnswer(expectedAnswer);
        String actualImpressiveAnswer = radioButtonPage.getResultMessage();
        String expectedImpressiveAnswer = "You have selected " + expectedAnswer;

        // Assert
        softAssert.assertTrue(radioButtonPage.isResultMessageDisplayed());
        softAssert.assertEquals(actualImpressiveAnswer, expectedImpressiveAnswer, "\nNot chosen Impressive answer.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify green color of result message")
    public void VerifyGreenColorOfResultMessage() {
        // Arrange
        navigateToUrl("radio-button");
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        String expectedAnswer = "Impressive";
        String expectedGreenColor = "rgba(40, 167, 69, 1)";

        radioButtonPage.clickAnswer(expectedAnswer);
        String actualColor = radioButtonPage.isColorGreen();

        softAssert.assertEquals(actualColor, expectedGreenColor, "\nNot green color for Impressive answer.\n");

        expectedAnswer = "Yes";
        radioButtonPage.clickAnswer(expectedAnswer);
        actualColor = radioButtonPage.isColorGreen();

        // Assert
        softAssert.assertEquals(actualColor, expectedGreenColor, "\nNot green color For Yes answer.\n");

        softAssert.assertAll();
    }
}
