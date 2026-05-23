package com.kodilla.selenium.pom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KodillaStoreTest {

    private WebDriver driver;
    private KodillaStorePom storePage;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://kodilla.com/pl/test/store");
        storePage = new KodillaStorePom(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }

    @Test
    public void testSearchProductsCount() {
        storePage.search("NoteBook");
        assertEquals(2, storePage.getSearchResultsCount(), "Niezgodna liczba wyników dla NoteBook");

        storePage.search("School");
        assertEquals(1, storePage.getSearchResultsCount(), "Niezgodna liczba wyników dla School");

        storePage.search("Brand");
        assertEquals(1, storePage.getSearchResultsCount(), "Niezgodna liczba wyników dla Brand");

        storePage.search("Business");
        assertEquals(0, storePage.getSearchResultsCount(), "Niezgodna liczba wyników dla Business");

        storePage.search("Gaming");
        assertEquals(1, storePage.getSearchResultsCount(), "Niezgodna liczba wyników dla Gaming");

        storePage.search("Powerful");
        assertEquals(0, storePage.getSearchResultsCount(), "Niezgodna liczba wyników dla Powerful");
    }

    @Test
    public void testSearchCaseInsensitive() {
        storePage.search("NoteBook");
        int countUpperCase = storePage.getSearchResultsCount();

        storePage.search("notebook");
        int countLowerCase = storePage.getSearchResultsCount();

        assertEquals(countUpperCase, countLowerCase, "Wyszukiwarka powinna ignorować wielkość liter dla NoteBook!");

        storePage.search("SCHOOL");
        int countSchoolUpper = storePage.getSearchResultsCount();

        storePage.search("school");
        int countSchoolLower = storePage.getSearchResultsCount();

        assertEquals(countSchoolUpper, countSchoolLower, "Wyszukiwarka powinna ignorować wielkość liter dla School!");
    }
}