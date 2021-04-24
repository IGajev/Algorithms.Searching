package org.example;

/**
 * Sort linked list
 * @param <Item>
 */
public class SortLinkedList<Item extends Comparable<Item>>{

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

  public void sort() {
    Node current = first;

    while (current != null) {
      Node index = current.next;
      while (index != null) {
        if (current.item.compareTo(index.item) > 0) {
          Item temp = current.item;
          current.item = index.item;
          index.item = temp;
        }
        index = index.next;
      }
      current = current.next;
    }
  }

  public void printList() {
    Node x = first;
    System.out.println("Printing List ...");
    while (x != null) {
      System.out.println(x.item);
      x = x.next;
    }
    System.out.println("\nEnd of List ...");
  }

  public static void main(String[] args) {
    SortLinkedList<String> sortLinkedList = new SortLinkedList<>();

    sortLinkedList.addNode("a");
    sortLinkedList.addNode("d");
    sortLinkedList.addNode("g");
    sortLinkedList.addNode("a");
    sortLinkedList.addNode("b");
    sortLinkedList.addNode("y");
    sortLinkedList.addNode("j");
    sortLinkedList.addNode("f");

    sortLinkedList.sort();

    sortLinkedList.printList();
  }

}
