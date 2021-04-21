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

    System.out.println("size: " + binarySearchTree.size());
    System.out.println(binarySearchTree.get("A"));
    System.out.println(binarySearchTree.get("B"));
    System.out.println(binarySearchTree.get("C"));
    System.out.println(binarySearchTree.get("D"));
    System.out.println(binarySearchTree.get("E"));
    System.out.println("min: " + binarySearchTree.min() + " and max:" + binarySearchTree.max());
    System.out.println("floor(E)->" + binarySearchTree.floor("E"));
    System.out.println("ceiling(E)->" + binarySearchTree.ceiling("E"));
    System.out.println("depth()->" + binarySearchTree.depth());


    BST<String, Integer> binarySearchTree2 = new BST<>();

    binarySearchTree2.put("D", 1);
    binarySearchTree2.put("G", 2);
    binarySearchTree2.put("C", 3);
    binarySearchTree2.put("A", 4);
    binarySearchTree2.put("F", 6);
    binarySearchTree2.put("B", 7);
    binarySearchTree2.put("H", 8);
    binarySearchTree2.put("I", 9);

    System.out.println("size: " + binarySearchTree2.size());
    System.out.println("min: " + binarySearchTree2.min() + " and max:" + binarySearchTree2.max());
    System.out.println("floor(E)->" + binarySearchTree2.floor("E"));
    System.out.println("ceiling(E)->" + binarySearchTree2.ceiling("E"));
    System.out.println("depth()->" + binarySearchTree2.depth());
  }
}
