package demoqa.web.test.forms;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PracticeFormPageTests extends BaseTest {
    @Test(enabled = true)
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

        Assert.assertEquals(actualPracticeFromText, practiceFromText, "\nWrong practice form text\n");
        Assert.assertEquals(actualStudentRegistrationFormText, studentRegistrationFormText, "\nWrong registration text\n");
        Assert.assertEquals(actualNameLabel, nameLabel, "\nWrong practice form text.\n");
        Assert.assertEquals(actualFirstNamePlaceholder, firstNamePlaceholder, "\nWrong first placeholder.\n");
        Assert.assertEquals(actualLastNamePlaceholder, lastNamePlaceholder, "\nWrong last placeholder.\n");
        Assert.assertEquals(actualEmailLabel, emailLabel, "\nWrong email placeholder");
        Assert.assertEquals(actualPlaceholderEmail, expectedPlaceholderEmail, "\nWrong email placeholder");
        Assert.assertEquals(actualGenderLabel, genderLabel, "\nWrong gender placeholder.\n");
        Assert.assertEquals(actualMaleRadioButtonText, expectedMaleRadioButtonText, "\nWrong male placeholder.\n");
        Assert.assertEquals(actualFemaleRadioButtonText, expectedFemaleRadioButtonText, "\nWrong female placeholder.\n");
        Assert.assertEquals(actualOtherRadioButtonText, otherRadioButtonText, "\nWrong other placeholder.\n");
        Assert.assertEquals(actualMobileNumberLabel, expectedMobileNumberLabel, "\nWrong mobile number placeholder.\n");
        Assert.assertEquals(actualMobileNumberPlaceholder, expectedMobileNumberPlaceholder, "\nWrong mobile number placeholder");
        Assert.assertEquals(actualDateOfBirthLabel, expectedDateOfBirthLabel, "\nWrong date of birth label.\n");
        Assert.assertEquals(actualDateOfBirthPlaceholder, expectedDateOfBirthPlaceholder, "\nWrong date of birth placeholder");
        Assert.assertEquals(actualSubjectsLabel, expectedSubjectsLabel, "\nWrong subject placeholder.\n");
        Assert.assertNull(actualSubjectsPlaceholder);
        Assert.assertEquals(actualHobbiesLabel, expectedHobbiesLabel, "\nWrong hobbies placeholder.\n");
        Assert.assertEquals(actualHobbySportText, expectedHobbySportText, "\nWrong hobby sport text.\n");
        Assert.assertEquals(actualHobbyReadingText, expectedHobbyReadingText, "\nWrong hobby reading text.\n");
        Assert.assertEquals(actualHobbyMusicText, expectedHobbyMusicText, "\nWrong hobby music text.\n");
        Assert.assertEquals(actualPictureLabelText, expectedPictureLabelText, "\nWrong picture text.\n");
        Assert.assertEquals(actualSelectPictureText, expectedSelectPictureText, "\nWrong select picture.\n");
        Assert.assertEquals(actualCurrentAddressLabel, expectedCurrentAddressLabel, "\nWrong current address label");
        Assert.assertEquals(actualCurrentAddressPlaceholder, expectedCurrentAddressPlaceholder, "\nWrong current address placeholder");
        Assert.assertEquals(actualStateAndCityLabel, expectedStateAndCityLabel, "\nWrong state and City label");
        Assert.assertEquals(actualSelectStatePlaceholder, expectedSelectStatePlaceholder, "\nWrong select state placeholder");
        Assert.assertEquals(actualSelectCityPlaceholder, expectedSelectCityPlaceholder, "\nWrong select city placeholder");
        Assert.assertEquals(actualSubmitButtonText, expectedSubmitButtonText, "\nWrong submit button text.\n");
    }

    @Test(enabled = true)
    public void VerifyThreeHobbiesState() {
        navigateToUrl("automation-practice-form");

        practiceFormPage.clickSportHobbyCheckbox();
        practiceFormPage.clickMusicHobbyCheckbox();
        practiceFormPage.clickReadingHobbyCheckbox();
        practiceFormPage.unClickReadingHobbyCheckbox();

        boolean isReadingCheckBoxSelected = practiceFormPage.isReadingCheckBoxSelected();
        boolean isSportsCheckBoxSelected = practiceFormPage.isSportCheckBSelected();
        boolean isMusicCheckBoxSelected = practiceFormPage.isMusicCheckBoxSelected();

        Assert.assertTrue(isSportsCheckBoxSelected, "\nSports checkbox is not unselected.\n");
        Assert.assertFalse(isReadingCheckBoxSelected, "\nReading checkbox is not unselected.\n");
        Assert.assertTrue(isMusicCheckBoxSelected, "\nMusic checkbox is not unselected.\n");
    }

    @Test(enabled = true)
    public void SelectEveryRadioButton() {
        navigateToUrl("automation-practice-form");
        String gender = "Female";
        practiceFormPage.clickGenderRadioButton(gender);

        boolean isFemaleRadioButtonSelected = practiceFormPage.isFemaleRadioButtonSelected();
        Assert.assertTrue(isFemaleRadioButtonSelected, "\nFemale radio button is not selected.\n");

        gender = "Male";
        practiceFormPage.clickGenderRadioButton(gender);

        boolean isMaleRadioButtonSelected = practiceFormPage.isMaleRadioButtonSelected();
        Assert.assertTrue(isMaleRadioButtonSelected, "\nMale radio button is not selected.\n");

        gender = "Other";
        practiceFormPage.clickGenderRadioButton(gender);

        boolean isOtherRadioButtonSelected = practiceFormPage.isOtherRadioButtonSelected();
        Assert.assertTrue(isOtherRadioButtonSelected, "\nOther radio button is not selected.\n");
    }

    @Test(enabled = true)
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

        Assert.assertEquals(actualFullName, expectedFirstName + " " + expectedLastName, "\nWrong full name.\n");
        Assert.assertEquals(actualEmail, expectedEmail, "\nWrong email address.\n");
        Assert.assertEquals(actualGender, expectedGender, "\nWrong gender.\n");
        Assert.assertEquals(actualMobile, expectedMobileNumber, "\nWrong mobile number.\n");
        Assert.assertEquals(actualDaterOfBirth, expectedDateOfBirth, "Wrong date of birth.\n");
        Assert.assertEquals(actualSubjects, expectedSubject, "\nWrong subjects.\n");
        Assert.assertEquals(actualHobbies, expectedHobbies, "\nWrong hobbies.\n");
        Assert.assertEquals(actualPicture, expectedPicture, "\nWrong name of picture.\n");
        Assert.assertEquals(actualCurrentAddress, expectedCurrentAddress, "\nWrong current address.\n");
        Assert.assertEquals(actualStateAndCity, expectedState + " " + expectedCity, "Wrong State and City.\n");
        Assert.assertEquals(actualLabel, expectedLabel, "\nWrong label.\n");
        Assert.assertEquals(actualValues, expectedValues, "\nWrong values.\n");
    }

    @Test(enabled = true)
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

        Assert.assertEquals(firstNameBorderColor, expectedRedColor, "\nWrong color.Expected Red \n");
        Assert.assertEquals(lastNameBorderColor, expectedRedColor, "\nWrong color.Expected Red \n");
        Assert.assertEquals(emailBorderColor, expectedGreenColor, "\nWrong color.Expected Green \n");
        Assert.assertEquals(maleGenderColor, expectedRedColorText, "\nWrong color.Expected Red \n");
        Assert.assertEquals(femaleGenderColor, expectedRedColorText, "\nWrong color.Expected Red \n");
        Assert.assertEquals(otherGenderColor, expectedRedColorText, "\nWrong color.Expected Red \n");
        Assert.assertEquals(mobileBorderColor, expectedRedColor, "\nWrong color.Expected Red \n");
        Assert.assertEquals(dateOfBirth, expectedGreenColor, "\nWrong color.Expected Red \n");
        Assert.assertEquals(sportColor, expectedGreenColorText, "\nWrong color.Expected Green \n");
        Assert.assertEquals(readingColor, expectedGreenColorText, "\nWrong color.Expected Red \n");
        Assert.assertEquals(musicColor, expectedGreenColorText, "\nWrong color.Expected Green \n");
        Assert.assertEquals(currentAddress, expectedGreenColor, "\nWrong color.Expected Green \n");
    }

    @Test(enabled = true)
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
        Assert.assertEquals(firstNameBorderColorBefore, expectedRedColor, "\nWrong color.Expected Red.\n");
        practiceFormPage.setFirstName(expectedFirstName);

        String firstNameBorderColorAfter = practiceFormPage.getColorOfFirstNameBorder(expectedGreenColor);
        Assert.assertEquals(firstNameBorderColorAfter, expectedGreenColor, "\nWrong color.Expected Green.\n");

        String lastNameBorderColorBefore = practiceFormPage.getColorOfLastNameBorder(expectedRedColor);
        Assert.assertEquals(lastNameBorderColorBefore, expectedRedColor, "\nWrong color.Expected Red.\n");
        practiceFormPage.setLastName(expectedLastName);

        String lastNameBorderColorAfter = practiceFormPage.getColorOfLastNameBorder(expectedGreenColor);
        Assert.assertEquals(lastNameBorderColorAfter, expectedGreenColor, "\nWrong color.Expected Green.\n");

        String femaleGenderColorBefore = practiceFormPage.getFemaleGenderColor();
        Assert.assertEquals(femaleGenderColorBefore, expectedRedColorText, "\nWrong color.Expected Red.\n");
        practiceFormPage.clickGenderRadioButton(expectedFemaleGender);

        String femaleGenderColorAfter = practiceFormPage.getFemaleGenderColor();
        Assert.assertEquals(femaleGenderColorAfter, expectedGreenColorText, "\nWrong color.Expected Green.\n");

        String mobileBorderColorBefore = practiceFormPage.getColorOfMobile(expectedRedColor);
        Assert.assertEquals(mobileBorderColorBefore, expectedRedColor, "\nWrong color.Expected Red.\n");
        practiceFormPage.setMobile(expectedMobileNumber);

        String mobileBorderColorAfter = practiceFormPage.getColorOfMobile(expectedGreenColor);
        Assert.assertEquals(mobileBorderColorAfter, expectedGreenColor, "\nWrong color.Expected Green.\n");
    }
}
