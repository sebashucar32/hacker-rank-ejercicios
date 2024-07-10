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
    public static int sockMerchant(int n, List<Integer> ar) {
        Map<Integer, Integer> listShoks = new HashMap<>();
        var pairs = 0;
        
        for (Integer i=1; i <= 100; i++) {
            listShoks.put(i, 0);
        }
        
        for(Integer a : ar) {
            listShoks.put(a, listShoks.get(a) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : listShoks.entrySet()) {
            if(entry.getValue() != 0) {
                var valor = entry.getValue() / 2;
                pairs = pairs + valor;
            }
        }
        
        return pairs;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
