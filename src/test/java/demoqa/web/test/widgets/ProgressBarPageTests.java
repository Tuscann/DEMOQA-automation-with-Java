package demoqa.web.test.widgets;

import demoqa.web.BaseTest;
import org.testng.annotations.Test;

public class ProgressBarPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        navigateToUrl("progress-bar");

        String expectedHeaderText = "Progress Bar";
        String expectedProgressBarText = "Progress Bar";
        String expectedStartButtonText = "Start";

        String actualHeaderText = progressBarPage.getHeaderText();
        String actualProgressButtonText = progressBarPage.getProgressBarText();
        String actualStartButtonText = progressBarPage.getStartStopButtonText();

        softAssert.assertEquals(actualHeaderText, expectedHeaderText, "\nWrong header value.\n");
        softAssert.assertEquals(actualProgressButtonText, expectedProgressBarText, "\nWrong button value.\n");
        softAssert.assertEquals(actualStartButtonText, expectedStartButtonText, "\nWrong button value.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click start button and check progress bar end value")
    public void ClickStartButtonAndCheckProgressBarEndValue() {
        navigateToUrl("progress-bar");
        String expectedText = "100";
        String resetButtonText = "Reset";
        String stopButtonText = "Stop";
        String expectedGreenColor = "rgba(40, 167, 69, 1)";
        String expectedStartColor = "rgba(23, 162, 184, 1)";

        progressBarPage.clickStartButton();

        String actualNotGreenColor = progressBarPage.getColorProgressBar();
        String actualStartStopButtonText = progressBarPage.getStartStopButtonText();
        String actualText = progressBarPage.getValueOfProgressBarOnValue100();
        String actualGreenColor = progressBarPage.getColorProgressBar();
        String textOfResetButton = progressBarPage.getResetButtonText();

        softAssert.assertEquals(actualText, expectedText, "\nNot 100% value.\n");
        softAssert.assertEquals(actualGreenColor, expectedGreenColor, "\nWrong color value.\n");
        softAssert.assertEquals(actualNotGreenColor, expectedStartColor, "\nWrong color value.\n");
        softAssert.assertEquals(textOfResetButton, resetButtonText, "\nNot reset Button.\n");
        softAssert.assertEquals(actualStartStopButtonText, stopButtonText, "\nNot stop Button.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click reset button")
    public void ClickResetButton() {
        navigateToUrl("progress-bar");
        String expectedText = "100";
        String startButtonText = "Start";

        progressBarPage.clickStartButton();
        String actualText = progressBarPage.getValueOfProgressBarOnValue100();
        progressBarPage.clickResetButton();
        String actualStartButtonText = progressBarPage.getStartStopButtonText();

        softAssert.assertEquals(actualText, expectedText, "\nNot 100% value.\n");
        softAssert.assertEquals(actualStartButtonText, startButtonText, "\nWrong start button value.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click start stop start check progress bar end value")
    public void ClickStartStopStartCheckProgressBarEndValue() {
        navigateToUrl("progress-bar");
        String expectedEndProgressBarValueText = "100";
        int stopValue = 4;

        progressBarPage.clickStartButton();
        progressBarPage.stopProgressBarOnValue2(stopValue);
        int actualProgressBarText = progressBarPage.getValueProgressBar();
        progressBarPage.clickStartButton();
        String endProgressBarText = progressBarPage.getValueOfProgressBarOnValue100();

        softAssert.assertEquals(actualProgressBarText, stopValue, "\n Not stop on 1\n");
        softAssert.assertEquals(endProgressBarText, expectedEndProgressBarValueText, "\nNot 100% value.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Stop on 31 progress of progressbar")
    public void StopOn31ProgressOfProgressbar() {
        navigateToUrl("progress-bar");

        progressBarPage.clickStartButton();

        String expectedStartColor = "rgba(23, 162, 184, 1)";
        int stopValue = 31;

        progressBarPage.stopProgressBarOnValue2(stopValue);
        int actualValueOfProgressBar = progressBarPage.getValueProgressBar();
        String actualNotGreenColor = progressBarPage.getColorProgressBar();

        softAssert.assertEquals(actualValueOfProgressBar, stopValue, "\nNot " + stopValue + " value.\n");
        softAssert.assertEquals(actualNotGreenColor, expectedStartColor, "\nWrong color value.\n");

        softAssert.assertAll();
    }
}
