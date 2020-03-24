package com.automation.tests.day4;

import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FindElementByCSS {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Anastasiya");
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Tiunova");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("AnaTiu");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("email@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Something");
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("123-456-7890");
        driver.findElement(By.cssSelector("input[value='female']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("10/10/1996");
        Select select = new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        select.selectByVisibleText("SDET");
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(3000);

        driver.close();
    }
}
