package org.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class MyFirstTestCase {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {


//        HashMap<String, Object> prefs = new HashMap<>();
//        prefs.put("profile.default_content_setting_values.notifications",Integer.valueOf(2));
//        prefs.put("credentials_enable_service",false);
//        prefs.put("profile.password_manager_enabled",false);
//
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs",prefs);
//        options.addArguments("--disable-notifications");
//        options.addArguments("--disable-infobars");
//
//
//        WebDriver driver = new ChromeDriver(options);
        System.setProperty("webdriver.chrome.driver","C:\\Users\\jenys\\software\\chromedriver.exe");
        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);


        driver.get("https://askomdch.com");
        driver.manage().window().maximize();
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

        driver.quit();




    }

//    @Test
//    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {
//
//
//        HashMap<String, Integer> prefs = new HashMap<>();
//        prefs.put("profile.default_content_setting_values.notifications",2);
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs",prefs);
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.get("https://askomdch.com");
//        driver.manage().window().maximize();
//        driver.findElement(By.cssSelector("#menu-item-1227>a")).click();
//        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
//        driver.findElement(By.cssSelector("button[value='Search']")).click();
//
//        Assert.assertEquals(
//                driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),
//                "Search results: “Blue”"
//        );
//
//        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
//
//        Thread.sleep(3000);
//
//        driver.findElement(By.cssSelector("a[title='View cart']")).click();
//        Assert.assertEquals(
//                driver.findElement(By.cssSelector("td[class='product-name']>a")).getText(),
//                "Blue Shoes"
//        );
//
//        driver.findElement(By.cssSelector(".wc-proceed-to-checkout>a")).click();
//
//        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
//        driver.findElement(By.id("billing_last_name")).sendKeys("user");
//        driver.findElement(By.id("billing_address_1")).sendKeys("San Francisco");
//        driver.findElement(By.id("billing_city")).sendKeys("San Francisco");
//        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
//        driver.findElement(By.id("billing_email")).sendKeys("test@test.com");
//        Thread.sleep(5000);
//        driver.findElement(By.id("place_order")).click();
//
//        Thread.sleep(5000);
//
//
//        Assert.assertEquals(
//                driver.findElement(By.cssSelector(".woocommerce-notice")).getText(),
//                "Thank you. Your order has been received"
//        );
//
//        driver.quit();
//
//
//
//
//    }
}
