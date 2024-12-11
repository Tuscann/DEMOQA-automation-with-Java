package com.pages.demo.pages.elements;

import org.openqa.selenium.By;

import static utilities.ActionUtility.MoveToElementSelenium;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class TextBoxPage extends ElementsPage {

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
        return find(fullName).getAttribute("placeholder");
    }

    public String getPlaceholderEmail() {
        return find(email).getAttribute("placeholder");
    }

    public String getPlaceholderCurrentAddress() {
        return find(currentAddress).getAttribute("placeholder");
    }

    public String getPlaceholderPermanentAddress() {
        return find(permanentAddress).getAttribute("placeholder");
    }

    public void setFullName(String fullName2) {
        MoveToElementSelenium(fullName);

        click(fullName);
        set(fullName, fullName2);
    }

    public void setEmail(String email2) {
        scrollToElementJS(email);
        click(email);
        set(email, email2);
    }

    public void setCurrentAddress(String currentAddress2) {
        scrollToElementJS(currentAddress);
        click(currentAddress);
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

    public String isBorderRed() {
        delay(500);

        String str = find(email).getCssValue("border");
        return str.substring(str.length() - 20);
    }
}
