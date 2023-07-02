package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class MyFirstTestCase extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {


//        HashMap<String, Object> prefs = new HashMap<>();
//        prefs.put("autofill.profile_enabled",false);
//        prefs.put("profile.default_content_setting_values.notifications",Integer.valueOf(2));
//        prefs.put("credentials_enable_service",false);
//        prefs.put("profile.password_manager_enabled",false);
//
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs",prefs);
//        options.addArguments("start-maximized");

//        options.addArguments("--disable-notifications");
//        options.addArguments("--disable-infobars");
//
//
//        WebDriver driver = new ChromeDriver(options);
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\jenys\\software\\chromedriver.exe");
//        HashMap<String, Object> prefs = new HashMap<String, Object>();
//        prefs.put("profile.default_content_setting_values.notifications", 2);
//        prefs.put("credentials_enable_service", false);
//        prefs.put("profile.password_manager_enabled", false);
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs", prefs);
//        options.addArguments("start-maximized");
//        options.addArguments("disable-infobars");
//        options.addArguments("--disable-extensions");
//        options.addArguments("--disable-notifications");
        driver.get("https://askomdch.com");
        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.clickStoreMenuLink();
//        storePage.enterTextInSearchField();
//        storePage.clickSearchButton();
        storePage.search("Blue");
        storePage.getTitle();
        storePage.clickAddToCartBtn("Blue Jeans");


//        driver.findElement(By.cssSelector("#menu-item-1227>a")).click();
//        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
//        driver.findElement(By.cssSelector("button[value='Search']")).click();

//        Assert.assertEquals(
//                driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),
//                "Search results: “Blue”"
//        );

        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();

        Thread.sleep(3000);

        driver.findElement(By.cssSelector("a[title='View cart']")).click();
        Assert.assertEquals(
                driver.findElement(By.cssSelector("td[class='product-name']>a")).getText(),
                "Blue Shoes"
        );

        driver.findElement(By.cssSelector(".wc-proceed-to-checkout>a")).click();

        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
        driver.findElement(By.id("billing_last_name")).sendKeys("user");
        driver.findElement(By.id("billing_address_1")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_city")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
        driver.findElement(By.id("billing_email")).sendKeys("test@test.com");
        Thread.sleep(5000);
        driver.findElement(By.id("place_order")).click();

        Thread.sleep(5000);


        Assert.assertEquals(
                driver.findElement(By.cssSelector(".woocommerce-notice")).getText(),
                "Thank you. Your order has been received."
        );





    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {


//        HashMap<String, Object> prefs = new HashMap<>();
//        prefs.put("autofill.profile_enabled",false);
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs",prefs);
//        options.addArguments("start-maximized");

//
//        WebDriver driver = new ChromeDriver(options);
        driver.get("https://askomdch.com");
        driver.findElement(By.cssSelector("#menu-item-1227>a")).click();
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
        driver.findElement(By.cssSelector("button[value='Search']")).click();

        Assert.assertEquals(
                driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),
                "Search results: “Blue”"
        );

        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();

        Thread.sleep(3000);

        driver.findElement(By.cssSelector("a[title='View cart']")).click();
        Assert.assertEquals(
                driver.findElement(By.cssSelector("td[class='product-name']>a")).getText(),
                "Blue Shoes"
        );

        driver.findElement(By.cssSelector(".wc-proceed-to-checkout>a")).click();

        driver.findElement(By.className("showlogin")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("username")).sendKeys("test0630");
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.name("login")).click();


        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
        driver.findElement(By.id("billing_last_name")).sendKeys("user");
        driver.findElement(By.id("billing_address_1")).clear();
        driver.findElement(By.id("billing_address_1")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_city")).clear();
        driver.findElement(By.id("billing_city")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_postcode")).clear();
        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
        driver.findElement(By.id("billing_email")).clear();
        driver.findElement(By.id("billing_email")).sendKeys("test0630@test.com");
        Thread.sleep(5000);
        driver.findElement(By.id("place_order")).click();

        Thread.sleep(5000);


        Assert.assertEquals(
                driver.findElement(By.cssSelector(".woocommerce-notice")).getText(),
                "Thank you. Your order has been received."
        );





    }
}
