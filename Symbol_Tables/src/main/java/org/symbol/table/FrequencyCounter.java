package org.symbol.table;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FrequencyCounter {

  public static void main(String[] args) throws FileNotFoundException {
    if(args.length > 1)
      System.setIn(new FileInputStream(args[1]));

    int minlen = Integer.parseInt(args[0]);
    SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
    while (!StdIn.isEmpty()) {
      String word = StdIn.readString();
      if (word.length() < minlen) {
        continue;
      }
      if (!st.contains(word)) {
        st.put(word, 1);
      } else {
        st.put(word, st.get(word) + 1);
      }
    }
    String max = "";
    st.put(max, 0);
    for (String word : st.keys()) {
      if (st.get(word) > st.get(max)) {
        max = word;
      }
    }
    StdOut.println(max + " " + st.get(max));
  }
}
