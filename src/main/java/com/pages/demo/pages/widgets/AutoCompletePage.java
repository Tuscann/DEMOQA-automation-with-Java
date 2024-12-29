package com.pages.demo.pages.widgets;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutoCompletePage extends BasePage {
    private final By multiAutoComplete = By.id("autoCompleteMultipleInput");
    private final By singleAutoComplete = By.id("autoCompleteSingleInput");
    private final By text = By.xpath("//h1[contains(.,'Auto Complete')]");
    private final By multipleContainerText = By.id("autoCompleteMultiple");
    private final By autoCompleteSingleText = By.id("autoCompleteSingle");
    private final By closeButton = By.xpath(" //div[@aria-hidden='true']");
    private final By allSelectedMultiColorNames = By.xpath("//div[contains(@class,'value-container--has-value css-1hwfws3')]");

    public String getMultipleContainerText() {
        return find(multipleContainerText).getText();
    }

    public String getText() {
        return find(text).getText();
    }

    public String getAllSelectedMultiColorNames() {
        return find(allSelectedMultiColorNames).getText();
    }

    public String getAutoCompleteSingleText() {
        return find(autoCompleteSingleText).getText();
    }

    public String getAllSingleColorNames() {
        return find(allSelectedMultiColorNames).getText();
    }

    public void clickCloseButton() {
        find(closeButton).click();
    }

    public void clickSingleAutoComplete() {
        find(singleAutoComplete).click();
    }

    public void multiAutoComplete(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(multiAutoComplete))
                .sendKeys(color);
        wait.until(ExpectedConditions.visibilityOfElementLocated(multiAutoComplete))
                .sendKeys(Keys.chord("" + Keys.ENTER));
    }

    public void singleAutoComplete(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(singleAutoComplete))
                .sendKeys(color);
        wait.until(ExpectedConditions.visibilityOfElementLocated(singleAutoComplete))
                .sendKeys(Keys.chord("" + Keys.ENTER));
    }
}
