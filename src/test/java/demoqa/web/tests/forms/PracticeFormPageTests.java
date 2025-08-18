package demoqa.web.tests.forms;

import demoqa.pages.forms.PracticeFormPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PracticeFormPageTests extends BaseTest {

    public static final String AUTOMATION_PRACTICE_FORM_URL = "automation-practice-form";
    private PracticeFormPage practiceFormPage;
    
    // Form Headers Constants
    private static final String PRACTICE_FORM_HEADER = "Practice Form";
    private static final String STUDENT_REGISTRATION_HEADER = "Student Registration Form";
    
    // Form Labels Constants
    private static final String NAME_LABEL = "Name";
    private static final String EMAIL_LABEL = "Email";
    private static final String GENDER_LABEL = "Gender";
    private static final String MOBILE_LABEL = "Mobile(10 Digits)";
    private static final String DATE_OF_BIRTH_LABEL = "Date of Birth";
    private static final String SUBJECTS_LABEL = "Subjects";
    private static final String HOBBIES_LABEL = "Hobbies";
    private static final String PICTURE_LABEL = "Picture";
    private static final String CURRENT_ADDRESS_LABEL = "Current Address";
    private static final String STATE_AND_CITY_LABEL = "State and City";
    
    // Placeholder Constants
    private static final String FIRST_NAME_PLACEHOLDER = "First Name";
    private static final String LAST_NAME_PLACEHOLDER = "Last Name";
    private static final String EMAIL_PLACEHOLDER = "name@example.com";
    private static final String MOBILE_PLACEHOLDER = "Mobile Number";
    private static final String CURRENT_ADDRESS_PLACEHOLDER = "Current Address";
    private static final String SELECT_STATE_PLACEHOLDER = "Select State";
    private static final String SELECT_CITY_PLACEHOLDER = "Select City";
    private static final String SELECT_PICTURE_TEXT = "Select picture";
    
    // Gender Options Constants
    private static final String MALE_GENDER = "Male";
    private static final String FEMALE_GENDER = "Female";
    private static final String OTHER_GENDER = "Other";
    
    // Hobby Options Constants
    private static final String SPORTS_HOBBY = "Sports";
    private static final String READING_HOBBY = "Reading";
    private static final String MUSIC_HOBBY = "Music";
    
    // Button Constants
    private static final String SUBMIT_BUTTON_TEXT = "Submit";
    
    // Test Data Constants
    private static final String TEST_FIRST_NAME = "Zhivko";
    private static final String TEST_LAST_NAME = "Petrov";
    private static final String TEST_EMAIL = "karma@gmail.com";
    private static final String TEST_MOBILE = "1234567890";
    private static final String TEST_SUBJECT = "Hindi";
    private static final String TEST_ADDRESS = "Sofia Main St 244";
    private static final String TEST_STATE = "Haryana";
    private static final String TEST_CITY = "Karnal";
    private static final String TEST_PICTURE_FILE = "zhivko.jpg";
    
    // Color Constants
    private static final String VALIDATION_ERROR_COLOR = "rgb(220, 53, 69)";
    private static final String VALIDATION_ERROR_COLOR_RGBA = "rgba(220, 53, 69, 1)";
    private static final String VALIDATION_SUCCESS_COLOR = "rgb(40, 167, 69)";
    private static final String VALIDATION_SUCCESS_COLOR_RGBA = "rgba(40, 167, 69, 1)";
    
    // Modal Constants
    private static final String MODAL_LABEL_TEXT = "Label";
    private static final String MODAL_VALUES_TEXT = "Values";

    @BeforeMethod
    public void goToAutomationPracticeFormPage() {
        navigateToUrl(AUTOMATION_PRACTICE_FORM_URL);
        practiceFormPage = new PracticeFormPage(driver);
    }

    @Test(enabled = true, description = "Verify all text and placeholders")
    public void verifyAllTextAndPlaceHolders() {
        // Arrange
        String expectedDateOfBirthPlaceholder = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"));

        // Act
        String actualPracticeFromText = practiceFormPage.getPracticeFormLabel();
        String actualStudentRegistrationFormText = practiceFormPage.getStudentRegistrationFormLabel();
        String actualNameLabel = practiceFormPage.getNameLabel();
        String actualFirstNamePlaceholder = practiceFormPage.getFirstNamePlaceholderText();
        String actualLastNamePlaceholder = practiceFormPage.getLastNamePlaceholderText();
        String actualEmailLabel = practiceFormPage.getEmailLLabel();
        String actualPlaceholderEmail = practiceFormPage.getPlaceholderEmail();
        String actualGenderLabel = practiceFormPage.getGenderLabel();
        String actualMaleRadioButtonText = practiceFormPage.getMaleGenderText();
        String actualFemaleRadioButtonText = practiceFormPage.getFemaleGenderText();
        String actualOtherRadioButtonText = practiceFormPage.getOtherRadioButtonGenderText();
        String actualMobileNumberLabel = practiceFormPage.getMobileNumberLabel();
        String actualMobileNumberPlaceholder = practiceFormPage.getMobileNumberPlaceholderText();
        String actualDateOfBirthLabel = practiceFormPage.getDateOfBirthLabel();
        String actualDateOfBirthPlaceholder = practiceFormPage.getDateOfBirthPlaceholder();
        String actualSubjectsLabel = practiceFormPage.getSubjectLabel();
        String actualSubjectsPlaceholder = practiceFormPage.getPlaceholderSubjects();
        String actualHobbiesLabel = practiceFormPage.getHobbiesLabel();
        String actualHobbySportText = practiceFormPage.getHobbySportText();
        String actualHobbyReadingText = practiceFormPage.getReadingLabel();
        String actualHobbyMusicText = practiceFormPage.getMusicLabel();
        String actualPictureLabelText = practiceFormPage.getPictureLabel();
        String actualSelectPictureText = practiceFormPage.getSelectPictureLabel();
        String actualCurrentAddressLabel = practiceFormPage.getCurrentAddressLabel();
        String actualCurrentAddressPlaceholder = practiceFormPage.getCurrentAddressPlaceholder();
        String actualStateAndCityLabel = practiceFormPage.getStateAndCityLabel();
        String actualSelectStatePlaceholder = practiceFormPage.getSelectStatePlaceholder();
        String actualSelectCityPlaceholder = practiceFormPage.getCityPlaceholder();
        String actualSubmitButtonText = practiceFormPage.getSubmitButtonText();

        // Assert
        softAssert.assertEquals(actualPracticeFromText, PRACTICE_FORM_HEADER, "Practice form header text mismatch");
        softAssert.assertEquals(actualStudentRegistrationFormText, STUDENT_REGISTRATION_HEADER, "Student registration header text mismatch");
        softAssert.assertEquals(actualNameLabel, NAME_LABEL, "Name label text mismatch");
        softAssert.assertEquals(actualFirstNamePlaceholder, FIRST_NAME_PLACEHOLDER, "First name placeholder text mismatch");
        softAssert.assertEquals(actualLastNamePlaceholder, LAST_NAME_PLACEHOLDER, "Last name placeholder text mismatch");
        softAssert.assertEquals(actualEmailLabel, EMAIL_LABEL, "Email label text mismatch");
        softAssert.assertEquals(actualPlaceholderEmail, EMAIL_PLACEHOLDER, "Email placeholder text mismatch");
        softAssert.assertEquals(actualGenderLabel, GENDER_LABEL, "Gender label text mismatch");
        softAssert.assertEquals(actualMaleRadioButtonText, MALE_GENDER, "Male gender text mismatch");
        softAssert.assertEquals(actualFemaleRadioButtonText, FEMALE_GENDER, "Female gender text mismatch");
        softAssert.assertEquals(actualOtherRadioButtonText, OTHER_GENDER, "Other gender text mismatch");
        softAssert.assertEquals(actualMobileNumberLabel, MOBILE_LABEL, "Mobile number label text mismatch");
        softAssert.assertEquals(actualMobileNumberPlaceholder, MOBILE_PLACEHOLDER, "Mobile number placeholder text mismatch");
        softAssert.assertEquals(actualDateOfBirthLabel, DATE_OF_BIRTH_LABEL, "Date of birth label text mismatch");
        softAssert.assertEquals(actualDateOfBirthPlaceholder, expectedDateOfBirthPlaceholder, "Date of birth placeholder text mismatch");
        softAssert.assertEquals(actualSubjectsLabel, SUBJECTS_LABEL, "Subjects label text mismatch");
        softAssert.assertNull(actualSubjectsPlaceholder);
        softAssert.assertEquals(actualHobbiesLabel, HOBBIES_LABEL, "Hobbies label text mismatch");
        softAssert.assertEquals(actualHobbySportText, SPORTS_HOBBY, "Sports hobby text mismatch");
        softAssert.assertEquals(actualHobbyReadingText, READING_HOBBY, "Reading hobby text mismatch");
        softAssert.assertEquals(actualHobbyMusicText, MUSIC_HOBBY, "Music hobby text mismatch");
        softAssert.assertEquals(actualPictureLabelText, PICTURE_LABEL, "Picture label text mismatch");
        softAssert.assertEquals(actualSelectPictureText, SELECT_PICTURE_TEXT, "Select picture text mismatch");
        softAssert.assertEquals(actualCurrentAddressLabel, CURRENT_ADDRESS_LABEL, "Current address label text mismatch");
        softAssert.assertEquals(actualCurrentAddressPlaceholder, CURRENT_ADDRESS_PLACEHOLDER, "Current address placeholder text mismatch");
        softAssert.assertEquals(actualStateAndCityLabel, STATE_AND_CITY_LABEL, "State and city label text mismatch");
        softAssert.assertEquals(actualSelectStatePlaceholder, SELECT_STATE_PLACEHOLDER, "Select state placeholder text mismatch");
        softAssert.assertEquals(actualSelectCityPlaceholder, SELECT_CITY_PLACEHOLDER, "Select city placeholder text mismatch");
        softAssert.assertEquals(actualSubmitButtonText, SUBMIT_BUTTON_TEXT, "Submit button text mismatch");
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify three hobbies state")
    public void VerifyThreeHobbiesState() {
        // Arrange
        // Act
        practiceFormPage.clickSportHobbyCheckbox();
        practiceFormPage.clickMusicHobbyCheckbox();
        practiceFormPage.clickReadingHobbyCheckbox();
        practiceFormPage.unClickReadingHobbyCheckbox();

        boolean isReadingCheckBoxSelected = practiceFormPage.isReadingCheckBoxSelected();
        boolean isSportsCheckBoxSelected = practiceFormPage.isSportCheckBSelected();
        boolean isMusicCheckBoxSelected = practiceFormPage.isMusicCheckBoxSelected();

        // Assert
        softAssert.assertTrue(isSportsCheckBoxSelected, "Sports checkbox should be selected");
        softAssert.assertFalse(isReadingCheckBoxSelected, "Reading checkbox should be unselected");
        softAssert.assertTrue(isMusicCheckBoxSelected, "Music checkbox should be selected");
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select three radio buttons for gender")
    public void selectEveryRadioButton() {
        // Act
        practiceFormPage.clickGenderRadioButton(FEMALE_GENDER);
        practiceFormPage.clickGenderRadioButton(MALE_GENDER);
        practiceFormPage.clickGenderRadioButton(OTHER_GENDER);

        boolean isFemaleRadioButtonSelected = practiceFormPage.isFemaleRadioButtonSelected();
        boolean isMaleRadioButtonSelected = practiceFormPage.isMaleRadioButtonSelected();
        boolean isOtherRadioButtonSelected = practiceFormPage.isOtherRadioButtonSelected();

        // Assert
        softAssert.assertFalse(isFemaleRadioButtonSelected, "Female radio button should not be selected");
        softAssert.assertFalse(isMaleRadioButtonSelected, "Male radio button should not be selected");
        softAssert.assertTrue(isOtherRadioButtonSelected, "Other radio button should be selected");
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Submit valid practice form and verify")
    public void SubmitValidPracticeFormAndVerify() {
        // Arrange
        String dateOfBirth = "27 Feb 2024";
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd MMMM,yyyy");
        LocalDate date = LocalDate.parse(dateOfBirth, inputFormatter);
        String expectedDateOfBirth = date.format(outputFormatter);

        // Act
        String filePathOnOperationSystem = practiceFormPage.getFilePathFromResources(TEST_PICTURE_FILE);
        practiceFormPage.setFirstName(TEST_FIRST_NAME);
        practiceFormPage.setLastName(TEST_LAST_NAME);
        practiceFormPage.setEmail(TEST_EMAIL);
        practiceFormPage.clickGenderRadioButton(FEMALE_GENDER);
        practiceFormPage.setMobile(TEST_MOBILE);
        practiceFormPage.setDateOfBirth("March", "2024", "27");
        practiceFormPage.setSubject(TEST_SUBJECT);
        practiceFormPage.clickSportHobbyCheckbox();
        practiceFormPage.setCurrentAddress(TEST_ADDRESS);
        practiceFormPage.uploadFile(filePathOnOperationSystem);
        practiceFormPage.setState(TEST_STATE);
        practiceFormPage.setCity(TEST_CITY);
        practiceFormPage.clickSubmitButton2();

        String actualFullName = practiceFormPage.getStudentNameFromModal();
        String actualEmail = practiceFormPage.getEmailFromModal();
        String actualGender = practiceFormPage.getGenderFromModal();
        String actualMobile = practiceFormPage.getMobileFromModal();
        String actualDaterOfBirth = practiceFormPage.getDateOfBirthFromModal();
        String actualSubjects = practiceFormPage.getSubjectsFromModal();
        String actualHobbies = practiceFormPage.getHobbiesFromModal();
        String actualPicture = practiceFormPage.getPictureFromModal();
        String actualCurrentAddress = practiceFormPage.getCurrentAddressFromModal();
        String actualStateAndCity = practiceFormPage.getStateAndCityFromModal();
        String actualLabel = practiceFormPage.getLabelFromModal();
        String actualValues = practiceFormPage.getValuesFromModal();

        // Assert
        softAssert.assertEquals(actualFullName, TEST_FIRST_NAME + " " + TEST_LAST_NAME, "\nWrong full name.\n");
        softAssert.assertEquals(actualEmail, TEST_EMAIL, "\nWrong email address.\n");
        softAssert.assertEquals(actualGender, FEMALE_GENDER, "\nWrong gender.\n");
        softAssert.assertEquals(actualMobile, TEST_MOBILE, "\nWrong mobile number.\n");
        softAssert.assertEquals(actualDaterOfBirth, expectedDateOfBirth, "Wrong date of birth.\n");
        softAssert.assertEquals(actualSubjects, TEST_SUBJECT, "\nWrong subjects.\n");
        softAssert.assertEquals(actualHobbies, SPORTS_HOBBY, "\nWrong hobbies.\n");
        softAssert.assertEquals(actualPicture, TEST_PICTURE_FILE, "\nWrong name of picture.\n");
        softAssert.assertEquals(actualCurrentAddress, TEST_ADDRESS, "\nWrong current address.\n");
        softAssert.assertEquals(actualStateAndCity, TEST_STATE + " " + TEST_CITY, "Wrong State and City.\n");
        softAssert.assertEquals(actualLabel, MODAL_LABEL_TEXT, "\nWrong label.\n");
        softAssert.assertEquals(actualValues, MODAL_VALUES_TEXT, "\nWrong values.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click submit button on empty form and verify colors")
    public void clickSubmitOnEmptyFormAndVerifyColors() {
        // Arrange
        practiceFormPage.clickSubmitButton();

        // Act
        String firstNameBorderColor = practiceFormPage.getColorOfFirstNameBorder(VALIDATION_ERROR_COLOR);
        String lastNameBorderColor = practiceFormPage.getColorOfLastNameBorder(VALIDATION_ERROR_COLOR);
        String emailBorderColor = practiceFormPage.getColorOfEmail();
        String maleGenderColor = practiceFormPage.getMaleGenderColor();
        String femaleGenderColor = practiceFormPage.getFemaleGenderColor();
        String otherGenderColor = practiceFormPage.getOtherGenderColor();
        String mobileBorderColor = practiceFormPage.getColorOfMobile(VALIDATION_ERROR_COLOR);
        String dateOfBirth = practiceFormPage.getColorOfDateOfBirth();
        String sportColor = practiceFormPage.getHobbiesSportColor();
        String readingColor = practiceFormPage.getHobbiesReadingColor();
        String musicColor = practiceFormPage.getHobbiesMusicColor();
        String currentAddress = practiceFormPage.getCurrentAddressColor();

        // Assert
        softAssert.assertEquals(firstNameBorderColor, VALIDATION_ERROR_COLOR, "\nWrong color.Expected Red \n");
        softAssert.assertEquals(lastNameBorderColor, VALIDATION_ERROR_COLOR, "\nWrong color.Expected Red \n");
        softAssert.assertEquals(emailBorderColor, VALIDATION_SUCCESS_COLOR, "\nWrong color.Expected Green \n");
        softAssert.assertEquals(maleGenderColor, VALIDATION_ERROR_COLOR_RGBA, "\nWrong color.Expected Red \n");
        softAssert.assertEquals(femaleGenderColor, VALIDATION_ERROR_COLOR_RGBA, "\nWrong color.Expected Red \n");
        softAssert.assertEquals(otherGenderColor, VALIDATION_ERROR_COLOR_RGBA, "\nWrong color.Expected Red \n");
        softAssert.assertEquals(mobileBorderColor, VALIDATION_ERROR_COLOR, "\nWrong color.Expected Red \n");
        softAssert.assertEquals(dateOfBirth, VALIDATION_SUCCESS_COLOR, "\nWrong color.Expected Red \n");
        softAssert.assertEquals(sportColor, VALIDATION_SUCCESS_COLOR_RGBA, "\nWrong color.Expected Green \n");
        softAssert.assertEquals(readingColor, VALIDATION_SUCCESS_COLOR_RGBA, "\nWrong color.Expected Red \n");
        softAssert.assertEquals(musicColor, VALIDATION_SUCCESS_COLOR_RGBA, "\nWrong color.Expected Green \n");
        softAssert.assertEquals(currentAddress, VALIDATION_SUCCESS_COLOR, "\nWrong color.Expected Green \n");
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify colors change from red to green")
    public void verifyColorsChangeFromRedToGreen() {
        // Arrange
        practiceFormPage.clickSubmitButton();

        // Act
        String firstNameBorderColorBefore = practiceFormPage.getColorOfFirstNameBorder(VALIDATION_ERROR_COLOR);
        softAssert.assertEquals(firstNameBorderColorBefore, VALIDATION_ERROR_COLOR, "\nWrong color.Expected Red.\n");
        practiceFormPage.setFirstName(TEST_FIRST_NAME);

        String firstNameBorderColorAfter = practiceFormPage.getColorOfFirstNameBorder(VALIDATION_SUCCESS_COLOR);
        softAssert.assertEquals(firstNameBorderColorAfter, VALIDATION_SUCCESS_COLOR, "\nWrong color.Expected Green.\n");

        String lastNameBorderColorBefore = practiceFormPage.getColorOfLastNameBorder(VALIDATION_ERROR_COLOR);
        softAssert.assertEquals(lastNameBorderColorBefore, VALIDATION_ERROR_COLOR, "\nWrong color.Expected Red.\n");
        practiceFormPage.setLastName(TEST_LAST_NAME);

        String lastNameBorderColorAfter = practiceFormPage.getColorOfLastNameBorder(VALIDATION_SUCCESS_COLOR);
        softAssert.assertEquals(lastNameBorderColorAfter, VALIDATION_SUCCESS_COLOR, "\nWrong color.Expected Green.\n");

        String femaleGenderColorBefore = practiceFormPage.getFemaleGenderColor();
        practiceFormPage.clickGenderRadioButton(FEMALE_GENDER);

        String femaleGenderColorAfter = practiceFormPage.getFemaleGenderColor();
        String mobileBorderColorBefore = practiceFormPage.getColorOfMobile(VALIDATION_ERROR_COLOR);
        practiceFormPage.setMobile(TEST_MOBILE);

        String mobileBorderColorAfter = practiceFormPage.getColorOfMobile(VALIDATION_SUCCESS_COLOR);

        softAssert.assertEquals(femaleGenderColorBefore, VALIDATION_ERROR_COLOR_RGBA, "\nWrong color.Expected Red.\n");
        softAssert.assertEquals(femaleGenderColorAfter, VALIDATION_SUCCESS_COLOR_RGBA, "\nWrong color.Expected Green.\n");
        softAssert.assertEquals(mobileBorderColorBefore, VALIDATION_ERROR_COLOR, "\nWrong color.Expected Red.\n");
        softAssert.assertEquals(mobileBorderColorAfter, VALIDATION_SUCCESS_COLOR, "\nWrong color.Expected Green.\n");

        // Assert
        softAssert.assertAll();
    }
}
