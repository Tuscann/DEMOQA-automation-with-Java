package demoqa.web.tests.widgets;

import demoqa.pages.widgets.MenuPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.Test;

public class MenuPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on page")
    public void CheckAllTextOnPage() {
        MenuPage menuPage = new MenuPage(driver);

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

        softAssert.assertEquals(actualPageHeader, pageHeader, "\nPage header not correct.\n");
        softAssert.assertEquals(actualMainItem1, mainItem1, "\nMain Item 1 not correct.\n");
        softAssert.assertEquals(actualMainItem2, mainItem2, "\nMain Item 2 not correct.\n");
        softAssert.assertEquals(actualMainItem2SubItem1, mainItem2SubItem1, "\nMain Item 1 sub item 1 not correct.\n");
        softAssert.assertEquals(actualMainItem2SubItem2, mainItem2SubItem2, "\nMain Item 1 sub item 2 not correct.\n");
        softAssert.assertEquals(actualMainItem2SubSubList, mainItem2SubSubList, "\nMain 2 SubList.\n");
        softAssert.assertEquals(actualMainItem2SubSubListSubItem1, mainItem2SubSubListSubItem1, "\nSubSubListSubItem1 not correct.\n");
        softAssert.assertEquals(actualMainItem2SubSubListSubItem2, mainItem2SubSubListSubItem2, "\nSubSubListSubItem2 not correct.\n");
        softAssert.assertEquals(actualMainItem3, mainItem3, "\nMain Item 3 not correct.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Hover over every item in menu and check hover color")
    public void HoverOverEveryItemInMenuAndCheckHoverColor() {
        navigateToUrl("menu#");
        MenuPage menuPage = new MenuPage(driver);

        final String colorBeforeSelection = "rgba(36, 175, 21, 1)";
        final String colorAfterSelection = "rgba(0, 63, 32, 1)";

        String actualColorSelected = menuPage.takeBackgroundColorMainItem1();
        softAssert.assertEquals(actualColorSelected, colorBeforeSelection, "\nNot normal green.\n");
        menuPage.selectMainItem1();
        actualColorSelected = menuPage.takeBackgroundColorMainItem1();
        softAssert.assertEquals(actualColorSelected, colorAfterSelection, "\nNot dark green.\n");

        actualColorSelected = menuPage.takeBackgroundColorMainItem2();
        softAssert.assertEquals(actualColorSelected, colorBeforeSelection, "\nNot normal green.\n");
        menuPage.selectMainItem2();
        actualColorSelected = menuPage.takeBackgroundColorMainItem2();
        softAssert.assertEquals(actualColorSelected, colorAfterSelection, "\nNot dark green.\n");

        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubItem1();
        softAssert.assertEquals(actualColorSelected, colorBeforeSelection, "\nNot normal green.\n");
        menuPage.selectMainItem2SubItem1();
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubItem1();
        softAssert.assertEquals(actualColorSelected, colorAfterSelection, "\nNot dark green.\n");

        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubItem2();
        softAssert.assertEquals(actualColorSelected, colorBeforeSelection, "\nNot normal green.\n");
        menuPage.selectMainItem2SubItem2();
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubItem2();
        softAssert.assertEquals(actualColorSelected, colorAfterSelection, "\nNot dark green.\n");

        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubSubsLIst();
        softAssert.assertEquals(actualColorSelected, colorBeforeSelection, "\nNot normal green.\n");
        menuPage.selectMainItem2SubSubList();
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubSubsLIst();
        softAssert.assertEquals(actualColorSelected, colorAfterSelection, "\nNot dark green.\n");

        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubSubsLIstSubSubItem1();
        softAssert.assertEquals(actualColorSelected, colorBeforeSelection, "\nNot normal green.\n");
        menuPage.selectMainItem2SubSubsLIstSubSubItem1();
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubSubsLIstSubSubItem1();
        softAssert.assertEquals(actualColorSelected, colorAfterSelection, "\nNot dark green.\n");

        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubSubsLIstSubSubItem2();
        softAssert.assertEquals(actualColorSelected, colorBeforeSelection, "\nNot normal green.\n");
        menuPage.selectMainItem2SubSubsLIstSubSubItem2();
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubSubsLIstSubSubItem2();
        softAssert.assertEquals(actualColorSelected, colorAfterSelection, "\nNot dark green.\n");

        actualColorSelected = menuPage.takeBackgroundColorMainItem3();
        softAssert.assertEquals(actualColorSelected, colorBeforeSelection, "\nNot normal green.\n");
        menuPage.selectMainItem3();
        actualColorSelected = menuPage.takeBackgroundColorMainItem3();
        softAssert.assertEquals(actualColorSelected, colorAfterSelection, "\nNot dark green.\n");

        softAssert.assertAll();
    }
}
