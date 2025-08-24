package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ActionUtility;

import java.time.Duration;

public class SliderPage extends BasePage {
    @FindBy(id = "sliderValue")
    private WebElement sliderValue;

    @FindBy(className = "range-slider__wrap")
    private WebElement slider;

    private final ActionUtility actionUtility;

    public SliderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.actionUtility = new ActionUtility(driver);
    }

    public String getSliderValue() {
        return sliderValue.getDomAttribute("value");
    }

    public void moveSlider(int x, int y) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(slider));
        actionUtility.dragAndDropBy(slider, x, y);
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
