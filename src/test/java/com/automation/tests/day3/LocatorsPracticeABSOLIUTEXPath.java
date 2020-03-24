package com.automation.tests.day3;

import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorsPracticeABSOLIUTEXPath {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        WebElement headerText = driver.findElement(By.xpath("//span[@class='h1y']"));
        WebElement contextMenuLink = driver.findElement(By.xpath("//a[.='Context Menu']"));
        System.out.println("h1 text: " + headerText.getText());
        contextMenuLink.click();


        Thread.sleep(3000);
        driver.close();

    }
}
