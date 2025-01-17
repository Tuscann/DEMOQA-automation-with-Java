package demoqa.web.test.elements;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBoxPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all placeholders and all labels")
    public void VerifyAllPlaceholdersAndAllLabels() {
        navigateToUrl("text-box");

        String header = "Text Box";
        String expectedFullNameLabel = "Full Name";
        String expectedFullNamePlaceholder = "Full Name";
        String expectedFEmailLabel = "Email";
        String expectedEmailPlaceholder = "name@example.com";
        String expectedCurrentAddressLabel = "Current Address";
        String expectedCurrentAddressPlaceholder = "Current Address";
        String expectedPermanentAddressLabel = "Permanent Address";
        String expectedPermanentAddressPlaceholder = "";
        String submitButtonText = "Submit";

        String actualHeader = textBoxPage.getHeaderText();
        String placeholderFullName = textBoxPage.getPlaceholderFullName();
        String placeholderEmail = textBoxPage.getPlaceholderEmail();
        String placeholderCurrentAddress = textBoxPage.getPlaceholderCurrentAddress();
        String actualPlaceholderPermanentAddress = textBoxPage.getPlaceholderPermanentAddress();
        String fullNameLabel = textBoxPage.getFullNameLabel();
        String emailLabel = textBoxPage.getEmailLabel();
        String currentAddressLabel = textBoxPage.getCurrentAddressLabel();
        String permanentAddressLabel = textBoxPage.getPermanentAddressLabel();
        String actualSubmitButtonText = textBoxPage.getSubmitButtonText();

        softAssert.assertEquals(actualHeader, header, "\nWrong header.\n");
        softAssert.assertEquals(fullNameLabel, expectedFullNameLabel, "\nNot same label Full Name.\n");
        softAssert.assertEquals(placeholderFullName, expectedFullNamePlaceholder, "\nNot same placeholder Full Name.\n");
        softAssert.assertEquals(emailLabel, expectedFEmailLabel, "\nNot same label Email.\n");
        softAssert.assertEquals(placeholderEmail, expectedEmailPlaceholder, "\nNot same placeholder Email.\n");
        softAssert.assertEquals(currentAddressLabel, expectedCurrentAddressLabel, "\nNot same label Current Address.\n");
        softAssert.assertEquals(placeholderCurrentAddress, expectedCurrentAddressPlaceholder, "\nNot same placeholder Current Address.\n");
        softAssert.assertEquals(permanentAddressLabel, expectedPermanentAddressLabel, "\nNot same label Permanent Address.\n");
        softAssert.assertEquals(actualPlaceholderPermanentAddress, expectedPermanentAddressPlaceholder, "Not same placeholder Permanent Address.\n");
        softAssert.assertEquals(actualSubmitButtonText, submitButtonText, "\nWrong submit button text.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Submit fill form")
    public void SubmitFillForm() {
        navigateToUrl("text-box");

        String expectedFullName = "Zhivko Nedyalkov";
        String expectedEmail = "fbinnzhivko@gmail.com";
        String expectedCurrentAddress = "Sofia";
        String expectedPermanentAddress = "Earth";

        textBoxPage.setFullNameField(expectedFullName);
        textBoxPage.setEmailField(expectedEmail);
        textBoxPage.setCurrentAddressField(expectedCurrentAddress);
        textBoxPage.setPermanentAddressField(expectedPermanentAddress);
        textBoxPage.clickSubmitButton();

        String actualFullName = textBoxPage.getExpectedFullName();
        String actualEmail = textBoxPage.getExpectedEmail();
        String actualCurrentAddress = textBoxPage.getExpectedCurrentAddress();
        String actualPermanentAddress = textBoxPage.getExpectedPermanentAddress();

        softAssert.assertEquals(actualFullName, "Name:" + expectedFullName, "\nNot same Full Name.\n");
        softAssert.assertEquals(actualEmail, "Email:" + expectedEmail, "\nNot same Email.\n");
        softAssert.assertEquals(actualCurrentAddress, "Current Address :" + expectedCurrentAddress, "\nNot same current Address.\n");
        softAssert.assertEquals(actualPermanentAddress, "Permananet Address :" + expectedPermanentAddress, "\nNot same permanent Address.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Submit empty form")
    public void SubmitEmptyForm() {
        navigateToUrl("text-box");
        textBoxPage.clickSubmitButton();

        String actualOutput = textBoxPage.getOutput();
        String expectedOutput = "";
        Assert.assertEquals(actualOutput, expectedOutput, "\nNot empty output.\n");
    }

    @Test(enabled = true, testName = "Submit only full name")
    public void SubmitOnlyFullName() {
        navigateToUrl("text-box");

        String fullName = "Zhivko Nedyalkov";

        textBoxPage.setFullNameField(fullName);
        textBoxPage.clickSubmitButton();

        String actualOutput = textBoxPage.getOutput();
        String expectedOutput = "Name:" + fullName;
        Assert.assertEquals(actualOutput, expectedOutput, "\nMissing Full Name.\n");
    }

    @Test(enabled = true, testName = "Submit only valid email")
    public void SubmitOnlyValidEmail() {
        navigateToUrl("text-box");
        String email = "testemail@example.com";

        textBoxPage.setEmailField(email);
        textBoxPage.clickSubmitButton();

        String actualEmail = textBoxPage.getExpectedEmail();
        Assert.assertEquals(actualEmail, "Email:" + email, "\nEmail does not match\n");
    }

    @Test(enabled = true, testName = "Try to submit non valid email and check red line")
    public void TryToSubmitUnValidEmailAndCheckRedLine() {
        navigateToUrl("text-box");
        String email = "InvalidEmailFormat";
        textBoxPage.setEmailField(email);
        textBoxPage.clickSubmitButton();

        String expectedRedColor = "1px solid rgb(255, 0, 0)";
        String actualRedColor = textBoxPage.isBorderRedAroundEmail(expectedRedColor);

        Assert.assertEquals(actualRedColor, expectedRedColor, "\nNot same red color\n");
    }

    @Test(enabled = true, testName = "Submit only valid current address")
    public void SubmitOnlyValidCurrentAddress() {
        navigateToUrl("text-box");
        String currentAddress = "4321 Maple Lane, Metropolis";

        textBoxPage.setCurrentAddressField(currentAddress);
        textBoxPage.clickSubmitButton();

        String actualCurrentAddress = textBoxPage.getExpectedCurrentAddress();
        Assert.assertEquals(actualCurrentAddress, "Current Address :" + currentAddress, "\nCurrent address does not match.\n");
    }

    @Test(enabled = true, testName = "Submit only valid permanent address")
    public void SubmitOnlyValidPermanentAddress() {
        navigateToUrl("text-box");
        String permanentAddress = "1234 Elm Street, Springfield";

        textBoxPage.setPermanentAddressField(permanentAddress);
        textBoxPage.clickSubmitButton();

        String actualPermanentAddress = textBoxPage.getExpectedPermanentAddress();
        Assert.assertEquals(actualPermanentAddress, "Permananet Address :" + permanentAddress, "\nPermanent address does not match.\n");
    }

    @Test(enabled = true, testName = "Update all fields after submit")
    public void UpdateAllFieldsAfterSubmit() {
        navigateToUrl("text-box");

        String fullName = "Zhivko Nedyalkov";
        String email = "fbinnzhivko@gmail.com";
        String currentAddress = "Sofia";
        String permanentAddress = "Earth";

        textBoxPage.setFullNameField(fullName);
        textBoxPage.setEmailField(email);
        textBoxPage.setCurrentAddressField(currentAddress);
        textBoxPage.setPermanentAddressField(permanentAddress);
        textBoxPage.clickSubmitButton();

        String actualFullName = textBoxPage.getExpectedFullName();
        String actualEmail = textBoxPage.getExpectedEmail();
        String actualCurrentAddress = textBoxPage.getExpectedCurrentAddress();
        String actualPermanentAddress = textBoxPage.getExpectedPermanentAddress();

        softAssert.assertEquals(actualFullName, "Name:" + fullName, "\nNot same Full Name.\n");
        softAssert.assertEquals(actualEmail, "Email:" + email, "\nNot same Email.\n");
        softAssert.assertEquals(actualCurrentAddress, "Current Address :" + currentAddress, "\nNot same current Address.\n");
        softAssert.assertEquals(actualPermanentAddress, "Permananet Address :" + permanentAddress, "\nNot same permanent Address.\n");

        fullName = "Petar Kamenov";
        email = "da@gmail.com";
        currentAddress = "Varna";
        permanentAddress = "Mars";

        textBoxPage.setFullNameField(fullName);
        textBoxPage.setEmailField(email);
        textBoxPage.setCurrentAddressField(currentAddress);
        textBoxPage.setPermanentAddressField(permanentAddress);
        textBoxPage.clickSubmitButton();

        actualFullName = textBoxPage.getExpectedFullName();
        actualEmail = textBoxPage.getExpectedEmail();
        actualCurrentAddress = textBoxPage.getExpectedCurrentAddress();
        actualPermanentAddress = textBoxPage.getExpectedPermanentAddress();

        softAssert.assertEquals(actualFullName, "Name:" + fullName, "\nNot same Full Name.\n");
        softAssert.assertEquals(actualEmail, "Email:" + email, "\nNot same Email.\n");
        softAssert.assertEquals(actualCurrentAddress, "Current Address :" + currentAddress, "\nNot same current Address.\n");
        softAssert.assertEquals(actualPermanentAddress, "Permananet Address :" + permanentAddress, "\nNot same permanent Address.\n");

        softAssert.assertAll();
    }
}
