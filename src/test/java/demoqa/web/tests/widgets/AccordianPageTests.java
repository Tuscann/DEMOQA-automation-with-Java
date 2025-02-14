package demoqa.web.tests.widgets;

import demoqa.pages.widgets.AccordianPage;
import demoqa.web.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccordianPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        navigateToUrl("accordian");
        AccordianPage accordianPage = new AccordianPage(driver);

        String expectedHeading = "Accordian";
        String expectedOneHeadingText = "What is Lorem Ipsum?";
        String expectedTwoHeadingText = "Where does it come from?";
        String expectedThreeHeadingText = "Why do we use it?";

        String actualHeading = accordianPage.getHeading();
        String actualSectionOneHeadingText = accordianPage.getSectionOneHeadingText();
        String actualSectionTwoHeadingText = accordianPage.getSectionTwoHeadingText();
        String actualSectionThreeHeadingText = accordianPage.getSectionThreeHeadingText();

        softAssert.assertEquals(actualHeading, expectedHeading, "\nWrong heading.\n");
        softAssert.assertEquals(actualSectionOneHeadingText, expectedOneHeadingText, "\nWrong one heading text.\n");
        softAssert.assertEquals(actualSectionTwoHeadingText, expectedTwoHeadingText, "\nWrong two heading text.\n");
        softAssert.assertEquals(actualSectionThreeHeadingText, expectedThreeHeadingText, "\nWrong three heading text.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Select first heading")
    public void SelectFirstHeading() {
        navigateToUrl("accordian");
        AccordianPage accordianPage = new AccordianPage(driver);

        accordianPage.clickOneHeading();

        String actualText = accordianPage.getSectionOneText();
        String expectedText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        Assert.assertEquals(actualText, expectedText, "\nWrong first paragraph.\n");
    }

    @Test(enabled = true, testName = "Select second heading")
    public void SelectSecondHeading() {
        navigateToUrl("accordian");
        AccordianPage accordianPage = new AccordianPage(driver);

        accordianPage.clickTwoHeading();

        String actualText = accordianPage.getSectionTwoText();
        String expectedText = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.";

        Assert.assertEquals(actualText, expectedText, "\nWrong second paragraph.\n");
    }

    @Test(enabled = true, testName = "Select third heading")
    public void SelectThirdHeading() {
        navigateToUrl("accordian");
        AccordianPage accordianPage = new AccordianPage(driver);

        accordianPage.clickThreeHeading();

        String actualText = accordianPage.getSectionThreeText();
        String expectedText = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).";

        Assert.assertEquals(actualText, expectedText, "\nWrong third paragraph.\n");
    }
}