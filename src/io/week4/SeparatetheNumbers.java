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


public class SeparatetheNumbers {

    /*
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
        int i = 1;
        boolean result = false;
        String subStr = "";
        while (!result && i <= s.length() / 2) {
            subStr = s.substring(0, i);
            result = isSeparate(subStr, s.substring(i++));
        }

        System.out.println((result) ? "YES" + subStr : "NO");

    }

    private static boolean isSeparate(String pre, String s) {
        if (s.length() == 0) return true;
        String next = String.valueOf(Long.parseLong(pre) + 1);
        if (s.length() < next.length())
            return false;
        if (next.charAt(0) == '0')
            return false;
        String current = s.substring(0, next.length());
        if (next.equals(current))
            return isSeparate(next, s.substring(next.length()));

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();
                SeparatetheNumbers.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
