import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Project Euler #8: Largest product in a series
 *
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler008
 */

public class Solution008 {

    public static long calcLargestProduct(int sequence, int range, String test) {
        long result = 0;
        for(int i=0; i<(sequence-range)+1; i++) {
            long temp = 0;
            String digits = test.substring(i,i+range);
            if(digits.indexOf('0') != -1) temp = 0;
            else{
                temp = 1;
                for(int j=0; j<range; j++) {
                    int x = Integer.parseInt(digits.substring(j,j+1));
                    temp *= x;
                }
            }
            if(result<temp) result=temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i=0; i<testCases; i++) {
            int N = in.nextInt();
            int K = in.nextInt();
            String test = in.next();
            System.out.println(calcLargestProduct(N, K, test));
        }
    }
}
