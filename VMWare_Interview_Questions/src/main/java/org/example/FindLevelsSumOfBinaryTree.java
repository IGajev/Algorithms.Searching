package org.example;

/**
 * Find levelwise sum of binary tree
 */
public class FindLevelsSumOfBinaryTree {
  private static Node root;

  private static class Node {
    int item;
    Node left, right;

    public Node(int item) {
      this.item = item;
    }

  }

  public static int getLevelSum(int level) {
    return getLevelSum(root, level, 1);
  }

  public static int getLevelSum(Node x, int level, int levelReached) {
    int sum = 0;

    if (x == null || levelReached > level) return 0;

    if (level == levelReached) {
      sum += x.item;
    }

    sum += getLevelSum(x.left, level, levelReached + 1);
    sum += getLevelSum(x.right, level, levelReached + 1);

    return sum;
  }

  public static void main(String args[])
  {
    // Create the binary tree
    //level 1
    root = new Node(6);
    //level 2
    root.left = new Node(4);
    root.right = new Node(8);
    //level 3
    root.left.left = new Node(3);
    root.left.right = new Node(5);
    root.right.left = new Node(7);
    root.right.right = new Node(9);
    //level 4
    root.right.left.left = new Node(1);
    root.right.left.right = new Node(2);
    root.right.right.right = new Node(3);
    root.right.right.left = new Node(4);
    root.left.right.left = new Node(24);

    // To store the sum at every level
    // Print the required sums
    for (int i = 0; i < 5; i++) {
      System.out.println("sum of level " + i + " -> " + getLevelSum(i));
    }
  }
}
