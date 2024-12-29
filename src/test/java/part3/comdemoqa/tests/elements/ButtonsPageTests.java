package part3.comdemoqa.tests.elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class ButtonsPageTests extends BaseTest {

    public void VerifyAllTextOnPage() {
        navigateToUrl("buttons");

        String expectedHeaderButtonsText = "Buttons";
        String expectedDoubleClickButtonText = "Double Click Me";
        String expectedRightClickMeButtonText = "Right Click Me";
        String expectedDynamicClickMeButtonText = "Click Me";

        String buttonText = buttonsPage.getButtonsText();
        String actualDoubleClickButtonText = buttonsPage.getDoubleButtonText();
        String actualRightClickMeButtonText = buttonsPage.getRightButtonText();
        String actualDynamicClickMeButtonText = buttonsPage.getDynamicButtonText();

        Assert.assertEquals(buttonText, expectedHeaderButtonsText, "Wrong name Buttons");
        Assert.assertEquals(actualDoubleClickButtonText, expectedDoubleClickButtonText, "Wrong name Double Click Me");
        Assert.assertEquals(actualRightClickMeButtonText, expectedRightClickMeButtonText, "Wrong name Right Click Me");
        Assert.assertEquals(actualDynamicClickMeButtonText, expectedDynamicClickMeButtonText, "Wrong name Click Me");
    }

    @Test
    public void ClickOnThreeButtonsAndVerifyMessages() {
        navigateToUrl("buttons");

        String expectedDoubleClickMessage = "You have done a double click";
        String expectedRightClickMessage = "You have done a right click";
        String expectedDynamicClickMessage = "You have done a dynamic click";

        buttonsPage.doubleClickOnButton();
        buttonsPage.rightClickOnButton();
        buttonsPage.clickOnClickMeButton();
        buttonsPage.getButtonsText();

        String actualDoubleClickMessage = buttonsPage.getDoubleClickMessage();
        String actualRightClickMessage = buttonsPage.getRightClickMessage();
        String actualClickMeMessage = buttonsPage.getClickMeClickMessage();

        Assert.assertEquals(actualDoubleClickMessage, expectedDoubleClickMessage, "Wrong double click message");
        Assert.assertEquals(actualRightClickMessage, expectedRightClickMessage, "Wrong right click message");
        Assert.assertEquals(actualClickMeMessage, expectedDynamicClickMessage, "Wrong dynamic click message");
    }
}
