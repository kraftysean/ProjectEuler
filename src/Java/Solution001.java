import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Project Euler #1: Multiples of 3 and 5
 *
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler001
*/

public class Solution001 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i=0; i<testCases; i++) {
            int test = in.nextInt();      
            calcSumOfMultiples(test);
        }
    }

    public static void calcSumOfMultiples(int num) {
        long result=0;
        long d3 = 3;
        long d5 = 5;
        long d15 = 15;
        long terms3 = (num-1)/d3;
        long terms5 = (num-1)/d5;
        long terms15 = (num-1)/d15;
        long nth3 = terms3*d3;
        long nth5 = terms5*d5;
        long nth15 = terms15*d15;
        // Using Arithmetic Progression & Series...
        result += terms3*(d3+nth3)/2;      // All multiples of 3
        result += terms5*(d5+nth5)/2;      // All multiples of 5
        result -= terms15*(d15+nth15)/2;   // Minus all multiples of lowest common denominator
        
        System.out.println(result);
    }
}
