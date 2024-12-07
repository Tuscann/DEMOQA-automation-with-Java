package part3_4.comdemoqa.tests.part4.interactions;

import com.pages.demo.pages.widgets.SliderPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

public class SliderTests extends BaseTest {

    @Test
    public void testSliderResult() throws InterruptedException {
        int x = 180;
        int y = 0;

        SliderPage sliderPage = homePage.goToWidgets().clickSlider();
        sliderPage.moveSlider(x, y);

        String actualValue = sliderPage.getSliderValue();
        String expectedValue = "70";

        Assert.assertEquals(actualValue, expectedValue, "Actual value is not equal to expected value");
    }

    @Test
    public void testSliderResultZero() throws InterruptedException {
        int x = 90;
        int y = 0;

        SliderPage sliderPage = homePage.goToWidgets().clickSlider();

        sliderPage.moveSlider(x, y);

        String actualValue = sliderPage.getSliderValue();
        String expectedValue = "60";

        Assert.assertEquals(actualValue, expectedValue, "Actual value is not equal to expected value");
    }

    @Test
    public void checkDefaultValueSlider() {
        SliderPage sliderPage = homePage.goToWidgets().clickSlider();

        String actualValue = sliderPage.getSliderValue();
        String expectedValue = "25";

        Assert.assertEquals(actualValue, expectedValue, "Actual value is not default 25");
    }
}
