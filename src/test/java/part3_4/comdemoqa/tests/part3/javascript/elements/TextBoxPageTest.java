package part3_4.comdemoqa.tests.part3.javascript.elements;

import com.pages.demo.pages.elements.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

public class TextBoxPageTest extends BaseTest {
    @Test
    public void SubmitTextBox() {

        String fullName = "Zhivko Nedyalkov";
        String email = "fbinnzhivko@gmail.com";
        String currentAddress = "Sofia";
        String permanentAddress = "Earth";

        TextBoxPage textBoxPage = homePage.goToElements().clickTextBox();
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

    @Test
    public void clickSubmitButton() {
        TextBoxPage textBoxPage = homePage.goToElements().clickTextBox();
        textBoxPage.clickSubmitButton();

        String actualdOutput = textBoxPage.getOutput();
        String expectedOutput = "";
        Assert.assertEquals(actualdOutput, expectedOutput, "Not empty output");
    }

    @Test
    public void addFullName() {
        String fullName = "Zhivko Nedyalkov";
        String expectedOutput = "Name:" + fullName;

        TextBoxPage textBoxPage = homePage.goToElements().clickTextBox();
        textBoxPage.setFullName(fullName);
        textBoxPage.clickSubmitButton();

        String actualOutput = textBoxPage.getOutput();

        Assert.assertEquals(actualOutput, expectedOutput, "Missing Full Name");
    }

    @Test
    public void addEmail() {
        String email = "testemail@example.com";

        TextBoxPage textBoxPage = homePage.goToElements().clickTextBox();
        textBoxPage.setEmail(email);
        textBoxPage.clickSubmitButton();

        String actualEmail = textBoxPage.getExpectedEmail();
        Assert.assertEquals(actualEmail, "Email:" + email, "Email does not match");
    }

    @Test
    public void addPermanentAddress() {
        String permanentAddress = "1234 Elm Street, Springfield";

        TextBoxPage textBoxPage = homePage.goToElements().clickTextBox();
        textBoxPage.setPermanentAddress(permanentAddress);
        textBoxPage.clickSubmitButton();

        String actualPermanentAddress = textBoxPage.getExpectedPermanentAddress();
        Assert.assertEquals(actualPermanentAddress, "Permananet Address :" + permanentAddress, "Permanent address does not match");
    }

    @Test
    public void addCurrentAddress() {
        String currentAddress = "4321 Maple Lane, Metropolis";

        TextBoxPage textBoxPage = homePage.goToElements().clickTextBox();
        textBoxPage.setCurrentAddress(currentAddress);
        textBoxPage.clickSubmitButton();

        String actualCurrentAddress = textBoxPage.getExpectedCurrentAddress();
        Assert.assertEquals(actualCurrentAddress, "Current Address :" + currentAddress, "Current address does not match");
    }

    @Test
    public void updateAllFieldsAfterSubmit() {

        String fullName = "Zhivko Nedyalkov";
        String email = "fbinnzhivko@gmail.com";
        String currentAddress = "Sofia";
        String permanentAddress = "Earth";

        TextBoxPage textBoxPage = homePage.goToElements().clickTextBox();
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

    @Test
    public void checkAllPlaceholders() {
        TextBoxPage textBoxPage = homePage.goToElements().clickTextBox();
        String expectedPlaceholderFullName = "Full Name";
        String expectedPlaceholderFEmail = "name@example.com";
        String expectedPlaceholderCurrentAddress = "Current Address";
        String expectedPlaceholderPermanentAddress = "";

        String placeholderFullName = textBoxPage.getPlaceholderFullName();
        String placeholderEmail = textBoxPage.getPlaceholderEmail();
        String placeholderCurrentAddress = textBoxPage.getPlaceholderCurrentAddress();
        String placeholderPermanentAddress = textBoxPage.getPlaceholderPermanentAddress();

        Assert.assertEquals(placeholderFullName, expectedPlaceholderFullName, "Not same placeholder Full Name");
        Assert.assertEquals(placeholderEmail, expectedPlaceholderFEmail, "Not same placeholder Email");
        Assert.assertEquals(placeholderCurrentAddress, expectedPlaceholderCurrentAddress, "Not same placeholder Current Address");
        Assert.assertEquals(placeholderPermanentAddress, expectedPlaceholderPermanentAddress, "Not same placeholder Permanent Address");
    }

    @Test
    public void checkAllLabels() {
        TextBoxPage textBoxPage = homePage.goToElements().clickTextBox();
        String expectedFullNameLabel = "Full Name";
        String expectedFEmailLabel = "Email";
        String expectedCurrentAddressLabel = "Current Address";
        String expectedPermanentAddressLabel = "Permanent Address";

        String fullNameLabel = textBoxPage.getFullNameLabel();
        String emailLabel = textBoxPage.getEmailLabel();
        String currentAddressLabel = textBoxPage.getCurrentAddressLabel();
        String permanentAddressLabel = textBoxPage.getPermanentAddressLabel();

        Assert.assertEquals(fullNameLabel, expectedFullNameLabel, "Not same label Full Name");
        Assert.assertEquals(emailLabel, expectedFEmailLabel, "Not same label Email");
        Assert.assertEquals(currentAddressLabel, expectedCurrentAddressLabel, "Not same label Current Address");
        Assert.assertEquals(permanentAddressLabel, expectedPermanentAddressLabel, "Not same label Permanent Address");
    }
}
