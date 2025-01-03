package demoqa.web.test.forms;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormsPageTests extends BaseTest {
    @Test(enabled = true)
    public void CheckAllTextOnPage() {
        // Arrange
        navigateToUrl("forms");
        String actualString = "Please select an item from left to start practice.";

        // Act
        String expectedString = formsPage.getText();

        // Assert
        Assert.assertEquals(expectedString, actualString, "\n Wrong text \n");
    }

    @Test(enabled = true)
    public void VerifyPracticeFormLink() {
        navigateToUrl("forms");

        String expectedUrl = "https://demoqa.com/automation-practice-form";
        formsPage.clickPracticeForm();
        String actualUrl = practiceFormPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\n Wrong URL not automation-practice-form \n");
    }
}
