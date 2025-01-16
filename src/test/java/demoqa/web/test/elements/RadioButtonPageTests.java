package demoqa.web.test.elements;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonPageTests extends BaseTest {

    @Test(enabled = true)
    public void CheckAllTextOnPage() {
        navigateToUrl("radio-button");

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

        Assert.assertEquals(actualRadioButtonText, expectedRadioButtonText, "\nNot found " + expectedRadioButtonText + ".\n");
        Assert.assertEquals(actualYesAnswerLabelText, expectedYesAnswerLabel, "\nNot found " + expectedYesAnswerLabel + ".\n");
        Assert.assertEquals(actualNoAnswerLabel, expectedNoAnswerLabel, "\nNot found " + expectedNoAnswerLabel + ".\n");
        Assert.assertEquals(actualQuestionText, expectedActualQuestionText, "\nNot found " + expectedActualQuestionText + ".\n");
        Assert.assertEquals(actualImpressiveAnswerLabel, expectedImpressiveAnswerLabel, "\nNot found " + expectedImpressiveAnswerLabel + ".\n");
        Assert.assertTrue(radioButtonPage.isResultMessageDisplayed());
    }

    @Test(enabled = true)
    public void VerifyAnswerNoIsDisabled() {
        navigateToUrl("radio-button");
        String expectedNoAnswer = "No";

        Assert.assertTrue(radioButtonPage.isAnswerDisable(expectedNoAnswer));
    }

    @Test(enabled = true)
    public void ChooseAnswerYes() {
        navigateToUrl("radio-button");

        String expectedAnswer = "Yes";
        radioButtonPage.clickAnswer(expectedAnswer);

        String actualYesAnswer = radioButtonPage.getResultMessage();
        String expectedYesAnswer = "You have selected " + expectedAnswer;

        Assert.assertFalse(radioButtonPage.isResultMessageDisplayed());
        Assert.assertEquals(actualYesAnswer, expectedYesAnswer, "\nNot chosen yes answer.\n");
    }

    @Test(enabled = true)
    public void ChooseAnswerImpressive() {
        navigateToUrl("radio-button");

        String expectedAnswer = "Impressive";
        radioButtonPage.clickAnswer(expectedAnswer);

        String actualAnswer = radioButtonPage.getResultMessage();
        String expectedImpressiveAnswer = "You have selected " + expectedAnswer;

        softAssert.assertFalse(radioButtonPage.isResultMessageDisplayed());
        softAssert.assertEquals(actualAnswer, expectedImpressiveAnswer, "\nNot chosen Impressive answer.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true)
    public void VerifyGreenColorOfMessage() {
        navigateToUrl("radio-button");

        String expectedAnswer = "Impressive";
        radioButtonPage.clickAnswer(expectedAnswer);

        String expectedGreenColor = "rgba(40, 167, 69, 1)";
        String actualColor = radioButtonPage.isColorGreen();

        softAssert.assertEquals(actualColor, expectedGreenColor, "\nNot green color for Impressive answer.\n");

        expectedAnswer = "Yes";
        radioButtonPage.clickAnswer(expectedAnswer);
        actualColor = radioButtonPage.isColorGreen();

        softAssert.assertEquals(actualColor, expectedGreenColor, "\nNot green color For Yes answer.\n");

        softAssert.assertAll();
    }
}
