package part3.comdemoqa.tests.forms;

import com.pages.demo.pages.forms.PracticeFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class PracticeFormsTests extends BaseTest {

    @Test
    public void SelectTwoCheckBoxes() {
        PracticeFormPage formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickSportHobbyCheckbox();
        formsPage.clickMusicHobbyCheckbox();
        formsPage.clickReadingHobbyCheckbox();
        formsPage.unClickReadingHobbyCheckbox();

        boolean isReadingCheckBoxSelected = formsPage.isReadingCheckBoxSelected();
        boolean isSportsCheckBoxSelected = formsPage.isSportCheckBSelected();
        boolean isMusicCheckBoxSelected = formsPage.isMusicCheckBoxSelected();

        Assert.assertTrue(isSportsCheckBoxSelected, "\n Sports checkbox is not unselected \n");
        Assert.assertFalse(isReadingCheckBoxSelected, "\n Reading checkbox is not unselected \n");
        Assert.assertTrue(isMusicCheckBoxSelected, "\n Music checkbox is not unselected \n");
    }

    @Test
    public void SelectFemaleRadioButton() {
        String gender = "Female";
        PracticeFormPage formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickGenderRadioButton(gender);

        boolean isFemaleRadioButtonSelected = formsPage.isFemaleRadioButtonSelected();
        Assert.assertTrue(isFemaleRadioButtonSelected, "\n Female radio button is not selected \n");
    }

    @Test
    public void SelectMaleRadioButton() {
        String gender = "Male";
        PracticeFormPage formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickGenderRadioButton(gender);

        boolean isMaleRadioButtonSelected = formsPage.isМaleRadioButtonSelected();
        Assert.assertTrue(isMaleRadioButtonSelected, "\n Male radio button is not selected \n");
    }

    @Test
    public void SelectOtherRadioButton() {
        String gender = "Other";
        PracticeFormPage formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickGenderRadioButton(gender);

        boolean isOtherRadioButtonSelected = formsPage.isOtherRadioButtonSelected();
        Assert.assertTrue(isOtherRadioButtonSelected, "\n Other radio button is not selected \n");
    }

    @Test
    public void ClickSubmitButton() {
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

        PracticeFormPage practiceFormPage = homePage.goToForms().clickPracticeForm();

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
