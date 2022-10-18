package io.week3;


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


public class MaximumPerimeterTriangle {
    /*
     * Complete the 'maximumPerimeterTriangle' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY sticks as parameter.
     */

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        int n = sticks.size(), max = Integer.MIN_VALUE;
        List<Integer> maxPerimeter = new ArrayList<>();
        if (sticks.size() < 3) {
            return Arrays.asList(-1);
        }
        Collections.sort(sticks);
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (isTriangle(sticks.get(i), sticks.get(j), sticks.get(k)) && max <= (sticks.get(i) + sticks.get(j) + sticks.get(k))) {
                      //  if (max == (i + j + k))
                            maxPerimeter = longestMinumumSide(maxPerimeter, Arrays.asList(sticks.get(i), sticks.get(j), sticks.get(k)));
                      //  else
                      //      maxPerimeter = Arrays.asList(i, j, k);
                        max = sticks.get(i)+sticks.get(j)+ sticks.get(k);
                    }
                }
            }
        }
        return maxPerimeter;
    }

    private static List<Integer> longestMinumumSide(List<Integer> preMaxPerimeter, List<Integer> newMaxPerimeter) {
        if (preMaxPerimeter.size() == 0)
            return newMaxPerimeter;
        return (getMin(preMaxPerimeter) < getMin(newMaxPerimeter)) ? preMaxPerimeter : newMaxPerimeter;
    }

    private static int getMin(List<Integer> list) {
        return Math.min(Math.min(list.get(0), list.get(1)), Math.min(list.get(1), list.get(2)));
    }

    private static boolean isTriangle(int i, int j, int k) {
        if (i + j <= k || i + k <= j || j + k <= i)
            return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = MaximumPerimeterTriangle.maximumPerimeterTriangle(sticks);
        System.out.println(result);
       /* bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );*/

        bufferedReader.close();
        //  bufferedWriter.close();
    }
}
