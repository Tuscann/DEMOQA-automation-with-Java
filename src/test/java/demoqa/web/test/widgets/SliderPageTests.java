package demoqa.web.test.widgets;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderPageTests extends BaseTest {

    @Test(enabled = false)
    public void StartAndStopOnValue() throws InterruptedException {
        navigateToUrl("slider");
        int targetValue = 70;
// Need HELP TODO

//        sliderPage.stopOnValue(targetValue);
//        int actualValue = sliderPage.getFinalValue();
//
//        Assert.assertEquals(actualValue, stopValue, "Different values");
    }

    @Test(enabled = false)
    public void TestSliderResultZero() throws InterruptedException {
        int x = 90;
        int y = 0;
        navigateToUrl("slider");

        sliderPage.moveSlider(x, y);

        String actualValue = sliderPage.getSliderValue();
        String expectedValue = "60";

        Assert.assertEquals(actualValue, expectedValue, "Actual value is not equal to expected value");
    }

    @Test(enabled = true)
    public void CheckDefaultValueSlider() {
        navigateToUrl("slider");

        String actualValue = sliderPage.getSliderValue();
        String expectedValue = "25";

        Assert.assertEquals(actualValue, expectedValue, "Actual value is not default 25");
    }
}
