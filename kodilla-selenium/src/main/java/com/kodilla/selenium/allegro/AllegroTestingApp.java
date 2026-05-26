package com.kodilla.selenium.allegro;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AllegroTestingApp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSI\\selenium-drivers\\Chrome\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);

        try {
            driver.get("https://allegro.pl/");

            try {
                Alert alert = driver.switchTo().alert();
                alert.accept();
            } catch (NoAlertPresentException e) {
                System.out.println("Brak aktywnego alertu – kontynuuję działanie.");
            }

            WebDriverWait wait = new WebDriverWait(driver, 15);
            WebElement categorySelect = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class, 'm-c999')]//select")));

            Select selectCategory = new Select(categorySelect);
            selectCategory.selectByVisibleText("Elektronika");

            WebElement searchField = driver.findElement(By.xpath("//input[@type='search']"));
            searchField.sendKeys("Mavic mini");

            WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(), 'Szukaj')]"));
            searchButton.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section//article")));
            List<WebElement> productCards = driver.findElements(By.xpath("//section//article"));

            System.out.println("Znaleziono " + productCards.size() + " produktów.");
            for (WebElement card : productCards) {
                System.out.println(card.getText());
                System.out.println("--------------------------------------------------");
            }

        } catch (Exception e) {
            System.out.println("Wystąpił błąd: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}