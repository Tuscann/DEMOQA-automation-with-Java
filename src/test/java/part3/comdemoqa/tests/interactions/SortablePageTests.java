package part3.comdemoqa.tests.interactions;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class SortablePageTests extends BaseTest {
    @Test
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

        Assert.assertEquals(actualPageTitle, pageTitle, "Wrong page title");
        Assert.assertEquals(actualListTab, listTab, "Wrong page tab");
        Assert.assertEquals(actualListOne, listOne, "Wrong page one");
        Assert.assertEquals(actualListTwo, listTwo, "Wrong page two");
        Assert.assertEquals(actualListThree, listThree, "Wrong page three");
        Assert.assertEquals(actualListFour, listFour, "Wrong page four");
        Assert.assertEquals(actualListFive, listFive, "Wrong page five");
        Assert.assertEquals(actualListSix, listSix, "Wrong page six");
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
}
