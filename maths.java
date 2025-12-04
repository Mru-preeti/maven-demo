import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number to check if it's prime: ");
        int number = scanner.nextInt();
        
        if(isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
        
        // Display prime numbers up to the entered number
        System.out.println("\nPrime numbers up to " + number + ":");
        for(int i = 2; i <= number; i++) {
            if(isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        scanner.close();
    }
    
    public static boolean isPrime(int num) {
        if(num <= 1) {
            return false;
        }
        if(num == 2) {
            return true;
        }
        if(num % 2 == 0) {
            return false;
        }
        
        for(int i = 3; i <= Math.sqrt(num); i += 2) {
            if(num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
