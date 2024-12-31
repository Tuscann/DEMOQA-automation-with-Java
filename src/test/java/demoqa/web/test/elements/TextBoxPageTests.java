package demoqa.web.test.elements;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBoxPageTests extends BaseTest {
    @Test
    public void VerifyAllPlaceholdersAndAllLabels() {
        navigateToUrl("text-box");

        String header = "Text Box";
        String expectedPlaceholderFullName = "Full Name";
        String expectedPlaceholderEmail = "name@example.com";
        String expectedPlaceholderCurrentAddress = "Current Address";
        String expectedPlaceholderPermanentAddress = "";
        String expectedTextBoxText = "Text Box";
        String expectedFullNameLabel = "Full Name";
        String expectedFEmailLabel = "Email";
        String expectedCurrentAddressLabel = "Current Address";
        String expectedPermanentAddressLabel = "Permanent Address";
        String submitButtonText = "Submit";

        String actualHeader = textBoxPage.getHeaderText();
        String placeholderFullName = textBoxPage.getPlaceholderFullName();
        String placeholderEmail = textBoxPage.getPlaceholderEmail();
        String placeholderCurrentAddress = textBoxPage.getPlaceholderCurrentAddress();
        String actualPlaceholderPermanentAddress = textBoxPage.getPlaceholderPermanentAddress();
        String textBoxText = textBoxPage.getTextBoxText();
        String fullNameLabel = textBoxPage.getFullNameLabel();
        String emailLabel = textBoxPage.getEmailLabel();
        String currentAddressLabel = textBoxPage.getCurrentAddressLabel();
        String permanentAddressLabel = textBoxPage.getPermanentAddressLabel();
        String actualSubmitButtonText = textBoxPage.getSubmitButtonText();

        Assert.assertEquals(actualHeader, header, "Wrong header");
        Assert.assertEquals(placeholderFullName, expectedPlaceholderFullName, "Not same placeholder Full Name");
        Assert.assertEquals(placeholderEmail, expectedPlaceholderEmail, "Not same placeholder Email");
        Assert.assertEquals(placeholderCurrentAddress, expectedPlaceholderCurrentAddress, "Not same placeholder Current Address");
        Assert.assertEquals(actualPlaceholderPermanentAddress, expectedPlaceholderPermanentAddress, "Not same placeholder Permanent Address");
        Assert.assertEquals(textBoxText, expectedTextBoxText, "Wrong text box text");
        Assert.assertEquals(fullNameLabel, expectedFullNameLabel, "Not same label Full Name");
        Assert.assertEquals(emailLabel, expectedFEmailLabel, "Not same label Email");
        Assert.assertEquals(currentAddressLabel, expectedCurrentAddressLabel, "Not same label Current Address");
        Assert.assertEquals(permanentAddressLabel, expectedPermanentAddressLabel, "Not same label Permanent Address");
        Assert.assertEquals(actualSubmitButtonText, submitButtonText, "Wrong submit button text");
    }

    @Test
    public void SubmitFulledForm() {
        String fullName = "Zhivko Nedyalkov";
        String email = "fbinnzhivko@gmail.com";
        String currentAddress = "Sofia";
        String permanentAddress = "Earth";

        navigateToUrl("text-box");
        textBoxPage.setFullName(fullName);
        textBoxPage.setEmail(email);
        textBoxPage.setCurrentAddress(currentAddress);
        textBoxPage.setPermanentAddress(permanentAddress);
        textBoxPage.clickSubmitButton();

        String actualFullName = textBoxPage.getExpectedFullName();
        String actualEmail = textBoxPage.getExpectedEmail();
        String actualCurrentAddress = textBoxPage.getExpectedCurrentAddress();
        String actualPermanentAddress = textBoxPage.getExpectedPermanentAddress();

        Assert.assertEquals(actualFullName, "Name:" + fullName, "Not same Full Name");
        Assert.assertEquals(actualEmail, "Email:" + email, "Not same Email");
        Assert.assertEquals(actualCurrentAddress, "Current Address :" + currentAddress, "Not same current Address");
        Assert.assertEquals(actualPermanentAddress, "Permananet Address :" + permanentAddress, "Not same permanent Address");
    }

    @Test(enabled = true)
    public void SubmitButtonOnEmptyForm() {
        navigateToUrl("text-box");
        textBoxPage.clickSubmitButton();

        String actualOutput = textBoxPage.getOutput();
        String expectedOutput = "";
        Assert.assertEquals(actualOutput, expectedOutput, "Not empty output");
    }

    @Test
    public void SubmitOnlyFullName() {
        navigateToUrl("text-box");

        String fullName = "Zhivko Nedyalkov";
        String expectedOutput = "Name:" + fullName;
        textBoxPage.setFullName(fullName);
        textBoxPage.clickSubmitButton();

        String actualOutput = textBoxPage.getOutput();

        Assert.assertEquals(actualOutput, expectedOutput, "Missing Full Name");
    }

    @Test
    public void SubmitOnlyValidEmail() {
        navigateToUrl("text-box");
        String email = "testemail@example.com";

        textBoxPage.setEmail(email);
        textBoxPage.clickSubmitButton();

        String actualEmail = textBoxPage.getExpectedEmail();
        Assert.assertEquals(actualEmail, "Email:" + email, "Email does not match");
    }

    @Test
    public void TryToSubmitUnValidEmailAndCheckRedLine() {
        navigateToUrl("text-box");
        String email = "a";
        textBoxPage.setEmail(email);
        textBoxPage.clickSubmitButton();

        String redColor = "solid rgb(255, 0, 0)";
        String actualColor = textBoxPage.isBorderRedAroundEmail();

        Assert.assertEquals(actualColor, redColor, "Not same red color");
    }

    @Test
    public void SubmitOnlyValidPermanentAddress() {
        navigateToUrl("text-box");
        String permanentAddress = "1234 Elm Street, Springfield";

        textBoxPage.setPermanentAddress(permanentAddress);
        textBoxPage.clickSubmitButton();

        String actualPermanentAddress = textBoxPage.getExpectedPermanentAddress();
        Assert.assertEquals(actualPermanentAddress, "Permananet Address :" + permanentAddress, "Permanent address does not match");
    }

    @Test
    public void SubmitOnlyValidCurrentAddress() {
        navigateToUrl("text-box");
        String currentAddress = "4321 Maple Lane, Metropolis";

        textBoxPage.setCurrentAddress(currentAddress);
        textBoxPage.clickSubmitButton();

        String actualCurrentAddress = textBoxPage.getExpectedCurrentAddress();
        Assert.assertEquals(actualCurrentAddress, "Current Address :" + currentAddress, "Current address does not match");
    }

    @Test
    public void UpdateAllFieldsAfterSubmit() {
        navigateToUrl("text-box");

        String fullName = "Zhivko Nedyalkov";
        String email = "fbinnzhivko@gmail.com";
        String currentAddress = "Sofia";
        String permanentAddress = "Earth";

        textBoxPage.setFullName(fullName);
        textBoxPage.setEmail(email);
        textBoxPage.setCurrentAddress(currentAddress);
        textBoxPage.setPermanentAddress(permanentAddress);
        textBoxPage.clickSubmitButton();

        String actualFullName = textBoxPage.getExpectedFullName();
        String actualEmail = textBoxPage.getExpectedEmail();
        String actualCurrentAddress = textBoxPage.getExpectedCurrentAddress();
        String actualPermanentAddress = textBoxPage.getExpectedPermanentAddress();

        Assert.assertEquals(actualFullName, "Name:" + fullName, "Not same Full Name");
        Assert.assertEquals(actualEmail, "Email:" + email, "Not same Email");
        Assert.assertEquals(actualCurrentAddress, "Current Address :" + currentAddress, "Not same current Address");
        Assert.assertEquals(actualPermanentAddress, "Permananet Address :" + permanentAddress, "Not same permanent Address");

        fullName = "Petar Kamenov";
        email = "da@gmail.com";
        currentAddress = "Varna";
        permanentAddress = "Mars";

        textBoxPage.setFullName(fullName);
        textBoxPage.setEmail(email);
        textBoxPage.setCurrentAddress(currentAddress);
        textBoxPage.setPermanentAddress(permanentAddress);
        textBoxPage.clickSubmitButton();

        actualFullName = textBoxPage.getExpectedFullName();
        actualEmail = textBoxPage.getExpectedEmail();
        actualCurrentAddress = textBoxPage.getExpectedCurrentAddress();
        actualPermanentAddress = textBoxPage.getExpectedPermanentAddress();

        Assert.assertEquals(actualFullName, "Name:" + fullName, "Not same Full Name");
        Assert.assertEquals(actualEmail, "Email:" + email, "Not same Email");
        Assert.assertEquals(actualCurrentAddress, "Current Address :" + currentAddress, "Not same current Address");
        Assert.assertEquals(actualPermanentAddress, "Permananet Address :" + permanentAddress, "Not same permanent Address");
    }
}
