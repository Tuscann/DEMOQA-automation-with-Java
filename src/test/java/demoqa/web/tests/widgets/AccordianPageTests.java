package demoqa.web.tests.widgets;

import demoqa.pages.widgets.AccordianPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccordianPageTests extends BaseTest {

    public static final String ACCORDIAN_URL = "accordian";
    private AccordianPage accordianPage;
    
    // Text Constants
    private static final String PAGE_HEADING = "Accordian";
    private static final String SECTION_ONE_HEADING = "What is Lorem Ipsum?";
    private static final String SECTION_TWO_HEADING = "Where does it come from?";
    private static final String SECTION_THREE_HEADING = "Why do we use it?";
    
    // Long Text Constants
    private static final String SECTION_ONE_TEXT = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
    private static final String SECTION_TWO_TEXT = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
            "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.";
    private static final String SECTION_THREE_TEXT = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).";
    
    // Error Message Constants
    private static final String PAGE_HEADING_ERROR = "Page heading mismatch";
    private static final String SECTION_ONE_HEADING_ERROR = "First section heading mismatch";
    private static final String SECTION_TWO_HEADING_ERROR = "Second section heading mismatch";
    private static final String SECTION_THREE_HEADING_ERROR = "Third section heading mismatch";
    private static final String SECTION_ONE_TEXT_ERROR = "First section text mismatch";
    private static final String SECTION_TWO_TEXT_ERROR = "Second section text mismatch";
    private static final String SECTION_THREE_TEXT_ERROR = "Third section text mismatch";

    @BeforeMethod
    public void goToDatePickerPage() {
        navigateToUrl(ACCORDIAN_URL);
        accordianPage = new AccordianPage(driver);
    }

    @Test(enabled = true, description = "Verify all headings on Accordian page")
    public void verifyAllTextOnPage() {
        // Arrange
        // Act & Assert
        softAssert.assertEquals(accordianPage.getHeading(), PAGE_HEADING, PAGE_HEADING_ERROR);
        softAssert.assertEquals(accordianPage.getSectionOneHeadingText(), SECTION_ONE_HEADING, SECTION_ONE_HEADING_ERROR);
        softAssert.assertEquals(accordianPage.getSectionTwoHeadingText(), SECTION_TWO_HEADING, SECTION_TWO_HEADING_ERROR);
        softAssert.assertEquals(accordianPage.getSectionThreeHeadingText(), SECTION_THREE_HEADING, SECTION_THREE_HEADING_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select first heading")
    public void selectFirstHeading() {
        // Arrange
        // Act
        accordianPage.clickOneHeading();

        // Assert
        softAssert.assertEquals(accordianPage.getSectionOneText(), SECTION_ONE_TEXT, SECTION_ONE_TEXT_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select second heading")
    public void selectSecondHeading() {
        // Arrange & Act
        accordianPage.clickTwoHeading();

        // Assert
        softAssert.assertEquals(accordianPage.getSectionTwoText(), SECTION_TWO_TEXT, SECTION_TWO_TEXT_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select third heading")
    public void selectThirdHeading() {
        // Arrange & Act
        accordianPage.clickThreeHeading();

        // Assert
        softAssert.assertEquals(accordianPage.getSectionThreeText(), SECTION_THREE_TEXT, SECTION_THREE_TEXT_ERROR);
        softAssert.assertAll();
    }
}