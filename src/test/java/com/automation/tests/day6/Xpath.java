package com.automation.tests.day6;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(3);

        // value can be inside single quotes (' ') or double (" ")
        // if you don't know the tag name, or want to skip tag name, use *
        // for example, //*[@onclick='button1()']  | * means any tag name
        WebElement btn1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        btn1.click();

        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());

        WebElement btn2 = driver.findElement(By.xpath("//button[text()='Button 2']"));
        btn2.click();
        System.out.println(result.getText());

        WebElement btn3 = driver.findElement(By.xpath("//button[starts-with(@id,'button_')]"));
        btn3.click();
        System.out.println(result.getText());

        WebElement btn4 = driver.findElement(By.xpath("//button[contains(@id,'_button')][1]"));
        btn4.click();
        System.out.println(result.getText());

        WebElement btn5 = driver.findElement(By.xpath("//button[5]"));
        btn5.click();
        System.out.println(result.getText());

        WebElement btn6 = driver.findElement(By.xpath("//button[contains(text(),'5')]"));
        btn6.click();
        System.out.println(result.getText());


        BrowserUtils.wait(3);
        //driver.quit();
    }
}
