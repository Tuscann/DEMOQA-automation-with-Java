package demoqa.web.tests.elements;

import demoqa.pages.elements.ButtonsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsPageTests extends BaseTest {
    // Text Constants
    private static final String EXPECTED_HEADER_TEXT = "Buttons";
    private static final String EXPECTED_DOUBLE_CLICK_TEXT = "Double Click Me";
    private static final String EXPECTED_RIGHT_CLICK_TEXT = "Right Click Me";
    private static final String EXPECTED_DYNAMIC_CLICK_TEXT = "Click Me";

    // Message Constants
    private static final String EXPECTED_DOUBLE_CLICK_MESSAGE = "You have done a double click";
    private static final String EXPECTED_RIGHT_CLICK_MESSAGE = "You have done a right click";
    private static final String EXPECTED_DYNAMIC_CLICK_MESSAGE = "You have done a dynamic click";

    // Color Constants
    private static final String EXPECTED_BORDER_COLOR = "rgb(0, 123, 255)";
    private static final String EXPECTED_BACKGROUND_COLOR = "rgba(0, 123, 255, 1)";

    // Error Message Constants
    private static final String HEADER_TEXT_MISMATCH = "Header text mismatch";
    private static final String DOUBLE_CLICK_BUTTON_TEXT_MISMATCH = "Double click button text mismatch";
    private static final String RIGHT_CLICK_BUTTON_TEXT_MISMATCH = "Right click button text mismatch";
    private static final String DYNAMIC_CLICK_BUTTON_TEXT_MISMATCH = "Dynamic click button text mismatch";
    private static final String BORDER_COLOR_MISMATCH = "Border color mismatch";
    private static final String BACKGROUND_COLOR_MISMATCH = "Background color mismatch";
    private static final String DOUBLE_CLICK_MESSAGE_MISMATCH = "Double click message mismatch";
    private static final String RIGHT_CLICK_MESSAGE_MISMATCH = "Right click message mismatch";
    private static final String DYNAMIC_CLICK_MESSAGE_MISMATCH = "Dynamic click message mismatch";

    private ButtonsPage buttonsPage;
    private static final String BUTTONS_URL = "buttons";

    @BeforeMethod
    public void goToButtonsPage() {
        navigateToUrl(BUTTONS_URL);
        buttonsPage = new ButtonsPage(driver);
    }

    @Test(enabled = true, description = "Verify all button text elements and color properties on the buttons page")
    public void verifyAllTextOnPage() {
        // Arrange & Act        
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
        softAssert.assertEquals(actualHeaderButtonText, EXPECTED_HEADER_TEXT, HEADER_TEXT_MISMATCH);
        softAssert.assertEquals(actualDoubleClickButtonText, EXPECTED_DOUBLE_CLICK_TEXT, DOUBLE_CLICK_BUTTON_TEXT_MISMATCH);
        softAssert.assertEquals(doubleClickButtonBorderColor, EXPECTED_BORDER_COLOR, BORDER_COLOR_MISMATCH);
        softAssert.assertEquals(doubleClickButtonBackGroundColor, EXPECTED_BACKGROUND_COLOR, BACKGROUND_COLOR_MISMATCH);
        softAssert.assertEquals(actualRightClickMeButtonText, EXPECTED_RIGHT_CLICK_TEXT, RIGHT_CLICK_BUTTON_TEXT_MISMATCH);
        softAssert.assertEquals(rightClickMeButtonBorderColor, EXPECTED_BORDER_COLOR, BORDER_COLOR_MISMATCH);
        softAssert.assertEquals(rightClickMeButtonBackGroundColor, EXPECTED_BACKGROUND_COLOR, BACKGROUND_COLOR_MISMATCH);
        softAssert.assertEquals(actualClickMeButtonText, EXPECTED_DYNAMIC_CLICK_TEXT, DYNAMIC_CLICK_BUTTON_TEXT_MISMATCH);
        softAssert.assertEquals(clickMeButtonBorderColor, EXPECTED_BORDER_COLOR, BORDER_COLOR_MISMATCH);
        softAssert.assertEquals(clickMeButtonBackGroundColor, EXPECTED_BACKGROUND_COLOR, BACKGROUND_COLOR_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click on three buttons and verify success messages")
    public void clickOnThreeButtonsAndVerifyMessages() {
        // Arrange & Act
        buttonsPage.doubleClickOnButton();
        buttonsPage.rightClickOnButton();
        buttonsPage.clickOnClickMeButton();

        String actualDoubleClickMessage = buttonsPage.getDoubleClickMessage();
        String actualRightClickMessage = buttonsPage.getRightClickMessage();
        String actualClickMeMessage = buttonsPage.getClickMeClickMessage();

        // Assert
        softAssert.assertEquals(actualDoubleClickMessage, EXPECTED_DOUBLE_CLICK_MESSAGE, DOUBLE_CLICK_MESSAGE_MISMATCH);
        softAssert.assertEquals(actualRightClickMessage, EXPECTED_RIGHT_CLICK_MESSAGE, RIGHT_CLICK_MESSAGE_MISMATCH);
        softAssert.assertEquals(actualClickMeMessage, EXPECTED_DYNAMIC_CLICK_MESSAGE, DYNAMIC_CLICK_MESSAGE_MISMATCH);
        softAssert.assertAll();
    }
}
