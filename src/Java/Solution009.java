import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Project Euler #9: Special Pythagorean triplet
 *
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler009
 */

public class Solution009 {

    public static int calcProduct(int num) {
        List<Integer> highestProduct = new ArrayList<Integer>();
        for(int x=1; x<num/2; x++) {
            for(int y=x+1; y<num/2; y++) {
                int z = num-x-y;
                if(x*x+y*y == z*z) {
                    highestProduct.add(x*y*z);
                }
            }
        }
        if(highestProduct.isEmpty())
            return -1;
        else {
            return highestProduct.get(highestProduct.size()-1);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i=0; i<testCases; i++) {
            int test = in.nextInt();
            System.out.println(calcProduct(test));
        }
    }
}
