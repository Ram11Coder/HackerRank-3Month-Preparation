package io.week1;

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


public class MinMaxSum {
    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {

        long sum = 0L;
        for (int i : arr)
            sum += i;

        long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
        for (int i : arr) {
            if (sum - i > max)
                max = sum - i;
            if (sum - i < min)
                min = sum - i;
        }
        System.out.println(min +" "+max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        MinMaxSum.miniMaxSum(arr);

        bufferedReader.close();
    }
}
