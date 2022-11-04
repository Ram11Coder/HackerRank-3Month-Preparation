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

import static java.util.stream.Collectors.*;


public class CounterGame {


    /*
     * Complete the 'counterGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts LONG_INTEGER n as parameter.
     */
//My solution
    public static String counterGame(long n) {
        if (n == 1)
            return "Richard";
        long power[] = new long[63];

        for (int i = 0; i < power.length; i++)
            power[i] = (long) Math.pow(2, i);

        int c = 0;
        while (n > 1) {
            n = findLowestPowerOf2(power, n);
            c++;
        }
        return c % 2 == 1 ? "Louise" : "Richard";
    }

    private static long findLowestPowerOf2(long[] power, long n) {

        int start = 0, end = power.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (power[mid] == n)
                return n / 2;
            if (power[mid] > n)
                end = mid - 1;
            else
                start = mid + 1;

        }
        return n - power[start - 1];
    }

    // My solution can be improvised further

    /**
     * Using log2(n)
     * ex: n=16
     * log2(2^4)
     * power - 4
     * Formula:
     * power = (int) (Math.log(n) / Math.log(2));
     */
    public static String counterGame_Optimised(long n) {
        if (n == 1)
            return "Richard";
        //calculating lowest power of n using log
        int c = 0;
        while (n > 1) {
            int power = (int) (Math.log(n) / Math.log(2));
            long pow = (long) Math.pow(2, power);
            n = (n == pow) ? n / 2 : n - pow;
            c++;
        }
        return c % 2 == 1 ? "Louise" : "Richard";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                String result = CounterGame.counterGame_Optimised(n);

                System.out.println(result);
                //       bufferedWriter.write(result);
                //        bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        //  bufferedWriter.close();
    }
}
