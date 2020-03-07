package com.automation.OfficeHour;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOH2 {
    public static void main(String[] args) throws InterruptedException {
        /*
        1. Go to http://automationpractice.com
        2. Search for 't-shirt' in a search box + click enter OR click search button
        3. validate you got 'no results' message on UI
        4. Search fot 't-shirt'
        5. Validate there was 1 result found
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com");
        WebElement search_box = driver.findElement(By.id("search_query_top"));
        // WebElement - class in selenium/java and it has many useful methods
        // .sendKeys("value that we want to send - input tag")
        search_box.sendKeys("tshirt" + Keys.ENTER);

        /*
        <p class="alert alert-warning">
                     No results were found fot your search&nbsp;"tshirt"
                </p>
         */
        try {
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        WebElement error = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
        String errorText = error.getText();
        // .getText() -> returns String (text) from the element
        System.out.println("Error message " + errorText);
        // NoSuchElementException - it means we could not locate the element
        search_box = driver.findElement(By.id("search_query_top"));
        // .clear() - (void) it will delete any values from input box
        search_box.sendKeys("t-shirt" + Keys.ENTER);
        // StateElementReferenceException - element is old/state - we want to find
        // this element again or refresh page

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
           e.printStackTrace();
        }
        WebElement count = driver.findElement(By.className("product-count"));
        System.out.println("items found: " + count.getText());
        /*
        <a class "button ajax_add_to_cart_button btn btn-default"
        href="http://automationpractice.com/index.php?
        controller=cart&amp;add=1&amp;id_product=1&amp;token=e817bb0
        705dd58da8db074c69f729fd8"
        rel="nofollow" title="Add to cart" data-id-product="1">
              <span>Add to cart </span>
              </a>
          a - link
          span - description
         */
        
        WebElement addToCart = driver.findElement(By.className("button ajax_add_to_cart_button btn btn-default"));
        addToCart.click();

       // driver.quit();

    }
}
