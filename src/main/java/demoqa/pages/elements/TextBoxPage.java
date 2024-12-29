package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.By;

import static utilities.ActionUtility.MoveToElementSelenium;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class TextBoxPage extends BasePage {

    private final By header = By.xpath("//h1[@class='text-center'][contains(.,'Text Box')]");
    private final By fullName = By.id("userName");
    private final By email = By.id("userEmail");
    private final By currentAddress = By.id("currentAddress");
    private final By permanentAddress = By.id("permanentAddress");
    private final By submitButton = By.id("submit");
    private final By textBoxText = By.xpath("//h1[contains(.,'Text Box')]");

    private final By expectedFullName = By.xpath("//p[@id=\"name\"]");
    private final By expectedEmail = By.xpath("//p[@id=\"email\"]");
    private final By expectedCurrentAddress = By.xpath("//p[@id=\"currentAddress\"]");
    private final By expectedPermanentAddress = By.xpath("//p[@id=\"permanentAddress\"]");
    private final By output = By.id("output");

    private final By labelFullName = By.id("userName-label");
    private final By labelEmail = By.id("userEmail-label");
    private final By labelCurrentAddress = By.id("currentAddress-label");
    private final By labelPermanentAddress = By.id("permanentAddress-label");

    public String getFullNameLabel() {
        return find(labelFullName).getText();
    }

    public String getEmailLabel() {
        return find(labelEmail).getText();
    }

    public String getCurrentAddressLabel() {
        return find(labelCurrentAddress).getText();
    }

    public String getPermanentAddressLabel() {
        return find(labelPermanentAddress).getText();
    }

    public String getPlaceholderFullName() {
        return find(fullName).getDomAttribute("placeholder");
    }

    public String getPlaceholderEmail() {
        return find(email).getDomAttribute("placeholder");
    }

    public String getPlaceholderCurrentAddress() {
        return find(currentAddress).getDomAttribute("placeholder");
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

    public String getTextBoxText() {
        return find(textBoxText).getText();
    }

    public void setFullName(String fullName2) {
        MoveToElementSelenium(fullName);
        set(fullName, fullName2);
    }

    public void setEmail(String email2) {
        scrollToElementJS(email);
        set(email, email2);
    }

    public void setCurrentAddress(String currentAddress2) {
        scrollToElementJS(currentAddress);
        set(currentAddress, currentAddress2);
    }

    public void setPermanentAddress(String permanentAddress2) {
        scrollToElementJS(permanentAddress);
        set(permanentAddress, permanentAddress2);
    }

    public void clickSubmitButton() {
        scrollToElementJS(submitButton);
        click(submitButton);
    }

    public String isBorderRedAroundEmail() {
        delay(500);

        String str = find(email).getCssValue("border");
        return str.substring(str.length() - 20);
    }

    public String getHeaderText() {
        return find(header).getText();
    }

    public String getSubmitButtonText() {
        return find(submitButton).getText();
    }
}
