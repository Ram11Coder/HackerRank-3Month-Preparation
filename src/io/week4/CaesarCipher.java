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

public class CaesarCipher {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        k %= 26;
        if (k == 0)
            return s;
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++)
            if (Character.isAlphabetic(charArr[i])) { // Check alphabet in both capital and small characters only
                if ((Character.isLowerCase(charArr[i])) ? charArr[i] + k > 'z' : charArr[i] + k > 'Z')
                    charArr[i] = (char) ((charArr[i] - 26) + k);
                else
                    charArr[i] += k;
            }

        return String.valueOf(charArr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = CaesarCipher.caesarCipher(s, k);
        System.out.println(result);
        // bufferedWriter.write(result);
        // bufferedWriter.newLine();

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
