package org.binary.search.tree;

public class Main {
  public static void main(String[] args) {
    BST<String, Integer> binarySearchTree = new BST<>();

    binarySearchTree.put("A", 1);
    binarySearchTree.put("B", 2);
    binarySearchTree.put("C", 3);
    binarySearchTree.put("D", 4);
    binarySearchTree.put("F", 6);
    binarySearchTree.put("G", 7);
    binarySearchTree.put("H", 8);
    binarySearchTree.put("I", 9);

    System.out.println(binarySearchTree.size());
    System.out.println(binarySearchTree.get("A"));
    System.out.println(binarySearchTree.get("B"));
    System.out.println(binarySearchTree.get("C"));
    System.out.println(binarySearchTree.get("D"));
    System.out.println(binarySearchTree.get("E"));
    System.out.println("min: " + binarySearchTree.min() + " and max:" + binarySearchTree.max());
    System.out.println("floor(E)->" + binarySearchTree.floor("E"));
    System.out.println("ceiling(E)->" + binarySearchTree.ceiling("E"));
  }
}
