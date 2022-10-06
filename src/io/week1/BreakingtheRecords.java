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


public class BreakingtheRecords {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int minCount = 0, maxCount = 0;
        if (scores == null || scores.size() == 0) {
            return Arrays.asList(0, 0);
        }
        int min, max;
        min = max = scores.get(0);
        for (int i = 1; i < scores.size(); i++) {
            int score = scores.get(i);
            if (score > max) {
                max = score;
                maxCount++;
            }
            if (score < min) {
                min = score;
                minCount++;
            }
        }
        return Arrays.asList(maxCount, minCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = BreakingtheRecords.breakingRecords(scores);
        System.out.println(result);
/*        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );*/

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
