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


public class PickingNumbers {
    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    /**
     * 7
     * 1 2 2 2 2 3 3
     * 5
     * in the above case should return 6 not 5
     * proposed approach : pickingNumbers_hash method
     * <p>
     * Time complexity : O(n)
     * Space complexity : O(1)
     *
     * @param a
     * @return
     */
    public static int pickingNumbers(List<Integer> a) {
        Collections.sort(a);
        int count = 1, max = 0, value = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            if (Math.abs(a.get(i) - value) <= 1)
                count++;
            else if (Math.abs(a.get(i) - value) >= 2) {
                value = a.get(i);
                if (max < count) {
                    max = count;
                }
                count = 1;
            }
        }
        return (max < count) ? count : max;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     *
     * @param a
     * @return
     */
    public static int pickingNumbers_hash(List<Integer> a) {
        int freq[] = new int[101];

        for (int i : a)
            freq[i]++;

        int max = 0;
        for (int i = 1; i < freq.length - 1; i++) {
            int val = freq[i] + freq[i + 1];
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = PickingNumbers.pickingNumbers_hash(a);
        System.out.println(result);
        //  bufferedWriter.write(String.valueOf(result));
        //  bufferedWriter.newLine();

        bufferedReader.close();
        //  bufferedWriter.close();
    }
}
