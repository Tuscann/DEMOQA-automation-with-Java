package demoqa.web.test.interactions;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ResizablePageTests extends BaseTest {
    @Test
    public void VerifyAllTextOnPage() {
        navigateToUrl("resizable");

        String pageTitle = "Resizable";
        String resizableBoxWithRestrictionText = "Resizable box, starting at 200x200. Min size is 150x150, max is 500x300.";
        String resizableText = "Resizable";

        String actualPageTitle = resizablePage.getPageTitleText();
        String actualResizableBoxWithRestrictionText = resizablePage.getResizableBoxWithRestrictionText();
        String actualResizableText = resizablePage.getResizableText();

        Assert.assertEquals(actualPageTitle, pageTitle, "Wrong page title");
        Assert.assertEquals(actualResizableBoxWithRestrictionText, resizableBoxWithRestrictionText, "Wrong resizable text");
        Assert.assertEquals(actualResizableText, resizableText, "Wrong resizable text");
    }

    @DataProvider(name = "resizeData")
    public Object[][] resizeDataProvider() {
        return new Object[][]{
                {300, 100, 500, 300}, // Test case 1: Test max limit Width and height
                {301, 301, 500, 300}, // Test case 2: More than limits
                {0, 0, 200, 200},     // Test case 3: No change
                {-50, -50, 150, 150}, // Test case 4: Test min values
                {-51, -51, 150, 150}  // Test case 5: More than min values
        };
    }

    @Test(dataProvider = "resizeData", description = "Test resizing with different values", enabled = true)
    public void testResizedBoxWithLimitation(int addX, int addY, int expectedWidth, int expectedHeight) {
        navigateToUrl("resizable");

        resizablePage.changeSize(addX, addY);

        String actualNewSize = resizablePage.getNewSizeBox();

        Assert.assertEquals(actualNewSize, "(" + expectedWidth + ", " + expectedHeight + ")", "Wrong new size");
    }

    @DataProvider(name = "resizeData2")
    public Object[][] resizeDataProvider2() {
        return new Object[][]{
                {300, 100, 500, 300}, // Test case 1: Test max limit Width and height
                //    {309, 109, 509, 309}, // Test case 2: More than limits
                {0, 0, 200, 200},     // Test case 3: No change
                {-180, -180, 20, 20}, // Test case 4: More than min values
                {-200, -200, 20, 20}  // Test case 5: More than Min limit 20
        };
    }

    @Test(dataProvider = "resizeData2", description = "Test resizing with different values", enabled = false)
    public void testResizedBoxWithoutLimitation(int addX, int addY, int expectedWidth, int expectedHeight) {
        navigateToUrl("resizable");

        resizablePage.changeSizeWithoutLimitations(addX, addY);

        String actualNewSize = resizablePage.getNewSizeBox2();

        Assert.assertEquals(actualNewSize, "(" + expectedWidth + ", " + expectedHeight + ")", "Wrong new size");
    }
}
