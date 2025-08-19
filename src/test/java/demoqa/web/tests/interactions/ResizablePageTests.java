package demoqa.web.tests.interactions;

import demoqa.pages.interactions.ResizablePage;
import demoqa.web.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ResizablePageTests extends BaseTest {
    public static final String RESIZABLE_URL = "resizable";
    private ResizablePage resizablePage;

    @BeforeMethod
    public void goToResizablePage() {
        navigateToUrl(RESIZABLE_URL);
        resizablePage = new ResizablePage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange
        String pageTitle = "Resizable";
        String resizableBoxWithRestrictionText = "Resizable box, starting at 200x200. Min size is 150x150, max is 500x300.";
        String resizableText = "Resizable";

        // Act
        String actualPageTitle = resizablePage.getPageTitleText();
        String actualResizableBoxWithRestrictionText = resizablePage.getResizableBoxWithRestrictionText();
        String actualResizableText = resizablePage.getResizableText();

        // Assert
        softAssert.assertEquals(actualPageTitle, pageTitle, "\nWrong page title.\n");
        softAssert.assertEquals(actualResizableBoxWithRestrictionText, resizableBoxWithRestrictionText, "\nWrong resizable text.\n");
        softAssert.assertEquals(actualResizableText, resizableText, "\nWrong resizable text.\n");

        softAssert.assertAll();
    }

    @DataProvider(name = "resizeData")
    public Object[][] resizeDataProvider() {
        return new Object[][]{
                {300, 100, 500, 300}, // Test case 1: Test max limit Width and height
                //   {301, 301, 500, 300}, // Test case 2: More than limits
                {0, 0, 200, 200},     // Test case 3: No change
                {-50, -50, 150, 150}, // Test case 4: Test min values
                {-51, -51, 150, 150}  // Test case 5: More than min values
        };
    }

    @Test(dataProvider = "resizeData", description = "Test resizing with different values", enabled = true)
    public void testResizedBoxWithLimitation(int addX, int addY, int expectedWidth, int expectedHeight) {
        // Arrange
        // Act
        resizablePage.changeSize(addX, addY);
        String actualNewSize = resizablePage.getNewSizeBox();

        // Assert
        Assert.assertEquals(actualNewSize, "(" + expectedWidth + ", " + expectedHeight + ")", "\nWrong new size.\n");
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
        Assert.assertEquals(actualNewSize, "(" + expectedWidth + ", " + expectedHeight + ")", "\nWrong new size.\n");
    }

    @DataProvider(name = "diagonalResizeData")
    public Object[][] diagonalResizeDataProvider() {
        return new Object[][]{
                {100, 100, 300, 300},  // Diagonal resize within limits
                //  {400, 400, 500, 300},  // Diagonal resize beyond max limits
                {-100, -100, 150, 150}, // Diagonal resize to min limits
        };
    }

    @Test(dataProvider = "diagonalResizeData", description = "Test diagonal resizing", enabled = true)
    public void diagonalResizing(int addX, int addY, int expectedWidth, int expectedHeight) {
        // Arrange & Act
        resizablePage.changeSize(addX, addY);
        String actualNewSize = resizablePage.getNewSizeBox();

        // Assert
        Assert.assertEquals(actualNewSize, "(" + expectedWidth + ", " + expectedHeight + ")", "\nWrong size after diagonal resize.\n");
    }

    @Test(description = "Test resize handle visibility", enabled = true)
    public void resizeHandleVisibility() {
        // Arrange
        // Act
        // Assert
        softAssert.assertTrue(resizablePage.isResizeHandleVisible(), "\nResize handle should be visible.\n");
        softAssert.assertTrue(resizablePage.isResizeHandle2Visible(), "\nSecond resize handle should be visible.\n");
        softAssert.assertAll();
    }
}
