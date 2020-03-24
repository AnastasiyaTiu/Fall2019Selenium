package com.automation.tests.day6;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);
        List<WebElement> buttons =driver.findElements(By.tagName("button"));
        buttons.get(0).click(); // to click on the first button
        BrowserUtils.wait(2);

        // to get text from popup message
        String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);

        driver.switchTo().alert().accept();   // to click OK

        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        // it will fail because there is a typo
        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
        }
        BrowserUtils.wait(3);
        buttons.get(1).click(); // to click the 2nd button
        BrowserUtils.wait(2);
        // click cancel
        driver.switchTo().alert().dismiss(); // must be: You clicked: Cancel

        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();

        if(expected2.equals(actual2)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected2: " + expected2);
            System.out.println("Actual2: " + actual2);
        }

        buttons.get(2).click();
        BrowserUtils.wait(3);
        Alert alert = driver.switchTo().alert();
       alert.sendKeys("Hello, World!");
       alert.accept();  // click ok

       String expected3 = "Hello, World!";
        String actual3 = driver.findElement(By.id("result")).getText();

        if (actual3.endsWith(expected3)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected3: " + expected3);
            System.out.println("Actual3: " + actual3);
        }

        BrowserUtils.wait(3);
        driver.quit();
    }
}
