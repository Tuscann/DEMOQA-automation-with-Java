package part3.comdemoqa.tests.forms;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class FormsPageTests extends BaseTest {
    @Test
    public void CheckAllTextOnPage() {
        // Arrange
        navigateToUrl("forms");
        String actualString = "Please select an item from left to start practice.";

        // Act
        String expectedString = formsPage.getText();

        // Assert
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void VerifyPracticeFormLink() {
        navigateToUrl("forms");

        String expectedUrl = "https://demoqa.com/automation-practice-form";
        formsPage.clickPracticeForm();
        String actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
