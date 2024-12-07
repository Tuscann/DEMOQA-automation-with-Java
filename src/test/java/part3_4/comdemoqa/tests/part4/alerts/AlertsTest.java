package part3_4.comdemoqa.tests.part4.alerts;

import com.pages.demo.pages.alerts_frames_windows.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

import static utilities.SwitchToUtility.*;

@Test
public class AlertsTest extends BaseTest {
    @Test
    public void testInformationAlert() {
        String expectedAlertText = "You clicked a button";
        AlertsPage alertsPage = homePage.goToAlertsFramesWindowsCard().clickAlerts();
        alertsPage.clickInformationAlertButton();

        Assert.assertEquals(getAlertText(), expectedAlertText, "\n Actual & Expected Messages Do Not Match \n");
        acceptAlert();
    }

    public void testPromptAlertAfter5seconds() throws InterruptedException {
        // Arrange
        String expectedAlertText = "This alert appeared after 5 seconds";
        AlertsPage alertsPage = homePage.goToAlertsFramesWindowsCard().clickAlerts();

        // Act
        alertsPage.clickConfirmationTimeAlertButton();
        Thread.sleep(5000);
        String actualAlertText = getAlertText();

        // Assert
        Assert.assertEquals(actualAlertText, expectedAlertText, "/n Different PromptAlertAfter message /n");
    }

    public void testConfirmationAlert() {
        AlertsPage alertsPage = homePage.goToAlertsFramesWindowsCard().clickAlerts();
        alertsPage.clickConfirmationAlertButton();
        dismissAlert();
        String actualConfirmationResult = alertsPage.getConfirmationResult();
        String expectedConfirmationResult = "You selected Cancel";
        Assert.assertEquals(actualConfirmationResult, expectedConfirmationResult,
                "\n You Did Not Select Cancel \n");
    }

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