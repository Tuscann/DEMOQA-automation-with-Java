package demoqa.web.test.forms;

import demoqa.web.BaseTest;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PracticeFormPageTests extends BaseTest {
    @Test(enabled = true, testName = "Verify all text and placeholders")
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

        softAssert.assertEquals(actualPracticeFromText, practiceFromText, "\nWrong practice form text\n");
        softAssert.assertEquals(actualStudentRegistrationFormText, studentRegistrationFormText, "\nWrong registration text\n");
        softAssert.assertEquals(actualNameLabel, nameLabel, "\nWrong practice form text.\n");
        softAssert.assertEquals(actualFirstNamePlaceholder, firstNamePlaceholder, "\nWrong first placeholder.\n");
        softAssert.assertEquals(actualLastNamePlaceholder, lastNamePlaceholder, "\nWrong last placeholder.\n");
        softAssert.assertEquals(actualEmailLabel, emailLabel, "\nWrong email placeholder");
        softAssert.assertEquals(actualPlaceholderEmail, expectedPlaceholderEmail, "\nWrong email placeholder");
        softAssert.assertEquals(actualGenderLabel, genderLabel, "\nWrong gender placeholder.\n");
        softAssert.assertEquals(actualMaleRadioButtonText, expectedMaleRadioButtonText, "\nWrong male placeholder.\n");
        softAssert.assertEquals(actualFemaleRadioButtonText, expectedFemaleRadioButtonText, "\nWrong female placeholder.\n");
        softAssert.assertEquals(actualOtherRadioButtonText, otherRadioButtonText, "\nWrong other placeholder.\n");
        softAssert.assertEquals(actualMobileNumberLabel, expectedMobileNumberLabel, "\nWrong mobile number placeholder.\n");
        softAssert.assertEquals(actualMobileNumberPlaceholder, expectedMobileNumberPlaceholder, "\nWrong mobile number placeholder");
        softAssert.assertEquals(actualDateOfBirthLabel, expectedDateOfBirthLabel, "\nWrong date of birth label.\n");
        softAssert.assertEquals(actualDateOfBirthPlaceholder, expectedDateOfBirthPlaceholder, "\nWrong date of birth placeholder");
        softAssert.assertEquals(actualSubjectsLabel, expectedSubjectsLabel, "\nWrong subject placeholder.\n");
        softAssert.assertNull(actualSubjectsPlaceholder);
        softAssert.assertEquals(actualHobbiesLabel, expectedHobbiesLabel, "\nWrong hobbies placeholder.\n");
        softAssert.assertEquals(actualHobbySportText, expectedHobbySportText, "\nWrong hobby sport text.\n");
        softAssert.assertEquals(actualHobbyReadingText, expectedHobbyReadingText, "\nWrong hobby reading text.\n");
        softAssert.assertEquals(actualHobbyMusicText, expectedHobbyMusicText, "\nWrong hobby music text.\n");
        softAssert.assertEquals(actualPictureLabelText, expectedPictureLabelText, "\nWrong picture text.\n");
        softAssert.assertEquals(actualSelectPictureText, expectedSelectPictureText, "\nWrong select picture.\n");
        softAssert.assertEquals(actualCurrentAddressLabel, expectedCurrentAddressLabel, "\nWrong current address label");
        softAssert.assertEquals(actualCurrentAddressPlaceholder, expectedCurrentAddressPlaceholder, "\nWrong current address placeholder");
        softAssert.assertEquals(actualStateAndCityLabel, expectedStateAndCityLabel, "\nWrong state and City label");
        softAssert.assertEquals(actualSelectStatePlaceholder, expectedSelectStatePlaceholder, "\nWrong select state placeholder");
        softAssert.assertEquals(actualSelectCityPlaceholder, expectedSelectCityPlaceholder, "\nWrong select city placeholder");
        softAssert.assertEquals(actualSubmitButtonText, expectedSubmitButtonText, "\nWrong submit button text.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify three hobbies state")
    public void VerifyThreeHobbiesState() {
        navigateToUrl("automation-practice-form");

        practiceFormPage.clickSportHobbyCheckbox();
        practiceFormPage.clickMusicHobbyCheckbox();
        practiceFormPage.clickReadingHobbyCheckbox();
        practiceFormPage.unClickReadingHobbyCheckbox();

        boolean isReadingCheckBoxSelected = practiceFormPage.isReadingCheckBoxSelected();
        boolean isSportsCheckBoxSelected = practiceFormPage.isSportCheckBSelected();
        boolean isMusicCheckBoxSelected = practiceFormPage.isMusicCheckBoxSelected();

        softAssert.assertTrue(isSportsCheckBoxSelected, "\nSports checkbox is not unselected.\n");
        softAssert.assertFalse(isReadingCheckBoxSelected, "\nReading checkbox is not unselected.\n");
        softAssert.assertTrue(isMusicCheckBoxSelected, "\nMusic checkbox is not unselected.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Select there radio button for gender")
    public void SelectEveryRadioButton() {
        navigateToUrl("automation-practice-form");

        String genderFemale = "Female";
        practiceFormPage.clickGenderRadioButton(genderFemale);
        boolean isFemaleRadioButtonSelected = practiceFormPage.isFemaleRadioButtonSelected();

        String genderMale = "Male";
        practiceFormPage.clickGenderRadioButton(genderMale);
        boolean isMaleRadioButtonSelected = practiceFormPage.isMaleRadioButtonSelected();

        String genderOther = "Other";
        practiceFormPage.clickGenderRadioButton(genderOther);
        boolean isOtherRadioButtonSelected = practiceFormPage.isOtherRadioButtonSelected();

        softAssert.assertTrue(isFemaleRadioButtonSelected, "\nFemale radio button is not selected.\n");
        softAssert.assertTrue(isMaleRadioButtonSelected, "\nMale radio button is not selected.\n");
        softAssert.assertTrue(isOtherRadioButtonSelected, "\nOther radio button is not selected.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Submit valid practice form and verify")
    public void SubmitValidPracticeFormAndVerify() {
        navigateToUrl("automation-practice-form");

        String expectedFirstName = "Zhivko";
        String expectedLastName = "Petrov";
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

        practiceFormPage.setFirstName(expectedFirstName);
        practiceFormPage.setLastName(expectedLastName);
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

        softAssert.assertEquals(actualFullName, expectedFirstName + " " + expectedLastName, "\nWrong full name.\n");
        softAssert.assertEquals(actualEmail, expectedEmail, "\nWrong email address.\n");
        softAssert.assertEquals(actualGender, expectedGender, "\nWrong gender.\n");
        softAssert.assertEquals(actualMobile, expectedMobileNumber, "\nWrong mobile number.\n");
        softAssert.assertEquals(actualDaterOfBirth, expectedDateOfBirth, "Wrong date of birth.\n");
        softAssert.assertEquals(actualSubjects, expectedSubject, "\nWrong subjects.\n");
        softAssert.assertEquals(actualHobbies, expectedHobbies, "\nWrong hobbies.\n");
        softAssert.assertEquals(actualPicture, expectedPicture, "\nWrong name of picture.\n");
        softAssert.assertEquals(actualCurrentAddress, expectedCurrentAddress, "\nWrong current address.\n");
        softAssert.assertEquals(actualStateAndCity, expectedState + " " + expectedCity, "Wrong State and City.\n");
        softAssert.assertEquals(actualLabel, expectedLabel, "\nWrong label.\n");
        softAssert.assertEquals(actualValues, expectedValues, "\nWrong values.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click submit button on empty form And verify colors")
    public void ClickSubmitOnEmptyFormAndVerifyColors() {
        navigateToUrl("automation-practice-form");
        practiceFormPage.clickSubmitButton();

        String expectedRedColor = "rgb(220, 53, 69)";
        String expectedRedColorText = "rgba(220, 53, 69, 1)";
        String expectedGreenColor = "rgb(40, 167, 69)";
        String expectedGreenColorText = "rgba(40, 167, 69, 1)";

        String firstNameBorderColor = practiceFormPage.getColorOfFirstNameBorder(expectedRedColor);
        String lastNameBorderColor = practiceFormPage.getColorOfLastNameBorder(expectedRedColor);
        String emailBorderColor = practiceFormPage.getColorOfEmail();
        String maleGenderColor = practiceFormPage.getMaleGenderColor();
        String femaleGenderColor = practiceFormPage.getFemaleGenderColor();
        String otherGenderColor = practiceFormPage.getOtherGenderColor();
        String mobileBorderColor = practiceFormPage.getColorOfMobile(expectedRedColor);
        String dateOfBirth = practiceFormPage.getColorOfDateOfBirth();
        String sportColor = practiceFormPage.getHobbiesSportColor();
        String readingColor = practiceFormPage.getHobbiesReadingColor();
        String musicColor = practiceFormPage.getHobbiesMusicColor();
        String currentAddress = practiceFormPage.getCurrentAddressColor();

        softAssert.assertEquals(firstNameBorderColor, expectedRedColor, "\nWrong color.Expected Red \n");
        softAssert.assertEquals(lastNameBorderColor, expectedRedColor, "\nWrong color.Expected Red \n");
        softAssert.assertEquals(emailBorderColor, expectedGreenColor, "\nWrong color.Expected Green \n");
        softAssert.assertEquals(maleGenderColor, expectedRedColorText, "\nWrong color.Expected Red \n");
        softAssert.assertEquals(femaleGenderColor, expectedRedColorText, "\nWrong color.Expected Red \n");
        softAssert.assertEquals(otherGenderColor, expectedRedColorText, "\nWrong color.Expected Red \n");
        softAssert.assertEquals(mobileBorderColor, expectedRedColor, "\nWrong color.Expected Red \n");
        softAssert.assertEquals(dateOfBirth, expectedGreenColor, "\nWrong color.Expected Red \n");
        softAssert.assertEquals(sportColor, expectedGreenColorText, "\nWrong color.Expected Green \n");
        softAssert.assertEquals(readingColor, expectedGreenColorText, "\nWrong color.Expected Red \n");
        softAssert.assertEquals(musicColor, expectedGreenColorText, "\nWrong color.Expected Green \n");
        softAssert.assertEquals(currentAddress, expectedGreenColor, "\nWrong color.Expected Green \n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify colors change from red to green")
    public void VerifyColorsChangeFromRedToGreen() {
        navigateToUrl("automation-practice-form");
        practiceFormPage.clickSubmitButton();

        String expectedFirstName = "Zhivko";
        String expectedLastName = "Petrov";
        String expectedRedColor = "rgb(220, 53, 69)";
        String expectedRedColorText = "rgba(220, 53, 69, 1)";
        String expectedGreenColor = "rgb(40, 167, 69)";
        String expectedGreenColorText = "rgba(40, 167, 69, 1)";
        String expectedFemaleGender = "Female";
        String expectedMobileNumber = "1234567890";

        String firstNameBorderColorBefore = practiceFormPage.getColorOfFirstNameBorder(expectedRedColor);
        softAssert.assertEquals(firstNameBorderColorBefore, expectedRedColor, "\nWrong color.Expected Red.\n");
        practiceFormPage.setFirstName(expectedFirstName);

        String firstNameBorderColorAfter = practiceFormPage.getColorOfFirstNameBorder(expectedGreenColor);
        softAssert.assertEquals(firstNameBorderColorAfter, expectedGreenColor, "\nWrong color.Expected Green.\n");

        String lastNameBorderColorBefore = practiceFormPage.getColorOfLastNameBorder(expectedRedColor);
        softAssert.assertEquals(lastNameBorderColorBefore, expectedRedColor, "\nWrong color.Expected Red.\n");
        practiceFormPage.setLastName(expectedLastName);

        String lastNameBorderColorAfter = practiceFormPage.getColorOfLastNameBorder(expectedGreenColor);
        softAssert.assertEquals(lastNameBorderColorAfter, expectedGreenColor, "\nWrong color.Expected Green.\n");

        String femaleGenderColorBefore = practiceFormPage.getFemaleGenderColor();
        softAssert.assertEquals(femaleGenderColorBefore, expectedRedColorText, "\nWrong color.Expected Red.\n");
        practiceFormPage.clickGenderRadioButton(expectedFemaleGender);

        String femaleGenderColorAfter = practiceFormPage.getFemaleGenderColor();
        softAssert.assertEquals(femaleGenderColorAfter, expectedGreenColorText, "\nWrong color.Expected Green.\n");

        String mobileBorderColorBefore = practiceFormPage.getColorOfMobile(expectedRedColor);
        softAssert.assertEquals(mobileBorderColorBefore, expectedRedColor, "\nWrong color.Expected Red.\n");
        practiceFormPage.setMobile(expectedMobileNumber);

        String mobileBorderColorAfter = practiceFormPage.getColorOfMobile(expectedGreenColor);
        softAssert.assertEquals(mobileBorderColorAfter, expectedGreenColor, "\nWrong color.Expected Green.\n");

        softAssert.assertAll();
    }
}
