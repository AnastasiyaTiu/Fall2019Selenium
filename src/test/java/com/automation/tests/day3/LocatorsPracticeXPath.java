package com.automation.tests.day3;

import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorsPracticeXPath {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        WebElement dropDownLink = driver.findElement(By.xpath("/html/body/div/div[2]/div/ul/li[11]/a"));
        System.out.println(dropDownLink.getText());
        dropDownLink.click();

        Thread.sleep(3000);
        driver.close();

    }
}
