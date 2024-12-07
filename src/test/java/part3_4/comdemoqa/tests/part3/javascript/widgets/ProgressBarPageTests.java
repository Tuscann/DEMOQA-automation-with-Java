package part3_4.comdemoqa.tests.part3.javascript.widgets;

import com.pages.demo.pages.widgets.ProgressBarPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

public class ProgressBarPageTests extends BaseTest {
    @Test
    public void clickStartButton() throws InterruptedException {
        ProgressBarPage progressBarPage = homePage.goToWidgets().clickProgressBar();
        progressBarPage.clickStartButtonAfter3seconds();

        progressBarPage.clickStartButton();

        String actualText = progressBarPage.getValueProgressBar();
        String expectedText = "3";

        Assert.assertEquals(actualText, expectedText, "Wrong time value");
    }
}
