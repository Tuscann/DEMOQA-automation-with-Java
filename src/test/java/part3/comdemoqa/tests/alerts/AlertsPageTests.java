package part3.comdemoqa.tests.alerts;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

import static utilities.SwitchToUtility.*;

public class AlertsPageTests extends BaseTest {
    @Test
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
    public void CheckTextOfPromptAlertAfter5seconds() {
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
    public void CheckTextOfConfirmationAlertYes() {
        // Arrange
        navigateToUrl("alerts");
        String expectedConfirmationResult = "You selected Cancel";

        // Act
        alertsPage.clickConfirmationAlertButton();
        dismissAlert();
        String actualConfirmationResult = alertsPage.getConfirmationResult();

        // Assert
        Assert.assertEquals(actualConfirmationResult, expectedConfirmationResult, "\n You Did Not Select Cancel \n");
    }

    @Test
    public void VerifyTextOfConfirmationAlertNo() {
        // Arrange
        navigateToUrl("alerts");
        String expectedConfirmationResult = "You selected Ok";

        // Act
        alertsPage.clickConfirmationAlertButton();
        acceptAlert();
        String actualConfirmationResult = alertsPage.getConfirmationResult();

        // Assert
        Assert.assertEquals(actualConfirmationResult, expectedConfirmationResult,
                "\n You Did Not Select OK \n");
    }

    @Test
    public void VerifyTextOfPromptAlert() {
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
        Assert.assertEquals(actualResult, expectedResult,
                "\n Actual & Expected Results Do Not Match \n");
    }

    @Test(enabled = true)
    public void VerifyAllTextOnPage() {
        // Arrange
        navigateToUrl("alerts");

        String alertText1 = "Alerts";
        String alertText2 = "Click Button to see alert";
        String alertText3 = "On button click, alert will appear after 5 seconds";
        String alertTex4 = "On button click, confirm box will appear";
        String alertTex5 = "On button click, prompt box will appear";

        // Act
        String actualFirstText = alertsPage.getFirstText();
        String actualSecondText = alertsPage.getSecondText();
        String actualThirdText = alertsPage.getThirdText();
        String actualFourText = alertsPage.getFourthText();
        String actualFiveText = alertsPage.getFiveText();

        // Assert
        Assert.assertEquals(actualFirstText, alertText1, "\n Alert Title Do Not Match \n");
        Assert.assertEquals(actualSecondText, alertText2, "\n Alert Second Text Do Not Match \n");
        Assert.assertEquals(actualThirdText, alertText3, "\n Alert Third Text Do Not Match \n");
        Assert.assertEquals(actualFourText, alertTex4, "\n Alert Four Text Do Not Match \n");
        Assert.assertEquals(actualFiveText, alertTex5, "\n Alert Five Text Do Not Match \n");
    }
}