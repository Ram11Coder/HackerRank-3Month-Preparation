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


public class TimeConversion {
    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        String[] hour = s.split(":");
        int hr = Integer.valueOf(hour[0]);
        if (s.contains("PM") && hr < 12)
            s = s.replace(hour[0], (hr + 12) + "");
        else if (s.contains("AM") && hr == 12)
            s = s.replace(hour[0], "00").replace("AM", "");

        return s.replaceAll("[A-Z]", "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = TimeConversion.timeConversion(s);
        System.out.printf(result);
        //  bufferedWriter.write(result);
        //     bufferedWriter.newLine();

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
