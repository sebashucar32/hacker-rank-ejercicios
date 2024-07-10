// Java 15

package org.example.hackerrank;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;

class Result {
    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        AtomicInteger contador = new AtomicInteger();

        IntStream.range(0, n).forEach(primerIndice -> {
            IntStream.range(0, n).forEach(segundoIndice -> {
                if(primerIndice < segundoIndice) {
                    if((ar.get(primerIndice) + ar.get(segundoIndice))%k == 0) {
                        contador.getAndIncrement();
                    }
                }
            });
        });


        return contador.intValue();
    }
}

public class DivisibleSumPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "")
            .split(" ")).map(Integer::parseInt).toList();

        int result = Result.divisibleSumPairs(n, k, ar);

        System.out.println(result);

        bufferedReader.close();
    }
}
