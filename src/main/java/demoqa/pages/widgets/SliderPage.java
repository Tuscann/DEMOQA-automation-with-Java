package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.ActionUtility.dragAndDropBy;
import static utilities.GetUtility.getDomAttribute;
import static utilities.WaitUtility.explicitWaitUntilVisible;
import static utilities.WaitUtility.fluentWaitUntilVisible;

public class SliderPage extends BasePage {
    private final By sliderValue = By.id("sliderValue");
    private final By slider = By.className("range-slider__wrap");

    public SliderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getSliderValue() {
        return getDomAttribute(sliderValue, "value");
    }

    public void moveSlider(int x, int y) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(slider));

        fluentWaitUntilVisible(3, slider);
        explicitWaitUntilVisible(3, slider);
        WebDriverWait waist = new WebDriverWait(driver, Duration.ofSeconds(13));
        waist.until(ExpectedConditions.visibilityOf(find(slider)));
        dragAndDropBy(find(slider), x, y);
    }

    public int getSliderPixels(WebElement slider, double amount, double sliderMax, double sliderMin) {
        int pixels;
        double sliderWidth = slider.getSize().getWidth();
        sliderWidth = sliderWidth / (sliderMax - sliderMin);
        sliderWidth = sliderWidth * (amount - sliderMin);
        pixels = (int) sliderWidth;
        return pixels;
    }
}
