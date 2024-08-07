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
    public static int countingValleys(int steps, String path) {
        int pivot = 0;
        int valleys = 0;
        int previusStep = 0;
        
        for (int i = 0; i < steps; i++) {
            char c = path.charAt(i);
            previusStep = pivot;
            
            if(c == 'U') { 
                pivot = pivot + 1;
            } else if(c == 'D') {
                pivot = pivot - 1;
            }
            
            if(previusStep < 0 && pivot==0) {
                valleys = valleys + 1;
            }
        }
        
        return valleys;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
