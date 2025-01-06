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

        Assert.assertEquals(actualRadioButtonText, expectedRadioButtonText, "Not found " + expectedRadioButtonText);
        Assert.assertEquals(actualYesAnswerLabelText, expectedYesAnswerLabel, "Not found " + expectedYesAnswerLabel);
        Assert.assertEquals(actualNoAnswerLabel, expectedNoAnswerLabel, "Not found " + expectedNoAnswerLabel);
        Assert.assertEquals(actualQuestionText, expectedActualQuestionText, "Not found " + expectedActualQuestionText);
        Assert.assertEquals(actualImpressiveAnswerLabel, expectedImpressiveAnswerLabel, "Not found " + expectedImpressiveAnswerLabel);
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

        String actualAnswer = radioButtonPage.getResultMessage();

        Assert.assertFalse(radioButtonPage.isResultMessageDisplayed());
        Assert.assertEquals(actualAnswer, "You have selected " + expectedAnswer, "\nNot chosen yes answer\n");
    }

    @Test(enabled = true)
    public void ChooseAnswerImpressive() {
        navigateToUrl("radio-button");

        String expectedAnswer = "Impressive";
        radioButtonPage.clickAnswer(expectedAnswer);

        String actualAnswer = radioButtonPage.getResultMessage();

        Assert.assertFalse(radioButtonPage.isResultMessageDisplayed());
        Assert.assertEquals(actualAnswer, "You have selected " + expectedAnswer, "\nNot chosen Impressive answer\n");
    }

    @Test(enabled = true)
    public void VerifyGreenColorOfMessage() {
        navigateToUrl("radio-button");

        String expectedAnswer = "Impressive";
        radioButtonPage.clickAnswer(expectedAnswer);

        String greenColor = "rgba(40, 167, 69, 1)";
        String actualColor = radioButtonPage.isColorGreen();

        Assert.assertEquals(actualColor, greenColor, "\nNot green color for Impressive answer\n");

        expectedAnswer = "Yes";
        radioButtonPage.clickAnswer(expectedAnswer);
        actualColor = radioButtonPage.isColorGreen();

        Assert.assertEquals(actualColor, greenColor, "\nNot green color For Yes answer\n");
    }
}
