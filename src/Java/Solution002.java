import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Project Euler #2: Even Fibonacci numbers
 *
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler002
 *
 */
public class Solution002 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        ArrayList fibSeq = new ArrayList();
        for(int i=0; i<testCases; i++) {
            long num = in.nextLong();
            System.out.println(fib(num));
        }
    }

    static long fib(long n) {
        int i=0;
        long sum=0;
        long fib=0;
        long x=1;
        long y=1;
        while(fib<=n) {
            if(fib%2==0)
                sum+=fib;
            fib=x;
            x=y;
            y=fib+x;
        }
        return sum;
    }
}
