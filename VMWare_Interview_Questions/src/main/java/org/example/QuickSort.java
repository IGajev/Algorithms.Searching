package org.example;

import edu.princeton.cs.algs4.QuickBentleyMcIlroy;

import java.util.Arrays;

public class QuickSort<Item extends Comparable<Item>> {

  public static void sort(Comparable[] a) {
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) return;
    int j = partition(a, lo, hi);
    sort(a, lo, j-1);
    sort(a, j+1, hi);
  }
  private static int partition(Comparable[] a, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    Comparable v = a[lo];
    while(true) {
      while(less(a[++i], v)) if (i == hi) break;
      while(less(v, a[--j])) if (j == lo) break;
      if (i >= j) break;
      exch(a, i, j);
    }
    exch(a, lo, j);
    return j;
  }

  private static void exch(Comparable[] a, int lo, int hi) {
    Comparable t = a[lo];
    a[lo] = a[hi];
    a[hi] = t;
  }

  private static boolean less(Comparable comparable, Comparable v) {
    return comparable.compareTo(v) < 0;
  }

  public static void main(String[] args) {
    Comparable<String>[] c = new String[]{"s", "e", "a", "r", "c", "h", };
    sort(c);
    for (int i =0 ; i < c.length; i++ ) System.out.print(c[i]);
  }
}
