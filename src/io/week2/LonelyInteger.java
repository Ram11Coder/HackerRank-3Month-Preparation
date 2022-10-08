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
//My solution
    public static int lonelyinteger_UsingHashMap(List<Integer> a) {
        if(a.size()==1)
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


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = LonelyInteger.lonelyinteger_UsingHashMap(a);
        System.out.println(result);
        //  bufferedWriter.write(String.valueOf(result));
        //   bufferedWriter.newLine();

        bufferedReader.close();
        //  bufferedWriter.close();
    }
}
