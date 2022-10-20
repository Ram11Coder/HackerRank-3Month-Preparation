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

    public static int pickingNumbers(List<Integer> a) {
        if (a.size() <= 2)
            return a.get(0);
        Collections.sort(a);
        int count = 1, max = 0, maxIndexValue = 0, value = a.get(0);
        for (int i = 1; i < a.size() - 1; i++) {
            if (Math.abs(a.get(i) - value) <= 1)
                count++;
            else if (Math.abs(a.get(i) - value) > 1) {
                value = a.get(i);
                if (max < count) {
                    count = max;
                    maxIndexValue = a.get(i);
                }
                count = 1;
            }
        }

        if (max < count) {
            count = max;
            maxIndexValue = a.get(a.size() - 1);
        }

        return maxIndexValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = PickingNumbers.pickingNumbers(a);
        System.out.println(result);
        //  bufferedWriter.write(String.valueOf(result));
        //  bufferedWriter.newLine();

        bufferedReader.close();
        //  bufferedWriter.close();
    }
}
