//package com.automation.tests.day8;
//
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class BasicTestingTests {
//
//    public class TestiNG2{
//        // runs only once in the class before @beforemethod and before any test
//        // regardless on number of tests, it runs only once
//        @BeforeMethod
//    public void beforeClass(){
//        System.out.println("BEFORE CLASS");
//    }
//
//    @AfterClass
//    //
//    public void afterClass(){
//        System.out.println("AFTER CLASS");
//    }
//
//    @Test
//    public void test1(){
//        System.out.println("Test 1");
//        String expected = "apple";
//        String actual = "apple";
//        Assert.assertEquals(actual, expected);
//    }
//
//    @Test
//    public void test2(){
//        System.out.println("Test 2");
//        int num1 = 5;
//        int num2 = 10;
//        // it calls hard assertion
//        // if assertion fails - it stops the execution (due to exception)
//        Assert.assertTrue(num1 > num2);
//    }
//}
