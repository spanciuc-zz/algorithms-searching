package com.pantifik.algorithms.searching.jump;

import java.util.Comparator;
import java.util.Objects;
import java.util.OptionalInt;

public class JumpSearch {

  private JumpSearch() {}

  /**
   * Performs a jump search of an object in an array.
   * <p>
   * Complexity O(sqrt(n)).
   *
   * @param array
   *     the array to search in.
   * @param object
   *     the object to search.
   * @param <T>
   *     the type of the elements in the array.
   * @param <S>
   *     the type of the object to search.
   * @return an OptionalInt with index of the element if found, otherwise empty OptionalInt.
   *
   * @throws NullPointerException
   *     if the given array is null.
   */
  public static <T extends Comparable<T>, S extends T> OptionalInt search(T[] array, S object) {
    Objects.requireNonNull(array);
    return doSearch(array, object);
  }

  private static <T extends Comparable<T>, S extends T> OptionalInt doSearch(T[] array, S object) {
    int jumpStep = (int) Math.sqrt(array.length);
    int prevIndex = 0;
    int index = jumpStep;
    while (index < array.length && isSmallerThan(array[index], object)) {
      prevIndex = index;
      index += jumpStep;
    }
    for (int i = prevIndex; i <= Math.min(index, array.length - 1); i++) {
      if (Objects.equals(array[i], object)) {
        return OptionalInt.of(i);
      }
    }
    return OptionalInt.empty();
  }

  private static <T extends Comparable<T>, S extends T> boolean isSmallerThan(S obj1, T obj2) {
    return Objects.compare(obj1, obj2, Comparator.nullsFirst(Comparable::compareTo)) < 0;
  }

}
