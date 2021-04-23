package org.binary.search.tree;

public class Main {
  public static void main(String[] args) {
    Tree<String, Integer> unbalancedBST = new BST<>();
    addUnbalancedTreeElements(unbalancedBST);
    printTree(unbalancedBST);

    Tree<String, Integer> balancedBST = new BST<>();
    addBalancedTreeElements(balancedBST);
    printTree(balancedBST);

    Tree<String, Integer> unbalancedRedBlackTree = new RedBlackBST<>();
    addBalancedTreeElements(unbalancedRedBlackTree);
    printTree(unbalancedRedBlackTree);

    Tree<String, Integer> ballancedRedBlackTree = new RedBlackBST<>();
    addUnbalancedTreeElements(ballancedRedBlackTree);
    printTree(ballancedRedBlackTree);
  }

  private static void addBalancedTreeElements(Tree<String, Integer> binarySearchTree) {
    binarySearchTree.put("D", 1);
    binarySearchTree.put("G", 2);
    binarySearchTree.put("C", 3);
    binarySearchTree.put("A", 4);
    binarySearchTree.put("F", 6);
    binarySearchTree.put("B", 7);
    binarySearchTree.put("H", 8);
    binarySearchTree.put("I", 9);
  }

  private static void addUnbalancedTreeElements(Tree<String, Integer> binarySearchTree) {
    binarySearchTree.put("A", 1);
    binarySearchTree.put("B", 2);
    binarySearchTree.put("C", 3);
    binarySearchTree.put("D", 4);
    binarySearchTree.put("F", 6);
    binarySearchTree.put("G", 7);
    binarySearchTree.put("H", 8);
    binarySearchTree.put("I", 9);
  }

  private static void printTree(Tree<String, Integer> binarySearchTree) {
    System.out.println("Printing tree->" + binarySearchTree.toString());
    System.out.println("size: " + binarySearchTree.size());
    System.out.println("min: " + binarySearchTree.min() + " and max:" + binarySearchTree.max());
    System.out.println("floor(E)->" + binarySearchTree.floor("E"));
    System.out.println("ceiling(E)->" + binarySearchTree.ceiling("E"));
    System.out.println("depth()->" + binarySearchTree.depth());
    System.out.println("End of tree->" + binarySearchTree.toString() + "\n");
  }
}
