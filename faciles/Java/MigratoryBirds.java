// Java 15

package org.example.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ResultBirds {
    public static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Long> pajaros = arr.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Long valorMaximo = Collections.max(pajaros.values());

        Integer idPajaro = pajaros.entrySet().stream()
                .filter(pajaro -> pajaro.getValue() == valorMaximo)
                        .findFirst().get().getKey();

        return idPajaro;
    }
}

public class MigratoryBirds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).toList();

        int result = ResultBirds.migratoryBirds(arr);
        System.out.println(result);

        bufferedReader.close();
    }
}
