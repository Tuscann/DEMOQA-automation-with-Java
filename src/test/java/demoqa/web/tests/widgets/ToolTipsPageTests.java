package demoqa.web.tests.widgets;

import demoqa.pages.widgets.ToolTipsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.Test;

public class ToolTipsPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        navigateToUrl("tool-tips");
        ToolTipsPage toolTipsPage = new ToolTipsPage(driver);

        String header = "Tool Tips";
        String practiceToolTips = "Practice Tool Tips";
        String hoverMeButtonButton = "Hover me to see";
        String textFieldPlaceholder = "Hover me to see";
        String mainText = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.";

        String actualHeader = toolTipsPage.getHeaderText();
        String actualPracticeToolTipsText = toolTipsPage.getPracticeToolTips();
        String actualHoverMeToSeeButtonText = toolTipsPage.getHoverMeButtonButton();
        String actualHoverMeToSeeButtonPlaceholder = toolTipsPage.getHoverMeToSeeButtonPlaceholder();
        String actualMainText = toolTipsPage.getMainText();

        softAssert.assertEquals(actualHeader, header, "\nMissing header.\n");
        softAssert.assertEquals(actualPracticeToolTipsText, practiceToolTips, "\nMissing practice ToolTips.\n");
        softAssert.assertEquals(actualHoverMeToSeeButtonText, hoverMeButtonButton, "\nMissing hover me to see.\n");
        softAssert.assertEquals(actualHoverMeToSeeButtonPlaceholder, textFieldPlaceholder, "\nHover placeholder.\n");
        softAssert.assertEquals(actualMainText, mainText, "\nMissing main text.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify over 4 tooltips")
    public void HoverOver4ToolTips() {
        navigateToUrl("tool-tips");
        ToolTipsPage toolTipsPage = new ToolTipsPage(driver);

        String actualTooltipText = toolTipsPage.getHoverOverHoverMeToSeeButtonReturnToolTipText();
        String expectedTooltipText = "You hovered over the Button";
        softAssert.assertEquals(actualTooltipText, expectedTooltipText, "\nMissing tooltip.\n");

        String actualHoverMeToSeeTextField = toolTipsPage.getHoverOverHoverMeToSeeTextFieldReturnToolTipText();
        expectedTooltipText = "You hovered over the text field";
        softAssert.assertEquals(actualHoverMeToSeeTextField, expectedTooltipText, "\nMissing tooltip text feild.\n");

        String actualContraryTextField = toolTipsPage.getHoverOverContraryReturnToolTipText();
        expectedTooltipText = "You hovered over the Contrary";
        softAssert.assertEquals(actualContraryTextField, expectedTooltipText, "\nMissing tooltip contrary.\n");

        String actualSection = toolTipsPage.getHoverOverSectionText();
        expectedTooltipText = "You hovered over the 1.10.32";
        softAssert.assertEquals(actualSection, expectedTooltipText, "\nMissing tooltip contrary.\n");

        softAssert.assertAll();
    }
}
