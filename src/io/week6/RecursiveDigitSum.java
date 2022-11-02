package io.week6;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class RecursiveDigitSum {
    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */


    // Bruteforce
    public static int superDigit(String n, int k) {
        int s = Sum(n);

        while (s > 9)
            s = Sum(String.valueOf(s));

        s = Sum(String.valueOf(s * k));
        while (s > 9)
            s = Sum(String.valueOf(s));

        return s;

    }

    private static int Sum(String n) {
        int sum = 0;
        for (int i = 0; i < n.length(); i++)
            sum += Integer.valueOf(n.charAt(i) - '0');
        return sum;

    }


    public static int superDigit_simplified(String n, int k) {
        if (n.length() == 1)
            return Integer.valueOf(n);

        int sum = calculateSum(n);
        sum *= k;
        while (sum > 9)
            sum = calculateSum(String.valueOf(sum));

        return sum;
    }

    private static int calculateSum(String n) {
        int sum = 0;
        for (char i : n.toCharArray())
            sum += Character.getNumericValue(i);
        return sum;
    }

    //Recursive
    public static int superDigit_recursive(String n, int k) {
        if (n.length() == 1 && k == 1)
            return Integer.valueOf(n);
        else {
            int sum = 0;
            for (char c : n.toCharArray())
                sum += Character.getNumericValue(c);
            sum *= k;
            return superDigit_recursive(String.valueOf(sum), 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = RecursiveDigitSum.superDigit_recursive(n, k);
        System.out.println(result);
        //   bufferedWriter.write(String.valueOf(result));
        //   bufferedWriter.newLine();

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
