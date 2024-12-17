package part3.comdemoqa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class HomePageTests extends BaseTest {

    @Test
    public void ClickAllLinks() {
        String expectedFooterText = "© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.";

        String actualFooterText = homePage.getFooterText();
        Assert.assertEquals(actualFooterText, expectedFooterText);

        String expectedUrl = "https://demoqa.com/elements";
        homePage.goToElements();
        String actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/forms";
        homePage.goToForms();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/alertsWindows";
        homePage.goToAlertsFramesWindowsCard();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/widgets";
        homePage.goToWidgets();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/interaction";
        homePage.goToInteractions();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/books";
        homePage.goToBooks();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
