package part3.comdemoqa.tests.forms;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class FormsTest extends BaseTest {
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
}
