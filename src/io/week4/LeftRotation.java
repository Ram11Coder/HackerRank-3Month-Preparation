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


public class LeftRotation {
    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     *
     * Time complexity - O(n*d)
     * Space complexity -O(1)
     */

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        for (int i = 0; i < d; i++) {
            int val = arr.get(0);
            for (int j = 0; j < arr.size() - 1; j++) {
                arr.set(j, arr.get(j + 1));
            }
            arr.set(arr.size() - 1, val);
        }
        return arr;
    }

    /**
     * Time complexity - O(n)
     * Space complexity - O(1)
     *
     * @param d
     * @param arr
     * @return
     */
    public static List<Integer> rotateLeft_swap(int d, List<Integer> arr) {
        int n = arr.size() - 1;
        if (d <= n) {
            swapList(arr, 0, n);//reverse the array
            swapList(arr, 0, n - d);//reverse the array n-d part
            swapList(arr, arr.size() - d, n);// reverse the remaining part
        }
        return arr;
    }

    private static void swapList(List<Integer> arr, int i, int j) {
        while (i < j) {
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = LeftRotation.rotateLeft_swap(d, arr);
        System.out.println(result);
        /*bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );*/

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
