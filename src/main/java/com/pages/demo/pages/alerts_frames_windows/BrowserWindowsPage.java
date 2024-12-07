package com.pages.demo.pages.alerts_frames_windows;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserWindowsPage extends Alerts_Frames_WindowsPage {
    private final By newTabButton = By.id("tabButton");
    private final By newWindowButton = By.id("windowButton");
    private final By newWindowMessageButton = By.id("messageWindowButton");

    public void clickNewTabButton() {
        click(newTabButton);
    }

    public void clickNewWindowButton() {
        click(newWindowButton);
    }

    public void clickNewWindowMessageButton() {
        click(newWindowMessageButton);
    }

    public String getNewTabUrl() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return driver.getCurrentUrl();
    }

    public String getNewWindowUrl(String newWindowUrl) {

        String originalWindow = driver.getWindowHandle();

        String actualWindowUrl = newWindowUrl;
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                driver.get(newWindowUrl);

                actualWindowUrl = driver.getCurrentUrl();
                break;
            }
        }
        return actualWindowUrl;
    }

    public String getBrowserMessage() {

        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

        String text = driver.findElement(By.xpath("/html/body/text()")).getText();

        return text;
    }
}
