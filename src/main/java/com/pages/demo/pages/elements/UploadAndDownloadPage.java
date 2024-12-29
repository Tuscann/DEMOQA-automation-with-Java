package com.pages.demo.pages.elements;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.nio.file.Paths;

public class UploadAndDownloadPage extends BasePage {
    private final By downloadButton = By.id("downloadButton");
    private final By chooseFileButton = By.id("uploadFile");
    private final By uploadFilePath = By.id("uploadedFilePath");
    private final By selectAFileLabel = By.xpath("//label[@for='uploadFile'][contains(.,'Select a file')]");
    private final By uploadAndDownloadLabel = By.xpath("//h1[@class='text-center'][contains(.,'Upload and Download')]");

    public String getUploadFilePath() {
        return find(uploadFilePath).getText();
    }

    public String getFilePathFromResources(String fileName) {
        File file = new File(System.getProperty("user.dir") + "/resources/screenshots/" + fileName);
        if (file.exists()) {
            return file.getAbsolutePath();
        } else {
            return null;
        }
    }

    public String getDownloadButtonText() {
        return find(downloadButton).getText();
    }

    public String getUploadAndDownloadText() {
        return find(uploadAndDownloadLabel).getText();
    }

    public String getSelectAFileText() {
        return find(selectAFileLabel).getText();
    }

    public void clickDownloadButton() {
        find(downloadButton).click();
    }

    public void uploadFile(String pathOfFile) {
        WebElement fileInput = driver.findElement(chooseFileButton);

        fileInput.sendKeys(pathOfFile);
    }

    public boolean checkIfFileExists(String fileName) {
        String downloadDir = Paths.get(System.getProperty("user.home"), "Downloads").toString();

        delay(1000); //TODO
        File downloadedFile = new File(downloadDir + File.separator + fileName);

        return downloadedFile.exists();
    }
}
