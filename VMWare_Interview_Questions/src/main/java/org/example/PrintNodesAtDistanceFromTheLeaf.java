package org.example;

/**
 * Print All the nodes which are at K distance from the leaf nodes.
 * @param <Item>
 */
public class PrintNodesAtDistanceFromTheLeaf<Item extends Comparable<Item>> {
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

  public void printAtDistanceK(int k) {
    int level = 1;
    printAtDistanceK(k, root, level);
  }

  public static void main(String[] args) {
    PrintNodesAtDistanceFromTheLeaf<String> printNodesAtDistanceFromTheLeaf = new PrintNodesAtDistanceFromTheLeaf<>();

    printNodesAtDistanceFromTheLeaf.addNode("B");
    printNodesAtDistanceFromTheLeaf.addNode("C");
    printNodesAtDistanceFromTheLeaf.addNode("A");

    printNodesAtDistanceFromTheLeaf.printAtDistanceK(2); //Play here with the parameter.
  }

  private void printAtDistanceK(int k, Node x, int level) {
    if (x == null) return;
    if (level == k)       System.out.print(x.item);
    if (level < k) {
      printAtDistanceK(k, x.left, level + 1);
      printAtDistanceK(k, x.right, level + 1);
    }
    if (level > k) return;
  }
}
