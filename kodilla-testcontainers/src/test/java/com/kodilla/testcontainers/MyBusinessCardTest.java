package com.kodilla.testcontainers;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.MountableFile;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;

@Testcontainers
public class MyBusinessCardTest {

    private static final Network network = Network.newNetwork();

    private static File getVideosFolder() {
        File folder = new File("build/videos");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return folder;
    }

    @Container
    public GenericContainer<?> webServer = new GenericContainer<>("nginx:alpine")
            .withNetwork(network)
            .withNetworkAliases("my-server")
            .withExposedPorts(80)
            .withCopyFileToContainer(
                    MountableFile.forClasspathResource("index.html"),
                    "/usr/share/nginx/html/index.html"
            );

    @Container
    public BrowserWebDriverContainer<?> chrome = new BrowserWebDriverContainer<>("selenium/standalone-chrome:4.8.1")
            .withNetwork(network)
            .withRecordingMode(RECORD_ALL, getVideosFolder())
            .withRecordingFileFactory((targetDir, prefix, success) -> new File(targetDir, "wizytowka.flv"))
            .withCapabilities(new ChromeOptions());

    @Test
    public void testMyBusinessCard() throws InterruptedException {
        RemoteWebDriver driver = chrome.getWebDriver();

        driver.get("http://my-server/");

        String title = driver.findElement(By.id("title")).getText();

        assertEquals("To moja wizytówka!", title);

        Thread.sleep(3000);
    }
}