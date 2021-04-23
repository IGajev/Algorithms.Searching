package org.binary.search.tree;

public interface Tree<Key extends Comparable<Key>, Value> {
  int size();

  Value get(Key key);

  void put(Key key, Value val);

  Key min();

  Key max();

  Key floor(Key key);

  Key ceiling(Key key);

  Iterable<Key> keys();

  int depth();
}
