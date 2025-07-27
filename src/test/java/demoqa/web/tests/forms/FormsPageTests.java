package demoqa.web.tests.forms;

import demoqa.pages.forms.FormsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.Test;

public class FormsPageTests extends BaseTest {
    @Test(enabled = true, testName = "Verify all text on page")
    public void CheckAllTextOnPage() {
        // Arrange
        navigateToUrl("forms");
        FormsPage formsPage = new FormsPage(driver);

        String actualString = "Please select an item from left to start practice.";

        // Act
        String expectedString = formsPage.getText();

        // Assert
        softAssert.assertEquals(expectedString, actualString, "\nWrong text.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify practice form link")
    public void VerifyPracticeFormLink() {
        // Arrange
        navigateToUrl("forms");
        FormsPage formsPage = new FormsPage(driver);
        String expectedUrl = "https://demoqa.com/automation-practice-form";

        // Act
        formsPage.clickPracticeForm();
        String actualUrl = formsPage.checkUrl();

        // Assert
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong URL not automation-practice-form.\n");
        softAssert.assertAll();
    }
}
