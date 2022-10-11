package io.week3;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;


public class SalesbyMatch {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        int count[] = new int[101];
        for (int i : ar)
            count[i]++;
        int pairs = 0;
        for (int i : count)
            pairs += (i / 2);
        return pairs;
    }


    //Added just for reference
    public static int sockMerchant_Java8(int n, List<Integer> ar) {
        int i = 0;
        List<Integer> sorted = ar.stream().sorted().collect(Collectors.toList());
        int counter = 0;
        while (i < sorted.size()) {
            final int current = sorted.get(i);
            int frequence = sorted.stream().filter(number -> number == current)
                    .collect(Collectors.toList()).size();

            counter += frequence / 2;
            i += frequence;
        }

        return counter;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> ar = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arTemp[i]);
            ar.add(arItem);
        }

        int result = SalesbyMatch.sockMerchant(n, ar);
        //int result = SalesbyMatch.sockMerchant_Java8(n, ar);
        System.out.println(result);

        // bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
