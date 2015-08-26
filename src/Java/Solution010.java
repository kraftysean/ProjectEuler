import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution010 {

    private static List<Integer> primes = new ArrayList<Integer>(Arrays.asList(2)); // Initialise with 1st prime

    public static int calcSumOfPrimes(int n) {
        int count = primes.get(primes.size()-1);
        if(primes.size() >= n) {
        //            return primes.get(n-1);
        //        }
        //        else {
        count+=1;
        while(count<n) {
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
    System.err.println(primes.toString());
    return primes.size();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i=0; i<testCases; i++)
            System.out.println(calcSumOfPrimes(in.nextInt()));
    }
}
