package AssignmentWork;

public class PrimeSum {
    public PrimeSum() {
    }

    public void findSum() {
        int sum = 0;

        for(int number = 1; number <= 100; ++number) {
            int count = 0;

            for(int i = 2; i <= number / 2; ++i) {
                if (number % i == 0) {
                    ++count;
                    break;
                }
            }

            if (count == 0 && number != 1) {
                sum += number;
            }
        }

        System.out.println("\n The Sum of Prime Numbers from 1 to 100 = " + sum);
    }

    public static void main(String[] args) {
        PrimeSum obj = new PrimeSum();
        obj.findSum();
    }
}
