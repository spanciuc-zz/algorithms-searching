package com.pantifik.algorithms.searching.binary;

import java.util.Comparator;
import java.util.Objects;
import java.util.OptionalInt;

public class BinarySearch {

  private BinarySearch() {}

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
