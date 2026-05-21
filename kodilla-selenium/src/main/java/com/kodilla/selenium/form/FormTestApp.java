package com.kodilla.selenium.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class FormTestApp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSI\\selenium-drivers\\Chrome\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://kodilla.com/pl/test/form/");

        WebElement yearCombo = driver.findElement(By.xpath("//*[@id=\"birthday_wrapper\"]/select[3]"));
        Select yearSelect = new Select(yearCombo);
        yearSelect.selectByIndex(5);

    }
}