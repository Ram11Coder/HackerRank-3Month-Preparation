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


public class NumberLineJumps {

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     *
     *
     *  x1 v1 | x2 v2
     * formula
     * => x1+(v1*T)==x2+(v2*T)
     * x1-x2=T(v2-v1)
     * => T=x1-x2/v2-v1
     * => Meeting point = T
     *
     * =>  meeting point of x1 -> x1+(v1 *Meeting point (T))
     * =>  meeting point of x2 -> x2+(v2 *Meeting point (T))
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        int diff = Math.abs(v2 - v1);

        if (diff == 0)
            return "NO";
        int meetingPointT = Math.abs(x1 - x2) / diff;

        int meetingPointX1 = x1 + (meetingPointT * v1);
        int meetingPointX2 = x2 + (meetingPointT * v2);

        if (meetingPointX1 == meetingPointX2)
            return "YES";
        return "NO";

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = NumberLineJumps.kangaroo(x1, v1, x2, v2);
        System.out.println(result);
        // bufferedWriter.write(result);
        // bufferedWriter.newLine();

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
