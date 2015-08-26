import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Project Euler #7: 10001st prime
 *
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler007
 */

public class Solution007 {

    private static List<Integer> primes = new ArrayList<Integer>(Arrays.asList(2)); // Initialise with 1st prime

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i=0; i<testCases; i++) {
            int test = in.nextInt();
            System.out.println(calcNthPrime(test));
        }
    }

    public static int calcNthPrime(int n) {
        int count = primes.get(primes.size()-1);
        if(primes.size() >= n) {
            return primes.get(n-1);
        }
        else {
            count+=1;
            while(primes.size()<n) {
                for(int i=0; i<primes.size(); i++) {
                    while(count%primes.get(i)==0) { 
                        count++; 
                        i=0;
                    }
                }
                primes.add(count);
                count++;
            }
        }
        return primes.get(n-1);
    }
}
