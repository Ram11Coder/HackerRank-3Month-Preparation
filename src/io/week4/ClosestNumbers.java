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


public class ClosestNumbers {
    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        Collections.sort(arr);
        List<Integer> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {

            int val = arr.get(i) - arr.get(i - 1);

            if (val < min) {
                min = val;
                result.clear();
                result.add(arr.get(i - 1));
                result.add(arr.get(i));
            } else if (val == min) {
                result.add(arr.get(i - 1));
                result.add(arr.get(i));
            }

        }
        return result;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = ClosestNumbers.closestNumbers(arr);
        System.out.println(result);
      /*  bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );*/

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
