package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage extends BasePage {

    private final By radioButtonText = By.xpath("//h1[contains(.,'Radio Button')]");
    private final By question = By.xpath("//div[@class='mb-3'][contains(.,'Do you like the site?')]");
    private final By yesAnswerLabel = By.xpath("//label[@for='yesRadio']");
    private final By impressiveLabel = By.xpath("//label[@for='impressiveRadio']");
    private final By noAnswerLabel = By.xpath("//label[@for='noRadio']");
    private final By resultMessage = By.xpath("//p[contains(@class, 'mt-3')]");
    private final By textSuccessMessage = By.xpath("//span[@class='text-success']");

    public RadioButtonPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getHeaderText() {
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
        return driver.findElements(resultMessage).isEmpty();
    }

    public void clickAnswer(String answer) {
        switch (answer) {
            case "Yes" -> find(yesAnswerLabel).click();
            case "Impressive" -> find(impressiveLabel).click();
            case "No" -> find(noAnswerLabel).click();
        }
    }

    public boolean isAnswerDisable(String answer) {
        boolean isDisabled = false;
        switch (answer) {
            case "Yes" -> isDisabled = find(yesAnswerLabel).isEnabled();
            case "Impressive" -> isDisabled = find(impressiveLabel).isEnabled();
            case "No" -> isDisabled = find(noAnswerLabel).isEnabled();
        }
        return isDisabled;
    }
}
