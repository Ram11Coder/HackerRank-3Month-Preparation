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


public class SumVsXOR {

    /*
     * Complete the 'sumXor' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long sumXor_optimised(long n) {
        int c=0;
        while (n > 0) {
            if (n % 2 == 0)
                c++;
            n/= 2;
        }
        return (long) Math.pow(2,c);

    }

//Simplified the code
    public static long sumXor(long n) {
        long res=1;
        while (n > 0) {
            if ((n & 1) == 0)
                res*=2;
            n/= 2;
        }
        return res;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = SumVsXOR.sumXor_optimised(n);
        System.out.println(result);
        //  bufferedWriter.write(String.valueOf(result));
        //    bufferedWriter.newLine();

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
