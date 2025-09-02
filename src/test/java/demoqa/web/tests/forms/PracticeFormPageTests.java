package demoqa.web.tests.forms;

import demoqa.pages.forms.PracticeFormPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PracticeFormPageTests extends BaseTest {
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
    private static final String MALE_GENDER = "Male";
    private static final String FEMALE_GENDER = "Female";
    private static final String OTHER_GENDER = "Other";
    private static final String MOBILE_PLACEHOLDER = "Mobile Number";
    private static final String SPORTS_HOBBY = "Sports";
    private static final String READING_HOBBY = "Reading";
    private static final String MUSIC_HOBBY = "Music";
    private static final String SELECT_PICTURE_TEXT = "Select picture";
    private static final String CURRENT_ADDRESS_PLACEHOLDER = "Current Address";
    private static final String SELECT_STATE_PLACEHOLDER = "Select State";
    private static final String SELECT_CITY_PLACEHOLDER = "Select City";

    // Button Constants
    private static final String SUBMIT_BUTTON_TEXT = "Submit";
    private static final String HEADER_TEXT = "Thanks for submitting the form";
    private static final String CLOSE_BUTTON_TEXT = "Close";

    // Test Data Constants
    private static final String FIRST_NAME = "Zhivko";
    private static final String LAST_NAME = "Petrov";
    private static final String EMAIL = "karma@gmail.com";
    private static final String MOBILE = "1234567890";
    private static final String SUBJECT = "Hindi";
    private static final String ADDRESS = "Sofia Main St 244";
    private static final String NCR_STATE = "NCR";
    private static final String DELHI_CITY = "Delhi";
    private static final String TEST_PICTURE_FILE = "zhivko.jpg";

    // Color Constants
    private static final String BLUE_COLOR = "rgba(0, 123, 255, 1)";
    private static final String RED_COLOR1 = "rgb(220, 53, 69)";
    private static final String RED_COLOR2 = "rgba(220, 53, 69, 1)";
    private static final String GREEN_COLOR1 = "rgb(40, 167, 69)";
    private static final String GREEN_COLOR2 = "rgba(40, 167, 69, 1)";

    // Modal Constants
    private static final String MODAL_LABEL_TEXT = "Label";
    private static final String MODAL_VALUES_TEXT = "Values";
    private static final String MODAL_STUDENT_NAME_TEXT = "Student Name";
    private static final String MODAL_STUDENT_EMAIL_TEXT = "Student Email";
    private static final String MODAL_GENDER_TEXT = "Gender";
    private static final String MODAL_MOBILE_TEXT = "Mobile";
    private static final String MODAL_DATE_OF_BIRTH_TEXT = "Date of Birth";
    private static final String MODAL_SUBJECTS_TEXT = "Subjects";
    private static final String MODAL_HOBBIES_TEXT = "Hobbies";
    private static final String MODAL_PICTURE_TEXT = "Picture";
    private static final String MODAL_ADDRESS_TEXT = "Address";
    private static final String MODAL_STATE_AND_CITY_TEXT = "State and City";


    // Error Message Constants
    private static final String PRACTICE_FORM_HEADER_ERROR = "Practice form header text mismatch";
    private static final String STUDENT_REGISTRATION_HEADER_ERROR = "Student registration header text mismatch";
    private static final String NAME_LABEL_ERROR = "Name label text mismatch";
    private static final String FIRST_NAME_PLACEHOLDER_ERROR = "First name placeholder text mismatch";
    private static final String LAST_NAME_PLACEHOLDER_ERROR = "Last name placeholder text mismatch";
    private static final String EMAIL_LABEL_ERROR = "Email label text mismatch";
    private static final String EMAIL_PLACEHOLDER_ERROR = "Email placeholder text mismatch";
    private static final String GENDER_LABEL_ERROR = "Gender label text mismatch";
    private static final String MALE_GENDER_ERROR = "Male gender text mismatch";
    private static final String FEMALE_GENDER_ERROR = "Female gender text mismatch";
    private static final String OTHER_GENDER_ERROR = "Other gender text mismatch";
    private static final String MOBILE_LABEL_ERROR = "Mobile number label text mismatch";
    private static final String MOBILE_PLACEHOLDER_ERROR = "Mobile number placeholder text mismatch";
    private static final String DATE_OF_BIRTH_LABEL_ERROR = "Date of birth label text mismatch";
    private static final String DATE_OF_BIRTH_PLACEHOLDER_ERROR = "Date of birth placeholder text mismatch";
    private static final String SUBJECTS_LABEL_ERROR = "Subjects label text mismatch";
    private static final String HOBBIES_LABEL_ERROR = "Hobbies label text mismatch";
    private static final String SPORTS_HOBBY_ERROR = "Sports hobby text mismatch";
    private static final String READING_HOBBY_ERROR = "Reading hobby text mismatch";
    private static final String MUSIC_HOBBY_ERROR = "Music hobby text mismatch";
    private static final String PICTURE_LABEL_ERROR = "Picture label text mismatch";
    private static final String SELECT_PICTURE_ERROR = "Select picture text mismatch";
    private static final String CURRENT_ADDRESS_LABEL_ERROR = "Current address label text mismatch";
    private static final String CURRENT_ADDRESS_PLACEHOLDER_ERROR = "Current address placeholder text mismatch";
    private static final String STATE_AND_CITY_LABEL_ERROR = "State and city label text mismatch";
    private static final String SELECT_STATE_PLACEHOLDER_ERROR = "Select state placeholder text mismatch";
    private static final String SELECT_CITY_PLACEHOLDER_ERROR = "Select city placeholder text mismatch";
    private static final String SUBMIT_BUTTON_ERROR = "Submit button text mismatch";
    private static final String CLOSE_BUTTON_ERROR = "Close button text mismatch";
    private static final String CLOSE_BUTTON_BACKGROUND_COLOR = "Close button wrong background color";
    private static final String SPORTS_CHECKBOX_ERROR = "Sports checkbox should be selected";
    private static final String READING_CHECKBOX_ERROR = "Reading checkbox should be unselected";
    private static final String MUSIC_CHECKBOX_ERROR = "Music checkbox should be selected";
    private static final String FEMALE_RADIO_ERROR = "Female radio button should not be selected";
    private static final String MALE_RADIO_ERROR = "Male radio button should not be selected";
    private static final String OTHER_RADIO_ERROR = "Other radio button should be selected";
    private static final String FULL_NAME_ERROR = "Wrong full name";
    private static final String EMAIL_ADDRESS_ERROR = "Wrong email address";
    private static final String GENDER_VALUE_ERROR = "Wrong gender";
    private static final String MOBILE_NUMBER_ERROR = "Wrong mobile number";
    private static final String DATE_OF_BIRTH_VALUE_ERROR = "Wrong date of birth";
    private static final String SUBJECTS_VALUE_ERROR = "Wrong subjects";
    private static final String HOBBIES_VALUE_ERROR = "Wrong hobbies";
    private static final String PICTURE_NAME_ERROR = "Wrong name of picture";
    private static final String CURRENT_ADDRESS_VALUE_ERROR = "Wrong current address";
    private static final String STATE_AND_CITY_VALUE_ERROR = "Wrong State and City";
    private static final String LABEL_VALUE_ERROR = "Wrong label";
    private static final String VALUES_TEXT_ERROR = "Wrong values";
    private static final String MODAL_GENDER_TEXT_ERROR = "Wrong modal gender label";
    private static final String FIRST_NAME_COLOR_BEFORE_ERROR = "First name expected red";
    private static final String LAST_NAME_COLOR_ERROR = "Wrong color, expected red";
    private static final String EMAIL_COLOR_ERROR = "Wrong color, expected green";
    private static final String MALE_GENDER_COLOR_ERROR = "Wrong color, expected red";
    private static final String FEMALE_GENDER_COLOR_ERROR_BEFORE = "Female expected color red";
    private static final String FEMALE_GENDER_COLOR_ERROR_AFTER = "Female expected color green";
    private static final String OTHER_GENDER_COLOR_ERROR = "Wrong color, expected red";
    private static final String MOBILE_COLOR_ERROR = "Wrong color, expected red";
    private static final String DATE_OF_BIRTH_COLOR_ERROR = "Wrong color, expected red";
    private static final String SPORT_COLOR_ERROR = "Wrong color, expected green";
    private static final String READING_COLOR_ERROR = "Wrong color, expected red";
    private static final String MUSIC_COLOR_ERROR = "Wrong color, expected green";
    private static final String CURRENT_ADDRESS_COLOR_ERROR = "Wrong color, expected green";
    private static final String FIRST_NAME_SUCCESS_COLOR_ERROR = "Wrong color, expected green";
    private static final String LAST_NAME_SUCCESS_COLOR_ERROR = "Wrong color, expected green";
    private static final String FEMALE_GENDER_SUCCESS_COLOR_ERROR = "Wrong color, expected green";
    private static final String MOBILE_SUCCESS_COLOR_ERROR = "Wrong color, expected green";
    private static final String AUTOMATION_PRACTICE_FORM_URL = "automation-practice-form";
    private PracticeFormPage practiceFormPage;

    @BeforeMethod
    public void goToAutomationPracticeFormPage() {
        navigateToUrl(AUTOMATION_PRACTICE_FORM_URL);
        practiceFormPage = new PracticeFormPage(driver);
    }

    @Test(enabled = true, description = "Verify all text and placeholders on the practice form")
    public void verifyAllTextAndPlaceHolders() {
        // Arrange
        String expectedDateOfBirthPlaceholder = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"));

        // Act & Assert
        softAssert.assertEquals(practiceFormPage.getPracticeFormLabel(), PRACTICE_FORM_HEADER, PRACTICE_FORM_HEADER_ERROR);
        softAssert.assertEquals(practiceFormPage.getStudentRegistrationFormLabel(), STUDENT_REGISTRATION_HEADER, STUDENT_REGISTRATION_HEADER_ERROR);
        softAssert.assertEquals(practiceFormPage.getNameLabel(), NAME_LABEL, NAME_LABEL_ERROR);
        softAssert.assertEquals(practiceFormPage.getFirstNamePlaceholderText(), FIRST_NAME_PLACEHOLDER, FIRST_NAME_PLACEHOLDER_ERROR);
        softAssert.assertEquals(practiceFormPage.getLastNamePlaceholderText(), LAST_NAME_PLACEHOLDER, LAST_NAME_PLACEHOLDER_ERROR);
        softAssert.assertEquals(practiceFormPage.getEmailLLabel(), EMAIL_LABEL, EMAIL_LABEL_ERROR);
        softAssert.assertEquals(practiceFormPage.getPlaceholderEmail(), EMAIL_PLACEHOLDER, EMAIL_PLACEHOLDER_ERROR);
        softAssert.assertEquals(practiceFormPage.getGenderLabel(), GENDER_LABEL, GENDER_LABEL_ERROR);
        softAssert.assertEquals(practiceFormPage.getMaleGenderText(), MALE_GENDER, MALE_GENDER_ERROR);
        softAssert.assertEquals(practiceFormPage.getFemaleGenderText(), FEMALE_GENDER, FEMALE_GENDER_ERROR);
        softAssert.assertEquals(practiceFormPage.getOtherRadioButtonGenderText(), OTHER_GENDER, OTHER_GENDER_ERROR);
        softAssert.assertEquals(practiceFormPage.getMobileNumberLabel(), MOBILE_LABEL, MOBILE_LABEL_ERROR);
        softAssert.assertEquals(practiceFormPage.getMobileNumberPlaceholderText(), MOBILE_PLACEHOLDER, MOBILE_PLACEHOLDER_ERROR);
        softAssert.assertEquals(practiceFormPage.getDateOfBirthLabel(), DATE_OF_BIRTH_LABEL, DATE_OF_BIRTH_LABEL_ERROR);
        softAssert.assertEquals(practiceFormPage.getDateOfBirthPlaceholder(), expectedDateOfBirthPlaceholder, DATE_OF_BIRTH_PLACEHOLDER_ERROR);
        softAssert.assertEquals(practiceFormPage.getSubjectLabel(), SUBJECTS_LABEL, SUBJECTS_LABEL_ERROR);
        softAssert.assertNull(practiceFormPage.getPlaceholderSubjects());
        softAssert.assertEquals(practiceFormPage.getHobbiesLabel(), HOBBIES_LABEL, HOBBIES_LABEL_ERROR);
        softAssert.assertEquals(practiceFormPage.getHobbySportText(), SPORTS_HOBBY, SPORTS_HOBBY_ERROR);
        softAssert.assertEquals(practiceFormPage.getReadingLabel(), READING_HOBBY, READING_HOBBY_ERROR);
        softAssert.assertEquals(practiceFormPage.getMusicLabel(), MUSIC_HOBBY, MUSIC_HOBBY_ERROR);
        softAssert.assertEquals(practiceFormPage.getPictureLabel(), PICTURE_LABEL, PICTURE_LABEL_ERROR);
        softAssert.assertEquals(practiceFormPage.getSelectPictureLabel(), SELECT_PICTURE_TEXT, SELECT_PICTURE_ERROR);
        softAssert.assertEquals(practiceFormPage.getCurrentAddressLabel(), CURRENT_ADDRESS_LABEL, CURRENT_ADDRESS_LABEL_ERROR);
        softAssert.assertEquals(practiceFormPage.getCurrentAddressPlaceholder(), CURRENT_ADDRESS_PLACEHOLDER, CURRENT_ADDRESS_PLACEHOLDER_ERROR);
        softAssert.assertEquals(practiceFormPage.getStateAndCityLabel(), STATE_AND_CITY_LABEL, STATE_AND_CITY_LABEL_ERROR);
        softAssert.assertEquals(practiceFormPage.getSelectStatePlaceholder(), SELECT_STATE_PLACEHOLDER, SELECT_STATE_PLACEHOLDER_ERROR);
        softAssert.assertEquals(practiceFormPage.getCityPlaceholder(), SELECT_CITY_PLACEHOLDER, SELECT_CITY_PLACEHOLDER_ERROR);
        softAssert.assertEquals(practiceFormPage.getSubmitButtonText(), SUBMIT_BUTTON_TEXT, SUBMIT_BUTTON_ERROR);
        softAssert.assertEquals(practiceFormPage.getSubmitButtonBackgroundColor(), BLUE_COLOR, SUBMIT_BUTTON_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select three radio buttons for gender and verify selection")
    public void selectEveryGenderRadioButton() {
        // Arrange & Act
        practiceFormPage.clickGenderRadioButton(FEMALE_GENDER);
        practiceFormPage.clickGenderRadioButton(MALE_GENDER);
        practiceFormPage.clickGenderRadioButton(OTHER_GENDER);

        // Assert
        softAssert.assertFalse(practiceFormPage.isFemaleRadioButtonSelected(), FEMALE_RADIO_ERROR);
        softAssert.assertFalse(practiceFormPage.isMaleRadioButtonSelected(), MALE_RADIO_ERROR);
        softAssert.assertTrue(practiceFormPage.isOtherRadioButtonSelected(), OTHER_RADIO_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify three hobbies state and selection behavior")
    public void verifyThreeHobbiesState() {
        // Arrange & Act
        practiceFormPage.clickSportHobbyCheckbox();
        practiceFormPage.clickMusicHobbyCheckbox();
        practiceFormPage.clickReadingHobbyCheckbox();
        practiceFormPage.unClickReadingHobbyCheckbox();

        // Assert
        softAssert.assertFalse(practiceFormPage.isReadingCheckBoxSelected(), READING_CHECKBOX_ERROR);
        softAssert.assertTrue(practiceFormPage.isSportCheckBSelected(), SPORTS_CHECKBOX_ERROR);
        softAssert.assertTrue(practiceFormPage.isMusicCheckBoxSelected(), MUSIC_CHECKBOX_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Submit valid practice form and verify all submitted data")
    public void submitValidPracticeFormAndVerify() {
        // Arrange
        String dateOfBirth = "27 Feb 2024";
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd MMMM,yyyy");
        LocalDate date = LocalDate.parse(dateOfBirth, inputFormatter);
        String expectedDateOfBirth = date.format(outputFormatter);
        String filePathOnOperationSystem = practiceFormPage.getFilePathFromResources(TEST_PICTURE_FILE);

        // Act
        practiceFormPage.setFirstName(FIRST_NAME);
        practiceFormPage.setLastName(LAST_NAME);
        practiceFormPage.setEmail(EMAIL);
        practiceFormPage.clickGenderRadioButton(FEMALE_GENDER);
        practiceFormPage.setMobile(MOBILE);
        practiceFormPage.setDateOfBirth("March", "2024", "27");
        practiceFormPage.setSubject(SUBJECT);
        practiceFormPage.clickSportHobbyCheckbox();
        practiceFormPage.setCurrentAddress(ADDRESS);
        practiceFormPage.uploadFile(filePathOnOperationSystem);
        practiceFormPage.setState(NCR_STATE);
        practiceFormPage.setCity(DELHI_CITY);
        softAssert.assertEquals(practiceFormPage.getSubmitButtonText(), SUBMIT_BUTTON_TEXT, SUBMIT_BUTTON_ERROR);
        softAssert.assertEquals(practiceFormPage.getSubmitButtonBackgroundColor(), BLUE_COLOR, SUBMIT_BUTTON_ERROR);
        practiceFormPage.clickSubmitButton2();
        softAssert.assertEquals(practiceFormPage.getCloseButtonText(), CLOSE_BUTTON_TEXT, CLOSE_BUTTON_ERROR);
        softAssert.assertEquals(practiceFormPage.getCloseButtonBackgroundColor(), BLUE_COLOR, CLOSE_BUTTON_BACKGROUND_COLOR);

        // Assert
        softAssert.assertEquals(practiceFormPage.getHeaderText(), HEADER_TEXT, VALUES_TEXT_ERROR);
        softAssert.assertEquals(practiceFormPage.getLabelTextFromModal(), MODAL_LABEL_TEXT, LABEL_VALUE_ERROR);
        softAssert.assertEquals(practiceFormPage.getValuesTextFromModal(), MODAL_VALUES_TEXT, VALUES_TEXT_ERROR);
        softAssert.assertEquals(practiceFormPage.getStudentNameLabelFromModal(), MODAL_STUDENT_NAME_TEXT, VALUES_TEXT_ERROR);
        softAssert.assertEquals(practiceFormPage.getStudentNameValueFromModal(), FIRST_NAME + " " + LAST_NAME, FULL_NAME_ERROR);
        softAssert.assertEquals(practiceFormPage.getStudentEmailLabelFromModal(), MODAL_STUDENT_EMAIL_TEXT, VALUES_TEXT_ERROR);
        softAssert.assertEquals(practiceFormPage.getEmailFromModal(), EMAIL, EMAIL_ADDRESS_ERROR);
        softAssert.assertEquals(practiceFormPage.getGenderLabelFromModal(), MODAL_GENDER_TEXT, MODAL_GENDER_TEXT_ERROR);
        softAssert.assertEquals(practiceFormPage.getGenderFromModal(), FEMALE_GENDER, GENDER_VALUE_ERROR);
        softAssert.assertEquals(practiceFormPage.getMobileLabelFromModal(), MODAL_MOBILE_TEXT, VALUES_TEXT_ERROR);
        softAssert.assertEquals(practiceFormPage.getMobileFromModal(), MOBILE, MOBILE_NUMBER_ERROR);
        softAssert.assertEquals(practiceFormPage.getDateOfBirthLabelFromModal(), MODAL_DATE_OF_BIRTH_TEXT, VALUES_TEXT_ERROR);
        softAssert.assertEquals(practiceFormPage.getDateOfBirthFromModal(), expectedDateOfBirth, DATE_OF_BIRTH_VALUE_ERROR);
        softAssert.assertEquals(practiceFormPage.getSubjectsLabelFromModal(), MODAL_SUBJECTS_TEXT, VALUES_TEXT_ERROR);
        softAssert.assertEquals(practiceFormPage.getSubjectsFromModal(), SUBJECT, SUBJECTS_VALUE_ERROR);
        softAssert.assertEquals(practiceFormPage.getHobbiesLabelFromModal(), MODAL_HOBBIES_TEXT, VALUES_TEXT_ERROR);
        softAssert.assertEquals(practiceFormPage.getHobbiesFromModal(), SPORTS_HOBBY, HOBBIES_VALUE_ERROR);
        softAssert.assertEquals(practiceFormPage.getPictureLabelFromModal(), MODAL_PICTURE_TEXT, VALUES_TEXT_ERROR);
        softAssert.assertEquals(practiceFormPage.getPictureFromModal(), TEST_PICTURE_FILE, PICTURE_NAME_ERROR);
        softAssert.assertEquals(practiceFormPage.getAddressLabelFromModal(), MODAL_ADDRESS_TEXT, VALUES_TEXT_ERROR);
        softAssert.assertEquals(practiceFormPage.getAddressFromModal(), ADDRESS, CURRENT_ADDRESS_VALUE_ERROR);
        softAssert.assertEquals(practiceFormPage.getStateAndCityLabelFromModal(), MODAL_STATE_AND_CITY_TEXT, VALUES_TEXT_ERROR);
        softAssert.assertEquals(practiceFormPage.getStateAndCityValueFromModal(), NCR_STATE + " " + DELHI_CITY, STATE_AND_CITY_VALUE_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click submit button on empty form and verify validation colors")
    public void clickSubmitOnEmptyFormAndVerifyBorderColors() {
        // Arrange
        practiceFormPage.clickSubmitButton();

        // Act & Assert
        softAssert.assertEquals(practiceFormPage.getColorOfFirstNameBorder(RED_COLOR1), RED_COLOR1, FIRST_NAME_COLOR_BEFORE_ERROR);
        softAssert.assertEquals(practiceFormPage.getColorOfLastNameBorder(RED_COLOR1), RED_COLOR1, LAST_NAME_COLOR_ERROR);
        softAssert.assertEquals(practiceFormPage.getColorOfEmail(), GREEN_COLOR1, EMAIL_COLOR_ERROR);
        softAssert.assertEquals(practiceFormPage.getMaleGenderColor(), RED_COLOR2, MALE_GENDER_COLOR_ERROR);
        softAssert.assertEquals(practiceFormPage.getFemaleGenderColor(), RED_COLOR2, FEMALE_GENDER_COLOR_ERROR_BEFORE);
        softAssert.assertEquals(practiceFormPage.getOtherGenderColor(), RED_COLOR2, OTHER_GENDER_COLOR_ERROR);
        softAssert.assertEquals(practiceFormPage.getColorOfMobile(RED_COLOR1), RED_COLOR1, MOBILE_COLOR_ERROR);
        softAssert.assertEquals(practiceFormPage.getColorOfDateOfBirth(), GREEN_COLOR1, DATE_OF_BIRTH_COLOR_ERROR);
        softAssert.assertEquals(practiceFormPage.getHobbiesSportColor(), GREEN_COLOR2, SPORT_COLOR_ERROR);
        softAssert.assertEquals(practiceFormPage.getHobbiesReadingColor(), GREEN_COLOR2, READING_COLOR_ERROR);
        softAssert.assertEquals(practiceFormPage.getHobbiesMusicColor(), GREEN_COLOR2, MUSIC_COLOR_ERROR);
        softAssert.assertEquals(practiceFormPage.getCurrentAddressColor(), GREEN_COLOR1, CURRENT_ADDRESS_COLOR_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify colors change from red to green after form validation")
    public void verifyBorderColorsChangeFromRedToGreen() {
        // Arrange
        practiceFormPage.clickSubmitButton();

        // Act
        softAssert.assertEquals(practiceFormPage.getColorOfFirstNameBorder(RED_COLOR1), RED_COLOR1, FIRST_NAME_COLOR_BEFORE_ERROR);
        practiceFormPage.setFirstName(FIRST_NAME);
        softAssert.assertEquals(practiceFormPage.getColorOfFirstNameBorder(GREEN_COLOR1), GREEN_COLOR1, FIRST_NAME_SUCCESS_COLOR_ERROR);

        softAssert.assertEquals(practiceFormPage.getColorOfLastNameBorder(RED_COLOR1), RED_COLOR1, LAST_NAME_COLOR_ERROR);
        practiceFormPage.setLastName(LAST_NAME);
        softAssert.assertEquals(practiceFormPage.getColorOfLastNameBorder(GREEN_COLOR1), GREEN_COLOR1, LAST_NAME_SUCCESS_COLOR_ERROR);

        softAssert.assertEquals(practiceFormPage.getFemaleGenderColor(), RED_COLOR2, FEMALE_GENDER_COLOR_ERROR_BEFORE);
        practiceFormPage.clickGenderRadioButton(FEMALE_GENDER);
        softAssert.assertEquals(practiceFormPage.getFemaleGenderColor(), GREEN_COLOR2, FEMALE_GENDER_COLOR_ERROR_AFTER);

        softAssert.assertEquals(practiceFormPage.getColorOfMobile(RED_COLOR1), RED_COLOR1, MOBILE_COLOR_ERROR);
        practiceFormPage.setMobile(MOBILE);
        softAssert.assertEquals(practiceFormPage.getColorOfMobile(GREEN_COLOR1), GREEN_COLOR1, MOBILE_SUCCESS_COLOR_ERROR);

        // Assert
        softAssert.assertAll();
    }
}
