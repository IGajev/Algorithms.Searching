package org.example;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class InterviewQuestionTwo {

    /*
     * Complete the 'droppedRequests' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY requestTime as parameter.
     */

    public static int droppedRequests(List<Integer> requestTime) {
      // Write your code here
      return 0;//this return is given in order to compile.
    }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int requestTimeCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> requestTime = new ArrayList<>();

    for (int i = 0; i < requestTimeCount; i++) {
      int requestTimeItem = Integer.parseInt(bufferedReader.readLine().trim());
      requestTime.add(requestTimeItem);
    }

    int result = InterviewQuestionTwo.droppedRequests(requestTime);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }

}
