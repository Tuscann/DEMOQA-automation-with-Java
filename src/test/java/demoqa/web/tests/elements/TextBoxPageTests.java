package demoqa.web.tests.elements;

import demoqa.pages.elements.TextBoxPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxPageTests extends BaseTest {
    // Text Constants
    private static final String EXPECTED_HEADER_TEXT = "Text Box";
    private static final String EXPECTED_FULL_NAME_LABEL = "Full Name";
    private static final String EXPECTED_FULL_NAME_PLACEHOLDER = "Full Name";
    private static final String EXPECTED_EMAIL_LABEL = "Email";
    private static final String EXPECTED_EMAIL_PLACEHOLDER = "name@example.com";
    private static final String EXPECTED_CURRENT_ADDRESS_LABEL = "Current Address";
    private static final String EXPECTED_CURRENT_ADDRESS_PLACEHOLDER = "Current Address";
    private static final String EXPECTED_PERMANENT_ADDRESS_LABEL = "Permanent Address";
    private static final String EXPECTED_PERMANENT_ADDRESS_PLACEHOLDER = "";
    private static final String EXPECTED_SUBMIT_BUTTON_TEXT = "Submit";

    // Test Data Constants
    private static final String TEST_FULL_NAME = "Zhivko Nedyalkov";
    private static final String TEST_EMAIL = "fbinnzhivko@gmail.com";
    private static final String TEST_CURRENT_ADDRESS = "Sofia";
    private static final String TEST_PERMANENT_ADDRESS = "Earth";
    private static final String TEST_EMAIL_INVALID = "InvalidEmailFormat";
    private static final String TEST_EMAIL_VALID = "testemail@example.com";
    private static final String TEST_CURRENT_ADDRESS_ALT = "4321 Maple Lane, Metropolis";
    private static final String TEST_PERMANENT_ADDRESS_ALT = "1234 Elm Street, Springfield";

    private static final String TEST_FULL_NAME_ALT = "Petar Kamenov";
    private static final String TEST_EMAIL_ALT = "da@gmail.com";
    private static final String TEST_CURRENT_ADDRESS_ALT2 = "Varna";
    private static final String TEST_PERMANENT_ADDRESS_ALT2 = "Mars";

    // Output Format Constants
    private static final String NAME_PREFIX = "Name:";
    private static final String EMAIL_PREFIX = "Email:";
    private static final String CURRENT_ADDRESS_PREFIX = "Current Address :";
    private static final String PERMANENT_ADDRESS_PREFIX = "Permananet Address :";

    // Color Constants
    private static final String EXPECTED_RED_BORDER_COLOR = "1px solid rgb(255, 0, 0)";

    // Error Message Constants
    private static final String HEADER_TEXT_MISMATCH = "Header text mismatch";
    private static final String FULL_NAME_LABEL_MISMATCH = "Full name label mismatch";
    private static final String FULL_NAME_PLACEHOLDER_MISMATCH = "Full name placeholder mismatch";
    private static final String EMAIL_LABEL_MISMATCH = "Email label mismatch";
    private static final String EMAIL_PLACEHOLDER_MISMATCH = "Email placeholder mismatch";
    private static final String CURRENT_ADDRESS_LABEL_MISMATCH = "Current address label mismatch";
    private static final String CURRENT_ADDRESS_PLACEHOLDER_MISMATCH = "Current address placeholder mismatch";
    private static final String PERMANENT_ADDRESS_LABEL_MISMATCH = "Permanent address label mismatch";
    private static final String PERMANENT_ADDRESS_PLACEHOLDER_MISMATCH = "Permanent address placeholder mismatch";
    private static final String SUBMIT_BUTTON_TEXT_MISMATCH = "Submit button text mismatch";
    private static final String FULL_NAME_MISMATCH = "Full name mismatch";
    private static final String EMAIL_MISMATCH = "Email mismatch";
    private static final String CURRENT_ADDRESS_MISMATCH = "Current address mismatch";
    private static final String PERMANENT_ADDRESS_MISMATCH = "Permanent address mismatch";
    private static final String OUTPUT_NOT_EMPTY_ERROR = "Output is not empty";
    private static final String FULL_NAME_MISSING_ERROR = "Full name is missing";
    private static final String EMAIL_DOES_NOT_MATCH_ERROR = "Email does not match";
    private static final String RED_BORDER_COLOR_MISMATCH = "Red border color mismatch";
    private static final String CURRENT_ADDRESS_DOES_NOT_MATCH_ERROR = "Current address does not match";
    private static final String PERMANENT_ADDRESS_DOES_NOT_MATCH_ERROR = "Permanent address does not match";

    private TextBoxPage textBoxPage;
    private static final String TEXT_BOX_URL = "text-box";

    @BeforeMethod
    public void goToTextBoxPage() {
        navigateToUrl(TEXT_BOX_URL);
        textBoxPage = new TextBoxPage(driver);
    }

    @Test(enabled = true, description = "Verify all placeholders and labels on the text box page")
    public void verifyAllPlaceholdersAndAllLabels() {
        // Arrange & Act
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

        // Assert
        softAssert.assertEquals(actualHeader, EXPECTED_HEADER_TEXT, HEADER_TEXT_MISMATCH);
        softAssert.assertEquals(fullNameLabel, EXPECTED_FULL_NAME_LABEL, FULL_NAME_LABEL_MISMATCH);
        softAssert.assertEquals(placeholderFullName, EXPECTED_FULL_NAME_PLACEHOLDER, FULL_NAME_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(emailLabel, EXPECTED_EMAIL_LABEL, EMAIL_LABEL_MISMATCH);
        softAssert.assertEquals(placeholderEmail, EXPECTED_EMAIL_PLACEHOLDER, EMAIL_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(currentAddressLabel, EXPECTED_CURRENT_ADDRESS_LABEL, CURRENT_ADDRESS_LABEL_MISMATCH);
        softAssert.assertEquals(placeholderCurrentAddress, EXPECTED_CURRENT_ADDRESS_PLACEHOLDER, CURRENT_ADDRESS_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(permanentAddressLabel, EXPECTED_PERMANENT_ADDRESS_LABEL, PERMANENT_ADDRESS_LABEL_MISMATCH);
        softAssert.assertEquals(actualPlaceholderPermanentAddress, EXPECTED_PERMANENT_ADDRESS_PLACEHOLDER, PERMANENT_ADDRESS_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(actualSubmitButtonText, EXPECTED_SUBMIT_BUTTON_TEXT, SUBMIT_BUTTON_TEXT_MISMATCH);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Submit filled form and verify all field values")
    public void submitFillForm() {
        // Arrange & Act
        textBoxPage.setFullNameField(TEST_FULL_NAME);
        textBoxPage.setEmailField(TEST_EMAIL);
        textBoxPage.setCurrentAddressField(TEST_CURRENT_ADDRESS);
        textBoxPage.setPermanentAddressField(TEST_PERMANENT_ADDRESS);
        textBoxPage.clickSubmitButton();

        String actualFullName = textBoxPage.getExpectedName();
        String actualEmail = textBoxPage.getExpectedEmail();
        String actualCurrentAddress = textBoxPage.getExpectedCurrentAddress();
        String actualPermanentAddress = textBoxPage.getExpectedPermanentAddress();

        // Assert
        softAssert.assertEquals(actualFullName, NAME_PREFIX + TEST_FULL_NAME, FULL_NAME_MISMATCH);
        softAssert.assertEquals(actualEmail, EMAIL_PREFIX + TEST_EMAIL, EMAIL_MISMATCH);
        softAssert.assertEquals(actualCurrentAddress, CURRENT_ADDRESS_PREFIX + TEST_CURRENT_ADDRESS, CURRENT_ADDRESS_MISMATCH);
        softAssert.assertEquals(actualPermanentAddress, PERMANENT_ADDRESS_PREFIX + TEST_PERMANENT_ADDRESS, PERMANENT_ADDRESS_MISMATCH);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Submit empty form and verify no output")
    public void submitEmptyForm() {
        // Arrange & Act
        textBoxPage.clickSubmitButton();

        String actualOutput = textBoxPage.getOutput();
        String expectedOutput = "";

        // Assert
        softAssert.assertEquals(actualOutput, expectedOutput, OUTPUT_NOT_EMPTY_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Submit only full name and verify output")
    public void submitOnlyFullName() {
        // Arrange & Act
        textBoxPage.setFullNameField(TEST_FULL_NAME);
        textBoxPage.clickSubmitButton();

        String actualOutput = textBoxPage.getOutput();
        String expectedOutput = NAME_PREFIX + TEST_FULL_NAME;

        // Assert
        softAssert.assertEquals(actualOutput, expectedOutput, FULL_NAME_MISSING_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Submit only valid email and verify output")
    public void submitOnlyValidEmail() {
        // Arrange & Act
        textBoxPage.setEmailField(TEST_EMAIL_VALID);
        textBoxPage.clickSubmitButton();

        String actualEmail = textBoxPage.getExpectedEmail();

        // Assert
        softAssert.assertEquals(actualEmail, EMAIL_PREFIX + TEST_EMAIL_VALID, EMAIL_DOES_NOT_MATCH_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Submit invalid email and verify red border validation")
    public void tryToSubmitInvalidEmailAndCheckRedLine() {
        // Arrange & Act
        textBoxPage.setEmailField(TEST_EMAIL_INVALID);
        textBoxPage.clickSubmitButton();

        String actualRedColor = textBoxPage.isBorderRedAroundEmail(EXPECTED_RED_BORDER_COLOR);

        // Assert
        softAssert.assertEquals(actualRedColor, EXPECTED_RED_BORDER_COLOR, RED_BORDER_COLOR_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Submit only valid current address and verify output")
    public void submitOnlyValidCurrentAddress() {
        // Arrange & Act
        textBoxPage.setCurrentAddressField(TEST_CURRENT_ADDRESS_ALT);
        textBoxPage.clickSubmitButton();

        String actualCurrentAddress = textBoxPage.getExpectedCurrentAddress();

        // Assert
        softAssert.assertEquals(actualCurrentAddress, CURRENT_ADDRESS_PREFIX + TEST_CURRENT_ADDRESS_ALT, CURRENT_ADDRESS_DOES_NOT_MATCH_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Submit only valid permanent address and verify output")
    public void submitOnlyValidPermanentAddress() {
        // Arrange & Act
        textBoxPage.setPermanentAddressField(TEST_PERMANENT_ADDRESS_ALT);
        textBoxPage.clickSubmitButton();

        String actualPermanentAddress = textBoxPage.getExpectedPermanentAddress();

        // Assert
        softAssert.assertEquals(actualPermanentAddress, PERMANENT_ADDRESS_PREFIX + TEST_PERMANENT_ADDRESS_ALT, PERMANENT_ADDRESS_DOES_NOT_MATCH_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Update all fields after submit and verify changes")
    public void updateAllFieldsAfterSubmit() {
        // Arrange & Act - First submission
        textBoxPage.setFullNameField(TEST_FULL_NAME);
        textBoxPage.setEmailField(TEST_EMAIL);
        textBoxPage.setCurrentAddressField(TEST_CURRENT_ADDRESS);
        textBoxPage.setPermanentAddressField(TEST_PERMANENT_ADDRESS);
        textBoxPage.clickSubmitButton();

        String actualName = textBoxPage.getExpectedName();
        String actualEmail = textBoxPage.getExpectedEmail();
        String actualCurrentAddress = textBoxPage.getExpectedCurrentAddress();
        String actualPermanentAddress = textBoxPage.getExpectedPermanentAddress();

        // Assert - First submission
        softAssert.assertEquals(actualName, NAME_PREFIX + TEST_FULL_NAME, FULL_NAME_MISMATCH);
        softAssert.assertEquals(actualEmail, EMAIL_PREFIX + TEST_EMAIL, EMAIL_MISMATCH);
        softAssert.assertEquals(actualCurrentAddress, CURRENT_ADDRESS_PREFIX + TEST_CURRENT_ADDRESS, CURRENT_ADDRESS_MISMATCH);
        softAssert.assertEquals(actualPermanentAddress, PERMANENT_ADDRESS_PREFIX + TEST_PERMANENT_ADDRESS, PERMANENT_ADDRESS_MISMATCH);

        // Arrange & Act - Second submission with updated values
        textBoxPage.setFullNameField(TEST_FULL_NAME_ALT);
        textBoxPage.setEmailField(TEST_EMAIL_ALT);
        textBoxPage.setCurrentAddressField(TEST_CURRENT_ADDRESS_ALT2);
        textBoxPage.setPermanentAddressField(TEST_PERMANENT_ADDRESS_ALT2);
        textBoxPage.clickSubmitButton();

        actualName = textBoxPage.getExpectedName();
        actualEmail = textBoxPage.getExpectedEmail();
        actualCurrentAddress = textBoxPage.getExpectedCurrentAddress();
        actualPermanentAddress = textBoxPage.getExpectedPermanentAddress();

        // Assert - Second submission
        softAssert.assertEquals(actualName, NAME_PREFIX + TEST_FULL_NAME_ALT, FULL_NAME_MISMATCH);
        softAssert.assertEquals(actualEmail, EMAIL_PREFIX + TEST_EMAIL_ALT, EMAIL_MISMATCH);
        softAssert.assertEquals(actualCurrentAddress, CURRENT_ADDRESS_PREFIX + TEST_CURRENT_ADDRESS_ALT2, CURRENT_ADDRESS_MISMATCH);
        softAssert.assertEquals(actualPermanentAddress, PERMANENT_ADDRESS_PREFIX + TEST_PERMANENT_ADDRESS_ALT2, PERMANENT_ADDRESS_MISMATCH);

        softAssert.assertAll();
    }
}
