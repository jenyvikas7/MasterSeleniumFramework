package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {

    private final By searchField = By.id("woocommerce-product-search-field-0");
    private final By searchButton = By.cssSelector("button[value='Search']");
    private final By tile = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By addToCartButton = By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public StorePage enterTextInSearchField(String txt) {
        driver.findElement(searchField).sendKeys(txt);
        return this;
    }

    public StorePage search(String txt) {
        driver.findElement(searchField).sendKeys(txt);
        driver.findElement(searchButton).click();
        return this;

    }

    public StorePage clickSearchButton() {
        driver.findElement(searchButton).click();
        return this;
    }

    public String getTitle() {
        return driver.findElement(tile).getText();
    }

    private By getAddToCartButtonElement(String productName) {

        return By.cssSelector("a[aria-label='Add “"+ productName +"” to your cart']");

    }

    public void clickAddToCartBtn(String productName) {

        By addToCartButton = getAddToCartButtonElement(productName);
        driver.findElement(addToCartButton).click();
    }

    public StorePage clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
        return this;
    }

}
