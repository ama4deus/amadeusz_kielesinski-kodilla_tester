package com.kodilla.testcontainers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.shaded.org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class BrowserTest {

    public BrowserWebDriverContainer<?> chromeContainer;

    @BeforeEach
    public void setUp() {
        chromeContainer = new BrowserWebDriverContainer()
                .withCapabilities(new ChromeOptions());
        chromeContainer.start();
    }

    @Test
    public void chromeTest() throws IOException, InterruptedException {
        RemoteWebDriver driver = chromeContainer.getWebDriver();
        driver.get("http://allegro.pl");

        // Dajemy przeglądarce 5 sekund na pełne załadowanie strony przed zrzutem ekranu
        Thread.sleep(5000);

        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,
                new File("./build/screenshots/" + screenshot.getName()));
    }

    @AfterEach
    public void tearDown() {
        chromeContainer.stop();
    }
}