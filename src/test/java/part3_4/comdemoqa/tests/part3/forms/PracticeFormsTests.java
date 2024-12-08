package part3_4.comdemoqa.tests.part3.forms;

import com.pages.demo.pages.forms.PracticeFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

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
    public void clickSubmit() throws InterruptedException {
        String firstName = "Zhivko";
        String lastName = "Petrov";
        String expectedEmail = "karma@gmail.com";
        String gender = "Female";
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

        PracticeFormPage formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.setFirstName(firstName);
        formsPage.setLastName(lastName);
        formsPage.setEmail(expectedEmail);
        formsPage.clickGenderRadioButton(gender);
        formsPage.setMobile(expectedMobileNumber);
        formsPage.setSubject(expectedSubject);
        formsPage.clickSportHobbyCheckbox();
        formsPage.setCurrentAddress(expectedCurrentAddress);
        // formsPage.setDropDown(expectedState);
        // formsPage.selectCity(city);
        formsPage.clickSubmitButton();

        String actualFullName = formsPage.getStudentNameFromModal();
        String actualEmail = formsPage.getEmailFromModal();
        String actualGender = formsPage.getGenderFromModal();
        String actualMobile = formsPage.getMobileFromModal();
        String actualDaterOfBirth = formsPage.getDateOfBirthFromModal();
        String actualSubjects = formsPage.getSubjectsFromModal();
        String actualHobbies = formsPage.getHobbiesFromModal();
        String actualPicture = formsPage.getPictureFromModal();
        String actualCurrentAddress = formsPage.getCurrentAddressFromModal();
        String actualStateAndCity = formsPage.getStateAndCityFromModal();
        String actualLabel = formsPage.getLabelFromModal();
        String actualValues = formsPage.getValuesFromModal();

        Assert.assertEquals(actualFullName, firstName + " " + lastName);
        Assert.assertEquals(actualEmail, expectedEmail);
        Assert.assertEquals(actualGender, "Female");
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
