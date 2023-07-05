package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {

    private final By productName = By.cssSelector("td[class='product-name']>a");

    private final By proceedToCheckoutElement = By.cssSelector(".wc-proceed-to-checkout>a");
    public CartPage(WebDriver driver) {
        super(driver);
    }
}
