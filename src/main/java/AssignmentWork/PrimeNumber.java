package AssignmentWork;
import java.util.Scanner;
public class PrimeNumber {
    public static void main(String[] args) {
            int min,max;
            Scanner sc = new Scanner(System.in);
            System.out.printf( "Enter lower bound :: ");
            min= sc.nextInt();
            System.out.printf( "\nEnter upper bound :: ");
            max= sc.nextInt();
            System.out.printf("\nPrime numbers between %d and %d are: ", min,max);
            for(int n=min;n<=max;n++) {
                if(isPrime(n)) {
                    System.out.println(n);
                }
            }
        }
        public static boolean isPrime(int num) {
            for(int i = 2; i <= num/i; ++i) {
                if(num % i == 0) {
                    return false;
                }
            }
            return true;
}
}
