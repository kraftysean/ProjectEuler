import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Project Euler #4: Largest Palindrome Product
 *
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler004
 */

public class Solution004 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i=0; i<testCases; i++) {
            int test = in.nextInt();
            calculateLargestPalindrome(test);
        }
    }

    public static void calculateLargestPalindrome(int num) {
        List<Integer> palindromeList = new ArrayList<Integer>();
        int sum = 0;
        int reverse = 0;
        for(int i=100; i<=999; i++) {
            for(int j=100; j<=999; j++) {
                sum = i*j;
                if(sum>=100000&&sum<num) {
                    reverse = reverseNumber(sum);
                    if(sum==reverse) {
                        palindromeList.add(sum);
                    }
                }
            }
        }
        Collections.sort(palindromeList);
        System.out.println(palindromeList.get(palindromeList.size()-1));
    }

    public static int reverseNumber(int num) {
        int n, reverse = 0;
        n = num;
        while( n != 0 ) {
            reverse = reverse * 10;
            reverse = reverse + n%10;
            n = n/10;
        }
        return reverse;
    }
}
