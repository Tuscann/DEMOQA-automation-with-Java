package part3.comdemoqa.tests.elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class ButtonsPageTests extends BaseTest {
    @Test
    public void ClickOnThreeButtons() {
        navigateToUrl("buttons");

        String expectedDoubleClickMessage = "You have done a double click";
        String expectedRightClickMessage = "You have done a right click";
        String expectedDynamicClickMessage = "You have done a dynamic click";

        String expectedDoubleClickButtonText = "Double Click Me";
        String expectedRightClickMeButtonText = "Right Click Me";
        String expectedDynamicClickMeButtonText = "Click Me";
        String expectedHeaderButtonsText = "Buttons";

        buttonsPage.doubleClickOnButton();
        buttonsPage.rightClickOnButton();
        buttonsPage.clickOnClickMeButton();
        buttonsPage.getButtonsText();

        String actualDoubleClickMessage = buttonsPage.getDoubleClickMessage();
        String actualRightClickMessage = buttonsPage.getRightClickMessage();
        String actualClickMeMessage = buttonsPage.getClickMeClickMessage();

        String actualDoubleClickButtonText = buttonsPage.getDoubleButtonText();
        String actualRightClickMeButtonText = buttonsPage.getRightButtonText();
        String actualDynamicClickMeButtonText = buttonsPage.getDynamicButtonText();

        String buttonText = buttonsPage.getButtonsText();

        Assert.assertEquals(actualDoubleClickMessage, expectedDoubleClickMessage, "Wrong double click message");
        Assert.assertEquals(actualRightClickMessage, expectedRightClickMessage, "Wrong right click message");
        Assert.assertEquals(actualClickMeMessage, expectedDynamicClickMessage, "Wrong dynamic click message");

        Assert.assertEquals(actualDoubleClickButtonText, expectedDoubleClickButtonText, "Wrong name Double Click Me");
        Assert.assertEquals(actualRightClickMeButtonText, expectedRightClickMeButtonText, "Wrong name Right Click Me");
        Assert.assertEquals(actualDynamicClickMeButtonText, expectedDynamicClickMeButtonText, "Wrong name Click Me");
        Assert.assertEquals(buttonText, expectedHeaderButtonsText, "Wrong name Buttons");
    }
}
