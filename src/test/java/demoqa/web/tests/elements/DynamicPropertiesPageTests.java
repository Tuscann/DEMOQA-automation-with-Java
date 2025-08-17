package demoqa.web.tests.elements;

import demoqa.pages.elements.DynamicPropertiesPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicPropertiesPageTests extends BaseTest {

    private static final String EXPECTED_PROPERTIES_TEXT = "Dynamic Properties";
    private static final String EXPECTED_RANDOM_ID_TEXT = "This text has random Id";
    private static final String EXPECTED_ENABLE_BUTTON_TEXT = "Will enable 5 seconds";
    private static final String EXPECTED_COLOR_CHANGE_TEXT = "Color Change";
    private static final String EXPECTED_VISIBLE_AFTER_5_SEC_TEXT = "Visible After 5 Seconds";
    private static final String EXPECTED_WHITE_COLOR = "rgba(255, 255, 255, 1)";

    private static final String DYNAMIC_PROPERTIES_URL = "dynamic-properties";
    private DynamicPropertiesPage dynamicPropertiesPage;

    @BeforeMethod
    public void goToProfilePage() {
        navigateToUrl(DYNAMIC_PROPERTIES_URL);
        dynamicPropertiesPage = new DynamicPropertiesPage(driver);
    }

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        // Arrange
        // Act
        String dynamicPropertiesText = dynamicPropertiesPage.getDynamicPropertiesText();
        String randomIdText = dynamicPropertiesPage.getTextWithRandomIdText();
        String willEnable5SecondsButtonText = dynamicPropertiesPage.getWillEnable5SecondsButtonText();
        String colorChangeButton = dynamicPropertiesPage.getColorChangeButtonText();
        String visibleAfter5SecondsButtonText = dynamicPropertiesPage.getVisibleAfter5SecondsButtonTextAfter5seconds();

        // Assert
        softAssert.assertEquals(dynamicPropertiesText, EXPECTED_PROPERTIES_TEXT, "\nWrong dynamic properties text.\n");
        softAssert.assertEquals(randomIdText, EXPECTED_RANDOM_ID_TEXT, "\nWrong random id text.\n");
        softAssert.assertEquals(willEnable5SecondsButtonText, EXPECTED_ENABLE_BUTTON_TEXT, "\nWrong will enable 5 seconds.\n");
        softAssert.assertEquals(colorChangeButton, EXPECTED_COLOR_CHANGE_TEXT, "\nWrong color change text.\n");
        softAssert.assertEquals(visibleAfter5SecondsButtonText, EXPECTED_VISIBLE_AFTER_5_SEC_TEXT, "\nVisible after 5 seconds.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify missing button on page")
    public void VerifyMissingButtonOnPage() {
        // Arrange
        // Act
        boolean isEnableButton = dynamicPropertiesPage.checkButtonWillEnable5Seconds();
        String colorOfColorChangeButton = dynamicPropertiesPage.getColorOfChangeButton();
        boolean isVisibleAfter5SecondsButton = dynamicPropertiesPage.checkButtonVisibleAfter5Seconds();

        // Assert
        softAssert.assertFalse(isEnableButton, "Enable button is enable now");
        softAssert.assertEquals(colorOfColorChangeButton, EXPECTED_WHITE_COLOR, "Not white color on change text");
        softAssert.assertFalse(isVisibleAfter5SecondsButton, "Visible after 5 button is visible now");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Check after 5 seconds all buttons")
    public void CheckAfter5secondsAllButtons() {
        // Arrange
        // Act
        String colorOFColorChangeButton = dynamicPropertiesPage.getColorOfChangeButton();
        String visibleAfter5SecondsButtonText = dynamicPropertiesPage.getVisibleAfter5SecondsButtonTextAfter5seconds();
        boolean isEnableButton = dynamicPropertiesPage.checkButtonWillEnable5Seconds();
        boolean isVisibleAfter5SecondsButton = dynamicPropertiesPage.checkButtonVisibleAfter5Seconds();

        // Assert
        softAssert.assertTrue(isEnableButton, "\nEnable button is not enable.\n");
        softAssert.assertEquals(colorOFColorChangeButton, EXPECTED_WHITE_COLOR, "\nNot white color on change text.\n");
        softAssert.assertTrue(isVisibleAfter5SecondsButton, "\nVisible after 5 button is visible now.\n");
        softAssert.assertEquals(visibleAfter5SecondsButtonText, EXPECTED_VISIBLE_AFTER_5_SEC_TEXT, "\nVisible after 5 seconds.\n");

        softAssert.assertAll();
    }
}
