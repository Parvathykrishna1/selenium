package com.obsqura.testngbasis;

import org.testng.annotations.Test;

public class AnnotationBasisTwo {
    @Test(priority = 4)
    public void verifyTestFour() {
        System.out.println("Test1");
    }

    @Test(priority = 5)
    public void verifyTestFive() {
        System.out.println("Test2");
    }
}
