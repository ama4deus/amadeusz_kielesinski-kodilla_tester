package com.kodilla.selenium.allegro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        driver.get("https://allegro.pl/");

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
        }

        WebElement categorySelect = driver.findElement(By.cssSelector("select[data-role='search-scope-select']"));
        Select selectCategory = new Select(categorySelect);
        selectCategory.selectByVisibleText("Elektronika");

        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.sendKeys("Mavic mini");

        WebElement searchButton = driver.findElement(By.cssSelector("button[data-role='search-button']"));
        searchButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section > article")));

        List<WebElement> productCards = driver.findElements(By.cssSelector("section > article"));

        System.out.println("Znaleziono " + productCards.size() + " produktów. Oto one:");
        for (WebElement card : productCards) {
            System.out.println(card.getText());
            System.out.println("--------------------------------------------------");
        }
    }
}