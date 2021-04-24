package org.example;

public class ReverseSinglyLinkedList<Item> {
  private Node first;

  private class Node {
    Item item;
    Node next;

    public  Node(Item item) {
      this.item = item;
    }
  }

  public void addNode(Item item) {
    Node oldFirst = first;
    first = new Node(item);
    first.next = oldFirst;
  }

  public void printList() {
    Node x = first;
    System.out.println("Printing List ...");
    while (x != null) {
      System.out.println(x.item);
      x = x.next;
    }
    System.out.println("End of List ...");
  }

  public void reverse() {
    Node prev = null;
    Node curr = first;
    Node next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    first = prev;
  }

  public void reverseRecursive() {
    first = reverse(first);
  }

  public Node reverse(Node x) {
    if (x == null || x.next == null) {
      return x;
    }
    Node rest = reverse(x.next);
    x.next.next = x;
    x.next = null;

    return rest;
  }

  public static void main(String[] args) {
    ReverseSinglyLinkedList reverseSinglyLinkedList = new ReverseSinglyLinkedList();

    reverseSinglyLinkedList.addNode("Ivan");
    reverseSinglyLinkedList.addNode("Petkan");
    reverseSinglyLinkedList.addNode("Dragan");
    reverseSinglyLinkedList.addNode("Bozhidar");
    reverseSinglyLinkedList.addNode("Milen");
    reverseSinglyLinkedList.addNode("Petar");

    reverseSinglyLinkedList.reverse();
    reverseSinglyLinkedList.printList();

    reverseSinglyLinkedList.reverseRecursive();
    reverseSinglyLinkedList.printList();
  }
}
