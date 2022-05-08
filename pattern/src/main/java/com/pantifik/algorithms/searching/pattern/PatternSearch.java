package com.pantifik.algorithms.searching.pattern;

import java.util.List;

/**
 * Defines methods for Pattern Search.
 */
public interface PatternSearch {

  /**
   * Search for the occurrences of a string in a text.
   *
   * @param text
   *     the text to search into.
   * @param pattern
   *     the string to search.
   * @return A list of indexes at which the string was found.
   *
   * @throws NullPointerException
   *     if the text or the pattern is null.
   */
  List<Integer> search(String text, String pattern);

}
