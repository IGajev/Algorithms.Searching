package org.example;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a regular expression pattern to match "525", "528", and "530" to "599" exclusively -> 5[2,3,9][5,8,0,9]
 * @param <Item>
 */
public class DetectLoopInLinkedList <Item extends Comparable<Item>>{

  private Node first;
  private int N = 0;

  private class Node {
    private Item item;
    private Node next;

    private Node(Item item) {
      this.item = item;
      this.next = null;
    }
  }

  public void addNode(Item item) {
    Node oldFirst = first;
    first = new Node(item);
    first.next = oldFirst;
    N++;
  }

  public static void main(String[] args) {
    DetectLoopInLinkedList<String> detectLoopInLinkedList = new DetectLoopInLinkedList<>();

    detectLoopInLinkedList.addNode("a");
    detectLoopInLinkedList.addNode("d");
    detectLoopInLinkedList.addNode("g");
    detectLoopInLinkedList.addNode("a");
    detectLoopInLinkedList.addNode("b");
    detectLoopInLinkedList.addNode("y");
    detectLoopInLinkedList.addNode("j");

    System.out.print("Expected NO->");
    if (detectLoopInLinkedList.loopDetected()) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
    //create the loop
    detectLoopInLinkedList.first.next.next.next.next.next.next= detectLoopInLinkedList.first;

    System.out.print("Expected YES->");
    if (detectLoopInLinkedList.loopDetected()) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

  public boolean loopDetected() {
    return loopDetected(first);
  }

  private boolean loopDetected(Node x) {
    Set<Node> set = new HashSet<>();
    while (x != null) {
      set.add(x);
      if (set.contains(x.next)) {
        return true;
      }
      x = x.next;
    }
    return false;
  }
}
