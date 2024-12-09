package part3.comdemoqa.tests.alerts;

import com.pages.demo.pages.alerts_frames_windows.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

import static utilities.SwitchToUtility.*;

public class AlertsTests extends BaseTest {
    @Test
    public void CheckTextOfInformationAlert() {
        // Arrange
        String expectedAlertText = "You clicked a button";
        AlertsPage alertsPage = homePage.goToAlertsFramesWindowsCard().clickAlerts();

        // Act
        alertsPage.clickInformationAlertButton();

        // Assert
        Assert.assertEquals(getAlertText(), expectedAlertText, "\n Actual & Expected Messages Do Not Match \n");
        acceptAlert();
    }

    //  @Test //TODO
    public void CheckTextOfPromptAlertAfter5seconds() throws InterruptedException {
        // Arrange
        String expectedAlertText = "This alert appeared after 5 seconds";
        AlertsPage alertsPage = homePage.goToAlertsFramesWindowsCard().clickAlerts();

        // Act
        alertsPage.clickConfirmationTimeAlertButton();
        Thread.sleep(6000);
        String actualAlertText = getAlertText();

        // Assert
        Assert.assertEquals(actualAlertText, expectedAlertText, "/n Different PromptAlertAfter message /n");
    }

    //   @Test  //TODO
    public void CheckTextOfConfirmationAlert() {
        // Arrange
        AlertsPage alertsPage = homePage.goToAlertsFramesWindowsCard().clickAlerts();
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

        // Act
        AlertsPage alertsPage = homePage.goToAlertsFramesWindowsCard().clickAlerts();
        alertsPage.clickPromptAlertButton();
        setAlertText(alertText);
        acceptAlert();
        String actualResult = alertsPage.getPromptAlertResult();

        // Assert
        Assert.assertEquals(actualResult, expectedResult,
                "\n Actual & Expected Results Do Not Match \n");
    }
}