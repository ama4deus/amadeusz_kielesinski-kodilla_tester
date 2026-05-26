package com.kodilla.selenium.pom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KodillaStoreTest {

    private WebDriver driver;
    private KodillaStorePom storePage;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://kodilla.com/pl/test/store");
        storePage = new KodillaStorePom(driver);
    }

    @ParameterizedTest
    @CsvSource({
            "NoteBook, 2",
            "School, 1",
            "Brand, 1",
            "Business, 0", // Teraz to zadziała bez błędu
            "Gaming, 1",
            "Powerful, 0"  // To również przejdzie
    })
    public void testSearchProductsCount(String phrase, int expectedCount) {
        storePage.search(phrase);
        assertEquals(expectedCount, storePage.getSearchResultsCount());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}