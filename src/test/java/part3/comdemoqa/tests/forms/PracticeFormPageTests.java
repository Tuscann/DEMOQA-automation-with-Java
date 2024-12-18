package part3.comdemoqa.tests.forms;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PracticeFormPageTests extends BaseTest {

    @Test
    public void VerifyCheckBoxesState() {
        navigateToUrl("automation-practice-form");

        practiceFormPage.clickSportHobbyCheckbox();
        practiceFormPage.clickMusicHobbyCheckbox();
        practiceFormPage.clickReadingHobbyCheckbox();
        practiceFormPage.unClickReadingHobbyCheckbox();

        boolean isReadingCheckBoxSelected = practiceFormPage.isReadingCheckBoxSelected();
        boolean isSportsCheckBoxSelected = practiceFormPage.isSportCheckBSelected();
        boolean isMusicCheckBoxSelected = practiceFormPage.isMusicCheckBoxSelected();

        Assert.assertTrue(isSportsCheckBoxSelected, "\n Sports checkbox is not unselected \n");
        Assert.assertFalse(isReadingCheckBoxSelected, "\n Reading checkbox is not unselected \n");
        Assert.assertTrue(isMusicCheckBoxSelected, "\n Music checkbox is not unselected \n");
    }

    @Test
    public void SelectFemaleRadioButton() {
        navigateToUrl("automation-practice-form");
        String gender = "Female";
        practiceFormPage.clickGenderRadioButton(gender);

        boolean isFemaleRadioButtonSelected = practiceFormPage.isFemaleRadioButtonSelected();
        Assert.assertTrue(isFemaleRadioButtonSelected, "\n Female radio button is not selected \n");
    }

    @Test
    public void SelectMaleRadioButton() {
        navigateToUrl("automation-practice-form");
        String gender = "Male";
        practiceFormPage.clickGenderRadioButton(gender);

        boolean isMaleRadioButtonSelected = practiceFormPage.isMaleRadioButtonSelected();
        Assert.assertTrue(isMaleRadioButtonSelected, "\n Male radio button is not selected \n");
    }

    @Test
    public void SelectOtherRadioButton() {
        navigateToUrl("automation-practice-form");
        String gender = "Other";
        practiceFormPage.clickGenderRadioButton(gender);

        boolean isOtherRadioButtonSelected = practiceFormPage.isOtherRadioButtonSelected();
        Assert.assertTrue(isOtherRadioButtonSelected, "\n Other radio button is not selected \n");
    }

    @Test
    public void SubmitPracticeForm() {
        String firstName = "Zhivko";
        String lastName = "Petrov";
        String expectedEmail = "karma@gmail.com";
        String expectedGender = "Female";
        String expectedMobileNumber = "1234567890";
        String expectedDateOfBirth = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM,yyyy"));
        String DateOfBirth = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String expectedSubject = "Hindi";
        String expectedHobbies = "Sports";
        String expectedPicture = "";
        String expectedCurrentAddress = "Sofia Main St 244";
        String expectedState = ""; //"Haryana"
        String expectedCity = "";  //"Karnal";
        String expectedLabel = "Label";
        String expectedValues = "Values";

        navigateToUrl("automation-practice-form");

        practiceFormPage.setFirstName(firstName);
        practiceFormPage.setLastName(lastName);
        practiceFormPage.setEmail(expectedEmail);
        practiceFormPage.clickGenderRadioButton(expectedGender);
        practiceFormPage.setMobile(expectedMobileNumber);
        practiceFormPage.setDateOfBirth(DateOfBirth);
        practiceFormPage.setSubject(expectedSubject);
        practiceFormPage.clickSportHobbyCheckbox();
        practiceFormPage.setCurrentAddress(expectedCurrentAddress);
        // practiceFormPage.setStateFromDropDown(expectedState);
        // practiceFormPage.selectCity(city);
        practiceFormPage.clickSubmitButton();

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

        Assert.assertEquals(actualFullName, firstName + " " + lastName);
        Assert.assertEquals(actualEmail, expectedEmail);
        Assert.assertEquals(actualGender, expectedGender);
        Assert.assertEquals(actualMobile, expectedMobileNumber);
        Assert.assertEquals(actualDaterOfBirth, expectedDateOfBirth);
        Assert.assertEquals(actualSubjects, expectedSubject);
        Assert.assertEquals(actualHobbies, expectedHobbies);
        Assert.assertEquals(actualPicture, expectedPicture);
        Assert.assertEquals(actualCurrentAddress, expectedCurrentAddress);
        Assert.assertEquals(actualStateAndCity, expectedState + "" + expectedCity);
        Assert.assertEquals(actualLabel, expectedLabel);
        Assert.assertEquals(actualValues, expectedValues);
    }

    @Test
    public void VerifyAllTextAndPlaceHolders() {
        navigateToUrl("automation-practice-form");

        String practiceFromText = "Practice Form";
        String studentRegistrationFormText = "Student Registration Form";
        String nameLabel = "Name";
        String firstNamePlaceholder = "First Name";
        String lastNamePlaceholder = "Last Name";
        String emailLabel = "Email";
        String expectedPlaceholderEmail = "name@example.com";
        String genderLabel = "Gender";
        String expectedMaleRadioButtonText = "Male";
        String expectedFemaleRadioButtonText = "Female";
        String otherRadioButtonText = "Other";
        String expectedMobileNumberLabel = "Mobile(10 Digits)";
        String expectedMobileNumberPlaceholder = "Mobile Number";
        String expectedDateOfBirthLabel = "Date of Birth";
        String expectedDateOfBirthPlaceholder = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
        String expectedSubjectsLabel = "Subjects";
        String expectedHobbiesLabel = "Hobbies";
        String expectedHobbySportText = "Sports";
        String expectedHobbyReadingText = "Reading";
        String expectedHobbyMusicText = "Music";
        String expectedPictureLabelText = "Picture";
        String expectedSelectPictureText = "Select picture";
        String expectedCurrentAddressLabel = "Current Address";
        String expectedCurrentAddressPlaceholder = "Current Address";
        String expectedStateAndCityLabel = "State and City";
        String expectedSelectStatePlaceholder = "Select State";
        String expectedSelectCityPlaceholder = "Select City";
        String expectedSubmitButtonText = "Submit";

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

        Assert.assertEquals(actualPracticeFromText, practiceFromText, "Wrong practice form text");
        Assert.assertEquals(actualStudentRegistrationFormText, studentRegistrationFormText, "Wrong registration text");
        Assert.assertEquals(actualNameLabel, nameLabel, "Wrong practice form text");
        Assert.assertEquals(actualFirstNamePlaceholder, firstNamePlaceholder, "Wrong first placeholder");
        Assert.assertEquals(actualLastNamePlaceholder, lastNamePlaceholder, "Wrong last placeholder");
        Assert.assertEquals(actualEmailLabel, emailLabel, "Wrong email placeholder");
        Assert.assertEquals(actualPlaceholderEmail, expectedPlaceholderEmail, "Wrong email placeholder");
        Assert.assertEquals(actualGenderLabel, genderLabel, "Wrong gender placeholder");
        Assert.assertEquals(actualMaleRadioButtonText, expectedMaleRadioButtonText, "Wrong male placeholder");
        Assert.assertEquals(actualFemaleRadioButtonText, expectedFemaleRadioButtonText, "Wrong female placeholder");
        Assert.assertEquals(actualOtherRadioButtonText, otherRadioButtonText, "Wrong other placeholder");
        Assert.assertEquals(actualMobileNumberLabel, expectedMobileNumberLabel, "Wrong mobile number placeholder");
        Assert.assertEquals(actualMobileNumberPlaceholder, expectedMobileNumberPlaceholder, "Wrong mobile number placeholder");
        Assert.assertEquals(actualDateOfBirthLabel, expectedDateOfBirthLabel, "Wrong date of birth label");
        Assert.assertEquals(actualDateOfBirthPlaceholder, expectedDateOfBirthPlaceholder, "Wrong date of birth placeholder");
        Assert.assertEquals(actualSubjectsLabel, expectedSubjectsLabel, "Wrong subject placeholder");
        Assert.assertNull(actualSubjectsPlaceholder);
        Assert.assertEquals(actualHobbiesLabel, expectedHobbiesLabel, "Wrong hobbies placeholder");
        Assert.assertEquals(actualHobbySportText, expectedHobbySportText, "Wrong hobby sport text");
        Assert.assertEquals(actualHobbyReadingText, expectedHobbyReadingText, "Wrong hobby reading text");
        Assert.assertEquals(actualHobbyMusicText, expectedHobbyMusicText, "Wrong hobby music text");
        Assert.assertEquals(actualPictureLabelText, expectedPictureLabelText, "Wrong picture text");
        Assert.assertEquals(actualSelectPictureText, expectedSelectPictureText, "Wrong select picture");
        Assert.assertEquals(actualCurrentAddressLabel, expectedCurrentAddressLabel, "Wrong current address label");
        Assert.assertEquals(actualCurrentAddressPlaceholder, expectedCurrentAddressPlaceholder, "Wrong current address placeholder");
        Assert.assertEquals(actualStateAndCityLabel, expectedStateAndCityLabel, "Wrong state and City label");
        Assert.assertEquals(actualSelectStatePlaceholder, expectedSelectStatePlaceholder, "Wrong select state placeholder");
        Assert.assertEquals(actualSelectCityPlaceholder, expectedSelectCityPlaceholder, "Wrong select city placeholder");
        Assert.assertEquals(actualSubmitButtonText, expectedSubmitButtonText, "Wrong submit button text");
    }

    @Test
    public void VerifySubmitFormTexts() {
        String firstName = "Zhivko";
        String lastName = "Petrov";
        String expectedEmail = "karma@gmail.com";
        String expectedGender = "Female";
        String expectedMobileNumber = "1234567890";
        String DateOfBirth = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String expectedSubject = "Hindi";
        String expectedHobbies = "Sports";
        String expectedPicture = "";
        String expectedCurrentAddress = "Sofia Main St 244";
        String expectedState = ""; //"Haryana"
        String expectedCity = "";  //"Karnal";

        navigateToUrl("automation-practice-form");

        practiceFormPage.setFirstName(firstName);
        practiceFormPage.setLastName(lastName);
        practiceFormPage.setEmail(expectedEmail);
        practiceFormPage.clickGenderRadioButton(expectedGender);
        practiceFormPage.setMobile(expectedMobileNumber);
        practiceFormPage.setDateOfBirth(DateOfBirth);
        practiceFormPage.setSubject(expectedSubject);
        practiceFormPage.clickSportHobbyCheckbox();
        practiceFormPage.setCurrentAddress(expectedCurrentAddress);
        // practiceFormPage.setStateFromDropDown(expectedState);
        // practiceFormPage.selectCity(city);
        practiceFormPage.clickSubmitButton();

        String expectedThanksText = "Thanks for submitting the form";
        String expectedStudentNameFormLabel = "Student Name";
        String expectedLabel = "Label";
        String expectedValues = "Values";
        String expectedStudentEmail = "Student Email";
        String expectedGenderFormLabel = "Gender";
        String expectedMobileFormLabel = "Mobile";
        String expectedDateOfBirthFormLabel = "Date of Birth";
        String expectedSubjectsFormLabel = "Subjects";
        String expectedHobbiesFormLabel = "Hobbies";
        String expectedPictureFormLabel = "Picture";
        String expectedAddressFormLabel = "Address";
        String expectedStateAndCityFormLabel = "State and City";
        String expectedCloseButtonText = "Close";

        String actualThanksText = practiceFormPage.getThanksText();
        String actualStudentNameFormLabel = practiceFormPage.getStudentNameFormLabel();
        String actualStudentEmail = practiceFormPage.getStudentEmailLabel();
        String actualGenderFormLabel = practiceFormPage.getGenderFormLabel();
        String actualMobileFormLabel = practiceFormPage.getMobileFormLabel();
        String actualDateOfBirthFormLabel = practiceFormPage.getDateOfBirthFormLabel();
        String actualSubjectsFormLabel = practiceFormPage.getSubjectsFormLabel();
        String actualHobbiesFormLabel = practiceFormPage.getHobbiesFormLabel();
        String actualPictureFormLabel = practiceFormPage.getPictureFormLabel();
        String actualAddressFormLabel = practiceFormPage.getAddressFormLabel();
        String actualStateAndCityFormLabel = practiceFormPage.getStateAndCityFormLabel();
        String actualCloseButtonText = practiceFormPage.getCloseButtonText();

        Assert.assertEquals(actualThanksText, expectedThanksText, "Wrong thanks text");
        Assert.assertEquals(actualStudentNameFormLabel, expectedStudentNameFormLabel, "Wrong student name label");
        Assert.assertEquals(actualStudentEmail, expectedStudentEmail, "Wrong student email");
        Assert.assertEquals(actualGenderFormLabel, expectedGenderFormLabel, "Wrong gender label");
        Assert.assertEquals(actualMobileFormLabel, expectedMobileFormLabel, "Wrong mobile label");
        Assert.assertEquals(actualDateOfBirthFormLabel, expectedDateOfBirthFormLabel, "Wrong date of birth");
        Assert.assertEquals(actualSubjectsFormLabel, expectedSubjectsFormLabel, "Wrong subject label");
        Assert.assertEquals(actualHobbiesFormLabel, expectedHobbiesFormLabel, "Wrong hobbies label");
        Assert.assertEquals(actualPictureFormLabel, expectedPictureFormLabel, "Wrong picture label");
        Assert.assertEquals(actualAddressFormLabel, expectedAddressFormLabel, "Wrong address label");
        Assert.assertEquals(actualStateAndCityFormLabel, expectedStateAndCityFormLabel, "Wrong state and City label");
        Assert.assertEquals(actualCloseButtonText, expectedCloseButtonText, "Wrong close button text");
    }
}
