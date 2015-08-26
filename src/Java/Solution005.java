import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Project Euler #5: Smallest multiple
 *
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler005
 */

public class Solution005 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        long start = System.currentTimeMillis();
        for(int i=0; i<testCases; i++) {
            int test = in.nextInt();
            calcMultiples(test);
        }
        long stop = System.currentTimeMillis();
        System.err.println(stop-start + " ms");
    }

    public static void calculateSmallestMultiple(int num) {
        long n = num;

        for(int i=num; i>=1; i--) {
            while(n%i != 0) {
                n += num;
                i = num;
            }
        }
        System.out.println(n);
    }

    public static List<Integer> primeFactors(int num) {
        List<Integer> factors = new ArrayList<Integer>();
        for(int i=2; i<=num/i; i++){
            while(num%i==0) {
                factors.add(i);
                num/=i; // We want to multiples of the prime factors for each number
            }
        }
        if(num>1)   // The number itself is prime - add it!
            factors.add(num);
        return factors;
    }

    public static void calcMultiples(int num) {
        long multiples = 1;
        List<Integer> factors = new ArrayList<Integer>();
        List<Integer> factors4Num = new ArrayList<Integer>();
        int index= -1;
        for(int i=1; i<=num; i++) {           
            factors4Num = primeFactors(i);  // Add all prime factors for each number in range (2x2x3x5...) 
            for(int j=0; j<factors4Num.size(); j++) {
                index = factors.indexOf(factors4Num.get(j)); // Check if we already have a prime factor
                if(index!=-1) {
                    factors.remove(index);    // If we do, then remove it
                }
            }
            factors.addAll(factors4Num);  // Add all prime factors for new number.
        }
        for(int i=0; i<factors.size(); i++) {
            multiples *= factors.get(i);      // Multiply all prime factors to get smallest multiple from 1->n
        }
        System.out.println(multiples);
    }
}
