package com.pantifik.algorithms.searching.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.OptionalInt;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

  @Test
  void search_whenArrayIsNull_shouldThrowException() {
    assertThrows(NullPointerException.class, () -> BinarySearch.search(null, 1));
  }

  @Test
  void search_whenArrayIsEmpty_shouldReturnEmptyOptional() {
    assertEquals(OptionalInt.empty(), BinarySearch.search(new Integer[]{}, 1));
  }

  @Test
  void search_whenObjectIsNotFound_shouldReturnEmptyOptional() {
    var array = new String[]{"t", "1", "2", "3"};
    var object = "toSearch";
    assertEquals(OptionalInt.empty(), BinarySearch.search(array, object));
  }

  @Test
  void search_whenObjectIsFound_shouldReturnOptionalOfIndex() {
    var array = new Integer[]{1, 2, 3, 4, 5, 6};
    var object = 1;
    assertEquals(OptionalInt.of(0), BinarySearch.search(array, object));
  }

}