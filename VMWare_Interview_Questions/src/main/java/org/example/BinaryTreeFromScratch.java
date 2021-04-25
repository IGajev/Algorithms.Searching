package org.example;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromScratch<Item extends Comparable<Item>> {
  private Node root;

  private class Node {
    Item item;
    Node left;
    Node right;

    public Node (Item item) {
      this.item = item;
    }
  }

  public void add(Item item) {
    root = add(item, root);
  }

  private Node add(Item item, Node x) {
    if (x == null) {
      x = new Node(item);
    }

    if (item.compareTo(x.item) < 0) {
      x.left = add(item, x.left);
    }

    if (item.compareTo(x.item) > 0) {
      x.right = add(item, x.right);
    }
    return x;
  }

  public Node get(Item item) {
    return get(item, root);
  }

  private Node get(Item item, Node x) {
    if (x == null) return null;
    if (item.compareTo(x.item) < 0) return get(item, x.left);
    if (item.compareTo(x.item) > 0) return get(item, x.right);
    return x;
  }

  public List<Item> getItems() {
    List<Item> items = new ArrayList<>();
    return getItems(root, items);
  }

  private List<Item> getItems(Node x, List<Item> items) {
    if (x == null) return items;
    items = getItems(x.left, items);
    items = getItems(x.right, items);
    items.add(x.item);
    return items;
  }

  public static void main(String[] args) {
    BinaryTreeFromScratch<String> binaryTreeFromScratch = new BinaryTreeFromScratch<>();

    binaryTreeFromScratch.add("B");
    binaryTreeFromScratch.add("C");
    binaryTreeFromScratch.add("A");
    binaryTreeFromScratch.add("gajev");

    System.out.println(binaryTreeFromScratch.get("gajev").item);
    System.out.print("Items->");
    for(String item : binaryTreeFromScratch.getItems()) {
      System.out.print(item + " ");
    }
  }
}
