package demoqa.web.tests.elements;

import demoqa.pages.elements.DynamicPropertiesPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicPropertiesPageTests extends BaseTest {
    // Text Constants
    private static final String EXPECTED_PROPERTIES_TEXT = "Dynamic Properties";
    private static final String EXPECTED_RANDOM_ID_TEXT = "This text has random Id";
    private static final String EXPECTED_ENABLE_BUTTON_TEXT = "Will enable 5 seconds";
    private static final String EXPECTED_COLOR_CHANGE_TEXT = "Color Change";
    private static final String EXPECTED_VISIBLE_AFTER_5_SEC_TEXT = "Visible After 5 Seconds";

    // Color Constants
    private static final String EXPECTED_WHITE_COLOR = "rgba(255, 255, 255, 1)";
    private static final String EXPECTED_RED_COLOR = "rgba(220, 53, 69, 1)";

    // Error Message Constants
    private static final String DYNAMIC_PROPERTIES_TEXT_MISMATCH = "Dynamic properties text mismatch";
    private static final String RANDOM_ID_TEXT_MISMATCH = "Random ID text mismatch";
    private static final String ENABLE_BUTTON_TEXT_MISMATCH = "Enable button text mismatch";
    private static final String COLOR_CHANGE_TEXT_MISMATCH = "Color change button text mismatch";
    private static final String VISIBLE_AFTER_5_SEC_TEXT_MISMATCH = "Visible after 5 seconds text mismatch";
    private static final String ENABLE_BUTTON_ENABLED_ERROR = "Enable button should not be enabled initially";
    private static final String COLOR_CHANGE_COLOR_MISMATCH = "Color change button color mismatch";
    private static final String CHANGE_BUTTON_COLOR_MISMATCH_AFTER = "Change button color mismatch after";
    private static final String VISIBLE_BUTTON_VISIBLE_ERROR = "Visible after 5 seconds button should not be visible initially";
    private static final String ENABLE_BUTTON_NOT_ENABLED_ERROR = "Enable button should be enabled after 5 seconds";
    private static final String VISIBLE_BUTTON_NOT_VISIBLE_ERROR = "Visible after 5 seconds button should be visible after 5 seconds";
    private static final String DYNAMIC_PROPERTIES_URL = "dynamic-properties";
    private DynamicPropertiesPage dynamicPropertiesPage;

    @BeforeMethod
    public void goToProfilePage() {
        navigateToUrl(DYNAMIC_PROPERTIES_URL);
        dynamicPropertiesPage = new DynamicPropertiesPage(driver);
    }

    @Test(enabled = true, description = "Verify all text elements on the dynamic properties page")
    public void verifyAllTextOnPage() {
        // Arrange & Act & Assert
        softAssert.assertEquals(dynamicPropertiesPage.getDynamicPropertiesText(), EXPECTED_PROPERTIES_TEXT, DYNAMIC_PROPERTIES_TEXT_MISMATCH);
        softAssert.assertEquals(dynamicPropertiesPage.getTextWithRandomIdText(), EXPECTED_RANDOM_ID_TEXT, RANDOM_ID_TEXT_MISMATCH);
        softAssert.assertEquals(dynamicPropertiesPage.getWillEnable5SecondsButtonText(), EXPECTED_ENABLE_BUTTON_TEXT, ENABLE_BUTTON_TEXT_MISMATCH);
        softAssert.assertEquals(dynamicPropertiesPage.getChangeButtonColorText(), EXPECTED_COLOR_CHANGE_TEXT, COLOR_CHANGE_TEXT_MISMATCH);
        softAssert.assertEquals(dynamicPropertiesPage.getVisibleAfter5SecondsButtonText(), EXPECTED_VISIBLE_AFTER_5_SEC_TEXT, VISIBLE_AFTER_5_SEC_TEXT_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify button states and properties before 5-second delay")
    public void verifyMissingButtonOnPage() {
        // Arrange & Act
        boolean isButtonEnable = dynamicPropertiesPage.checkButtonWillEnable5Seconds();
        String changeButtonColorBefore = dynamicPropertiesPage.getChangeButtonColor();
        boolean isVisibleAfter5SecondsButton = dynamicPropertiesPage.checkButtonVisibleAfter5Seconds();

        // Assert
        softAssert.assertFalse(isButtonEnable, ENABLE_BUTTON_ENABLED_ERROR);
        softAssert.assertEquals(changeButtonColorBefore, EXPECTED_WHITE_COLOR, COLOR_CHANGE_COLOR_MISMATCH);
        softAssert.assertFalse(isVisibleAfter5SecondsButton, VISIBLE_BUTTON_VISIBLE_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify button states and properties after 5-second delay")
    public void checkAfter5SecondsAllButtons() {
        // Arrange & Act
        String changeButtonColorBefore = dynamicPropertiesPage.getChangeButtonColor();
        String visibleAfter5SecondsButtonText = dynamicPropertiesPage.getVisibleAfter5SecondsButtonText();
        boolean isEnableButton = dynamicPropertiesPage.checkButtonWillEnable5Seconds();
        boolean isVisibleAfter5SecondsButton = dynamicPropertiesPage.checkButtonVisibleAfter5Seconds();
        String changeButtonColorAfter = dynamicPropertiesPage.getChangeButtonColor();

        // Assert
        softAssert.assertTrue(isEnableButton, ENABLE_BUTTON_NOT_ENABLED_ERROR);
        softAssert.assertEquals(changeButtonColorBefore, EXPECTED_WHITE_COLOR, COLOR_CHANGE_COLOR_MISMATCH);
        softAssert.assertTrue(isVisibleAfter5SecondsButton, VISIBLE_BUTTON_NOT_VISIBLE_ERROR);
        softAssert.assertEquals(visibleAfter5SecondsButtonText, EXPECTED_VISIBLE_AFTER_5_SEC_TEXT, VISIBLE_AFTER_5_SEC_TEXT_MISMATCH);
        softAssert.assertEquals(changeButtonColorAfter, EXPECTED_RED_COLOR, CHANGE_BUTTON_COLOR_MISMATCH_AFTER);
        softAssert.assertAll();
    }
}
