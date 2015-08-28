import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution010 {

    private static final int MAX = 1000000;  // Max value of N
    
    public static boolean[] simpleSieve() {
        boolean[] sieve = new boolean[MAX+1];
        // Sieve of Eratosthenes
        Arrays.fill(sieve, true);  //true = prime, false = composite
        sieve[0] = false; // 0 - not prime
        sieve[1] = false; // 1 - not prime

        // 1. All even numbers greater than 2 are composite => Set as false 
        for(int i = 4; i <= MAX; i+=2) {
            sieve[i] = false; 
        }

        // 2. Numbers greater than square root of N are composite, iterate through odd numbers to find primes
        int limit = (int)Math.sqrt(MAX);
        for(int i = 3; i <= limit; i+=2) {
            // 3. If 'i' is prime, set all multiples of i to false for N
            if(sieve[i]) {
                for(int j = i*i; j <= MAX; j+=i) { 
                    sieve[j] = false; }
            }
        }
        // 4. Any remaining numbers after square root must be prime
        return sieve;
    }

    public static List<Long> sumOfPrimes(boolean[] primes)
    {
        List<Long> sums = new ArrayList<Long>();
        long sum = 0;
        for(int i = 0; i < primes.length; i++) {
            if(primes[i]) { 
                sum += i; 
                sums.add(sum);
            }
            else {
                sums.add(sum);
            }
        }
        return sums;
    }

    public static void main(String[] args) {
        boolean[] sieve = simpleSieve();        // Pre-compute list of primes
        List<Long> sums = sumOfPrimes(sieve);   // Pre-compute list of sums
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i = 0; i < testCases; i++)
            System.out.println(sums.get(in.nextInt()));
    }
}
