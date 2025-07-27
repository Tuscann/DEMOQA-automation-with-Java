package demoqa.web.tests.widgets;

import demoqa.pages.widgets.SliderPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.Test;

public class SliderPageTests extends BaseTest {

    @Test(enabled = false, testName = "Start and stop on value")
    public void StartAndStopOnValue() throws InterruptedException {
        navigateToUrl("slider");
        int targetValue = 70;
// Need HELP TODO

//        sliderPage.stopOnValue(targetValue);
//        int actualValue = sliderPage.getFinalValue();
//
//        Assert.assertEquals(actualValue, stopValue, "Different values");
    }

    @Test(enabled = false, testName = "Test slider result zero")
    public void TestSliderResultZero() throws InterruptedException {

        navigateToUrl("slider");
        SliderPage sliderPage = new SliderPage(driver);
        String expectedValue = "60";
        int x = 90;
        int y = 0;

        // Act
        sliderPage.moveSlider(x, y);
        String actualValue = sliderPage.getSliderValue();

        // Assert
        softAssert.assertEquals(actualValue, expectedValue, "Actual value is not equal to expected value");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Check default value slider")
    public void CheckDefaultValueSlider() {
        navigateToUrl("slider");
        SliderPage sliderPage = new SliderPage(driver);
        String expectedValue = "25";

        // Act
        String actualValue = sliderPage.getSliderValue();

        // Assert
        softAssert.assertEquals(actualValue, expectedValue, "Actual value is not default 25");
        softAssert.assertAll();
    }
}
