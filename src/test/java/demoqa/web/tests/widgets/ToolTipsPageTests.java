package demoqa.web.tests.widgets;

import demoqa.pages.widgets.ToolTipsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsPageTests extends BaseTest {
    // Page URL
    public static final String TOOLS_TIPS_URL = "tool-tips";

    // Static Page Text
    public static final String HEADER_TEXT = "Tool Tips";
    public static final String PRACTICE_TEXT = "Practice Tool Tips";
    public static final String BUTTON_TEXT = "Hover me to see";
    public static final String TEXT_FIELD_PLACEHOLDER = "Hover me to see";
    public static final String MAIN_PARAGRAPH_TEXT = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.";

    // Tooltip Text
    public static final String BUTTON_TOOLTIP = "You hovered over the Button";
    public static final String TEXT_FIELD_TOOLTIP = "You hovered over the text field";
    public static final String CONTRARY_LINK_TOOLTIP = "You hovered over the Contrary";
    public static final String SECTION_LINK_TOOLTIP = "You hovered over the 1.10.32";

    private ToolTipsPage toolTipsPage;

    @BeforeMethod
    public void goToToolsTipsPage() {
        navigateToUrl(TOOLS_TIPS_URL);
        toolTipsPage = new ToolTipsPage(driver);
    }

    @Test(enabled = true, testName = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange
        // Act
        String actualHeader = toolTipsPage.getHeaderText();
        String actualPracticeToolTipsText = toolTipsPage.getPracticeToolTips();
        String actualHoverMeToSeeButtonText = toolTipsPage.getHoverMeButtonButton();
        String actualHoverMeToSeeButtonPlaceholder = toolTipsPage.getHoverMeToSeeButtonPlaceholder();
        String actualMainText = toolTipsPage.getMainText();

        // Assert
        softAssert.assertEquals(actualHeader, HEADER_TEXT, "\nMissing header.\n");
        softAssert.assertEquals(actualPracticeToolTipsText, PRACTICE_TEXT, "\nMissing practice ToolTips.\n");
        softAssert.assertEquals(actualHoverMeToSeeButtonText, BUTTON_TEXT, "\nMissing hover me to see.\n");
        softAssert.assertEquals(actualHoverMeToSeeButtonPlaceholder, TEXT_FIELD_PLACEHOLDER, "\nHover placeholder.\n");
        softAssert.assertEquals(actualMainText, MAIN_PARAGRAPH_TEXT, "\nMissing main text.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify over 4 tooltips")
    public void hoverOver4ToolTips() {
        // Arrange
        // Act
        String actualTooltipText = toolTipsPage.getHoverOverHoverMeToSeeButtonReturnToolTipText();
        String actualHoverMeToSeeTextField = toolTipsPage.getHoverOverHoverMeToSeeTextFieldReturnToolTipText();
        String actualContraryTextField = toolTipsPage.getHoverOverContraryReturnToolTipText();
        String actualSection = toolTipsPage.getHoverOverSectionText();

        // Assert
        softAssert.assertEquals(actualTooltipText, BUTTON_TOOLTIP, "\nMissing tooltip.\n");
        softAssert.assertEquals(actualHoverMeToSeeTextField, TEXT_FIELD_TOOLTIP, "\nMissing tooltip text field.\n");
        softAssert.assertEquals(actualContraryTextField, CONTRARY_LINK_TOOLTIP, "\nMissing tooltip contrary.\n");
        softAssert.assertEquals(actualSection, SECTION_LINK_TOOLTIP, "\nMissing tooltip contrary.\n");
        softAssert.assertAll();
    }
}
