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
    private static final String FULL_NAME = "Zhivko Nedyalkov";
    private static final String CURRENT_ADDRESS = "Sofia";
    private static final String PERMANENT_ADDRESS = "Earth";
    private static final String INVALID_EMAIL = "InvalidEmailFormat";
    private static final String VALID_EMAIL = "fbinnzhivko@gmail.com";

    private static final String FULL_NAME_ALT = "Petar Kamenov";
    private static final String CURRENT_ADDRESS_ALT = "4321 Maple Lane, Metropolis";
    private static final String PERMANENT_ADDRESS_ALT = "1234 Elm Street, Springfield";
    private static final String VALID_EMAIL_ALT = "kimi@gmail.com";

    // Output Format Constants
    private static final String NAME_PREFIX = "Name:";
    private static final String EMAIL_PREFIX = "Email:";
    private static final String CURRENT_ADDRESS_PREFIX = "Current Address :";
    private static final String PERMANENT_ADDRESS_PREFIX = "Permananet Address :";

    // Color Constants
    private static final String EXPECTED_RED_BORDER_COLOR = "1px solid rgb(255, 0, 0)";
    private static final String EXPECTED_SUBMIT_BUTTON_COLOR = "rgba(0, 123, 255, 1)";

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
    private static final String TEXT_BOX_URL = "text-box";
    private TextBoxPage textBoxPage;

    @BeforeMethod
    public void goToTextBoxPage() {
        navigateToUrl(TEXT_BOX_URL);
        textBoxPage = new TextBoxPage(driver);
    }

    @Test(enabled = true, description = "Verify all placeholders and labels on the text box page")
    public void verifyAllPlaceholdersAndAllLabels() {
        // Arrange & Act
        String actualTextBoxHeader = textBoxPage.getTextBoxHeaderText();
        String fullNameLabel = textBoxPage.getFullNameLabel();
        String fullNamePlaceholder = textBoxPage.getPlaceholderFullName();
        String emailLabel = textBoxPage.getEmailLabel();
        String emailPlaceholder = textBoxPage.getPlaceholderEmail();
        String currentAddressLabel = textBoxPage.getCurrentAddressLabel();
        String currentAddressPlaceholder = textBoxPage.getPlaceholderCurrentAddress();
        String permanentAddressLabel = textBoxPage.getPermanentAddressLabel();
        String permanentAddressPlaceholder = textBoxPage.getPlaceholderPermanentAddress();
        String actualSubmitButtonText = textBoxPage.getSubmitButtonText();
        String actualSubmitButtonBackGroundColor = textBoxPage.getSubmitButtonColor();

        // Assert
        softAssert.assertEquals(actualTextBoxHeader, EXPECTED_HEADER_TEXT, HEADER_TEXT_MISMATCH);
        softAssert.assertEquals(fullNameLabel, EXPECTED_FULL_NAME_LABEL, FULL_NAME_LABEL_MISMATCH);
        softAssert.assertEquals(fullNamePlaceholder, EXPECTED_FULL_NAME_PLACEHOLDER, FULL_NAME_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(emailLabel, EXPECTED_EMAIL_LABEL, EMAIL_LABEL_MISMATCH);
        softAssert.assertEquals(emailPlaceholder, EXPECTED_EMAIL_PLACEHOLDER, EMAIL_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(currentAddressLabel, EXPECTED_CURRENT_ADDRESS_LABEL, CURRENT_ADDRESS_LABEL_MISMATCH);
        softAssert.assertEquals(currentAddressPlaceholder, EXPECTED_CURRENT_ADDRESS_PLACEHOLDER, CURRENT_ADDRESS_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(permanentAddressLabel, EXPECTED_PERMANENT_ADDRESS_LABEL, PERMANENT_ADDRESS_LABEL_MISMATCH);
        softAssert.assertEquals(permanentAddressPlaceholder, EXPECTED_PERMANENT_ADDRESS_PLACEHOLDER, PERMANENT_ADDRESS_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(actualSubmitButtonText, EXPECTED_SUBMIT_BUTTON_TEXT, SUBMIT_BUTTON_TEXT_MISMATCH);
        softAssert.assertEquals(actualSubmitButtonBackGroundColor, EXPECTED_SUBMIT_BUTTON_COLOR, SUBMIT_BUTTON_TEXT_MISMATCH);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Submit filled form and verify all field values")
    public void submitFillForm() {
        // Arrange & Act
        textBoxPage.setFullNameField(FULL_NAME);
        textBoxPage.setEmailField(VALID_EMAIL);
        textBoxPage.setCurrentAddressField(CURRENT_ADDRESS);
        textBoxPage.setPermanentAddressField(PERMANENT_ADDRESS);
        textBoxPage.clickSubmitButton();

        // Assert
        softAssert.assertEquals(textBoxPage.getExpectedName(), NAME_PREFIX + FULL_NAME, FULL_NAME_MISMATCH);
        softAssert.assertEquals(textBoxPage.getExpectedEmail(), EMAIL_PREFIX + VALID_EMAIL, EMAIL_MISMATCH);
        softAssert.assertEquals(textBoxPage.getExpectedCurrentAddress(), CURRENT_ADDRESS_PREFIX + CURRENT_ADDRESS, CURRENT_ADDRESS_MISMATCH);
        softAssert.assertEquals(textBoxPage.getExpectedPermanentAddress(), PERMANENT_ADDRESS_PREFIX + PERMANENT_ADDRESS, PERMANENT_ADDRESS_MISMATCH);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Try to submit empty form and verify no output")
    public void tryToSubmitEmptyForm() {
        // Arrange & Act
        textBoxPage.clickSubmitButton();

        // Assert
        softAssert.assertEquals(textBoxPage.getOutput(), "", OUTPUT_NOT_EMPTY_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Submit only full name and verify output")
    public void submitFormOnlyWithFullName() {
        // Arrange & Act
        textBoxPage.setFullNameField(FULL_NAME);
        textBoxPage.clickSubmitButton();

        // Assert
        softAssert.assertEquals(textBoxPage.getOutput(), NAME_PREFIX + FULL_NAME, FULL_NAME_MISSING_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Submit only valid email and verify output")
    public void submitFormOnlyWithValidEmail() {
        // Arrange & Act
        textBoxPage.setEmailField(VALID_EMAIL);
        textBoxPage.clickSubmitButton();

        // Assert
        softAssert.assertEquals(textBoxPage.getExpectedEmail(), EMAIL_PREFIX + VALID_EMAIL, EMAIL_DOES_NOT_MATCH_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Submit invalid email and verify red border validation")
    public void submitWithInvalidEmail() {
        // Arrange & Act
        textBoxPage.setEmailField(INVALID_EMAIL);
        textBoxPage.clickSubmitButton();

        String actualRedColor = textBoxPage.isBorderRedAroundEmail(EXPECTED_RED_BORDER_COLOR);

        // Assert
        softAssert.assertEquals(actualRedColor, EXPECTED_RED_BORDER_COLOR, RED_BORDER_COLOR_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Submit only valid current address and verify output")
    public void submitFormOnlyWithCurrentAddress() {
        // Arrange & Act
        textBoxPage.setCurrentAddressField(CURRENT_ADDRESS);
        textBoxPage.clickSubmitButton();

        // Assert
        softAssert.assertEquals(textBoxPage.getExpectedCurrentAddress(), CURRENT_ADDRESS_PREFIX + CURRENT_ADDRESS, CURRENT_ADDRESS_DOES_NOT_MATCH_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Submit only valid permanent address and verify output")
    public void submitFormOnlyWithPermanentAddress() {
        // Arrange & Act
        textBoxPage.setPermanentAddressField(PERMANENT_ADDRESS);
        textBoxPage.clickSubmitButton();

        // Assert
        softAssert.assertEquals(textBoxPage.getExpectedPermanentAddress(), PERMANENT_ADDRESS_PREFIX + PERMANENT_ADDRESS, PERMANENT_ADDRESS_DOES_NOT_MATCH_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Update all fields after submit and verify changes")
    public void updateAllFieldsAfterSubmit() {
        // Arrange & Act - First submission
        textBoxPage.setFullNameField(FULL_NAME);
        textBoxPage.setEmailField(VALID_EMAIL);
        textBoxPage.setCurrentAddressField(CURRENT_ADDRESS);
        textBoxPage.setPermanentAddressField(PERMANENT_ADDRESS);
        textBoxPage.clickSubmitButton();

        // Assert - First submission
        softAssert.assertEquals(textBoxPage.getExpectedName(), NAME_PREFIX + FULL_NAME, FULL_NAME_MISMATCH);
        softAssert.assertEquals(textBoxPage.getExpectedEmail(), EMAIL_PREFIX + VALID_EMAIL, EMAIL_MISMATCH);
        softAssert.assertEquals(textBoxPage.getExpectedCurrentAddress(), CURRENT_ADDRESS_PREFIX + CURRENT_ADDRESS, CURRENT_ADDRESS_MISMATCH);
        softAssert.assertEquals(textBoxPage.getExpectedPermanentAddress(), PERMANENT_ADDRESS_PREFIX + PERMANENT_ADDRESS, PERMANENT_ADDRESS_MISMATCH);

        // Arrange & Act - Second submission with updated values
        textBoxPage.setFullNameField(FULL_NAME_ALT);
        textBoxPage.setEmailField(VALID_EMAIL_ALT);
        textBoxPage.setCurrentAddressField(CURRENT_ADDRESS_ALT);
        textBoxPage.setPermanentAddressField(PERMANENT_ADDRESS_ALT);
        textBoxPage.clickSubmitButton();

        // Assert - Second submission
        softAssert.assertEquals(textBoxPage.getExpectedName(), NAME_PREFIX + FULL_NAME_ALT, FULL_NAME_MISMATCH);
        softAssert.assertEquals(textBoxPage.getExpectedEmail(), EMAIL_PREFIX + VALID_EMAIL_ALT, EMAIL_MISMATCH);
        softAssert.assertEquals(textBoxPage.getExpectedCurrentAddress(), CURRENT_ADDRESS_PREFIX + CURRENT_ADDRESS_ALT, CURRENT_ADDRESS_MISMATCH);
        softAssert.assertEquals(textBoxPage.getExpectedPermanentAddress(), PERMANENT_ADDRESS_PREFIX + PERMANENT_ADDRESS_ALT, PERMANENT_ADDRESS_MISMATCH);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Submit with all fields and resubmit except email")
    public void submitFillFormAndReSubmitOnlyWithEmail() {
        // Arrange & Act - First submission
        textBoxPage.setFullNameField(FULL_NAME);
        textBoxPage.setEmailField(VALID_EMAIL);
        textBoxPage.setCurrentAddressField(CURRENT_ADDRESS);
        textBoxPage.setPermanentAddressField(PERMANENT_ADDRESS);
        textBoxPage.clickSubmitButton();

        // Assert - First submission
        softAssert.assertEquals(textBoxPage.getExpectedName(), NAME_PREFIX + FULL_NAME, FULL_NAME_MISMATCH);
        softAssert.assertEquals(textBoxPage.getExpectedEmail(), EMAIL_PREFIX + VALID_EMAIL, EMAIL_MISMATCH);
        softAssert.assertEquals(textBoxPage.getExpectedCurrentAddress(), CURRENT_ADDRESS_PREFIX + CURRENT_ADDRESS, CURRENT_ADDRESS_MISMATCH);
        softAssert.assertEquals(textBoxPage.getExpectedPermanentAddress(), PERMANENT_ADDRESS_PREFIX + PERMANENT_ADDRESS, PERMANENT_ADDRESS_MISMATCH);

        // Arrange & Act - Second submission with updated values
        textBoxPage.setFullNameField("");
        textBoxPage.setCurrentAddressField("");
        textBoxPage.setPermanentAddressField("");
        textBoxPage.clickSubmitButton();

        // Assert - Second submission
        softAssert.assertEquals(textBoxPage.getPlaceholderFullName(), EXPECTED_FULL_NAME_PLACEHOLDER, FULL_NAME_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(textBoxPage.getExpectedEmail(), EMAIL_PREFIX + VALID_EMAIL, EMAIL_MISMATCH);
        softAssert.assertEquals(textBoxPage.getPlaceholderCurrentAddress(), EXPECTED_CURRENT_ADDRESS_PLACEHOLDER, CURRENT_ADDRESS_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(textBoxPage.getPlaceholderPermanentAddress(), EXPECTED_PERMANENT_ADDRESS_PLACEHOLDER, PERMANENT_ADDRESS_PLACEHOLDER_MISMATCH);
        softAssert.assertAll();
    }
}
