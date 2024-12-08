package com.pages.demo.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutoCompletePage extends WidgetsPage {
    private final By multiAutoComplete = By.xpath("//*[@id='autoCompleteMultipleInput']");
    private final By singleAutoComplete = By.xpath("//div[@class='auto-complete__value-container css-1hwfws3']");
    private final By text = By.xpath("//h1[contains(.,'Auto Complete')]");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void multiAutoComplete(String color) {
        wait.until(ExpectedConditions.elementToBeClickable(multiAutoComplete))
                .sendKeys("re", Keys.chord(Keys.LEFT_SHIFT, Keys.ENTER));
    }

    public void singleAutoComplete() {
    }

}
