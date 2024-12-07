package com.pages.demo.pages.elements;

import org.openqa.selenium.By;

public class CheckBoxPage extends ElementsPage {

    private final By home = By.xpath("(//span[contains(.,'Home')])[2]");
    private final By desktop = By.xpath("(//span[contains(.,'Desktop')])[2]");
    private final By notes = By.xpath("(//span[contains(.,'Notes')])[2]");
    private final By commands = By.xpath("(//span[contains(.,'Commands')])[2]");
    private final By contacts = By.xpath("(//span[contains(.,'Contacts')])[2]");
    private final By documents = By.xpath("(//span[contains(.,'Documents')])[2]");
    private final By workSpace = By.xpath("(//span[contains(.,'WorkSpace')])[2]");
    private final By react = By.xpath("(//span[contains(.,'React')])[2]");
    private final By angular = By.xpath("(//span[contains(.,'Angular')])[2]");
    private final By veu = By.xpath("(//span[contains(.,'Veu')])[2]");
    private final By office = By.xpath("(//span[contains(.,'Office')])[2]");
    private final By publicOffice = By.xpath("(//span[contains(.,'Public')])[2]");
    private final By privateOffice = By.xpath("(//span[contains(.,'Private')])[2]");
    private final By classified = By.xpath("(//span[contains(.,'Classified')])[2]");
    private final By general = By.xpath("(//span[contains(.,'General')])[2]");
    private final By downloads = By.xpath("(//span[contains(.,'Downloads')])[2]");
    private final By wordFileDoc = By.xpath("(//span[contains(.,'Word File.doc')])[2]");
    private final By excelFileDoc = By.xpath("(//span[contains(.,'Excel File.doc')])[2]");

    private final By expandAll = By.cssSelector(".rct-option.rct-option-expand-all");
    private final By collapseAll = By.cssSelector(".rct-option.rct-icon-collapse-all");
    private final By resultMessage = By.id("result");


    public void clickHome() {
        click(home);
    }

    public String getResultMessage() {
        return find(resultMessage).getText();
    }

    public void clickExpandAll() {
        click(expandAll);
    }

    public void clickCollapseAll() {
        click(collapseAll);
    }

    public void clickDesktop() {
        click(desktop);
    }

    public void clickNotes() {
        click(notes);
    }

    public void clickCommands() {
        click(commands);
    }

    public void clickContacts() {
        click(contacts);
    }

    public void clickDocuments() {
        click(documents);
    }

}