package AssignmentWork;
import java.util.Scanner;
public class ReverseNumber {
    public static void main(String[] args) {
        int num;
        int rem , sum = 0;
        System.out.println("ENTER A NUMBER::");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        while (num != 0) {
            rem = num % 10;
            sum = sum * 10 + rem;
            num = num / 10;
        }
        System.out.println("Reverse :: "+sum);
    }
}
