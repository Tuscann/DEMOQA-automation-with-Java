package com.pages.demo.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.ActionUtility.dragAndDropBy;
import static utilities.GetUtility.getAttribute;
import static utilities.WaitUtility.explicitWaitUntilVisible;
import static utilities.WaitUtility.fluentWaitUntilVisible;

public class SliderPage extends WidgetsPage {
    private final By slider = By.xpath("//div[@id='sliderContainer']//input[@type='range']");
    private final By sliderValue = By.id("sliderValue");

    public String getSliderValue() {
        return getAttribute(sliderValue, "value");
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
}
