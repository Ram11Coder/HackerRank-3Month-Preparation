package io.week4;


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


public class MinimumAbsoluteDifferenceInAnArray {

    /*
     * Complete the 'minimumAbsoluteDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     *
     * Time Complexity - O(n^2)
     */

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int absValue = Math.abs(arr.get(i) - arr.get(j));
                if (absValue < min) {
                    min = absValue;
                }
            }
        }
        return min;
    }

    /**
     * Time Complexity - O(n*log(n))
     *
     * @param arr
     * @return
     */
    public static int minimumAbsoluteDifference_sort(List<Integer> arr) {

        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() - 1; i++) {
            int absValue = Math.abs(arr.get(i) - arr.get(i + 1));
            if (absValue < min)
                min = absValue;
        }
        return min;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = MinimumAbsoluteDifferenceInAnArray.minimumAbsoluteDifference(arr);
        System.out.println(result);

        result = MinimumAbsoluteDifferenceInAnArray.minimumAbsoluteDifference_sort(arr);
        System.out.println(result);
        //  bufferedWriter.write(String.valueOf(result));
        //  bufferedWriter.newLine();

        bufferedReader.close();
        //  bufferedWriter.close();
    }
}
