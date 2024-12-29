package com.pages.demo.pages.elements;

import com.pages.base.BasePage;
import org.openqa.selenium.By;

public class RadioButtonPage extends BasePage {

    private final By radioButtonText = By.xpath("//h1[contains(.,'Radio Button')]");
    private final By question = By.xpath("//div[@class='mb-3'][contains(.,'Do you like the site?')]");
    private final By yesAnswerLabel = By.xpath("//label[@for='yesRadio']");
    private final By impressiveLabel = By.xpath("//label[@for='impressiveRadio']");
    private final By noAnswerLabel = By.xpath("//label[@for='noRadio']");
    private final By resultMessage = By.xpath("//p[contains(@class, 'mt-3')]");
    private final By textSuccessMessage = By.xpath("//span[@class='text-success']");

    public String getRadioButtonText() {
        return find(radioButtonText).getText();
    }

    public String getQuestionText() {
        return find(question).getText();
    }

    public String getYesAnswerLabel() {
        return find(yesAnswerLabel).getText();
    }

    public String getImpressiveAnswerLabel() {
        return find(impressiveLabel).getText();
    }

    public String getNoAnswerLabel() {
        return find(noAnswerLabel).getText();
    }

    public String getResultMessage() {
        return find(resultMessage).getText();
    }

    public String isColorGreen() {
        return find(textSuccessMessage).getCssValue("color");
    }

    public boolean isResultMessageDisplayed() {
        return driver.findElements(By.id("result")).isEmpty();
    }

    public void clickAnswer(String answer) {
        switch (answer) {
            case "Yes" -> find(yesAnswerLabel).click();
            case "No" -> find(noAnswerLabel).click();
            case "Impressive" -> find(impressiveLabel).click();
        }
    }

    public boolean isAnswerDisable(String answer) {
        switch (answer) {
            case "Yes" -> {
                return find(yesAnswerLabel).isEnabled();
            }
            case "No" -> {
                return find(noAnswerLabel).isEnabled();
            }
            case "Impressive" -> {
                return find(impressiveLabel).isEnabled();
            }
        }
        return true;
    }
}
