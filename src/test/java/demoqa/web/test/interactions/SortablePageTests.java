package demoqa.web.test.interactions;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortablePageTests extends BaseTest {
    @Test(enabled = true)
    public void VerifyAllTextOnPage() {
        navigateToUrl("sortable");

        String pageTitle = "Sortable";
        String listTab = "List";
        String listOne = "One";
        String listTwo = "Two";
        String listThree = "Three";
        String listFour = "Four";
        String listFive = "Five";
        String listSix = "Six";
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

        String actualPageTitle = sortablePage.getPageTitle();
        String actualListTab = sortablePage.getListTab();
        String actualListOne = sortablePage.getListOne();
        String actualListTwo = sortablePage.getListTwo();
        String actualListThree = sortablePage.getListThree();
        String actualListFour = sortablePage.getListFour();
        String actualListFive = sortablePage.getListFive();
        String actualListSix = sortablePage.getListSix();
        sortablePage.clickGridTab();
        String actualGridTab = sortablePage.getGridTab();
        String actualGridOne = sortablePage.getGridOne();
        String actualGridTwo = sortablePage.getGridTwo();
        String actualGridThree = sortablePage.getGridThree();
        String actualGridFour = sortablePage.getGridFour();
        String actualGridFive = sortablePage.getGridFive();
        String actualGridSix = sortablePage.getGridSix();
        String actualGridSeven = sortablePage.getGridSeven();
        String actualGridEight = sortablePage.getGridEight();
        String actualGridNine = sortablePage.getGridNine();

        softAssert.assertEquals(actualPageTitle, pageTitle, "\nWrong page title.\n");
        softAssert.assertEquals(actualListTab, listTab, "\nWrong page tab.\n");
        softAssert.assertEquals(actualListOne, listOne, "Wrong page one");
        softAssert.assertEquals(actualListTwo, listTwo, "Wrong page two");
        softAssert.assertEquals(actualListThree, listThree, "Wrong page three");
        softAssert.assertEquals(actualListFour, listFour, "Wrong page four");
        softAssert.assertEquals(actualListFive, listFive, "Wrong page five");
        softAssert.assertEquals(actualListSix, listSix, "Wrong page six");
        softAssert.assertEquals(actualGridTab, gridTab, "Wrong page tab");
        softAssert.assertEquals(actualGridOne, gridOne, "Wrong page one");
        softAssert.assertEquals(actualGridTwo, gridTwo, "Wrong page two");
        softAssert.assertEquals(actualGridThree, gridThree, "Wrong page three");
        softAssert.assertEquals(actualGridFour, gridFour, "Wrong page four");
        softAssert.assertEquals(actualGridFive, gridFive, "Wrong page five");
        softAssert.assertEquals(actualGridSix, gridSix, "Wrong page six");
        softAssert.assertEquals(actualGridSeven, gridSeven, "\nWrong page seven.\n");
        softAssert.assertEquals(actualGridEight, gridEight, "\nWrong page eight.\n");
        softAssert.assertEquals(actualGridNine, gridNine, "\nWrong page nine.\n");

        softAssert.assertAll();
    }

    @DataProvider(name = "resizeData")
    public Object[][] resizeDataProvider() {
        return new Object[][]{
                {"One", "Six", """
                Two
                Three
                Four
                Five
                Six
                One"""},
                {"Two", "Six", """
                One
                Three
                Four
                Five
                Six
                Two"""},
                {"Three", "Six", """
                One
                Two
                Four
                Five
                Six
                Three"""},
                {"Four", "Six", """
                One
                Two
                Three
                Five
                Six
                Four"""},
                {"Five", "Six", """
                One
                Two
                Three
                Four
                Six
                Five"""},
                {"Six", "One", """
                Six
                One
                Two
                Three
                Four
                Five"""},

        };
    }

    @Test(dataProvider = "resizeData", description = "Check order in List", enabled = true)
    public void DragAndDropFromListTab(String dragFromPlace, String dropOnPlace, String expectedOrder) {
        navigateToUrl("sortable");

        sortablePage.moveOverList(dragFromPlace, dropOnPlace);
        String actualListSix = sortablePage.getListOrder();

        Assert.assertEquals(actualListSix, expectedOrder, "\nWrong order in the list.\n");
    }

    @DataProvider(name = "resizeData2")
    public Object[][] resizeDataProvider2() {
        return new Object[][]{
                {"One", "Nine", """
                Two
                Three
                Four
                Five
                Six
                Seven
                Eight
                Nine
                One"""},
                {"Two", "Nine", """
                One
                Three
                Four
                Five
                Six
                Seven
                Eight
                Nine
                Two"""},
                {"Three", "Nine", """
                One
                Two
                Four
                Five
                Six
                Seven
                Eight
                Nine
                Three"""},
                {"Four", "Nine", """
                One
                Two
                Three
                Five
                Six
                Seven
                Eight
                Nine
                Four"""},
                {"Five", "Nine", """
                One
                Two
                Three
                Four
                Six
                Seven
                Eight
                Nine
                Five"""},
                {"Six", "Nine", """
                One
                Two
                Three
                Four
                Five
                Seven
                Eight
                Nine
                Six"""},
                {"Seven", "Nine", """
                One
                Two
                Three
                Four
                Five
                Six
                Eight
                Nine
                Seven"""},
                {"Eight", "Nine", """
                One
                Two
                Three
                Four
                Five
                Six
                Seven
                Nine
                Eight"""},
                {"Nine", "One", """
                Nine
                One
                Two
                Three
                Four
                Five
                Six
                Seven
                Eight"""},
        };
    }

    @Test(dataProvider = "resizeData2", description = "Check order in Grid", enabled = true)
    public void DragAndDropFromGridTab(String dragFromPlace, String dropOnPlace, String expectedOrder) {
        navigateToUrl("sortable");
        sortablePage.clickGridTab();

        sortablePage.moveOverGrid(dragFromPlace, dropOnPlace);
        String actualListSix = sortablePage.getGridOrder();

        Assert.assertEquals(actualListSix, expectedOrder, "\nWrong order in the grid.\n");
    }
}
