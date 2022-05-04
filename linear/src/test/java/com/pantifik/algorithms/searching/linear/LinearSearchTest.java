package com.pantifik.algorithms.searching.linear;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.OptionalInt;
import org.junit.jupiter.api.Test;

class LinearSearchTest {

  @Test
  void search_whenArrayIsNull_shouldThrowException() {
    assertThrows(NullPointerException.class, () -> LinearSearch.search(null, 1));
  }

  @Test
  void search_whenArrayIsEmpty_shouldReturnEmptyOptional() {
    assertEquals(OptionalInt.empty(), LinearSearch.search(new Integer[]{}, 1));
  }

  @Test
  void search_whenObjectIsNotFound_shouldReturnEmptyOptional() {
    var array = new String[]{"1", "2", "3"};
    var object = "toSearch";
    assertEquals(OptionalInt.empty(), LinearSearch.search(array, object));
  }

  @Test
  void search_whenObjectIsFound_shouldReturnOptionalOfIndex() {
    var array = new Integer[]{1, 2, 6, 4, 5, 6};
    var object = 6;
    assertEquals(OptionalInt.of(2), LinearSearch.search(array, object));
  }
}