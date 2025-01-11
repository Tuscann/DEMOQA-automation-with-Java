package demoqa.web.test.elements;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsPageTests extends BaseTest {
    @Test(enabled = true)
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

        Assert.assertEquals(actualHeaderButtonText, expectedHeaderButtonsText, "\nWrong header Buttons.\n");
        Assert.assertEquals(actualDoubleClickButtonText, expectedDoubleClickButtonText, "\nWrong name Double Click Me.\n");
        Assert.assertEquals(doubleClickButtonBorderColor, blueBorderColor, "\nExpected border blue color.\n");
        Assert.assertEquals(doubleClickButtonBackGroundColor, blueBackgroundColor, "\nExpected border blue color.\n");
        Assert.assertEquals(actualRightClickMeButtonText, expectedRightClickMeButtonText, "\nWrong name Right Click Me.\n");
        Assert.assertEquals(rightClickMeButtonBorderColor, blueBorderColor, "\nExpected border blue color.");
        Assert.assertEquals(rightClickMeButtonBackGroundColor, blueBackgroundColor, "\nExpected border blue color.");
        Assert.assertEquals(actualClickMeButtonText, expectedDynamicClickMeButtonText, "\nWrong name Click Me.\n");
        Assert.assertEquals(clickMeButtonBorderColor, blueBorderColor, "\nExpected border blue color.\n");
        Assert.assertEquals(clickMeButtonBackGroundColor, blueBackgroundColor, "\nExpected border blue color.\n");
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

        Assert.assertEquals(actualDoubleClickMessage, expectedDoubleClickMessage, "\nWrong double click message.\n");
        Assert.assertEquals(actualRightClickMessage, expectedRightClickMessage, "\nWrong right click message.\n");
        Assert.assertEquals(actualClickMeMessage, expectedDynamicClickMessage, "\nWrong dynamic click message.\n");
    }
}
