package org.example;

public class HeightOfTheBinaryTree <Item extends Comparable<Item>> {
  private Node root;

  private class Node {
    Item item;
    Node left;
    Node right;

    public Node(Item item) {
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

  public int getHeight() {
    int height = 1;
    return getHeight(root, height);
  }

  public static void main(String[] args) {
    HeightOfTheBinaryTree<String> heightOfTheBinaryTree = new HeightOfTheBinaryTree<>();

    heightOfTheBinaryTree.addNode("B");
    heightOfTheBinaryTree.addNode("C");
    heightOfTheBinaryTree.addNode("A");

    System.out.println(heightOfTheBinaryTree.getHeight());

    HeightOfTheBinaryTree<String> heightOfTheBinaryTree1 = new HeightOfTheBinaryTree<>();

    heightOfTheBinaryTree1.addNode("A");
    heightOfTheBinaryTree1.addNode("B");
    heightOfTheBinaryTree1.addNode("C");
    heightOfTheBinaryTree1.addNode("D");
    heightOfTheBinaryTree1.addNode("E");
    heightOfTheBinaryTree1.addNode("F");
    heightOfTheBinaryTree1.addNode("G");
    heightOfTheBinaryTree1.addNode("H");
    System.out.println(heightOfTheBinaryTree1.getHeight());

    HeightOfTheBinaryTree heightOfTheBinaryTree2 = new HeightOfTheBinaryTree();
    System.out.println(heightOfTheBinaryTree2.getHeight());
  }

  private int getHeight(Node x, int height) {
    if (x == null) return 0;
    if (x.left == null && x.right == null) {
      return height;
    }
    int heightLeft = getHeight(x.left, height + 1);
    int heightRight = getHeight(x.right, height + 1);
    return heightRight > heightLeft ? heightRight : heightLeft;
  }
}
