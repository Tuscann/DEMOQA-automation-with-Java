package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage extends BasePage {

    @FindBy(xpath = "//h1[contains(.,'Radio Button')]")
    private WebElement radioButtonText;
    @FindBy(xpath = "//div[@class='mb-3'][contains(.,'Do you like the site?')]")
    private WebElement question;
    @FindBy(xpath = "//label[@for='yesRadio']")
    private WebElement yesAnswerLabel;
    @FindBy(xpath = "//label[@for='impressiveRadio']")
    private WebElement impressiveLabel;
    @FindBy(xpath = "//label[@for='noRadio']")
    private WebElement noAnswerLabel;
    @FindBy(xpath = "//p[contains(@class, 'mt-3')]")
    private WebElement resultMessage;
    @FindBy(xpath = "//span[@class='text-success']")
    private WebElement textSuccessMessage;

    public RadioButtonPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getHeaderText() {
        return radioButtonText.getText();
    }

    public String getQuestionText() {
        return question.getText();
    }

    public String getYesAnswerLabel() {
        return yesAnswerLabel.getText();
    }

    public String getImpressiveAnswerLabel() {
        return impressiveLabel.getText();
    }

    public String getNoAnswerLabel() {
        return noAnswerLabel.getText();
    }

    public String getResultMessage() {
        return resultMessage.getText();
    }

    public String isColorGreen() {
        return textSuccessMessage.getCssValue("color");
    }

    public boolean isResultMessageDisplayed() {
        final By message = By.xpath("//p[contains(@class, 'mt-3')]");

        return !driver.findElements(message).isEmpty();
    }

    public void clickAnswer(String answer) {
        switch (answer) {
            case "Yes" -> yesAnswerLabel.click();
            case "Impressive" -> impressiveLabel.click();
            case "No" -> noAnswerLabel.click();
        }
    }

    public boolean isAnswerDisable(String answer) {
        boolean isDisabled = false;
        switch (answer) {
            case "Yes" -> isDisabled = yesAnswerLabel.isEnabled();
            case "Impressive" -> isDisabled = impressiveLabel.isEnabled();
            case "No" -> isDisabled = noAnswerLabel.isEnabled();
        }
        return isDisabled;
    }
}
