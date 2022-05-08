package com.pantifik.algorithms.searching.pattern;

import com.pantifik.algorithms.searching.pattern.naive.NaivePatternSearch;
import java.util.List;
import java.util.Objects;

/**
 * Represents the strategy for PatternSearch.
 */
public enum Strategy {
  /**
   * Uses nested for loops for pattern search.
   */
  NAIVE(new NaivePatternSearch());

  private final PatternSearch patternSearch;

  Strategy(PatternSearch patternSearch) {
    Objects.requireNonNull(patternSearch);
    this.patternSearch = patternSearch;
  }

  /**
   * Gets pattern search instance.
   *
   * @return the pattern search instance.
   */
  public PatternSearch getPatternSearch() {
    return patternSearch;
  }

  /**
   * Performs the strategy's pattern search.
   *
   * @param text
   *     the text to search into.
   * @param pattern
   *     the string to search.
   * @return a list of indexes at which the string was found.
   */
  List<Integer> search(String text, String pattern) {
    return this.patternSearch.search(text, pattern);
  }


}
