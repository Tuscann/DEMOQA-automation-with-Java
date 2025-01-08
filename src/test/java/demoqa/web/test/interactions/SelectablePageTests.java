package demoqa.web.test.interactions;


import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectablePageTests extends BaseTest {
    @Test(enabled = true)
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

        Assert.assertEquals(actualPageTitle, pageTitle, "\nWrong page title.\n");
        Assert.assertEquals(actualListTab, listTab, "\nWrong page tab name. \n");
        Assert.assertEquals(actualListFirstText, listFirstText, "\nWrong page one.\n");
        Assert.assertEquals(actualListSecondText, listSecondText, "\nWrong page two.\n");
        Assert.assertEquals(actualListThirdText, listThirdText, "Wrong page three");
        Assert.assertEquals(actualListFourText, listFourText, "Wrong page four");
        Assert.assertEquals(actualGridTab, gridTab, "Wrong page tab");
        Assert.assertEquals(actualGridOne, gridOne, "Wrong page one");
        Assert.assertEquals(actualGridTwo, gridTwo, "Wrong page two");
        Assert.assertEquals(actualGridThree, gridThree, "Wrong page three");
        Assert.assertEquals(actualGridFour, gridFour, "Wrong page four");
        Assert.assertEquals(actualGridFive, gridFive, "Wrong page five");
        Assert.assertEquals(actualGridSix, gridSix, "Wrong page six");
        Assert.assertEquals(actualGridSeven, gridSeven, "Wrong page seven");
        Assert.assertEquals(actualGridEight, gridEight, "Wrong page eight");
        Assert.assertEquals(actualGridNine, gridNine, "Wrong page nine");
    }

    @Test(enabled = true)
    public void SelectOneByOneAllFromList() {
        navigateToUrl("selectable");

        String searched1Selection = "Cras justo odio";
        boolean isRowSelected = selectablePage.RowSelected(searched1Selection);
        Assert.assertFalse(isRowSelected, "\nFirst row is selected.\n");
        int position = 0;
        selectablePage.clickElement(position);
        isRowSelected = selectablePage.RowSelected(searched1Selection);
        Assert.assertTrue(isRowSelected, "\nFirst row is not selected.\n");

        String searched2Selection = "Dapibus ac facilisis in";
        isRowSelected = selectablePage.RowSelected(searched2Selection);
        Assert.assertFalse(isRowSelected, "\nSecond row is selected.\n");
        position = 1;
        selectablePage.clickElement(position);
        isRowSelected = selectablePage.RowSelected(searched2Selection);
        Assert.assertTrue(isRowSelected, "\nSecond row is not selected.\n");

        String searched3Selection = "Morbi leo risus";
        isRowSelected = selectablePage.RowSelected(searched3Selection);
        Assert.assertFalse(isRowSelected, "\nThird row is selected.\n");
        position = 2;
        selectablePage.clickElement(position);
        isRowSelected = selectablePage.RowSelected(searched3Selection);
        Assert.assertTrue(isRowSelected, "\nThird row is not selected.\n");

        String searched4Selection = "Porta ac consectetur ac";
        isRowSelected = selectablePage.RowSelected(searched4Selection);
        Assert.assertFalse(isRowSelected, "\nFour row is selected.\n");
        position = 3;
        selectablePage.clickElement(position);
        isRowSelected = selectablePage.RowSelected(searched4Selection);
        Assert.assertTrue(isRowSelected, "\nFour row is not selected.\n");
    }

    @Test(enabled = true)
    public void SelectOneByOneAllFromGrid() {
        navigateToUrl("selectable");
        selectablePage.clickGridTab();

        String searched1Selection;
        boolean isSelected;
        for (int i = 0; i < 9; i++) {
            if (i == 0) {
                searched1Selection = "One";
            } else if (i == 1) {
                searched1Selection = "Two";
            } else if (i == 2) {
                searched1Selection = "Three";
            } else if (i == 3) {
                searched1Selection = "Four";
            } else if (i == 4) {
                searched1Selection = "Five";
            } else if (i == 5) {
                searched1Selection = "Six";
            } else if (i == 6) {
                searched1Selection = "Seven";
            } else if (i == 7) {
                searched1Selection = "Eight";
            } else {
                searched1Selection = "Nine";
            }

            selectablePage.selectPositionFromGrid(searched1Selection);
            isSelected = selectablePage.isPositionFromGridSelected(searched1Selection);
            Assert.assertTrue(isSelected, searched1Selection + " is not selected.\n");
        }
    }
}
