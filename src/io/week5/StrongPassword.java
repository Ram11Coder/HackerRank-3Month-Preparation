package io.week5;


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


public class StrongPassword {

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
        if (password.length() <= 3) {
            return 6 - n;
        }
        int count = 4;

        boolean isUpper = true, isLower = true, isNumber = true, isSpecial = true;
        for (int i = 0; i < n; i++) {
            if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z' && isLower) {
                count--;
                isLower = false;
            } else if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z' && isUpper) {
                count--;
                isUpper = false;
            } else if (password.charAt(i) >= '0' && password.charAt(i) <= '9' && isNumber) {
                count--;
                isNumber = false;
            } else if (isSpecial && (password.charAt(i) == '!' || password.charAt(i) == '@' || password.charAt(i) == '#' ||
                    password.charAt(i) == '$' || password.charAt(i) == '%' || password.charAt(i) == '^' ||
                    password.charAt(i) == '&' || password.charAt(i) == '*' || password.charAt(i) == '(' ||
                    password.charAt(i) == ')' || password.charAt(i) == '-' || password.charAt(i) == '+')) {
                count--;
                isSpecial = false;
            }
        }
        // If the count and length which is greater than 6 then return count
        if (n >= 6 || n + count > 6) {
            return count;
        }

        return 6 - n;//if length greater than 3 and count is less than 3 then we need return 6 - length
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = StrongPassword.minimumNumber(n, password);
        System.out.println(answer);
        //  bufferedWriter.write(String.valueOf(answer));
        //  bufferedWriter.newLine();

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
