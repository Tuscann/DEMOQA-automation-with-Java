package com.pages.demo.pages.elements;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

public class UploadAndDownloadPage extends BasePage {
    private final By downloadButton = By.id("downloadButton");
    private final By chooseFileButton = By.id("uploadFile");
    private final By uploadFilePath = By.id("uploadedFilePath");
    private final By selectAFileLabel = By.xpath("//label[@for='uploadFile'][contains(.,'Select a file')]");
    private final By uploadAndDownloadLabel = By.xpath("//h1[@class='text-center'][contains(.,'Upload and Download')]");

    String downloadDir = Paths.get(System.getProperty("user.home"), "Downloads", "selenium_downloads").toString();

    public void clickDownloadButton() {
        String expectedFileName = driver.findElement(downloadButton).getDomAttribute("download");

        waitForFileDownload(expectedFileName, 20);
    }

    public String getUploadFilePath() {
        return find(uploadFilePath).getText();
    }

    public void uploadFile(String pathOfFile) {
        WebElement fileInput = driver.findElement(chooseFileButton);

        fileInput.sendKeys(pathOfFile);
    }

    public String getFilePathFromResources(String fileName) {
        URL resource = getClass().getClassLoader().getResource(fileName);
        URL resource2 = getClass().getClassLoader().getResource("./test/java/recources/" + fileName);

        if (resource2 == null) {
            return null;
        }

//        File file = new File(resource.getFile());
//        if (file.exists()) {
//            return file.getAbsolutePath();
//        }
        return null;
    }

    private void waitForFileDownload(String fileName, int maxWaitTimeSeconds) {
        File downloadPath = new File(downloadDir);
        File downloadedFile;

        long startTime = System.currentTimeMillis();
        long endTime;

        do {
            downloadedFile = new File(downloadPath, fileName);

            if (downloadedFile.exists()) {
                return;
            }

            endTime = System.currentTimeMillis();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } while ((endTime - startTime) <= maxWaitTimeSeconds * 1000);

    }

    public boolean checkIfFileExists(String fileName) {
        File downloadPath = new File(downloadDir);
        File downloadedFile = new File(downloadPath, fileName);

        return downloadedFile.exists();
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
}
