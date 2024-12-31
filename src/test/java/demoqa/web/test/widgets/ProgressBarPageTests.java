package demoqa.web.test.widgets;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProgressBarPageTests extends BaseTest {

    @Test(enabled = true)
    public void VerifyAllTextOnPage() {
        navigateToUrl("progress-bar");

        String expectedHeaderText = "Progress Bar";
        String expectedProgressBarText = "Progress Bar";
        String expectedStartButtonText = "Start";

        String actualHeaderText = progressBarPage.getHeaderText();
        String actualProgressButtonText = progressBarPage.getProgressBarText();
        String actualStartButtonText = progressBarPage.getStartStopButtonText();

        Assert.assertEquals(actualHeaderText, expectedHeaderText, "Wrong header value");
        Assert.assertEquals(actualProgressButtonText, expectedProgressBarText, "Wrong button value");
        Assert.assertEquals(actualStartButtonText, expectedStartButtonText, "Wrong button value");
    }

    @Test
    public void ClickStartButtonCheckEndValue() {
        navigateToUrl("progress-bar");
        String expectedText = "100";
        String resetButtonText = "Reset";
        String stopButtonText = "Stop";
        String expectedGreenColor = "rgba(40, 167, 69, 1)";
        String expectedStartColor = "rgba(23, 162, 184, 1)";

        progressBarPage.clickStartButton();

        String actualNotGreenColor = progressBarPage.getColorProgressBar();
        String actualStartStopButtonText = progressBarPage.getStartStopButtonText();
        String actualText = progressBarPage.getValueProgressBarAfter5seconds();
        String actualGreenColor = progressBarPage.getColorProgressBar();
        String textOfResetButton = progressBarPage.getResetButtonText();

        Assert.assertEquals(actualText, expectedText, "Not 100% value");
        Assert.assertEquals(actualGreenColor, expectedGreenColor, "Wrong color value");
        Assert.assertEquals(actualNotGreenColor, expectedStartColor, "Wrong color value");
        Assert.assertEquals(textOfResetButton, resetButtonText, "Not reset Button");
        Assert.assertEquals(actualStartStopButtonText, stopButtonText, "Not stop Button");
    }

    @Test(enabled = true)
    public void StopOn10ProgressOfProgressbar() {
        navigateToUrl("progress-bar");

        progressBarPage.clickStartButton();

        String expectedStartColor = "rgba(23, 162, 184, 1)";
        int stopValue = 10;

        progressBarPage.waitForProgressBarValue(stopValue);
        String actualText = progressBarPage.getValueProgressBar();
        String actualNotGreenColor = progressBarPage.getColorProgressBar();


        Assert.assertEquals(actualText, "" + (stopValue + 1), "Not " + stopValue + " value");
        Assert.assertEquals(actualNotGreenColor, expectedStartColor, "Wrong color value");
    }
}
