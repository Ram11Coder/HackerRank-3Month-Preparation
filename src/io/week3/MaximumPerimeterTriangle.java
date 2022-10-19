package io.week3;


import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class MaximumPerimeterTriangle {
    /*
     * Complete the 'maximumPerimeterTriangle' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY sticks as parameter.
     */

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {

        List<Integer> newList = new ArrayList<>();
        long currentMax = Integer.MIN_VALUE;
        // Pre check conditions
        if (sticks.size() < 3) {
            newList.add(-1);
            return newList;
        }
        //Sort the array so we can capture maximum perimeter triangle with sticks.size() - 2 iteration
        Collections.sort(sticks);

        for (int i = 0; i < sticks.size() - 2; i++) {
            long tempMax = 0;
            if (sticks.get(i) + sticks.get(i + 1) > sticks.get(i + 2) && sticks.get(i + 1) + sticks.get(i + 2) > sticks.get(i) && sticks.get(i + 2) + sticks.get(i) > sticks.get(i + 1)) {
                tempMax = sticks.get(i) + sticks.get(i + 1) + sticks.get(i + 2);
                if (tempMax > currentMax) {
                    currentMax = tempMax;
                    newList.clear();
                    newList.add(sticks.get(i));
                    newList.add(sticks.get(i + 1));
                    newList.add(sticks.get(i + 2));
                }
            }
        }

        if (newList.isEmpty())
            newList.add(-1);
        return newList;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = MaximumPerimeterTriangle.maximumPerimeterTriangle(sticks);
        System.out.println(result);
       /* bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );*/

        bufferedReader.close();
        //  bufferedWriter.close();
    }
}
