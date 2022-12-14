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

public class DivisibleSumPairs {
    /*
     * Complete the 'divisibleSumPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY ar
     */
// O(n^2) solution
    public static int divisibleSumPairs(int n, int k, List<Integer> arr) {
        int pair = 0;
        for (int i = 0; i < n - 1; i++) {
            int val = arr.get(i);
            for (int j = i + 1; j < n; j++) {
                if ((val + arr.get(j)) % k == 0)
                    pair++;
            }
        }
        return pair;
    }

    // O(n) solution using map
    public static int divisibleSumPairs_Optimised(int n, int k, List<Integer> arr) {

        Map<Integer, Integer> map = new HashMap<>();
        int pairCount = 0;
        for (int i : arr) {
            int mod = i % k; // Apply module to track the elements divisible by k
            int comp = (mod == 0) ? 0 : k - mod;
            pairCount += (map.containsKey(comp)) ? map.get(comp) : 0;// If element present return value otherwise 0
            map.put(mod, (map.containsKey(mod)) ? map.get(mod) + 1 : 1);//Adding to the map already traversed element and incrementing
        }
        return pairCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = DivisibleSumPairs.divisibleSumPairs(n, k, ar);
        System.out.println(result);
        result = DivisibleSumPairs.divisibleSumPairs_Optimised(n, k, ar);
        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        bufferedReader.close();
        //  bufferedWriter.close();
    }
}
