//package com.automation.tests.day8;
//
////import com.automation.utilities.BrowserUtils;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import java.util.List;
//
//
//public class SearchTests {
//    private WebDriver driver;
//
//    @Test
//    public void googleSearchTest() throws InterruptedException {
//        driver.get("http://google.com");
//        Thread.sleep(4000);
//
//        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
//        Thread.sleep(4000);
//        // BrowserUtils.wait(2);
//        // since every search item has a tag name <h3>
//        // it's the easiest wat to collect all of them
//        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
//        for(WebElement searchItem : searchItems){
//            System.out.println(searchItem.getText());
//            // if there is a text = print it
//            if(!var.isEmpty()){
//                System.out.println(var);
//                // verify that every search result contains java
//                //is some of the search results
//                //doesn't contain java word, it will fail the test
//                Assert.assertTrue(var.toLowerCase().contains("java"));
//                System.out.println(var.toLowerCase());
//                System.out.println();
//            }
//        }
//    }
//    /**
//     * Given user is on the amazon.com page
//     * When user enters "java" as a search item
//     * Then user clicks on the search button
//     * And user clicks on the first search item
//     * And user verifies that title of the search item contains "Java"
//     */
//    @Test(description = "Search for Java book on Amazon")
//    public void amazonSearchTest() throws InterruptedException {
//        driver.get("http://amazon.com");
//        Thread.sleep(4000);
//       // BrowserUtils.wait(5);
//
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
//        Thread.sleep(4000);
//
//        List<WebElement> searchItems = (List<WebElement>) driver.findElement(By.tagName("//h2//a"));
//
//        //click on the first item
//        for(WebElement searchItem : searchItems){
//            System.out.println("Title: " +searchItem.getText());
//        }
//        searchItems.get(0).click();
//        Thread.sleep(4000);
//       // BrowserUtils.wait(5);
//
//        WebElement productTitle = driver.findElement(By.id("title"));
//        String productTitleString = productTitle.getText();
//        System.out.println(productTitleString);
//        Assert.assertTrue(productTitleString.contains("Java"));
//    }
//
//    @BeforeMethod
//    public void setup(){
//        // set up webdriver
//        WebDriverManager.chromedriver().version("79").setup();
//        driver = new ChromeDriver();
//    }
//
//    @AfterMethod
//    public void teardown(){
//        // close browser and destroy webdriver object
//        driver.close();
//
//    }
//}
