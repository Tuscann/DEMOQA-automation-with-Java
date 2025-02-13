package demoqa.web.tests.interactions;

import demoqa.web.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ResizablePageTests extends BaseTest {
    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        navigateToUrl("resizable");

        String pageTitle = "Resizable";
        String resizableBoxWithRestrictionText = "Resizable box, starting at 200x200. Min size is 150x150, max is 500x300.";
        String resizableText = "Resizable";

        String actualPageTitle = resizablePage.getPageTitleText();
        String actualResizableBoxWithRestrictionText = resizablePage.getResizableBoxWithRestrictionText();
        String actualResizableText = resizablePage.getResizableText();

        softAssert.assertEquals(actualPageTitle, pageTitle, "\nWrong page title.\n");
        softAssert.assertEquals(actualResizableBoxWithRestrictionText, resizableBoxWithRestrictionText, "\nWrong resizable text.\n");
        softAssert.assertEquals(actualResizableText, resizableText, "\nWrong resizable text.\n");

        softAssert.assertAll();
    }

    @DataProvider(name = "resizeData")
    public Object[][] resizeDataProvider() {
        return new Object[][]{
                {300, 100, 500, 300}, // Test case 1: Test max limit Width and height
                //   {301, 301, 500, 300}, // Test case 2: More than limits throw error
                {0, 0, 200, 200},     // Test case 3: No change
                {-50, -50, 150, 150}, // Test case 4: Test min values
                {-51, -51, 150, 150}  // Test case 5: More than min values show limits
        };
    }

    @Test(dataProvider = "resizeData", description = "Test resizing with different values", enabled = true, testName = "Resizing with different values")
    public void ТestResizedBoxWithLimitation(int addX, int addY, int expectedWidth, int expectedHeight) {
        navigateToUrl("resizable");
        resizablePage.changeSize(addX, addY);

        String actualNewSize = resizablePage.getNewSizeBox();
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

    @Test(dataProvider = "resizeData2", description = "Test resizing with different values", enabled = true, testName = "Resizing with different values")
    public void ТestResizedBoxWithoutLimitation(int addAmountOnXAxis, int addAmountOnYAxis, int expectedWidth, int expectedHeight) {
        navigateToUrl("resizable");

        resizablePage.changeSizeWithoutLimitations(addAmountOnXAxis, addAmountOnYAxis);

        String actualNewSize = resizablePage.getNewSizeBox2();

        Assert.assertEquals(actualNewSize, "(" + expectedWidth + ", " + expectedHeight + ")", "\nWrong new size.\n");
    }

    @DataProvider(name = "diagonalResizeData")
    public Object[][] diagonalResizeDataProvider() {
        return new Object[][]{
                {100, 100, 300, 300},  // Diagonal resize within limits
                {-100, -100, 150, 150}, // Diagonal resize to min limits
        };
    }

    @Test(dataProvider = "diagonalResizeData", description = "Test diagonal resizing", enabled = true, testName = "Diagonal resizing test")
    public void DiagonalResizing(int addX, int addY, int expectedWidth, int expectedHeight) {
        navigateToUrl("resizable");

        resizablePage.changeSize(addX, addY);
        String actualNewSize = resizablePage.getNewSizeBox();

        Assert.assertEquals(actualNewSize, "(" + expectedWidth + ", " + expectedHeight + ")", "\nWrong size after diagonal resize.\n");
    }

    @Test(description = "Test resize handle visibility", enabled = true, testName = "Resize handle visibility test")
    public void ResizeHandleVisibility() {
        navigateToUrl("resizable");

        softAssert.assertTrue(resizablePage.isResizeHandleVisible(), "\nResize handle should be visible.\n");
        softAssert.assertTrue(resizablePage.isResizeHandle2Visible(), "\nSecond resize handle should be visible.\n");

        softAssert.assertAll();
    }
}
