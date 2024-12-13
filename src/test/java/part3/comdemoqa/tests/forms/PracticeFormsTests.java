package part3.comdemoqa.tests.forms;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeFormsTests extends FormsTest {

    @Test
    public void verifyCheckBoxesState() {
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

        boolean isMaleRadioButtonSelected = practiceFormPage.isМaleRadioButtonSelected();
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
        String expectedDateOfBirth = "08 December,2024";
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
        practiceFormPage.setDateOfBirth(expectedDateOfBirth);
        practiceFormPage.setSubject(expectedSubject);
        practiceFormPage.clickSportHobbyCheckbox();
        practiceFormPage.setCurrentAddress(expectedCurrentAddress);
        // formsPage.setDropDown(expectedState);
        // formsPage.selectCity(city);
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
}
