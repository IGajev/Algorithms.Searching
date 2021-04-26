package org.example;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class InterviewQuestionOne {

    /*
     * Complete the 'getSubsequenceCount' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    /*
        UVV
        VVVVUUUUVUVUVUVVVVUUVVUUUUVUVUVUVUUU
    */
    public static long getSubsequenceCount(String s1, String s2) {
      long count = 0l;
      String s11 = s1.substring(0, 1);
      String s12 = s1.substring(1, 2);
      String s13 = s1.substring(2, 3);
      for ( int i = 0 ; i < s2.length() - 2; i++) {
        if (s11.equals(s2.substring(i, i + 1))) {
          for (int j = i + 1; j < s2.length() - 1; j ++) {
            if(s12.equals(s2.substring(j, j+1))) {
              for (int k = j + 1; k < s2.length(); k ++){
                if (s13.equals(s2.substring(k, k+1))) {
                  count++;
                }
              }
            }
          }
        }
      }
      return count;
    }

    public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String s1 = bufferedReader.readLine();

      String s2 = bufferedReader.readLine();

      long result = InterviewQuestionOne.getSubsequenceCount(s1, s2);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedReader.close();
      bufferedWriter.close();
    }
 }


