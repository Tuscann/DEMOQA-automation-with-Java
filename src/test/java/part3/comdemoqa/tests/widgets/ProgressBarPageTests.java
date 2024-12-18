package part3.comdemoqa.tests.widgets;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class ProgressBarPageTests extends BaseTest {

    @Test(enabled = true)
    public void ClickStartButtonCheckEndValue() {
        navigateToUrl("progress-bar");

        progressBarPage.clickStartButton();

        String expectedText = "100";
        String actualText = progressBarPage.getValueProgressBar();

        Assert.assertEquals(actualText, expectedText, "Not 100% value");
    }

    @Test(enabled = false)
    public void StopOn50Progressbar() {
        navigateToUrl("progress-bar");

        progressBarPage.clickStartButton();

        String expectedText = "50";
        progressBarPage.stopOnValeProgressBar(expectedText);
        String actualText = progressBarPage.getValueProgressBar();

        Assert.assertEquals(actualText, expectedText, "Not 50% value");
    }

    @Test(enabled = true)
    public void VerifyTextOnPage() {
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
}
