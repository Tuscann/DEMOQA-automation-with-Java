package demoqa.web.test.elements;

import demoqa.web.BaseTest;
import org.testng.annotations.Test;

public class DynamicPropertiesPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on Page")
    public void VerifyAllTextOnPage() {
        navigateToUrl("dynamic-properties");

        String expectedPropertiesText = "Dynamic Properties";
        String expectedRandomIdText = "This text has random Id";
        String expectedWillEnable5SecondsButtonText = "Will enable 5 seconds";
        String expectedColorChangeText = "Color Change";
        String expectedVisibleAfter5SecondsButtonText = "Visible After 5 Seconds";

        String dynamicPropertiesText = dynamicPropertiesPage.getDynamicPropertiesText();
        String randomIdText = dynamicPropertiesPage.getTextWithRandomIdText();
        String willEnable5SecondsButtonText = dynamicPropertiesPage.getWillEnable5SecondsButtonText();
        String colorChangeButton = dynamicPropertiesPage.getColorChangeButtonText();
        String visibleAfter5SecondsButtonText = dynamicPropertiesPage.getVisibleAfter5SecondsButtonTextAfter5seconds();

        softAssert.assertEquals(dynamicPropertiesText, expectedPropertiesText, "\nWrong dynamic properties text.\n");
        softAssert.assertEquals(randomIdText, expectedRandomIdText, "\nWrong random id text.\n");
        softAssert.assertEquals(willEnable5SecondsButtonText, expectedWillEnable5SecondsButtonText, "\nWrong will enable 5 seconds.\n");
        softAssert.assertEquals(colorChangeButton, expectedColorChangeText, "\nWrong color change text.\n");
        softAssert.assertEquals(visibleAfter5SecondsButtonText, expectedVisibleAfter5SecondsButtonText, "\nVisible after 5 seconds.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true)
    public void VerifyMissingButtonOnPage() {
        navigateToUrl("dynamic-properties");

        boolean isEnableButton = dynamicPropertiesPage.checkButtonWillEnable5Seconds();
        String colorOfColorChangeButton = dynamicPropertiesPage.getColorOfChangeButton();
        boolean isVisibleAfter5SecondsButton = dynamicPropertiesPage.checkButtonVisibleAfter5Seconds();

        String expectedColor = "rgba(255, 255, 255, 1)";

        softAssert.assertFalse(isEnableButton, "Enable button is enable now");
        softAssert.assertEquals(colorOfColorChangeButton, expectedColor, "Not white color on change text");
        softAssert.assertFalse(isVisibleAfter5SecondsButton, "Visible after 5 button is visible now");

        softAssert.assertAll();
    }

    @Test(enabled = true)
    public void CheckAfter5secondsAllButtons() {
        navigateToUrl("dynamic-properties");

        String expectedVisibleAfter5SecondsButtonText = "Visible After 5 Seconds";
        String expectedColor = "rgba(255, 255, 255, 1)";

        String colorOFColorChangeButton = dynamicPropertiesPage.getColorOfChangeButton();
        String visibleAfter5SecondsButtonText = dynamicPropertiesPage.getVisibleAfter5SecondsButtonTextAfter5seconds();
        boolean isEnableButton = dynamicPropertiesPage.checkButtonWillEnable5Seconds();
        boolean isVisibleAfter5SecondsButton = dynamicPropertiesPage.checkButtonVisibleAfter5Seconds();

        softAssert.assertTrue(isEnableButton, "\nEnable button is not enable.\n");
        softAssert.assertEquals(colorOFColorChangeButton, expectedColor, "\nNot white color on change text.\n");
        softAssert.assertTrue(isVisibleAfter5SecondsButton, "\nVisible after 5 button is visible now.\n");
        softAssert.assertEquals(visibleAfter5SecondsButtonText, expectedVisibleAfter5SecondsButtonText, "\nVisible after 5 seconds.\n");

        softAssert.assertAll();
    }
}
