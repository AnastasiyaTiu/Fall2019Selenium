package com.automation.tests.day5;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploading {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(5);

        WebElement upload = driver.findElement(By.id("file-upload"));

        // https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        // I am gonna upload pom.xml file
        String filePath = System.getProperty("user.dir") + "/pom.xml";
        String filePath2 = "C:/Users/18185/Documents/Credit Card Authorization Form Cybertek..pdf";

        upload.sendKeys(filePath);
        System.out.println(filePath);

        upload.sendKeys(filePath2);
        System.out.println(filePath2);

        driver.findElement(By.id("file-submit")).click(); // click to upload

        BrowserUtils.wait(3);
        driver.quit();
    }
}
