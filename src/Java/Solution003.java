import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Project Euler #3: Largest prime factor
 *
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler003
 */

public class Solution003 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i=0; i<testCases; i++) {
            long test = in.nextLong();
            calculateLargestPrimeFactor(test);
        }
    }

    public static void calculateLargestPrimeFactor(long num) {
        List<Long> factors = new ArrayList<Long>();
        for(long i=2; i<=num/i; i++){            
            while(num%i==0) {
                factors.add(i);
                num/=i;
            }
        }
        if(num>1) {
            factors.add(num);
        }
        System.out.println(factors.get(factors.size()-1));
    }  
}
