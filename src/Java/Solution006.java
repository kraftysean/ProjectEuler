import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Project Euler #6: Sum square difference
 *
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler006
 */

public class Solution006 {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i=0; i<testCases; i++) {
            int num = in.nextInt();
            long sSquares = sumOfSquares(num);
            long sSum = squareOfSum(num);
            System.out.println(diff(sSquares,sSum));
        }
    }

    static long sumOfSquares(int n) throws Exception {
        long result=0;
        for(int i=0; i<=n; i++)
            result += i*i;
        return result;
    }

    static long squareOfSum(int n) {
        long result = 0;
        for(int i=0; i<=n; i++)
            result += i;
        return result*=result;
    }

    static long diff(long sum, long square) {
        return Math.abs(square-sum);
    }
}
