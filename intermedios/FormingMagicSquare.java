// Java 15

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

class Result {
    public static List<List<Integer>> fillPossibleSolutions() {
        List<Integer> solution1 = new ArrayList<>(List.of(8, 1, 6, 3, 5, 7, 4, 9, 2));
        List<Integer> solution2 = new ArrayList<>(List.of(6, 1, 8, 7, 5, 3, 2, 9, 4));
        List<Integer> solution3 = new ArrayList<>(List.of(4, 9, 2, 3, 5, 7, 8, 1, 6));
        List<Integer> solution4 = new ArrayList<>(List.of(2, 9, 4, 7, 5, 3, 6, 1, 8));
        List<Integer> solution5 = new ArrayList<>(List.of(8, 3, 4, 1, 5, 9, 6, 7, 2));
        List<Integer> solution6 = new ArrayList<>(List.of(4, 3, 8, 9, 5, 1, 2, 7, 6));
        List<Integer> solution7 = new ArrayList<>(List.of(6, 7, 2, 1, 5, 9, 8, 3, 4));
        List<Integer> solution8 = new ArrayList<>(List.of(2, 7, 6, 9, 5, 1, 4, 3, 8));

        return List.of(solution1, solution2, solution3, solution4, solution5, solution6, solution7, solution8);
    }
    
    public static int formingMagicSquare(List<List<Integer>> s) {
        int coste = 1000;
        List<List<Integer>> possibleSolutions = fillPossibleSolutions();

        for (List<Integer> solution : possibleSolutions) {
            var indexOfSolution = 0;
            List<Integer> resultCostes = new ArrayList<>();

            for (int i=0; i < 3; i++) {
                for (int j=0; j < 3; j++) {
                    if(s.get(i).get(j) != solution.get(indexOfSolution)) {
                        resultCostes.add(Math.abs(s.get(i).get(j) - solution.get(indexOfSolution)));
                    }

                    indexOfSolution++;
                }
            }

            var currentCoste = resultCostes.stream().reduce(0, Integer::sum);

            if (currentCoste < coste) {
                coste = currentCoste;
            }
        }

        return coste;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}