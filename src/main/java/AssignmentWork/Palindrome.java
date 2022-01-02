package AssignmentWork;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        int num, temp ;
        int rem , sum = 0;
        System.out.println("ENTER A NUMBER::");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        temp = num;
        while (num != 0) {
            rem = num % 10;
            sum = sum * 10 + rem;
            num = num / 10;
        }
        System.out.println(sum);
        if (temp == sum)
            System.out.println("Palindrome");
        else
            System.out.println("Not palindrome");
    }
}
