package com.pages.demo.pages.Intereactions;

import com.pages.demo.pages.HomePage;
import org.openqa.selenium.By;

public class InteractionPage extends HomePage {
    private final By sortable = By.xpath("//li[@id='item-0']/span[text()='Sortable']");
    private final By selectable = By.xpath("//li[@id='item-1']/span[text()='Selectable']");
    private final By resizable = By.xpath("//li[@id='item-2']/span[text()='Resizable']");
    private final By droppable = By.xpath("//li[@id='item-3']/span[text()='Droppable']");
    private final By dragabble = By.xpath("//li[@id='item-4']/span[text()='Dragabble']");

    public SortablePage clickSortable() {
        click(sortable);
        return new SortablePage();
    }

    public SelectablePage clickSelectable() {
        click(selectable);
        return new SelectablePage();
    }

    public ResizablePage clickResizable() {
        click(resizable);
        return new ResizablePage();
    }

    public DroppablePage clickDroppable() {
        click(droppable);
        return new DroppablePage();
    }

    public DragabblePage clickDragabble() {
        click(dragabble);
        return new DragabblePage();
    }
}
