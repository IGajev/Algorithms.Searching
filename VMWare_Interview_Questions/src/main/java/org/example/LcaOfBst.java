package org.example;

public class LcaOfBst <Item extends Comparable<Item>> {
  private Node root;

  private class Node {
    Item item;
    Node left;
    Node right;

    public  Node(Item item) {
      this.item = item;
    }
  }

  public void addNode(Item item) {
    root = addNode(item, root);
  }

  private Node addNode(Item item, Node x) {
    if (x == null) {
      x = new Node(item);
    }

    if (item.compareTo(x.item) < 0) {
      x.left = addNode(item, x.left);
    }

    if (item.compareTo(x.item) > 0) {
      x.right = addNode(item, x.right);
    }
    return x;
  }

  public static void main(String[] args) {
    LcaOfBst<String> lcaOfBst = new LcaOfBst<>();

    lcaOfBst.addNode("B");
    lcaOfBst.addNode("C");
    lcaOfBst.addNode("A");

    lcaOfBst.getLca("A", "C");

    LcaOfBst<Integer> tree = new LcaOfBst<>();
    tree.addNode(20);
    tree.addNode(8);
    tree.addNode(22);
    tree.addNode(4);
    tree.addNode(12);
    tree.addNode(10);
    tree.addNode(14);

    printLca(tree, 10, 14);
    printLca(tree, 8, 14);
    printLca(tree, 10, 22);
  }

  private static void printLca(LcaOfBst<Integer> tree, int lo, int hi) {
    System.out.print("LCA of " + lo + " and " + hi + " is ");
    tree.getLca(lo, hi);
  }

  public void getLca(Item lo, Item hi) {
    System.out.println(getLca(lo, hi, root).item);
  }

  private Node getLca(Item lo, Item hi, Node x) {
    if (x == null) return null;
    if (lo.compareTo(x.item) > 0 && hi.compareTo(x.item) > 0) {
      x = getLca(lo, hi, x.right);
    }
    if (lo.compareTo(x.item) < 0 && hi.compareTo(x.item) < 0) {
      x = getLca(lo, hi, x.left);
    }
    return x;
  }
}
