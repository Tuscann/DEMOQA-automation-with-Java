package part3.comdemoqa.tests.forms;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PracticeFormPageTests extends BaseTest {
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
        navigateToUrl("automation-practice-form");

        String firstName = "Zhivko";
        String lastName = "Petrov";
        String expectedEmail = "karma@gmail.com";
        String expectedGender = "Female";
        String expectedMobileNumber = "1234567890";
        String expectedDateOfBirth = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM,yyyy"));
        String DateOfBirth = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String expectedSubject = "Hindi";
        String expectedHobbies = "Sports";
        String expectedPicture = "zhivko.jpg";
        String expectedCurrentAddress = "Sofia Main St 244";
        String expectedState = "Haryana";
        String expectedCity = "Karnal";
        String expectedLabel = "Label";
        String expectedValues = "Values";

        String filePathOnOperationSystem = practiceFormPage.getFilePathFromResources(expectedPicture);

        practiceFormPage.setFirstName(firstName);
        practiceFormPage.setLastName(lastName);
        practiceFormPage.setEmail(expectedEmail);
        practiceFormPage.clickGenderRadioButton(expectedGender);
        practiceFormPage.setMobile(expectedMobileNumber);
        practiceFormPage.setDateOfBirth(DateOfBirth);
        practiceFormPage.setSubject(expectedSubject);
        practiceFormPage.clickSportHobbyCheckbox();
        practiceFormPage.uploadFile(filePathOnOperationSystem);
        practiceFormPage.setCurrentAddress(expectedCurrentAddress);
        practiceFormPage.setState(expectedState);
        practiceFormPage.setCity(expectedCity);
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

        Assert.assertEquals(actualFullName, firstName + " " + lastName, "Wrong full name");
        Assert.assertEquals(actualEmail, expectedEmail, "Wrong email address");
        Assert.assertEquals(actualGender, expectedGender, "Wrong gender");
        Assert.assertEquals(actualMobile, expectedMobileNumber, "Wrong mobile number");
        Assert.assertEquals(actualDaterOfBirth, expectedDateOfBirth, "Wrong date of birth");
        Assert.assertEquals(actualSubjects, expectedSubject, "Wrong subjects");
        Assert.assertEquals(actualHobbies, expectedHobbies, "Wrong hobbies");
        Assert.assertEquals(actualPicture, expectedPicture, "Wrong name of picture");
        Assert.assertEquals(actualCurrentAddress, expectedCurrentAddress, "Wrong current address");
        Assert.assertEquals(actualStateAndCity, expectedState + " " + expectedCity, "Wrong State and City");
        Assert.assertEquals(actualLabel, expectedLabel, "Wrong label");
        Assert.assertEquals(actualValues, expectedValues, "Wrong values");
    }
}
