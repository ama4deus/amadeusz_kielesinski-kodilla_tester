package com.kodilla.selenium.pom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KodillaLoginPomTest {

    KodillaLoginPom loginPom;
    WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://kodilla.com/pl/test/login");
        loginPom = new KodillaLoginPom(driver);
    }

    @Test
    public void testLoginPage_CheckErrorValidation() {
        boolean loggedIn = loginPom.login("test@toniedziala.pl", "password");
        assertFalse(loggedIn);
    }

    @Test
    public void testLoginPage_CheckPositiveValidation() {
        boolean loggedIn = loginPom.login("test@kodilla.com", "kodilla123");
        assertTrue(loggedIn);
    }

    @AfterEach
    public void testDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}