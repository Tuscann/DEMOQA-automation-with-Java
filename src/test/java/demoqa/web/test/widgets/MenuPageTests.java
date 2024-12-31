package demoqa.web.test.widgets;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuPageTests extends BaseTest {

    @Test(enabled = true)
    public void CheckAllTextOnPage() {
        navigateToUrl("menu#");
        String pageHeader = "Menu";
        String mainItem1 = "Main Item 1";
        menuPage.selectMainItem2();
        String mainItem2 = "Main Item 2";
        String mainItem2SubItem1 = "Sub Item";
        String mainItem2SubItem2 = "Sub Item";
        String mainItem2SubSubList = "SUB SUB LIST »";
        menuPage.selectMainItem2SubSubList();
        String mainItem2SubSubListSubItem1 = "Sub Sub Item 1";
        String mainItem2SubSubListSubItem2 = "Sub Sub Item 2";
        String mainItem3 = "Main Item 3";

        String actualPageHeader = menuPage.getHeaderText();
        String actualMainItem1 = menuPage.getMainItem1();
        String actualMainItem2 = menuPage.getMainItem2();
        String actualMainItem2SubItem1 = menuPage.getMainItem2SubItem1();
        String actualMainItem2SubItem2 = menuPage.getMainItem2SubItem2();
        String actualMainItem2SubSubList = menuPage.getMainItem2SubSubList();
        String actualMainItem2SubSubListSubItem1 = menuPage.getMainItem2SubSubListSubItem1();
        String actualMainItem2SubSubListSubItem2 = menuPage.getMainItem2SubSubListSubItem2();
        String actualMainItem3 = menuPage.getMainItem3();

        Assert.assertEquals(actualPageHeader, pageHeader, "Page header not correct");
        Assert.assertEquals(actualMainItem1, mainItem1, "Main Item 1 not correct");
        Assert.assertEquals(actualMainItem2, mainItem2, "Main Item 2 not correct");
        Assert.assertEquals(actualMainItem2SubItem1, mainItem2SubItem1, "Main Item 1 sub item 1 not correct");
        Assert.assertEquals(actualMainItem2SubItem2, mainItem2SubItem2, "Main Item 1 sub item 2 not correct");
        Assert.assertEquals(actualMainItem2SubSubList, mainItem2SubSubList, "Main 2 SubList");
        Assert.assertEquals(actualMainItem2SubSubListSubItem1, mainItem2SubSubListSubItem1, "SubSubListSubItem1 not correct");
        Assert.assertEquals(actualMainItem2SubSubListSubItem2, mainItem2SubSubListSubItem2, "SubSubListSubItem2 not correct");
        Assert.assertEquals(actualMainItem3, mainItem3, "Main Item 3 not correct");
    }

    @Test
    public void HoverOverEveryItemInMenuAndCheckHoverColor() {
        navigateToUrl("menu#");

        final String colorBeforeSelection = "rgba(36, 175, 21, 1)";
        final String colorAfterSelection = "rgba(0, 63, 32, 1)";

        String actualColorSelected = menuPage.takeBackgroundColorMainItem1();
        Assert.assertEquals(actualColorSelected, colorBeforeSelection, "Not normal green");
        menuPage.selectMainItem1();
        actualColorSelected = menuPage.takeBackgroundColorMainItem1();
        Assert.assertEquals(actualColorSelected, colorAfterSelection, "Not dark green");


        actualColorSelected = menuPage.takeBackgroundColorMainItem2();
        Assert.assertEquals(actualColorSelected, colorBeforeSelection, "Not normal green");
        menuPage.selectMainItem2();
        actualColorSelected = menuPage.takeBackgroundColorMainItem2();
        Assert.assertEquals(actualColorSelected, colorAfterSelection, "Not dark green");


        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubItem1();
        Assert.assertEquals(actualColorSelected, colorBeforeSelection, "Not normal green");
        menuPage.selectMainItem2SubItem1();
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubItem1();
        Assert.assertEquals(actualColorSelected, colorAfterSelection, "Not dark green");


        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubItem2();
        Assert.assertEquals(actualColorSelected, colorBeforeSelection, "Not normal green");
        menuPage.selectMainItem2SubItem2();
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubItem2();
        Assert.assertEquals(actualColorSelected, colorAfterSelection, "Not dark green");


        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubSubsLIst();
        Assert.assertEquals(actualColorSelected, colorBeforeSelection, "Not normal green");
        menuPage.selectMainItem2SubSubList();
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubSubsLIst();
        Assert.assertEquals(actualColorSelected, colorAfterSelection, "Not dark green");


        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubSubsLIstSubSubItem1();
        Assert.assertEquals(actualColorSelected, colorBeforeSelection, "Not normal green");
        menuPage.selectMainItem2SubSubsLIstSubSubItem1();
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubSubsLIstSubSubItem1();
        Assert.assertEquals(actualColorSelected, colorAfterSelection, "Not dark green");


        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubSubsLIstSubSubItem2();
        Assert.assertEquals(actualColorSelected, colorBeforeSelection, "Not normal green");
        menuPage.selectMainItem2SubSubsLIstSubSubItem2();
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubSubsLIstSubSubItem2();
        Assert.assertEquals(actualColorSelected, colorAfterSelection, "Not dark green");


        actualColorSelected = menuPage.takeBackgroundColorMainItem3();
        Assert.assertEquals(actualColorSelected, colorBeforeSelection, "Not normal green");
        menuPage.selectMainItem3();
        actualColorSelected = menuPage.takeBackgroundColorMainItem3();
        Assert.assertEquals(actualColorSelected, colorAfterSelection, "Not dark green");
    }
}
