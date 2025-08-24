package demoqa.web.tests.interactions;

import demoqa.pages.interactions.SortablePage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortablePageTests extends BaseTest {
    // Text Constants
    private static final String PAGE_TITLE = "Sortable";
    private static final String LIST_TAB = "List";
    private static final String LIST_ONE = "One";
    private static final String LIST_TWO = "Two";
    private static final String LIST_THREE = "Three";
    private static final String LIST_FOUR = "Four";
    private static final String LIST_FIVE = "Five";
    private static final String LIST_SIX = "Six";
    private static final String GRID_TAB = "Grid";
    private static final String GRID_ONE = "One";
    private static final String GRID_TWO = "Two";
    private static final String GRID_THREE = "Three";
    private static final String GRID_FOUR = "Four";
    private static final String GRID_FIVE = "Five";
    private static final String GRID_SIX = "Six";
    private static final String GRID_SEVEN = "Seven";
    private static final String GRID_EIGHT = "Eight";
    private static final String GRID_NINE = "Nine";

    // Error Message Constants
    private static final String PAGE_TITLE_ERROR = "Page title mismatch";
    private static final String LIST_TAB_ERROR = "List tab name mismatch";
    private static final String LIST_ONE_ERROR = "List one text mismatch";
    private static final String LIST_TWO_ERROR = "List two text mismatch";
    private static final String LIST_THREE_ERROR = "List three text mismatch";
    private static final String LIST_FOUR_ERROR = "List four text mismatch";
    private static final String LIST_FIVE_ERROR = "List five text mismatch";
    private static final String LIST_SIX_ERROR = "List six text mismatch";
    private static final String GRID_TAB_ERROR = "Grid tab name mismatch";
    private static final String GRID_ONE_ERROR = "Grid one text mismatch";
    private static final String GRID_TWO_ERROR = "Grid two text mismatch";
    private static final String GRID_THREE_ERROR = "Grid three text mismatch";
    private static final String GRID_FOUR_ERROR = "Grid four text mismatch";
    private static final String GRID_FIVE_ERROR = "Grid five text mismatch";
    private static final String GRID_SIX_ERROR = "Grid six text mismatch";
    private static final String GRID_SEVEN_ERROR = "Grid seven text mismatch";
    private static final String GRID_EIGHT_ERROR = "Grid eight text mismatch";
    private static final String GRID_NINE_ERROR = "Grid nine text mismatch";
    private static final String LIST_ORDER_ERROR = "Wrong order in the list";
    private static final String GRID_ORDER_ERROR = "Wrong order in the grid";

    public static final String SORTABLE_URL = "sortable";
    private SortablePage sortablePage;

    @BeforeMethod
    public void goToSortablePage() {
        navigateToUrl(SORTABLE_URL);
        sortablePage = new SortablePage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange & Act
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

        // Assert
        softAssert.assertEquals(actualPageTitle, PAGE_TITLE, PAGE_TITLE_ERROR);
        softAssert.assertEquals(actualListTab, LIST_TAB, LIST_TAB_ERROR);
        softAssert.assertEquals(actualListOne, LIST_ONE, LIST_ONE_ERROR);
        softAssert.assertEquals(actualListTwo, LIST_TWO, LIST_TWO_ERROR);
        softAssert.assertEquals(actualListThree, LIST_THREE, LIST_THREE_ERROR);
        softAssert.assertEquals(actualListFour, LIST_FOUR, LIST_FOUR_ERROR);
        softAssert.assertEquals(actualListFive, LIST_FIVE, LIST_FIVE_ERROR);
        softAssert.assertEquals(actualListSix, LIST_SIX, LIST_SIX_ERROR);
        softAssert.assertEquals(actualGridTab, GRID_TAB, GRID_TAB_ERROR);
        softAssert.assertEquals(actualGridOne, GRID_ONE, GRID_ONE_ERROR);
        softAssert.assertEquals(actualGridTwo, GRID_TWO, GRID_TWO_ERROR);
        softAssert.assertEquals(actualGridThree, GRID_THREE, GRID_THREE_ERROR);
        softAssert.assertEquals(actualGridFour, GRID_FOUR, GRID_FOUR_ERROR);
        softAssert.assertEquals(actualGridFive, GRID_FIVE, GRID_FIVE_ERROR);
        softAssert.assertEquals(actualGridSix, GRID_SIX, GRID_SIX_ERROR);
        softAssert.assertEquals(actualGridSeven, GRID_SEVEN, GRID_SEVEN_ERROR);
        softAssert.assertEquals(actualGridEight, GRID_EIGHT, GRID_EIGHT_ERROR);
        softAssert.assertEquals(actualGridNine, GRID_NINE, GRID_NINE_ERROR);

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
    public void dragAndDropFromListTab(String dragFromPlace, String dropOnPlace, String expectedOrder) {
        // Arrange & Act
        sortablePage.moveOverList(dragFromPlace, dropOnPlace);
        String actualList = sortablePage.getListOrder();

        // Assert
        softAssert.assertEquals(actualList, expectedOrder, LIST_ORDER_ERROR);
        softAssert.assertAll();
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
    public void dragAndDropFromGridTab(String dragFromPlace, String dropOnPlace, String expectedOrder) throws InterruptedException {
        // Arrange & Act
        sortablePage.clickGridTab();
        sortablePage.moveOverGrid(dragFromPlace, dropOnPlace);
        String actualList = sortablePage.getGridOrder();

        // Assert
        softAssert.assertEquals(actualList, expectedOrder, GRID_ORDER_ERROR);
        softAssert.assertAll();
    }
}
