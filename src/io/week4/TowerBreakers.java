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


public class TowerBreakers {

    /*
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    /**
     * Player p1
     * Player p2
     * <p>
     * if there is even no of towers always p2 will win
     * because first move taken by always player 1
     * let's take example:
     * Total Tower n=2 , Height m=9
     * case 1:
     * P1 -> Reduce Tower 1 height to 4 (9/2)
     * p2 -> Reduce Tower 2 height to 4 (Because both player optimally move)
     * <p>
     * P1 -> Reduce Tower 1 height from 4 to 1
     * P2 -> Reduce Tower 2 height from 4 to 1
     * <p>
     * now P1 does not have any move so p2 wins
     * <p>
     * case 2:
     * P1 -> Reduce Tower 1 height from 9 to 1
     * P2 -> Reduce Tower 2 height from 9 to 1
     * now P1 does not have any move so p2 wins
     * <p>
     * Both scenarios p1 will win(So even no tower always p2 will win)
     * <p>
     * Scenarios : Odd no of tower
     * ex: Total Tower n=1 , Height m=5
     * Player 1 either reduce to 2 ro 1 , p2 can not move or optimally move
     * so Player 1 will always win
     * But if m=1 then p1 can not make any move so player 2 will win
     */
    public static int towerBreakers(int n, int m) {
        return (n % 2 == 0 || m == 1) ? 2 : 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = TowerBreakers.towerBreakers(n, m);
                System.out.println(result);
                //      bufferedWriter.write(String.valueOf(result));
                //        bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        //   bufferedWriter.close();
    }
}
