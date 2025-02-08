import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Solution {
    public static void bonAppetit(List<Integer> bill, int k, int b) {
        var result = 0;
        bill.remove(k);
        int pay = bill.stream().reduce(0, (element1, element2) -> element1 + element2);
        int cost = pay / 2;

        if(cost == b) {
            System.out.println("Bon Appetit");
        } else {
            result = b - cost;
            System.out.println(result);
        }
    }
}

public class BillDivision2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        Solution.bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
