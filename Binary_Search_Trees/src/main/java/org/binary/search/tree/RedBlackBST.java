package org.binary.search.tree;

import edu.princeton.cs.algs4.Queue;

public class RedBlackBST<Key extends Comparable<Key>, Value> implements Tree<Key, Value> {

  private static final boolean RED = true;
  private static final boolean BLACK = false;

  private Node root;

  private class Node {
    private Key key;
    private Value val;
    private Node left;
    private Node right;
    private int N;
    private boolean color;

    public Node(Key key, Value val, int N, boolean color) {
      this.key = key;
      this.val = val;
      this.N = N;
      this.color = color;
    }
  }

  public boolean isRed(Node x){
    if (x == null) {
      return false;
    }
    return x.color == RED;
  }

  public int size() {
    return size(root);
  }

  private int size(Node x) {
    if(x == null) {
      return 0;
    } else {
      return x.N;
    }
  }

  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node x, Key key){
    if (x == null) {
      return null;
    } else if (key.compareTo(x.key) > 0) {
      return get(x.right, key);
    } else if (key.compareTo(x.key) < 0) {
      return get(x.left, key);
    } else {
      return x.val;
    }
  }

  public void put(Key key, Value val) {
    root = put(root, key, val);
    root.color = BLACK;
  }

  private Node put (Node x, Key key, Value val) {
    if ( x == null ) {
      return new Node(key, val, 1, RED);
    } else if (key.compareTo(x.key) > 0) {
      x.right = put(x.right, key, val);
    } else if (key.compareTo(x.key) < 0 ) {
      x.left = put(x.left, key, val);
    } else {
      x.val = val;
    }

    if (isRed(x.right) && !isRed(x.left)) {
      x = rotateLeft(x);
    }
    if (isRed(x.left) && isRed(x.left.left)) {
      x = rotateRight(x);
    }
    if(isRed(x.left) && isRed(x.right)) {
      flipColors(x);
    }

    x.N = size(x.left) + size(x.right) + 1;
    return x;
  }

  public Key min() {
    return min(root);
  }

  private Key min(Node x) {
    if (x.left == null) {
      return x.key;
    } else {
      return min(x.left);
    }
  }

  public Key max() {
    return (max(root));
  }

  private Key max(Node x) {
    if (x.right == null) {
      return x.key;
    } else {
      return (max(x.right));
    }
  }

  public Key floor(Key key) {
    Node x = floor(root, key);
    if (x == null) {
      return null;
    }
    return x.key;
  }

  private Node floor (Node x, Key key) {
    if (x == null) {
      return null;
    } else if (key.compareTo(x.key) == 0) {
      return x;
    } else if (key.compareTo(x.key) < 0) {
      return floor(x.left, key);
    } else {
      Node t = floor(x.right, key);
      if(t != null) {
        return t;
      } else {
        return x;
      }
    }
  }

  public Key ceiling(Key key) {
    Node x = ceiling(root, key);
    if (x == null) {
      return null;
    }
    return x.key;
  }

  private Node ceiling(Node x, Key key) {
    if (x ==null) {
      return null;
    } else if (key.compareTo(x.key) == 0) {
      return x;
    } else if (key.compareTo(x.key) > 0) {
      return ceiling(x.right, key);
    } else {
      Node t = ceiling(x.left, key);
      if (t != null) {
        return t;
      } else {
        return x;
      }
    }
  }

  public Iterable<Key>  keys() {
    return keys(min(), max());
  }

  private Iterable<Key> keys(Key lo, Key hi) {
    Queue<Key> queue = new Queue<>();
    keys(root, queue, lo, hi);
    return queue;
  }

  private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
    if (x == null) return;
    int cmplo = lo.compareTo(x.key);
    int cmphi = hi.compareTo(x.key);
    if (cmplo < 0) {
      keys(x.left, queue, lo, hi);
    }
    if (cmplo <= 0 && cmphi >= 0) {
      queue.enqueue(x.key);
    }
    if (cmphi > 0) {
      keys(x.right, queue, lo, hi);
    }
  }

  public int depth(){
    int i = 0;
    return depth(root, i);
  }

  private int depth(Node x, int i) {
    if (x == null) return 0;
    else if (x.left == null && x.right == null) return i;
    else {
      if (x.color == BLACK) {
        i++;
      }
      int leftDepth = depth(x.left, i);
      int rightDepth = depth(x.right, i);
      return leftDepth > rightDepth ? leftDepth : rightDepth;
    }
 }

  private Node rotateLeft(Node h) {
    Node x = h.right;

    h.right = x.left;
    x.left = h;
    x.color = h.color;
    h.color = RED;
    x.N = h.N;
    x.N = h.N;
    h.N = 1 + size(h.left) + size(h.right);

    return x;
  }

  private Node rotateRight(Node h) {
    Node x = h.left;

    h.left = x.right;
    x.right = h;
    x.color = h.color;
    h.color = RED;
    x.N = h.N;
    h.N = 1 + size(h.left) + size(h.right);

    return x;
  }

  private void flipColors(Node h) {
    h.color = RED;
    h.left.color = BLACK;
    h.right.color = BLACK;
  }
}
