package demoqa.web.tests.interactions;

import demoqa.pages.interactions.ResizablePage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ResizablePageTests extends BaseTest {

    public static final String RESIZABLE_URL = "resizable";
    // Text Constants
    private static final String EXPECTED_PAGE_TITLE = "Resizable";
    private static final String EXPECTED_RESIZABLE_BOX_WITH_RESTRICTION_TEXT = "Resizable box, starting at 200x200. Min size is 150x150, max is 500x300.";
    private static final String EXPECTED_RESIZABLE_TEXT = "Resizable";
    // Error Message Constants
    private static final String WRONG_PAGE_TITLE = "\nWrong page title.\n";
    private static final String WRONG_RESIZABLE_BOX_TEXT = "\nWrong resizable text.\n";
    private static final String WRONG_RESIZABLE_TEXT = "\nWrong resizable text.\n";
    private static final String WRONG_COLOR_SELECTED = "\nWrong color selected.\n";
    private static final String WRONG_NEW_SIZE = "\nWrong new size.\n";
    private static final String WRONG_SIZE_AFTER_DIAGONAL_RESIZE = "\nWrong size after diagonal resize.\n";
    private static final String RESIZE_HANDLE_SHOULD_BE_VISIBLE = "\nResize handle should be visible.\n";
    private static final String SECOND_RESIZE_HANDLE_SHOULD_BE_VISIBLE = "\nSecond resize handle should be visible.\n";
    private static final String EXPECTED_GREY_COLOR = "rgba(255, 255, 255, 1)";
    private ResizablePage resizablePage;

    @BeforeMethod
    public void goToResizablePage() {
        navigateToUrl(RESIZABLE_URL);
        resizablePage = new ResizablePage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange & Act
        String actualPageTitle = resizablePage.getPageTitleText();
        String actualResizableBoxWithRestrictionText = resizablePage.getResizableBoxWithRestrictionText();
        String actualResizableText = resizablePage.getResizableText();
        String actualBackgroundColor = resizablePage.getResizableBoxWithRestrictionBackgroudColor();

        // Assert
        softAssert.assertEquals(actualPageTitle, EXPECTED_PAGE_TITLE, WRONG_PAGE_TITLE);
        softAssert.assertEquals(actualResizableBoxWithRestrictionText, EXPECTED_RESIZABLE_BOX_WITH_RESTRICTION_TEXT, WRONG_RESIZABLE_BOX_TEXT);
        softAssert.assertEquals(actualResizableText, EXPECTED_RESIZABLE_TEXT, WRONG_RESIZABLE_TEXT);
        softAssert.assertEquals(actualBackgroundColor, EXPECTED_GREY_COLOR, WRONG_COLOR_SELECTED);

        softAssert.assertAll();
    }

    @DataProvider(name = "resizeData")
    public Object[][] resizeDataProvider() {
        return new Object[][]{
                {300, 100, 500, 300}, // Test case 1: Test max limit Width and height
                {0, 0, 200, 200},     // Test case 2: No change
                {-50, -50, 150, 150}, // Test case 3: Test min values
                {-51, -51, 150, 150}  // Test case 4: More than min values
        };
    }

    @Test(dataProvider = "resizeData", description = "Test resizing with different values", enabled = true)
    public void testResizedBoxWithLimitation(int addX, int addY, int expectedWidth, int expectedHeight) {
        // Arrange & Act
        resizablePage.changeSize(addX, addY);
        String actualNewSize = resizablePage.getNewSizeBox();

        // Assert
        softAssert.assertEquals(actualNewSize, "(" + expectedWidth + ", " + expectedHeight + ")", WRONG_NEW_SIZE);
        softAssert.assertAll();
    }

    @DataProvider(name = "resizeData2")
    public Object[][] resizeDataProvider2() {
        return new Object[][]{
                {300, 100, 500, 300}, // Test case 1: Test max limit Width and height
                {309, 109, 509, 309}, // Test case 2: More than limits
                {0, 0, 200, 200},     // Test case 3: No change
                {-180, -180, 20, 20}, // Test case 4: More than min values
                {-200, -200, 20, 20}  // Test case 5: More than Min limit 20
        };
    }

    @Test(dataProvider = "resizeData2", description = "Test resizing with different values", enabled = true)
    public void testResizedBoxWithoutLimitation(int addAmountOnXAxis, int addAmountOnYAxis, int expectedWidth, int expectedHeight) {
        // Arrange & Act
        resizablePage.changeSizeWithoutLimitations(addAmountOnXAxis, addAmountOnYAxis);
        String actualNewSize = resizablePage.getNewSizeBox2();

        // Assert
        softAssert.assertEquals(actualNewSize, "(" + expectedWidth + ", " + expectedHeight + ")", WRONG_NEW_SIZE);
        softAssert.assertAll();
    }

    @DataProvider(name = "diagonalResizeData")
    public Object[][] diagonalResizeDataProvider() {
        return new Object[][]{
                {100, 100, 300, 300},  // Diagonal resize within limits
                {-100, -100, 150, 150}, // Diagonal resize to min limits (constrained by minimum size)
        };
    }

    @Test(dataProvider = "diagonalResizeData", description = "Test diagonal resizing", enabled = true)
    public void diagonalResizing(int addX, int addY, int expectedWidth, int expectedHeight) {
        // Arrange & Act
        resizablePage.changeSize(addX, addY);
        String actualNewSize = resizablePage.getNewSizeBox();

        // Assert
        softAssert.assertEquals(actualNewSize, "(" + expectedWidth + ", " + expectedHeight + ")", WRONG_SIZE_AFTER_DIAGONAL_RESIZE);
        softAssert.assertAll();
    }

    @Test(description = "Test resize handle visibility", enabled = true)
    public void resizeHandleVisibility() {
        // Arrange & Act & Assert
        softAssert.assertTrue(resizablePage.isResizeHandleVisible(), RESIZE_HANDLE_SHOULD_BE_VISIBLE);
        softAssert.assertTrue(resizablePage.isResizeHandle2Visible(), SECOND_RESIZE_HANDLE_SHOULD_BE_VISIBLE);
        softAssert.assertAll();
    }
}
