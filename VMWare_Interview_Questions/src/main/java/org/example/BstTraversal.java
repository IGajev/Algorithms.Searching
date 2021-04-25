package org.example;

/**
 * Write code to do an inorder BST traversal with recursion and without recursion.
 * Explain in which case you would choose one implementation over the other.
 * Explain the runtime of each.
 * @param <Item>
 */
public class BstTraversal<Item extends Comparable<Item>> {
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

  public void preorderTraversal() {
    System.out.print("preorder->");
    preorderTraversal(root);
    System.out.println();
  }

  public void inorderTraversal() {
    System.out.print("inorder->");
    inorderTraversal(root);
    System.out.println();
  }

  public void postorderTraversal() {
    System.out.print("postorder->");
    postorderTraversal(root);
    System.out.println();
  }

  public static void main(String[] args) {
    BstTraversal<String> bstTraversal = new BstTraversal<>();

    bstTraversal.addNode("B");
    bstTraversal.addNode("C");
    bstTraversal.addNode("A");

    bstTraversal.preorderTraversal();
    bstTraversal.inorderTraversal();
    bstTraversal.postorderTraversal();
  }


  private void preorderTraversal(Node x) {
    if (x == null) return;
    System.out.print(x.item + " ");
    preorderTraversal(x.left);
    preorderTraversal(x.right);
  }

  private void inorderTraversal(Node x) {
    if (x == null) return;
    inorderTraversal(x.left);
    System.out.print(x.item + " ");
    inorderTraversal(x.right);
  }

  private void postorderTraversal(Node x) {
    if (x == null) return;
    postorderTraversal(x.left);
    postorderTraversal(x.right);
    System.out.print(x.item + " ");
  }
}
