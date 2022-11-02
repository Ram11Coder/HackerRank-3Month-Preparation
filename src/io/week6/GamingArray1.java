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


public class GamingArray1 {
    /*
     * Complete the 'gamingArray' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
//Brute force - O(n^2)
    public static String gamingArray(List<Integer> arr) {
        int count = 0;
        while (true) {
            int maxIndex = getMaxIndex(arr);
            if (maxIndex == -1)
                break;
            arr = arr.subList(0, maxIndex);
            count++;
        }
        return (count % 2 == 0) ? "ANDY" : "BOB";
    }

    public static int getMaxIndex(List<Integer> arr) {
        int max = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = 0; i < arr.size(); i++) {
            if (max < arr.get(i)) {
                maxIndex = i;
                max = arr.get(i);
            }
        }
        return maxIndex;
    }


    /**
     * Optimised solution 1
     * Time complexity - O(n)
     * Space Complexity -O(n)
     */
    public static String gamingArray_optimised1(List<Integer> arr) {
        int[] list = new int[arr.size()];
        int val = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (val < arr.get(i)) {
                list[i] = arr.get(i);
                val = arr.get(i);
            } else {
                list[i] = val;
            }
        }
        int count = 0;
        for (int i = list.length - 1; i > 0; i--) {
            if (list[i] > list[i - 1]) {
                count++;
            }
        }
        count++;
        return (count % 2 == 0) ? "ANDY" : "BOB";
    }


    /**
     * Optimised solution 2
     * Time complexity - O(n)
     * Space Complexity -O(1)
     */

    public static String gamingArray_optimised2(List<Integer> arr) {
        int count = 0, max = Integer.MIN_VALUE;

        for (int i : arr) {
            if (max < i) {
                count++;
                max = i;
            }
        }
        return (count % 2 == 0) ? "ANDY" : "BOB";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = GamingArray1.gamingArray_optimised2(arr);
                System.out.println(result);
                //        bufferedWriter.write(result);
                //        bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
