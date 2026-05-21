package com.kodilla.selenium.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EBayTestingApp {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSI\\selenium-drivers\\Chrome\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");

        //Znalezienie pola wyszukiwarki. eBay używa dla tego pola id="gh-ac"
        WebElement searchField = driver.findElement(By.id("gh-ac"));
        searchField.sendKeys("Laptop");
        searchField.sendKeys(Keys.ENTER);
    }
}