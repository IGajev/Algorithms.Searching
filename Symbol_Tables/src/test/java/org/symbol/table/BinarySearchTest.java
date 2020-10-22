package org.symbol.table;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {
  private BinarySearchST<String, Integer> binarySearchST;

  @Before
  public void setUp() {
    binarySearchST = new BinarySearchST<>(3);
  }

  @Test
  public void rank_emptySymbolTable_returnZeroTheIndexOfFirstEntry() {
    assertEquals(0, binarySearchST.rank("999"));
  }

  @Test
  public void rank_threeKeysSymbolTableOrderedPut_returnIndexOfKeyOrNextPlaceForKeyNotFound() {
    binarySearchST.put("0", 0);
    binarySearchST.put("1", 1);
    binarySearchST.put("2", 2);

    assertEquals(0, binarySearchST.rank("0"));
    assertEquals(1, binarySearchST.rank("1"));
    assertEquals(2, binarySearchST.rank("2"));
    assertEquals(3, binarySearchST.rank("3"));
    assertEquals(3, binarySearchST.rank("999"));
  }

  @Test
  public void rank_threeKeysSymbolTableUnorderedPut_returnIndexOfKeyOrNextPlaceForKeyNotFound() {
    binarySearchST.put("1", 1);
    binarySearchST.put("2", 2);
    binarySearchST.put("0", 0);

    assertEquals(0, binarySearchST.rank("0"));
    assertEquals(1, binarySearchST.rank("1"));
    assertEquals(2, binarySearchST.rank("2"));
    assertEquals(3, binarySearchST.rank("3"));
    assertEquals(3, binarySearchST.rank("999"));
  }
}
