package com.obsqura.testngbasis;


import org.testng.annotations.*;

public class AnnotationBasics {
    @BeforeSuite
   public void beforeSuiteMethod(){
       System.out.println("This is from before suite");
   }

   @BeforeTest
   public void beforeTestMethod(){
       System.out.println("This is from before Test");
    }

    @BeforeClass
    public void beforeClassMethod(){
        System.out.println("This is from before class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is from before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("This is from after method");
    }

    @AfterClass
    public void afterClassMethod(){
        System.out.println("This is from after class");
    }

    @AfterTest
    public void afterTestMethod(){
        System.out.println("This is from after Test");
    }

    @AfterSuite
    public void afterSuiteMethod(){
        System.out.println("This is from after Suite");
    }

    @Test(priority = 1)
    public void verifyTestOne() {
        System.out.println("Test1");
    }

    @Test(priority = 2)
    public void verifyTestTwo() {
        System.out.println("Test2");
    }

    @Test(priority = 3)
    public void verifyTestThree() {
        System.out.println("Test3");
    }
}
