package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcheckout {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("Jelena");
        driver.findElement(By.id("last-name")).sendKeys("Disic");
        driver.findElement(By.id("postal-code")).sendKeys("11070");
        driver.findElement(By.id("continue")).click();

        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.equals("https://www.saucedemo.com/checkout-step-two.html")) {
            System.out.println("passed");
        }
        else {
            System.out.println("failed");

        }


    }
}
