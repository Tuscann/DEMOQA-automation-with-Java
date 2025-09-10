package demoqa.web.tests.widgets;

import demoqa.pages.widgets.ToolTipsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsPageTests extends BaseTest {
    // Expected Text Constants
    private static final String EXPECTED_HEADER_TEXT = "Tool Tips";
    private static final String EXPECTED_PRACTICE_TEXT = "Practice Tool Tips";
    private static final String EXPECTED_BUTTON_TEXT = "Hover me to see";
    private static final String EXPECTED_TEXT_FIELD_PLACEHOLDER = "Hover me to see";

    // Long Text Constants (Lorem Ipsum Content)
    private static final String EXPECTED_MAIN_PARAGRAPH_TEXT = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.";

    // Expected Tooltip Text Constants
    private static final String EXPECTED_BUTTON_TOOLTIP = "You hovered over the Button";
    private static final String EXPECTED_TEXT_FIELD_TOOLTIP = "You hovered over the text field";
    private static final String EXPECTED_CONTRARY_LINK_TOOLTIP = "You hovered over the Contrary";
    private static final String EXPECTED_SECTION_LINK_TOOLTIP = "You hovered over the 1.10.32";

    // Error Message Constants
    private static final String BUTTON_COLOR_ERROR = "Missing button color";
    private static final String HEADER_MISSING_ERROR = "Missing header text";
    private static final String PRACTICE_TEXT_MISSING_ERROR = "Missing practice ToolTips text";
    private static final String BUTTON_TEXT_MISSING_ERROR = "Missing hover me to see button text";
    private static final String PLACEHOLDER_MISSING_ERROR = "Missing hover placeholder text";
    private static final String MAIN_TEXT_MISSING_ERROR = "Missing main paragraph text";
    private static final String BUTTON_TOOLTIP_MISSING_ERROR = "Missing button tooltip";
    private static final String TEXT_FIELD_TOOLTIP_MISSING_ERROR = "Missing text field tooltip";
    private static final String CONTRARY_TOOLTIP_MISSING_ERROR = "Missing contrary link tooltip";
    private static final String SECTION_TOOLTIP_MISSING_ERROR = "Missing section link tooltip";

    private static final String EXPECTED_GREEN_COLOR = "rgba(40, 167, 69, 1)";
    private static final String TOOL_TIPS_URL = "tool-tips";
    private ToolTipsPage toolTipsPage;

    @BeforeMethod
    public void goToToolTipsPage() {
        navigateToUrl(TOOL_TIPS_URL);
        toolTipsPage = new ToolTipsPage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange & Act & Assert

        softAssert.assertEquals(toolTipsPage.getToolTipsHeaderText(), EXPECTED_HEADER_TEXT, HEADER_MISSING_ERROR);
        softAssert.assertEquals(toolTipsPage.getPracticeToolTipsText(), EXPECTED_PRACTICE_TEXT, PRACTICE_TEXT_MISSING_ERROR);
        softAssert.assertEquals(toolTipsPage.getHoverMeButtonText(), EXPECTED_BUTTON_TEXT, BUTTON_TEXT_MISSING_ERROR);
        softAssert.assertEquals(toolTipsPage.getHoverMeButtonBackgroundColor(), EXPECTED_GREEN_COLOR, BUTTON_COLOR_ERROR);
        softAssert.assertEquals(toolTipsPage.getHoverMeToSeeInputPlaceholder(), EXPECTED_TEXT_FIELD_PLACEHOLDER, PLACEHOLDER_MISSING_ERROR);
        softAssert.assertEquals(toolTipsPage.getMainText(), EXPECTED_MAIN_PARAGRAPH_TEXT, MAIN_TEXT_MISSING_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify text after hover 4 tooltips")
    public void hoverOver4ToolTips() {
        // Arrange and Act
        String actualHoverMeToSeeButtonToolTipText = toolTipsPage.getHoverOverHoverMeToSeeButtonReturnToolTipText();
        String actualHoverMeToSeeFieldToolTipText = toolTipsPage.getHoverOverHoverMeToSeeTextFieldReturnToolTipText();
        String actualContraryTextToolTipText = toolTipsPage.getHoverOverContraryReturnToolTipText();
        String actualSectionToolTipText = toolTipsPage.getHoverOverSectionText();

        // Assert
        softAssert.assertEquals(actualHoverMeToSeeButtonToolTipText, EXPECTED_BUTTON_TOOLTIP, BUTTON_TOOLTIP_MISSING_ERROR);
        softAssert.assertEquals(actualHoverMeToSeeFieldToolTipText, EXPECTED_TEXT_FIELD_TOOLTIP, TEXT_FIELD_TOOLTIP_MISSING_ERROR);
        softAssert.assertEquals(actualContraryTextToolTipText, EXPECTED_CONTRARY_LINK_TOOLTIP, CONTRARY_TOOLTIP_MISSING_ERROR);
        softAssert.assertEquals(actualSectionToolTipText, EXPECTED_SECTION_LINK_TOOLTIP, SECTION_TOOLTIP_MISSING_ERROR);
        softAssert.assertAll();
    }
}
