package demoqa.web.tests.alerts;

import demoqa.web.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.SwitchToUtility.*;

public class AlertsPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        // Arrange
        navigateToUrl("alerts");

        String alertHeaderText = "Alerts";
        String firstText = "Click Button to see alert";
        String secondText = "On button click, alert will appear after 5 seconds";
        String thirdText = "On button click, confirm box will appear";
        String fourText = "On button click, prompt box will appear";

        // Act
        String actualHeaderText = alertsPage.getHeaderText();
        String actualFirstText = alertsPage.getFirstText();
        String actualSecondText = alertsPage.getSecondText();
        String actualThirdText = alertsPage.getThirdText();
        String actualFourText = alertsPage.getFourthText();

        // Assert
        softAssert.assertEquals(actualHeaderText, alertHeaderText, "\n Alert Title Do Not Match. \n");
        softAssert.assertEquals(actualFirstText, firstText, "\n Alert Second Text Do Not Match. \n");
        softAssert.assertEquals(actualSecondText, secondText, "\n Alert Third Text Do Not Match. \n");
        softAssert.assertEquals(actualThirdText, thirdText, "\n Alert Four Text Do Not Match. \n");
        softAssert.assertEquals(actualFourText, fourText, "\n Alert Five Text Do Not Match. \n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify text of Information alert")
    public void VerifyTextOfInformationAlert() {
        // Arrange
        navigateToUrl("alerts");
        String expectedAlertText = "You clicked a button";

        // Act
        alertsPage.clickInformationAlertButton();
        String actualAlertText = getAlertText();

        // Assert
        Assert.assertEquals(actualAlertText, expectedAlertText, "\n Actual & Expected Messages Do Not Match.\n");
    }

    @Test(enabled = true, testName = "Verify  text of prompt alert after 5 seconds")
    public void VerifyTextOfPromptAlertAfter5seconds() {
        // Arrange
        navigateToUrl("alerts");
        String expectedAlertText = "This alert appeared after 5 seconds";

        // Act
        alertsPage.clickConfirmationTimeAlertButton();
        String actualAlertText = getAlertText();

        // Assert
        Assert.assertEquals(actualAlertText, expectedAlertText, "\nDifferent Prompt Alert message.\n");
    }

    @Test(enabled = true, testName = "Verify you selected cancel on confirmation alert")
    public void VerifyTextOfConfirmationAlertCancel() {
        // Arrange
        navigateToUrl("alerts");
        String expectedConfirmationResult = "You selected Cancel";

        // Act
        alertsPage.clickConfirmationAlertButton();
        dismissAlert();
        String actualConfirmationResult = alertsPage.getConfirmationResult();

        // Assert
        Assert.assertEquals(actualConfirmationResult, expectedConfirmationResult, "\n You Did Not Select Cancel.\n");
    }

    @Test(enabled = true, testName = "Verify you selected ok on confirmation alert")
    public void VerifyTextOfConfirmationAlertYes() {
        // Arrange
        navigateToUrl("alerts");
        String expectedConfirmationResult = "You selected Ok";

        // Act
        alertsPage.clickConfirmationAlertButton();
        acceptAlert();
        String actualConfirmationResult = alertsPage.getConfirmationResult();

        // Assert
        Assert.assertEquals(actualConfirmationResult, expectedConfirmationResult, "\nYou Did Not Select OK.\n");
    }

    @Test(enabled = true, testName = "Verify text of message after of prompt alert")
    public void VerifyTextOfPromptAlertAccept() {
        // Arrange
        navigateToUrl("alerts");
        String alertText = "Selenium With Java";
        String expectedResult = "You entered " + alertText;

        // Act
        alertsPage.clickPromptAlertButton();
        setAlertText(alertText);
        acceptAlert();
        String actualResult = alertsPage.getPromptAlertResult();

        // Assert
        Assert.assertEquals(actualResult, expectedResult, "\nActual & Expected Results Do Not Match.\n");
    }

    @Test(enabled = true, testName = "Verify text of message after ok of prompt alert")
    public void VerifyTextOfPromptAlertOK() {
        // Arrange
        navigateToUrl("alerts");

        // Act
        alertsPage.clickPromptAlertButton();
        acceptAlert();
        boolean isAlertResultMissing = alertsPage.verifyNoAlertResult();

        // Assert
        Assert.assertTrue(isAlertResultMissing, "\nResult alert is not shown.\n");
    }

    @Test(enabled = true, testName = "Verify text of message after close prompt alert")
    public void VerifyTextOfPromptAlertCancel() {
        // Arrange
        navigateToUrl("alerts");

        // Act
        alertsPage.clickPromptAlertButton();
        dismissAlert();

        boolean isAlertResultMissing = alertsPage.verifyNoAlertResult();

        // Assert
        Assert.assertTrue(isAlertResultMissing, "\nResult alert is not shown.\n");
    }
}