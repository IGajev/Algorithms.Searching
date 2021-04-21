package org.binary.search.tree;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {

  public static void main(String[] args) {
    System.setIn(FrequencyCounter.class.getClassLoader().getResourceAsStream("tinyTale.txt"));

    int minlen = Integer.parseInt("0");
    BST<String, Integer> st = new BST<>();
    while (!StdIn.isEmpty()) {
      String word = StdIn.readString();
      if (word.length() < minlen) {
        continue;
      }
      if (st.get(word) == null) {
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
