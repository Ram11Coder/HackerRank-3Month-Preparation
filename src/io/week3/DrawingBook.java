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


public class DrawingBook {

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     * My solution
     */

    public static int pageCount(int n, int p) {
        int start = 1, end = n, rightCount = 0, leftCount = 0;
        /**
         * Searching front page of book always start from 1
         * Check every page with rigth and left side
         * so adding 2
         */
        while (start < p) {
            start += 2;
            rightCount++;
        }
        /**
         * If the target is current page then return 0
         */
        if (end % 2 == 1 && (end == p || end - 1 == p))
            return 0;

        /**
         * Searching back size of book start from n
         * if n is odd then it will be in right so flip page min value is n-3
         * if n is even then it will be in left so flip page min value is n-2
         *
         */
        while (p < end) {
            end -= (end % 2 == 0) ? 2 : 3;
            leftCount++;
        }
        return Math.min(rightCount, leftCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = DrawingBook.pageCount(n, p);
        System.out.println(result);
        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        bufferedReader.close();
        // bufferedWriter.close();

    }
}
