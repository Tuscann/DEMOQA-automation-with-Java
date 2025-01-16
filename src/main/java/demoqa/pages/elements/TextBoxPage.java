package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.ActionUtility.MoveToElementSelenium;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class TextBoxPage extends BasePage {

    private final By header = By.xpath("//h1[@class='text-center'][contains(.,'Text Box')]");
    private final By fullNameLabel = By.id("userName-label");
    private final By fullNameField = By.id("userName");
    private final By emailLabel = By.id("userEmail-label");
    private final By emailField = By.id("userEmail");
    private final By currentAddressLabel = By.id("currentAddress-label");
    private final By currentAddressField = By.id("currentAddress");
    private final By permanentAddressLabel = By.id("permanentAddress-label");
    private final By permanentAddress = By.id("permanentAddress");
    private final By submitButton = By.id("submit");

    private final By expectedFullName = By.xpath("//p[@id=\"name\"]");
    private final By expectedEmail = By.xpath("//p[@id=\"email\"]");
    private final By expectedCurrentAddress = By.xpath("//p[@id=\"currentAddress\"]");
    private final By expectedPermanentAddress = By.xpath("//p[@id=\"permanentAddress\"]");
    private final By output = By.id("output");

    public TextBoxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getFullNameLabel() {
        return find(fullNameLabel).getText();
    }

    public String getEmailLabel() {
        return find(emailLabel).getText();
    }

    public String getCurrentAddressLabel() {
        return find(currentAddressLabel).getText();
    }

    public String getPermanentAddressLabel() {
        return find(permanentAddressLabel).getText();
    }

    public String getPlaceholderFullName() {
        return find(fullNameField).getDomAttribute("placeholder");
    }

    public String getPlaceholderEmail() {
        return find(emailField).getDomAttribute("placeholder");
    }

    public String getPlaceholderCurrentAddress() {
        return find(currentAddressField).getDomAttribute("placeholder");
    }

    public String getPlaceholderPermanentAddress() {
        return find(permanentAddress).getText();
    }

    public String getExpectedFullName() {
        return find(expectedFullName).getText();
    }

    public String getExpectedEmail() {
        return find(expectedEmail).getText();
    }

    public String getExpectedCurrentAddress() {
        return find(expectedCurrentAddress).getText();
    }

    public String getExpectedPermanentAddress() {
        return find(expectedPermanentAddress).getText();
    }

    public String getOutput() {
        return find(output).getText();
    }

    public String getHeaderText() {
        return find(header).getText();
    }

    public String getSubmitButtonText() {
        return find(submitButton).getText();
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
        click(submitButton);
    }

    public String isBorderRedAroundEmail(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.attributeToBe(emailField, "border", color));

        return find(emailField).getCssValue("border");
    }
}
