package com.obsqura.basic;

public class EvenNumber {
    public void print() {
        int sum = 0;
        for (int i=2;i <=50;i++) {
            int r = i % 2;
            if (r == 0) {
                sum = sum+i;
            }
        }
        System.out.println("Sum of even numbers "+"= "+sum);
    }
}
