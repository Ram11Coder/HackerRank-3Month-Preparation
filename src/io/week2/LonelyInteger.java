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

public class LonelyInteger {
    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    /**
     * Using HashMap
     *
     * @param a
     * @return
     */
    public static int lonelyinteger_UsingHashMap(List<Integer> a) {
        if (a.size() == 1)
            return a.get(0);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a)
            map.put(i, (map.containsKey(i)) ? map.get(i) + 1 : 1);

        int result = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() == 1)
                result = entry.getKey();

        return result;
    }

    /**
     * All elements except one element occurs twice,
     * so using hash set to iterate it
     * 1. If element not present add it to set
     * 2. If present , remove it
     * 3. Finally only one element will be left, that is the result
     *
     * @param a
     * @return
     */
    public static int lonelyinteger_UsingHashSet(List<Integer> a) {
        if (a.size() == 1)
            return a.get(0);
        Set<Integer> set = new HashSet<>();
        for (int i : a)
            if (set.contains(i))
                set.remove(i);
            else
                set.add(i);

        return set.iterator().next();
    }

    /**
     * Using XOR
     * same bit(1,1 or 0,0) return 0
     * Opposite bit(1,0 or 1,0) return 1
     *
     * @param a
     * @return
     */
    public static int lonelyinteger_UsingXOR(List<Integer> a) {
        if (a.size() == 1)
            return a.get(0);
        int res = 0;
        for (int i : a)
            res ^= i;

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = LonelyInteger.lonelyinteger_UsingHashMap(a);
        System.out.println(result);
        result = LonelyInteger.lonelyinteger_UsingHashSet(a);
        System.out.println(result);
        result = LonelyInteger.lonelyinteger_UsingXOR(a);
        System.out.println(result);

        //  bufferedWriter.write(String.valueOf(result));
        //   bufferedWriter.newLine();

        bufferedReader.close();
        //  bufferedWriter.close();
    }
}
