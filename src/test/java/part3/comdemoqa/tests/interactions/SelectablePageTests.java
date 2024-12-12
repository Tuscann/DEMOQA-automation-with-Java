package part3.comdemoqa.tests.interactions;


import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class SelectablePageTests extends BaseTest {

    @Test
    public void SelectAllRowsInList() {
        navigateToUrl("selectable");

        String searched1Selection = "Cras justo odio";
        boolean isFirstRowSelected = selectablePage.RowSelected(searched1Selection);
        Assert.assertFalse(isFirstRowSelected, "First row is selected");
        int position = 0;
        selectablePage.clickElement(position);
        isFirstRowSelected = selectablePage.RowSelected(searched1Selection);
        Assert.assertTrue(isFirstRowSelected, "Second row is not selected");

        String searched2Selection = "Dapibus ac facilisis in";
        boolean isSecondRowSelected = selectablePage.RowSelected(searched2Selection);
        Assert.assertFalse(isSecondRowSelected, "Second row is selected");
        position = 1;
        selectablePage.clickElement(position);
        isSecondRowSelected = selectablePage.RowSelected(searched2Selection);
        Assert.assertTrue(isSecondRowSelected, "Second row is not selected");

        String searched3Selection = "Morbi leo risus";
        boolean isThirdRowSelected = selectablePage.RowSelected(searched3Selection);
        Assert.assertFalse(isThirdRowSelected, "Third row is selected");
        position = 2;
        selectablePage.clickElement(position);
        isThirdRowSelected = selectablePage.RowSelected(searched3Selection);
        Assert.assertTrue(isThirdRowSelected, "Third row is not selected");

        String searched4Selection = "Porta ac consectetur ac";
        boolean isFourRowSelected = selectablePage.RowSelected(searched4Selection);
        Assert.assertFalse(isFourRowSelected, "Four row is selected");
        position = 3;
        selectablePage.clickElement(position);
        isFourRowSelected = selectablePage.RowSelected(searched4Selection);
        Assert.assertTrue(isFourRowSelected, "Four row is not selected");
    }

    @Test(enabled = false)
    public void SelectOneFromGrid() {
        navigateToUrl("selectable");
        selectablePage.clickGrid();

        String searched1Selection = "Three";
        boolean isFirstRowSelected = selectablePage.RowSelected(searched1Selection);
        Assert.assertFalse(isFirstRowSelected, "One is selected");
        int position = 0;
        selectablePage.clickElement(position);
        isFirstRowSelected = selectablePage.RowSelected(searched1Selection);
        Assert.assertTrue(isFirstRowSelected, "One is not selected");
    }
}
