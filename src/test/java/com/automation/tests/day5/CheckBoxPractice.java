package com.automation.tests.day5;

import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/checkboxes");
//        Thread.sleep(3000);
//        driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)")).click();
//        Thread.sleep(3000);

        // find all elements with tag name input
        List<WebElement> checkboxes = driver.findElements(By.xpath("input[@type='checkboxes']"));
        // loop through this list ig elements
        for(WebElement checkbox : checkboxes){
            Thread.sleep(3000);
            // if checkbox is not selected yet
            if(! checkbox.isSelected()){
                checkbox.click();
            }
        }

        driver.quit();
    }
}
