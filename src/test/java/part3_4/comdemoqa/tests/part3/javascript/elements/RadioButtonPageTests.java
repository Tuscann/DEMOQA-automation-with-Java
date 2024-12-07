package part3_4.comdemoqa.tests.part3.javascript.elements;

import com.pages.demo.pages.elements.RadioButtonPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

public class RadioButtonPageTests extends BaseTest {

    @Test
    public void CheckAllElements() {
        RadioButtonPage radioButtonPage = homePage.goToElements().clickRadioButton();

        String expectedRadioButtonText = "Radio Button";
        String expectedYesAnswerLabel = "Yes";
        String expectedImpressiveAnswerLabel = "Impressive";
        String expectedNoAnswerLabel = "No";
        String expectedActualQuestionText = "Do you like the site?";

        String actualRadioButtonText = radioButtonPage.getRadioButtonText();
        String actualYesAnswerLabel = radioButtonPage.getYesAnswerLabel();
        String actualImpressiveAnswerLabel = radioButtonPage.getImpressiveAnswerLabel();
        String actualNoAnswerLabel = radioButtonPage.getNoAnswerLabel();
        String actualQuestionText = radioButtonPage.getQuestionText();

        Assert.assertEquals(actualRadioButtonText, expectedRadioButtonText, "Not found " + expectedRadioButtonText);
        Assert.assertEquals(actualYesAnswerLabel, expectedYesAnswerLabel, "Not found " + expectedYesAnswerLabel);
        Assert.assertEquals(actualNoAnswerLabel, expectedNoAnswerLabel, "Not found " + expectedNoAnswerLabel);
        Assert.assertEquals(actualQuestionText, expectedActualQuestionText, "Not found " + expectedActualQuestionText);
        Assert.assertEquals(actualImpressiveAnswerLabel, expectedImpressiveAnswerLabel, "Not found " + expectedImpressiveAnswerLabel);
        Assert.assertTrue(radioButtonPage.isResultMessageDisplayed());
    }

    @Test
    public void ChooseNoAnswer() {
        RadioButtonPage radioButtonPage = homePage.goToElements().clickRadioButton();
        String expectedNoAnswer = "No";

        Assert.assertTrue(radioButtonPage.isAnswerDisable(expectedNoAnswer));
    }

    @Test
    public void ChooseYesAnswer() {
        RadioButtonPage radioButtonPage = homePage.goToElements().clickRadioButton();

        String expectedAnswer = "Yes";
        radioButtonPage.clickAnswer(expectedAnswer);

        String actualAnswer = radioButtonPage.getResultMessage();

        Assert.assertTrue(radioButtonPage.isResultMessageDisplayed());
        Assert.assertEquals(actualAnswer, "You have selected " + expectedAnswer, "Not chosen yes answer");
    }

    @Test
    public void ChooseImpressiveAnswer() {
        RadioButtonPage radioButtonPage = homePage.goToElements().clickRadioButton();

        String expectedAnswer = "Impressive";
        radioButtonPage.clickAnswer(expectedAnswer);

        String actualAnswer = radioButtonPage.getResultMessage();

        Assert.assertTrue(radioButtonPage.isResultMessageDisplayed());
        Assert.assertEquals(actualAnswer, "You have selected " + expectedAnswer, "Not chosen Impressive answer");
    }

    @Test
    public void verifyColorOfMessage() {
        RadioButtonPage radioButtonPage = homePage.goToElements().clickRadioButton();

        String expectedAnswer = "Impressive";
        radioButtonPage.clickAnswer(expectedAnswer);

        String greenColor = "rgba(40, 167, 69, 1)";
        String actualColor = radioButtonPage.isColorGreen();

        Assert.assertEquals(actualColor, greenColor, "Not green color for Impressive answer");

        expectedAnswer = "Yes";
        radioButtonPage.clickAnswer(expectedAnswer);
        actualColor = radioButtonPage.isColorGreen();

        Assert.assertEquals(actualColor, greenColor, "Not green color For Yes answer");
    }
}
