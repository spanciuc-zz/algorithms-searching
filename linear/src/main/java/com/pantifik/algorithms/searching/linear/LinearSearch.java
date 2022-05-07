package com.pantifik.algorithms.searching.linear;

import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class LinearSearch {

  private LinearSearch() {}

  /**
   * Performs a linear search of the element in the given array.
   * <p>
   * Complexity O(n).
   *
   * @param array
   *     the array to search in.
   * @param obj
   *     the object to search.
   * @param <T>
   *     the type of the elements in the array.
   * @param <S>
   *     the type of the elements to search.
   * @return the OptionalInt with the index of the element if found, otherwise empty OptionalInt.
   *
   * @throws NullPointerException
   *     if the given array is null.
   */
  public static <T, S extends T> OptionalInt search(T[] array, S obj) {
    Objects.requireNonNull(array);
    return IntStream.range(0, array.length)
        .filter(e -> Objects.equals(array[e], obj))
        .findFirst();
  }

}
