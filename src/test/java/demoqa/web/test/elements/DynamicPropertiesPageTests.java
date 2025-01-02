package demoqa.web.test.elements;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicPropertiesPageTests extends BaseTest {
    @Test
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

        Assert.assertEquals(dynamicPropertiesText, expectedPropertiesText, "Wrong dynamic properties text");
        Assert.assertEquals(randomIdText, expectedRandomIdText, "Wrong random id text");
        Assert.assertEquals(willEnable5SecondsButtonText, expectedWillEnable5SecondsButtonText, "Wrong will enable 5 seconds");
        Assert.assertEquals(colorChangeButton, expectedColorChangeText, "Wrong color change text");
        Assert.assertEquals(visibleAfter5SecondsButtonText, expectedVisibleAfter5SecondsButtonText, "Visible after 5 seconds");
    }

    @Test
    public void VerifyMissingButtonOnPage() {
        navigateToUrl("dynamic-properties");

        boolean isEnableButton = dynamicPropertiesPage.checkButtonWillEnable5Seconds();
        String colorOfColorChangeButton = dynamicPropertiesPage.getColorOfChangeButton();
        boolean isVisibleAfter5SecondsButton = dynamicPropertiesPage.checkButtonVisibleAfter5Seconds();

        String expectedColor = "rgba(255, 255, 255, 1)";

        Assert.assertFalse(isEnableButton, "Enable button is enable now");
        Assert.assertEquals(colorOfColorChangeButton, expectedColor, "Not white color on change text");
        Assert.assertFalse(isVisibleAfter5SecondsButton, "Visible after 5 button is visible now");
    }

    @Test
    public void CheckAfter5secondsAllButtons() {
        navigateToUrl("dynamic-properties");

        String expectedVisibleAfter5SecondsButtonText = "Visible After 5 Seconds";
        String expectedColor = "rgba(255, 255, 255, 1)";

        String colorOFColorChangeButton = dynamicPropertiesPage.getColorOfChangeButton();
        String visibleAfter5SecondsButtonText = dynamicPropertiesPage.getVisibleAfter5SecondsButtonTextAfter5seconds();
        boolean isEnableButton = dynamicPropertiesPage.checkButtonWillEnable5Seconds();
        boolean isVisibleAfter5SecondsButton = dynamicPropertiesPage.checkButtonVisibleAfter5Seconds();

        Assert.assertTrue(isEnableButton, "Enable button is not enable");
        Assert.assertEquals(colorOFColorChangeButton, expectedColor, "Not white color on change text");
        Assert.assertTrue(isVisibleAfter5SecondsButton, "Visible after 5 button is visible now");
        Assert.assertEquals(visibleAfter5SecondsButtonText, expectedVisibleAfter5SecondsButtonText, "Visible after 5 seconds");
    }
}
