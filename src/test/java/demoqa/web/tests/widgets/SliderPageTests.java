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

    @Test(enabled = true, description = "Check default value slider")
    public void checkDefaultValueSlider() {
        // Arrange & Act & Assert
        softAssert.assertEquals(sliderPage.getSliderValue(), "25", "Actual value is not default 25");
        softAssert.assertAll();
    }
}
