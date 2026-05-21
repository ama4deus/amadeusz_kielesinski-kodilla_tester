package com.kodilla.selenium.allegro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

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

        WebElement categorySelect = driver.findElement(By.xpath("//select[@data-role='search-scope-select']"));
        Select selectCategory = new Select(categorySelect);
        selectCategory.selectByVisibleText("Elektronika");

        WebElement searchField = driver.findElement(By.xpath("//input[@type='search']"));
        searchField.sendKeys("Mavic mini");

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();
    }
}