package part3.comdemoqa.tests.alerts;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

import static utilities.SwitchToUtility.*;

public class AlertsPageTests extends BaseTest {
    @Test(enabled = true)
    public void CheckTextOfInformationAlert() {
        // Arrange
        navigateToUrl("alerts");
        String expectedAlertText = "You clicked a button";

        // Act
        alertsPage.clickInformationAlertButton();
        String actualAlertText = getAlertText();

        // Assert
        Assert.assertEquals(actualAlertText, expectedAlertText, "\n Actual & Expected Messages Do Not Match \n");
    }

    @Test(enabled = true)
    public void CheckTextOfPromptAlertAfter5seconds() throws InterruptedException {
        // Arrange
        navigateToUrl("alerts");
        String expectedAlertText = "This alert appeared after 5 seconds";

        // Act
        alertsPage.clickConfirmationTimeAlertButton();

        String actualAlertText = getAlertText();

        // Assert
        Assert.assertEquals(actualAlertText, expectedAlertText, "/n Different PromptAlertAfter message /n");
    }

    @Test
    public void CheckTextOfConfirmationAlert() {
        // Arrange
        navigateToUrl("alerts");
        String expectedConfirmationResult = "You selected Cancel";

        // Act
        alertsPage.clickConfirmationAlertButton();
        dismissAlert();
        String actualConfirmationResult = alertsPage.getConfirmationResult();

        // Assert
        Assert.assertEquals(actualConfirmationResult, expectedConfirmationResult,
                "\n You Did Not Select Cancel \n");
    }

    @Test
    public void testPromptAlert() {
        // Arrange
        String alertText = "Selenium With Java";
        String expectedResult = "You entered " + alertText;
        navigateToUrl("alerts");

        // Act
        alertsPage.clickPromptAlertButton();
        setAlertText(alertText);
        acceptAlert();
        String actualResult = alertsPage.getPromptAlertResult();

        // Assert
        Assert.assertEquals(actualResult, expectedResult,
                "\n Actual & Expected Results Do Not Match \n");
    }
}