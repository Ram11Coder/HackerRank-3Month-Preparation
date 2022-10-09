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


public class Pangrams {
    /*
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {

        boolean isPanagram = true;
        int alphabets[] = new int[26];
        s = s.toLowerCase().replace(" ", "");

        for (int i = 0; i < s.length(); i++)
            alphabets[s.charAt(i) - 'a']++;

        for (int c : alphabets)
            if (c == 0) {
                isPanagram = false;
                break;
            }
        return (isPanagram) ? "pangram" : "not pangram";
    }


    public static String pangrams_Regex(String s) {

        boolean isPanagram = false;
        s = s.toLowerCase().replace(" ", "");
        if (s.matches("(?=.*a)(?=.*b)(?=.*c)(?=.*d)(?=.*e)(?=.*f)(?=.*g)(?=.*h)(?=.*i)(?=.*j)(?=.*k)(?=.*l)(?=.*m)(?=.*n)(?=.*o)(?=.*p)(?=.*q)(?=.*r)(?=.*s)(?=.*t)(?=.*u)(?=.*v)(?=.*w)(?=.*x)(?=.*y)(?=.*z).*")) {
            isPanagram = true;
        }
        return (isPanagram) ? "pangram" : "not pangram";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Pangrams.pangrams(s);
        System.out.println(result);

        result = Pangrams.pangrams_Regex(s);
        System.out.println(result);

        //  bufferedWriter.write(result);
        //  bufferedWriter.newLine();

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
