package demoqa.web.test.elements;

import demoqa.web.BaseTest;
import org.testng.annotations.Test;

public class ButtonsPageTests extends BaseTest {
    @Test(enabled = true, testName = "Verify all buttons text and buttons color")
    public void VerifyAllTextOnPage() {
        navigateToUrl("buttons");

        String expectedHeaderButtonsText = "Buttons";
        String expectedDoubleClickButtonText = "Double Click Me";
        String expectedRightClickMeButtonText = "Right Click Me";
        String expectedDynamicClickMeButtonText = "Click Me";

        String blueBorderColor = "rgb(0, 123, 255)";
        String blueBackgroundColor = "rgba(0, 123, 255, 1)";

        String actualHeaderButtonText = buttonsPage.getButtonsText();

        String actualDoubleClickButtonText = buttonsPage.getDoubleButtonText();
        String doubleClickButtonBorderColor = buttonsPage.getDoubleClickButtonBorderColor();
        String doubleClickButtonBackGroundColor = buttonsPage.getDoubleClickButtonBackGroundColor();
        String actualRightClickMeButtonText = buttonsPage.getRightButtonText();
        String rightClickMeButtonBorderColor = buttonsPage.getRightClickMeButtonBorderColor();
        String rightClickMeButtonBackGroundColor = buttonsPage.getRightClickMeButtonBackGroundColor();
        String actualClickMeButtonText = buttonsPage.getDynamicButtonText();
        String clickMeButtonBorderColor = buttonsPage.getClickMeButtonBorderColor();
        String clickMeButtonBackGroundColor = buttonsPage.getClickMeButtonBackGroundColor();

        softAssert.assertEquals(actualHeaderButtonText, expectedHeaderButtonsText, "\nWrong header Buttons.\n");
        softAssert.assertEquals(actualDoubleClickButtonText, expectedDoubleClickButtonText, "\nWrong button text " + expectedDoubleClickButtonText + ".\n");
        softAssert.assertEquals(doubleClickButtonBorderColor, blueBorderColor, "\nExpected border blue color.\n");
        softAssert.assertEquals(doubleClickButtonBackGroundColor, blueBackgroundColor, "\nExpected border blue color.\n");
        softAssert.assertEquals(actualRightClickMeButtonText, expectedRightClickMeButtonText, "\nWrong button text" + expectedRightClickMeButtonText + ".\n");
        softAssert.assertEquals(rightClickMeButtonBorderColor, blueBorderColor, "\nExpected border blue color.");
        softAssert.assertEquals(rightClickMeButtonBackGroundColor, blueBackgroundColor, "\nExpected border blue color.");
        softAssert.assertEquals(actualClickMeButtonText, expectedDynamicClickMeButtonText, "\nWrong text " + expectedDynamicClickMeButtonText + "Click Me.\n");
        softAssert.assertEquals(clickMeButtonBorderColor, blueBorderColor, "\nExpected border blue color.\n");
        softAssert.assertEquals(clickMeButtonBackGroundColor, blueBackgroundColor, "\nExpected border blue color.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true)
    public void ClickOnThreeButtonsAndVerifyMessages() {
        navigateToUrl("buttons");

        String expectedDoubleClickMessage = "You have done a double click";
        String expectedRightClickMessage = "You have done a right click";
        String expectedDynamicClickMessage = "You have done a dynamic click";

        buttonsPage.doubleClickOnButton();
        buttonsPage.rightClickOnButton();
        buttonsPage.clickOnClickMeButton();

        String actualDoubleClickMessage = buttonsPage.getDoubleClickMessage();
        String actualRightClickMessage = buttonsPage.getRightClickMessage();
        String actualClickMeMessage = buttonsPage.getClickMeClickMessage();

        softAssert.assertEquals(actualDoubleClickMessage, expectedDoubleClickMessage, "\nExpected message is not" + expectedDoubleClickMessage + ".\n");
        softAssert.assertEquals(actualRightClickMessage, expectedRightClickMessage, "\nExpected message is not" + expectedRightClickMessage + ".\n");
        softAssert.assertEquals(actualClickMeMessage, expectedDynamicClickMessage, "\nExpected message is not" + expectedDynamicClickMessage + ".\n");

        softAssert.assertAll();
    }
}
