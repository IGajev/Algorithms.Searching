package org.symbol.table;

public class SequentialSearchST<Key, Value> {

  private Node first;
  private int size;

  private class Node {
    Key key;
    Value val;
    Node next;
    private Node(Key key, Value val, Node next) {
      this.key = key;
      this.val = val;
      this.next = next;
    }
  }

  public boolean contains(Key key) {
    for (Node x = first; x != null; x=x.next) {
      if(key.equals(x.key)){
        return true;
      }
    }
    return false;
  }

  public void put(Key key, Value val) {
    for (Node x = first; x != null; x=x.next) {
      if (key.equals(x.key)) {
        x.val = val;
        return;
      }
    }
    first = new Node(key, val, first);
    size++;
  }

  public Value get(Key key) {
    for (Node x = first; x != null; x=x.next){
      if (key.equals(x.key)) {
        return x.val;
      }
    }
    return null;
  }
  
  public int size() {
    return size;
  }

  public String[] keys() {
    String[] keys = new String[size()];
    int i = 0;
    for (Node x = first; x != null; x=x.next) {
      keys[i++] = x.key.toString();
    }
    return keys;
  }
}
