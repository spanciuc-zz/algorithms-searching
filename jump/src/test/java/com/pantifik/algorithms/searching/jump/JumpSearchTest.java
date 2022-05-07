package com.pantifik.algorithms.searching.jump;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.OptionalInt;
import org.junit.jupiter.api.Test;

class JumpSearchTest {

  @Test
  void search_whenArrayIsNull_shouldThrowException() {
    assertThrows(NullPointerException.class, () -> JumpSearch.search(null, 1));
  }

  @Test
  void search_whenArrayIsEmpty_shouldReturnEmptyOptional() {
    assertEquals(OptionalInt.empty(), JumpSearch.search(new Integer[]{}, 1));
  }

  @Test
  void search_whenObjectIsNotFound_shouldReturnEmptyOptional() {
    var array = new String[]{"t", "1", "2", "3"};
    var object = "toSearch";
    assertEquals(OptionalInt.empty(), JumpSearch.search(array, object));
  }

  @Test
  void search_whenObjectIsFound_shouldReturnOptionalOfIndex() {
    var array = new Integer[]{1, 2, 3, 4, 5, 6};
    var object = 1;
    assertEquals(OptionalInt.of(0), JumpSearch.search(array, object));
  }

  @Test
  void search_whenObjectIsFound2_shouldReturnOptionalOfIndex() {
    var array = new Integer[]{1, 2, 3, 4, 5, 6};
    var object = 4;
    assertEquals(OptionalInt.of(3), JumpSearch.search(array, object));
  }

  @Test
  void search_whenObjectIsFound3_shouldReturnOptionalOfIndex() {
    var array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    var object = 11;
    assertEquals(OptionalInt.of(10), JumpSearch.search(array, object));
  }

}