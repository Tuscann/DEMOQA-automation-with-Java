package demoqa.web.tests.widgets;

import demoqa.pages.widgets.SliderPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderPageTests extends BaseTest {

    public static final String SLIDER_URL = "slider";
    private SliderPage sliderPage;

    @BeforeMethod
    public void goToSliderPage() {
        navigateToUrl(SLIDER_URL);
        sliderPage = new SliderPage(driver);
    }

    @Test(enabled = false, testName = "Start and stop on value")
    public void startAndStopOnValue() throws InterruptedException {
        // Arrange
        int targetValue = 70;
// Need HELP TODO

//        sliderPage.stopOnValue(targetValue);
//        int actualValue = sliderPage.getFinalValue();
//
//        Assert.assertEquals(actualValue, stopValue, "Different values");
    }

    @Test(enabled = false, testName = "Test slider result zero")
    public void testSliderResultZero() throws InterruptedException {
        // Arrange
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
    public void checkDefaultValueSlider() {
        // Arrange
        String expectedValue = "25";

        // Act
        String actualValue = sliderPage.getSliderValue();

        // Assert
        softAssert.assertEquals(actualValue, expectedValue, "Actual value is not default 25");
        softAssert.assertAll();
    }
}
