package com.kodilla.selenium.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KodillaStorePom extends AbstractPom {

    @FindBy(css = "#searchField")
    WebElement searchField;

    @FindBy(css = ".element")
    List<WebElement> productList;

    public KodillaStorePom(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void search(String query) {
        searchField.clear();
        searchField.sendKeys(query);
        searchField.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int getSearchResultsCount() {

        return productList.size();
    }
}