package org.binary.search.tree;

public class BST <Key extends Comparable<Key>, Value> {
  private Node root;

  private class Node {
    private Key key;
    private Value val;
    private Node left;
    private Node right;
    private int N;

    public Node(Key key, Value val, int N) {
      this.key = key;
      this.val = val;
      this.N = N;
    }
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
  }

  private Node put (Node x, Key key, Value val) {
    if ( x == null ) {
      return new Node(key, val, 1);
    } else if (key.compareTo(x.key) > 0) {
      x.right = put(x.right, key, val);
    } else if (key.compareTo(x.key) < 0 ) {
      x.left = put(x.left, key, val);
    } else {
      x.val = val;
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
}
