package demoqa.web.tests.interactions;


import demoqa.web.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectablePageTests extends BaseTest {
    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        navigateToUrl("selectable");

        String pageTitle = "Selectable";
        String listTab = "List";
        String listFirstText = "Cras justo odio";
        String listSecondText = "Dapibus ac facilisis in";
        String listThirdText = "Morbi leo risus";
        String listFourText = "Porta ac consectetur ac";
        String gridTab = "Grid";
        String gridOne = "One";
        String gridTwo = "Two";
        String gridThree = "Three";
        String gridFour = "Four";
        String gridFive = "Five";
        String gridSix = "Six";
        String gridSeven = "Seven";
        String gridEight = "Eight";
        String gridNine = "Nine";

        String actualPageTitle = selectablePage.getPageTitleText();
        String actualListTab = selectablePage.getListTabText();
        String actualListFirstText = selectablePage.getListFirstText();
        String actualListSecondText = selectablePage.getListSecondText();
        String actualListThirdText = selectablePage.getListThirdText();
        String actualListFourText = selectablePage.getListFourText();
        selectablePage.clickGridTab();
        String actualGridTab = selectablePage.getGridText();
        String actualGridOne = selectablePage.getGridOneText();
        String actualGridTwo = selectablePage.getGridTwoText();
        String actualGridThree = selectablePage.getGridThreeText();
        String actualGridFour = selectablePage.getGridFourText();
        String actualGridFive = selectablePage.getGridFive();
        String actualGridSix = selectablePage.getGridSix();
        String actualGridSeven = selectablePage.getGridSeven();
        String actualGridEight = selectablePage.getGridEight();
        String actualGridNine = selectablePage.getGridNine();

        softAssert.assertEquals(actualPageTitle, pageTitle, "\nWrong page title.\n");
        softAssert.assertEquals(actualListTab, listTab, "\nWrong page tab name. \n");
        softAssert.assertEquals(actualListFirstText, listFirstText, "\nWrong page one.\n");
        softAssert.assertEquals(actualListSecondText, listSecondText, "\nWrong page two.\n");
        softAssert.assertEquals(actualListThirdText, listThirdText, "\nWrong page three.\n");
        softAssert.assertEquals(actualListFourText, listFourText, "\nWrong page four.\n");
        softAssert.assertEquals(actualGridTab, gridTab, "\nWrong page tab.\n");
        softAssert.assertEquals(actualGridOne, gridOne, "\nWrong page one.\n");
        softAssert.assertEquals(actualGridTwo, gridTwo, "\nWrong page two.\n");
        softAssert.assertEquals(actualGridThree, gridThree, "\nWrong page three.\n");
        softAssert.assertEquals(actualGridFour, gridFour, "\nWrong page four.\n");
        softAssert.assertEquals(actualGridFive, gridFive, "\nWrong page five.\n");
        softAssert.assertEquals(actualGridSix, gridSix, "\nWrong page six.\n");
        softAssert.assertEquals(actualGridSeven, gridSeven, "\nWrong page seven.\n");
        softAssert.assertEquals(actualGridEight, gridEight, "\nWrong page eight.\n");
        softAssert.assertEquals(actualGridNine, gridNine, "\nWrong page nine.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Select one by one all from list")
    public void SelectOneByOneAllFromList() {
        navigateToUrl("selectable");

        String searched1Selection = "Cras justo odio";
        boolean isRowSelected = selectablePage.RowSelected(searched1Selection);
        softAssert.assertFalse(isRowSelected, "\nFirst row is selected.\n");
        int position = 0;
        selectablePage.clickElement(position);
        isRowSelected = selectablePage.RowSelected(searched1Selection);
        softAssert.assertTrue(isRowSelected, "\nFirst row is not selected.\n");

        String searched2Selection = "Dapibus ac facilisis in";
        isRowSelected = selectablePage.RowSelected(searched2Selection);
        softAssert.assertFalse(isRowSelected, "\nSecond row is selected.\n");
        position = 1;
        selectablePage.clickElement(position);
        isRowSelected = selectablePage.RowSelected(searched2Selection);
        softAssert.assertTrue(isRowSelected, "\nSecond row is not selected.\n");

        String searched3Selection = "Morbi leo risus";
        isRowSelected = selectablePage.RowSelected(searched3Selection);
        softAssert.assertFalse(isRowSelected, "\nThird row is selected.\n");
        position = 2;
        selectablePage.clickElement(position);
        isRowSelected = selectablePage.RowSelected(searched3Selection);
        softAssert.assertTrue(isRowSelected, "\nThird row is not selected.\n");

        String searched4Selection = "Porta ac consectetur ac";
        isRowSelected = selectablePage.RowSelected(searched4Selection);
        softAssert.assertFalse(isRowSelected, "\nFour row is selected.\n");
        position = 3;
        selectablePage.clickElement(position);
        isRowSelected = selectablePage.RowSelected(searched4Selection);
        softAssert.assertTrue(isRowSelected, "\nFour row is not selected.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Select one by one all from grid")
    public void SelectOneByOneAllFromGrid() {
        navigateToUrl("selectable");
        selectablePage.clickGridTab();

        String searched1Selection;
        boolean isSelected;
        for (int i = 0; i < 9; i++) {
            searched1Selection = switch (i) {
                case 0 -> "One";
                case 1 -> "Two";
                case 2 -> "Three";
                case 3 -> "Four";
                case 4 -> "Five";
                case 5 -> "Six";
                case 6 -> "Seven";
                case 7 -> "Eight";
                case 8 -> "Nine";
                default -> "Error";
            };

            selectablePage.selectPositionFromGrid(searched1Selection);
            isSelected = selectablePage.isPositionFromGridSelected(searched1Selection);
            Assert.assertTrue(isSelected, searched1Selection + " is not selected.\n");
        }
    }
}
