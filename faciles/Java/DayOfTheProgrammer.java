import java.io.*;
// Java 15

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
    public static String dayOfProgrammer(int year) {
        String dateFinal = "";
        
        if(year == 1918) {
            dateFinal = "26.09." + String.valueOf(year);
        } else if(year <= 1917) {
            if(year%4 == 0) {
                dateFinal = "12.09." + String.valueOf(year);
            } else {
                dateFinal = "13.09." + String.valueOf(year);
            }
        } else if(year >= 1919) {
            if(year%400 == 0 || year%4 == 0 && year%100 != 0) {
                dateFinal = "12.09." + String.valueOf(year);
            } else {
                dateFinal = "13.09." + String.valueOf(year);
            }
        }
        
        return dateFinal;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}