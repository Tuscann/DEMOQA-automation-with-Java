package demoqa.web.tests.widgets;

import demoqa.pages.widgets.ProgressBarPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProgressBarPageTests extends BaseTest {
    // Text Constants
    private static final String EXPECTED_HEADER_TEXT = "Progress Bar";
    private static final String EXPECTED_PROGRESS_BAR_TEXT = "Progress Bar";
    private static final String EXPECTED_START_BUTTON_TEXT = "Start";
    private static final String EXPECTED_STOP_BUTTON_TEXT = "Stop";
    private static final String EXPECTED_RESET_BUTTON_TEXT = "Reset";

    // Progress Values
    private static final String EXPECTED_100_PERCENT_TEXT = "100";
    private static final int STOP_VALUE_31 = 31;

    // Color Constants
    private static final String EXPECTED_GREEN_COLOR = "rgba(40, 167, 69, 1)";
    private static final String EXPECTED_START_COLOR = "rgba(23, 162, 184, 1)";

    // Error Message Constants
    private static final String HEADER_VALUE_ERROR = "Wrong header value";
    private static final String BUTTON_VALUE_ERROR = "Wrong button value";
    private static final String NOT_100_PERCENT_ERROR = "Not 100% value";
    private static final String WRONG_COLOR_VALUE_ERROR = "Wrong color value";
    private static final String NOT_RESET_BUTTON_ERROR = "Not reset Button";
    private static final String NOT_STOP_BUTTON_ERROR = "Not stop Button";
    private static final String WRONG_START_BUTTON_VALUE_ERROR = "Wrong start button value";
    private static final String NOT_STOP_ON_VALUE_ERROR = "Not stop on ";
    private static final String NOT_STOP_100_PERCENT_ERROR = "Not stop 100% value";

    private ProgressBarPage progressBarPage;
    private static final String PROGRESS_BAR_URL = "progress-bar";

    @BeforeMethod
    public void goToProgressBarPage() {
        navigateToUrl(PROGRESS_BAR_URL);
        progressBarPage = new ProgressBarPage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange & Act
        softAssert.assertEquals(progressBarPage.getHeaderText(), EXPECTED_HEADER_TEXT, HEADER_VALUE_ERROR);
        softAssert.assertEquals(progressBarPage.getProgressBarText(), EXPECTED_PROGRESS_BAR_TEXT, BUTTON_VALUE_ERROR);
        softAssert.assertEquals(progressBarPage.getStartStopButtonText(), EXPECTED_START_BUTTON_TEXT, BUTTON_VALUE_ERROR);

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click start button and check progress bar end value")
    public void clickStartButtonAndCheckProgressBarEndValue() {
        // Arrange & Act
        String actualNotGreenColor = progressBarPage.getColorProgressBar();
        String actualStartButtonText = progressBarPage.getStartStopButtonText();

        progressBarPage.clickStartButton();

        String actualStopButtonText = progressBarPage.getStartStopButtonText();
        String progressBarOnValue100 = progressBarPage.getValueOfProgressBarOnValue100();
        String actualGreenColor = progressBarPage.getColorProgressBar();
        String resetButtonText = progressBarPage.getResetButtonText();

        softAssert.assertEquals(actualNotGreenColor, EXPECTED_START_COLOR, WRONG_COLOR_VALUE_ERROR);
        softAssert.assertEquals(actualStartButtonText, EXPECTED_START_BUTTON_TEXT, NOT_STOP_BUTTON_ERROR);
        softAssert.assertEquals(progressBarOnValue100, EXPECTED_100_PERCENT_TEXT, NOT_100_PERCENT_ERROR);
        softAssert.assertEquals(actualGreenColor, EXPECTED_GREEN_COLOR, WRONG_COLOR_VALUE_ERROR);
        softAssert.assertEquals(resetButtonText, EXPECTED_RESET_BUTTON_TEXT, NOT_RESET_BUTTON_ERROR);
        softAssert.assertEquals(actualStopButtonText, EXPECTED_STOP_BUTTON_TEXT, NOT_STOP_BUTTON_ERROR);

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click reset button")
    public void clickResetButton() {
        // Arrange & Act
        progressBarPage.clickStartButton();
        String actualProgressValueOn100 = progressBarPage.getValueOfProgressBarOnValue100();
        progressBarPage.clickResetButton();
        String actualStartButtonText = progressBarPage.getStartStopButtonText();

        // Assert
        softAssert.assertEquals(actualProgressValueOn100, EXPECTED_100_PERCENT_TEXT, NOT_100_PERCENT_ERROR);
        softAssert.assertEquals(actualStartButtonText, EXPECTED_START_BUTTON_TEXT, WRONG_START_BUTTON_VALUE_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click start stop start check progress bar end value")
    public void clickStartClickStopClickStartAndCheckProgressBarEndValue() {
        // Arrange & Act
        progressBarPage.clickStartButton();
        progressBarPage.stopProgressBarOnValue2(STOP_VALUE_31);
        int actualProgressBarText = progressBarPage.getValueProgressBar();
        progressBarPage.clickStartButton();
        String endProgressBarText = progressBarPage.getValueOfProgressBarOnValue100();

        // Assert
        softAssert.assertEquals(actualProgressBarText, STOP_VALUE_31, NOT_STOP_ON_VALUE_ERROR + STOP_VALUE_31);
        softAssert.assertEquals(endProgressBarText, EXPECTED_100_PERCENT_TEXT, NOT_STOP_100_PERCENT_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Stop on 31 percent of progressbar")
    public void stopOn31ProgressOfProgressbar() {
        // Arrange & Act
        progressBarPage.clickStartButton();
        progressBarPage.stopProgressBarOnValue2(STOP_VALUE_31);

        // Assert
        softAssert.assertEquals(progressBarPage.getValueProgressBar(), STOP_VALUE_31, NOT_STOP_ON_VALUE_ERROR + STOP_VALUE_31);
        softAssert.assertAll();
    }
}
