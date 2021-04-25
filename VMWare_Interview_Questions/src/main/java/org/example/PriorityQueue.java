package org.example;

public class PriorityQueue<Key extends Comparable<Key>> {
  private Key[] pq;
  private int N = 0;

  public PriorityQueue(int maxN) {
    this.pq = (Key[]) new Comparable[maxN + 1];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void insert(Key v) {
    pq[++N] = v;
    swim(N);
  }

  public Key delMax() {
    Key max = pq[1];
    exch(1, N--);
    pq[N + 1] = null;
    sink(1);
    return max;
  }

  private void swim(int k) {
    while (k > 1 && less(k/2, k)){
      exch(k/2, k);
      k = k/2;
    }
  }

  private void sink(int k) {
    while(2*k + 1 <= N) {
      int j = 2*k;
      if (j < N && less(j, j+1)) j++;
      if (!less(k, j)) break;
      exch(k, j);
      k = j;
    }
  }

  private boolean less(int a, int b) {
    return pq[a].compareTo(pq[b]) < 0;
  }

  private void exch(int a, int b) {
    Key t = pq[a];
    pq[a] = pq[b];
    pq[b] = t;
  }

  public static void main(String[] args) {
    PriorityQueue<String> priorityQueue = new PriorityQueue<>(10);
    priorityQueue.insert("a");
    priorityQueue.insert("f");
    priorityQueue.insert("s");
    priorityQueue.insert("j");
    priorityQueue.insert("d");
    priorityQueue.insert("k");
    priorityQueue.insert("q");
    priorityQueue.insert("h");

    priorityQueue.print();

    priorityQueue.delMax();

    priorityQueue.print();
  }

  private void print() {
    System.out.print("Printing pq->");
    for (Key k : pq) {
      if (k != null) System.out.print(k + " ");
    }
    System.out.println("\n");
  }
}
