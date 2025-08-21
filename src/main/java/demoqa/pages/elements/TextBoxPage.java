package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.ActionUtility.MoveToElementSelenium;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class TextBoxPage extends BasePage {

    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Text Box')]")
    private WebElement header;

    @FindBy(id = "userName-label")
    private WebElement fullNameLabel;

    @FindBy(id = "userName")
    private WebElement fullNameField;

    @FindBy(id = "userEmail-label")
    private WebElement emailLabel;

    @FindBy(id = "userEmail")
    private WebElement emailField;

    @FindBy(id = "currentAddress-label")
    private WebElement currentAddressLabel;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressField;

    @FindBy(id = "permanentAddress-label")
    private WebElement permanentAddressLabel;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddress;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(xpath = "//p[@id='name']")
    private WebElement expectedFullName;

    @FindBy(xpath = "//p[@id='email']")
    private WebElement expectedEmail;

    @FindBy(xpath = "//p[@id=\"currentAddress\"]")
    private WebElement expectedCurrentAddress;

    @FindBy(xpath = "//p[@id=\"permanentAddress\"]")
    private WebElement expectedPermanentAddress;

    @FindBy(id = "output")
    private WebElement output;

    public TextBoxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getFullNameLabel() {
        return fullNameLabel.getText();
    }

    public String getEmailLabel() {
        return emailLabel.getText();
    }

    public String getCurrentAddressLabel() {
        return currentAddressLabel.getText();
    }

    public String getPermanentAddressLabel() {
        return permanentAddressLabel.getText();
    }

    public String getPlaceholderFullName() {
        return fullNameField.getDomAttribute("placeholder");
    }

    public String getPlaceholderEmail() {
        return emailField.getDomAttribute("placeholder");
    }

    public String getPlaceholderCurrentAddress() {
        return currentAddressField.getDomAttribute("placeholder");
    }

    public String getPlaceholderPermanentAddress() {
        return permanentAddress.getText();
    }

    public String getExpectedName() {
        return expectedFullName.getText();
    }

    public String getExpectedEmail() {
        return expectedEmail.getText();
    }

    public String getExpectedCurrentAddress() {
        return expectedCurrentAddress.getText();
    }

    public String getExpectedPermanentAddress() {
        return expectedPermanentAddress.getText();
    }

    public String getOutput() {
        return output.getText();
    }

    public String getHeaderText() {
        return header.getText();
    }

    public String getSubmitButtonText() {
        return submitButton.getText();
    }

    public void setFullNameField(String fullName2) {
        MoveToElementSelenium(fullNameField);
        set(fullNameField, fullName2);
    }

    public void setEmailField(String email2) {
        scrollToElementJS(emailField);
        set(emailField, email2);
    }

    public void setCurrentAddressField(String currentAddress2) {
        scrollToElementJS(currentAddressField);
        set(currentAddressField, currentAddress2);
    }

    public void setPermanentAddressField(String permanentAddress2) {
        scrollToElementJS(permanentAddress);
        set(permanentAddress, permanentAddress2);
    }

    public void clickSubmitButton() {
        scrollToElementJS(submitButton);
        submitButton.click();
    }

    public String isBorderRedAroundEmail(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.attributeToBe(emailField, "border", color));

        return emailField.getCssValue("border");
    }
}
