package com.pantifik.algorithms.searching.linear;

import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class LinearSearch {

  private LinearSearch() {}

  public static <T, S extends T> OptionalInt search(T[] array, S obj) {
    Objects.requireNonNull(array);
    return IntStream.range(0, array.length)
        .filter(e -> Objects.equals(array[e], obj))
        .findFirst();
  }

}
