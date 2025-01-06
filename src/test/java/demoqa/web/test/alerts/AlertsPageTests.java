package demoqa.web.test.alerts;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.SwitchToUtility.*;

public class AlertsPageTests extends BaseTest {

    @Test(enabled = true)
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
        Assert.assertEquals(actualHeaderText, alertHeaderText, "\n Alert Title Do Not Match. \n");
        Assert.assertEquals(actualFirstText, firstText, "\n Alert Second Text Do Not Match. \n");
        Assert.assertEquals(actualSecondText, secondText, "\n Alert Third Text Do Not Match. \n");
        Assert.assertEquals(actualThirdText, thirdText, "\n Alert Four Text Do Not Match. \n");
        Assert.assertEquals(actualFourText, fourText, "\n Alert Five Text Do Not Match. \n");
    }

    @Test(enabled = true)
    public void CheckTextOfInformationAlert() {
        // Arrange
        navigateToUrl("alerts");
        String expectedAlertText = "You clicked a button";

        // Act
        alertsPage.clickInformationAlertButton();
        String actualAlertText = getAlertText();

        // Assert
        Assert.assertEquals(actualAlertText, expectedAlertText, "\n Actual & Expected Messages Do Not Match. \n");
    }

    @Test(enabled = true)
    public void CheckTextOfPromptAlertAfter5seconds() {
        // Arrange
        navigateToUrl("alerts");
        String expectedAlertText = "This alert appeared after 5 seconds";

        // Act
        alertsPage.clickConfirmationTimeAlertButton();
        String actualAlertText = getAlertText();

        // Assert
        Assert.assertEquals(actualAlertText, expectedAlertText, "\n Different Prompt Alert message. \n");
    }

    @Test(enabled = true)
    public void CheckTextOfConfirmationAlertCancel() {
        // Arrange
        navigateToUrl("alerts");
        String expectedConfirmationResult = "You selected Cancel";

        // Act
        alertsPage.clickConfirmationAlertButton();
        dismissAlert();
        String actualConfirmationResult = alertsPage.getConfirmationResult();

        // Assert
        Assert.assertEquals(actualConfirmationResult, expectedConfirmationResult, "\n You Did Not Select Cancel. \n");
    }

    @Test(enabled = true)
    public void VerifyTextOfConfirmationAlertYes() {
        // Arrange
        navigateToUrl("alerts");
        String expectedConfirmationResult = "You selected Ok";

        // Act
        alertsPage.clickConfirmationAlertButton();
        acceptAlert();
        String actualConfirmationResult = alertsPage.getConfirmationResult();

        // Assert
        Assert.assertEquals(actualConfirmationResult, expectedConfirmationResult, "\n You Did Not Select OK. \n");
    }

    @Test(enabled = true)
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
        Assert.assertEquals(actualResult, expectedResult, "\n Actual & Expected Results Do Not Match. \n");
    }

    @Test(enabled = true)
    public void VerifyTextOfPromptAlertClose() {
        // Arrange
        navigateToUrl("alerts");

        // Act
        alertsPage.clickPromptAlertButton();

        dismissAlert();
        boolean isAlertResultMissing = alertsPage.verifyNoAlertResult();

        // Assert
        Assert.assertTrue(isAlertResultMissing, "\n Show result. \n");
    }
}