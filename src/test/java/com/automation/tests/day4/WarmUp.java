package com.automation.tests.day4;

import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WarmUp {
static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        ebayTest();
        amazonTest();
        wikipediaTest();
    }
    /**
     * Go to ebay --->          driver.get("http://ebay.com");
     * enter search term        input.sendKeys("java book");
     * click on search button   searchButton.click();
     * print number of results  */

    public static void ebayTest() throws InterruptedException {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();

        Thread.sleep(3000);

        WebElement searchResults = driver.findElement(By.tagName("h1"));

        String[] searchSentence = searchResults.getText().split(" ");
        System.out.println(searchSentence[0]);
        driver.quit();
    }
    /**
     * go to amazon
     * enter search term
     * click on search button
     * verify title contains search term
     */
    public static void amazonTest() throws InterruptedException {
        driver = DriverFactory.createDriver("chrome") ;
        driver.get("http://amazon.com");
        // enter text and click ENTER
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);

        Thread.sleep(3000);

        String title = driver.getTitle();
        if(title.contains("java book")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }
        driver.quit();
    }
    /**
     * Go to wikipedia.org
     * enter search term `selenium webdriver`
     * click on search button
     * click on search result `Selenium (software)`
     * verify url ends with `Selenium_(software)`
     */
    public static void wikipediaTest() throws InterruptedException {
        driver = DriverFactory.createDriver("chrome");
        // Go to wikipedia.org
        driver.get("http://en.wikipedia.org");
        // enter search term `selenium webdriver`& click on search button
        driver.findElement(By.id("searchInput")).sendKeys("Selenium webdriver", Keys.ENTER);

        Thread.sleep(3000);

        // click on search result `Selenium (software)`
        driver.findElement(By.linkText("Selenium (software)")).click();

        Thread.sleep(3000);
         // verify url ends with `Selenium_(software)`
        String link = driver.getCurrentUrl(); // to get link as a String
        if (link.endsWith("Selenium_(software)")){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }
        driver.quit();

    }
}
