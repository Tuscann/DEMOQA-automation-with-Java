package demoqa.web.tests.elements;

import demoqa.pages.elements.ButtonsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsPageTests extends BaseTest {

    private static final String EXPECTED_HEADER_TEXT = "Buttons";
    private static final String EXPECTED_DOUBLE_CLICK_TEXT = "Double Click Me";
    private static final String EXPECTED_RIGHT_CLICK_TEXT = "Right Click Me";
    private static final String EXPECTED_DYNAMIC_CLICK_TEXT = "Click Me";
    private static final String EXPECTED_DOUBLE_CLICK_MESSAGE = "You have done a double click";
    private static final String EXPECTED_RIGHT_CLICK_MESSAGE = "You have done a right click";
    private static final String EXPECTED_DYNAMIC_CLICK_MESSAGE = "You have done a dynamic click";

    private static final String EXPECTED_BORDER_COLOR = "rgb(0, 123, 255)";
    private static final String EXPECTED_BACKGROUND_COLOR = "rgba(0, 123, 255, 1)";

    private static final String BUTTONS_URL = "buttons";
    private ButtonsPage buttonsPage;

    @BeforeMethod
    public void goToButtonsPage() {
        navigateToUrl(BUTTONS_URL);
        buttonsPage = new ButtonsPage(driver);
    }

    @Test(enabled = true, testName = "Verify all buttons text and buttons color")
    public void verifyAllTextOnPage() {
        // Arrange
        // Act
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

        // Assert
        softAssert.assertEquals(actualHeaderButtonText, EXPECTED_HEADER_TEXT, "\nWrong header Buttons.\n");
        softAssert.assertEquals(actualDoubleClickButtonText, EXPECTED_DOUBLE_CLICK_TEXT, "\nWrong button text " + EXPECTED_DOUBLE_CLICK_TEXT + ".\n");
        softAssert.assertEquals(doubleClickButtonBorderColor, EXPECTED_BORDER_COLOR, "\nExpected border blue color.\n");
        softAssert.assertEquals(doubleClickButtonBackGroundColor, EXPECTED_BACKGROUND_COLOR, "\nExpected background blue color.\n");
        softAssert.assertEquals(actualRightClickMeButtonText, EXPECTED_RIGHT_CLICK_TEXT, "\nWrong button text" + EXPECTED_RIGHT_CLICK_TEXT + ".\n");
        softAssert.assertEquals(rightClickMeButtonBorderColor, EXPECTED_BORDER_COLOR, "\nExpected border blue color.");
        softAssert.assertEquals(rightClickMeButtonBackGroundColor, EXPECTED_BACKGROUND_COLOR, "\nExpected border blue color.");
        softAssert.assertEquals(actualClickMeButtonText, EXPECTED_DYNAMIC_CLICK_TEXT, "\nWrong text " + EXPECTED_DYNAMIC_CLICK_TEXT + "Click Me.\n");
        softAssert.assertEquals(clickMeButtonBorderColor, EXPECTED_BORDER_COLOR, "\nExpected border blue color.\n");
        softAssert.assertEquals(clickMeButtonBackGroundColor, EXPECTED_BACKGROUND_COLOR, "\nExpected border blue color.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click on three buttons and verify messages")
    public void clickOnThreeButtonsAndVerifyMessages() {
        // Arrange
        // Act
        buttonsPage.doubleClickOnButton();
        buttonsPage.rightClickOnButton();
        buttonsPage.clickOnClickMeButton();

        String actualDoubleClickMessage = buttonsPage.getDoubleClickMessage();
        String actualRightClickMessage = buttonsPage.getRightClickMessage();
        String actualClickMeMessage = buttonsPage.getClickMeClickMessage();

        // Assert
        softAssert.assertEquals(actualDoubleClickMessage, EXPECTED_DOUBLE_CLICK_MESSAGE, "\nExpected message is not" + EXPECTED_DOUBLE_CLICK_MESSAGE + ".\n");
        softAssert.assertEquals(actualRightClickMessage, EXPECTED_RIGHT_CLICK_MESSAGE, "\nExpected message is not" + EXPECTED_RIGHT_CLICK_MESSAGE + ".\n");
        softAssert.assertEquals(actualClickMeMessage, EXPECTED_DYNAMIC_CLICK_MESSAGE, "\nExpected message is not" + EXPECTED_DYNAMIC_CLICK_MESSAGE + ".\n");
        softAssert.assertAll();
    }
}
