package io.week3;

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


public class PermutingTwoArrays {
    /*
     * Complete the 'twoArrays' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     *  3. INTEGER_ARRAY B
     */

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        boolean ispermutate = true;
        Collections.sort(A);
        Collections.sort(B);
        Collections.reverse(B);

        for (int i = 0; i < A.size(); i++) {
            if (!(A.get(i) + B.get(i) >= k)) {
                ispermutate = false;
                break;
            }

        }
        return (ispermutate) ? "YES" : "NO";
    }

    public static String twoArrays_lesscode(int k, List<Integer> A, List<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);

        for (int i = 0,j=B.size()-1; i < A.size(); i++,j--)
            if (!(A.get(i) + B.get(j) >= k))
                return "NO";

        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = PermutingTwoArrays.twoArrays(k, A, B);
                System.out.println(result);
                //   bufferedWriter.write(result);
                //     bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
