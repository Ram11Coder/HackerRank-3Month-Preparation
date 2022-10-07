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

public class SparseArrays {
    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> result = new ArrayList<>();
        for (String query : queries) {
            int queryLength = query.length(), count = 0;
            for (String str : strings) {
                if (str.length() == queryLength && str.equals(query))
                    count++;
            }
            result.add(count);
        }
        return result;
    }

    public static List<Integer> matchingStrings_UsingMap(List<String> strings, List<String> queries) {

        Map<String, Integer> map = new HashMap<>();
        for (String str : strings)
            map.put(str, (map.containsKey(str)) ? map.get(str) + 1 : 1);

        List<Integer> result = new ArrayList<>();
        for (String query : queries)
            result.add(map.containsKey(query) ? map.get(query) : 0);

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<Integer> res = SparseArrays.matchingStrings(strings, queries);
        System.out.println(res);
        res = SparseArrays.matchingStrings_UsingMap(strings, queries);
        System.out.println(res);
/*        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );*/

        bufferedReader.close();
        //   bufferedWriter.close();
    }
}
