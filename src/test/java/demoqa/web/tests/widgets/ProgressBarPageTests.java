package demoqa.web.tests.widgets;

import demoqa.pages.widgets.ProgressBarPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProgressBarPageTests extends BaseTest {

    public static final String PROGRESS_BAR_URL = "progress-bar";
    private ProgressBarPage progressBarPage;

    @BeforeMethod
    public void goToProgressBarPage() {
        navigateToUrl(PROGRESS_BAR_URL);
        progressBarPage = new ProgressBarPage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange
        String expectedHeaderText = "Progress Bar";
        String expectedProgressBarText = "Progress Bar";
        String expectedStartButtonText = "Start";

        // Act
        String actualHeaderText = progressBarPage.getHeaderText();
        String actualProgressButtonText = progressBarPage.getProgressBarText();
        String actualStartButtonText = progressBarPage.getStartStopButtonText();

        softAssert.assertEquals(actualHeaderText, expectedHeaderText, "\nWrong header value.\n");
        softAssert.assertEquals(actualProgressButtonText, expectedProgressBarText, "\nWrong button value.\n");
        softAssert.assertEquals(actualStartButtonText, expectedStartButtonText, "\nWrong button value.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click start button and check progress bar end value")
    public void clickStartButtonAndCheckProgressBarEndValue() {
        // Arrange
        String expectedText = "100";
        String resetButtonText = "Reset";
        String stopButtonText = "Stop";
        String expectedGreenColor = "rgba(40, 167, 69, 1)";
        String expectedStartColor = "rgba(23, 162, 184, 1)";

        // Act
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

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click reset button")
    public void clickResetButton() {
        // Arrange
        String expectedText = "100";
        String startButtonText = "Start";

        // Act
        progressBarPage.clickStartButton();
        String actualText = progressBarPage.getValueOfProgressBarOnValue100();
        progressBarPage.clickResetButton();
        String actualStartButtonText = progressBarPage.getStartStopButtonText();

        softAssert.assertEquals(actualText, expectedText, "\nNot 100% value.\n");
        softAssert.assertEquals(actualStartButtonText, startButtonText, "\nWrong start button value.\n");

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click start stop start check progress bar end value")
    public void clickStartStopStartCheckProgressBarEndValue() {
        // Arrange
        String expectedEndProgressBarValueText = "100";
        int stopValue = 14;

        // Act
        progressBarPage.clickStartButton();
        progressBarPage.stopProgressBarOnValue2(stopValue);
        int actualProgressBarText = progressBarPage.getValueProgressBar();
        progressBarPage.clickStartButton();
        String endProgressBarText = progressBarPage.getValueOfProgressBarOnValue100();

        softAssert.assertEquals(actualProgressBarText, stopValue, "\nNot stop on " + stopValue + ".\n");
        softAssert.assertEquals(endProgressBarText, expectedEndProgressBarValueText, "\nNot stop 100% value.\n");

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Stop on 31 percent of progressbar")
    public void stopOn31ProgressOfProgressbar() {
        // Arrange
        String expectedStartColor = "rgba(23, 162, 184, 1)";
        int stopValue = 31;

        // Act
        progressBarPage.clickStartButton();
        progressBarPage.stopProgressBarOnValue2(stopValue);
        int actualValueOfProgressBar = progressBarPage.getValueProgressBar();
        String actualNotGreenColor = progressBarPage.getColorProgressBar();

        softAssert.assertEquals(actualValueOfProgressBar, stopValue, "\nNot " + stopValue + " value.\n");
        softAssert.assertEquals(actualNotGreenColor, expectedStartColor, "\nWrong color value.\n");

        // Assert
        softAssert.assertAll();
    }
}
