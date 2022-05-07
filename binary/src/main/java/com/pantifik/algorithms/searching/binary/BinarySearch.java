package com.pantifik.algorithms.searching.binary;

import java.util.Comparator;
import java.util.Objects;
import java.util.OptionalInt;

public class BinarySearch {

  private BinarySearch() {}

  /**
   * Performs a binary search of the object in the given array.
   * <p>
   * Complexity O(log(n))
   *
   * @param array
   *     the array to search in.
   * @param object
   *     the object to search.
   * @param <T>
   *     the type of the elements in the array.
   * @param <S>
   *     the type of the object to search.
   * @return an OptionalInt with the index of the element if found, otherwise empty OptionalInt.
   *
   * @throws NullPointerException
   *     if the given array is null.
   */
  public static <T extends Comparable<T>, S extends T> OptionalInt search(T[] array, S object) {
    Objects.requireNonNull(array);
    return doSearch(array, object, 0, array.length - 1);
  }

  private static <T extends Comparable<T>, S extends T> OptionalInt doSearch(T[] array, S object,
      int leftIndex, int rightIndex) {
    if (leftIndex > rightIndex) {
      return OptionalInt.empty();
    }
    int midIndex = (leftIndex + rightIndex) / 2;
    T mid = array[midIndex];
    if (Objects.equals(mid, object)) {
      return OptionalInt.of(midIndex);
    }
    if (Objects.compare(object, mid, Comparator.nullsFirst(Comparable::compareTo)) < 0) {
      return doSearch(array, object, leftIndex, midIndex - 1);
    } else {
      return doSearch(array, object, midIndex + 1, rightIndex);
    }
  }

}
