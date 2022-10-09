package io.week2;


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


public class CountingValleys {
    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        int seaLevel = 0, valleyCount = 0;
        boolean isValley = false;
        for (int i = 0; i < steps; i++) {
            if (path.charAt(i) == 'U')
                seaLevel += 1;
            else if (path.charAt(i) == 'D')
                seaLevel -= 1;
            if (seaLevel == -1) {
                isValley = true;
            }
            if (seaLevel == 0 && isValley) {
                valleyCount++;
                isValley = false;
            }
        }
        return valleyCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = CountingValleys.countingValleys(steps, path);
        System.out.println(result);
        //  bufferedWriter.write(String.valueOf(result));
        //  bufferedWriter.newLine();

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
