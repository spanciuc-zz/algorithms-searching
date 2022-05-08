package com.pantifik.algorithms.searching.pattern.naive;

import com.pantifik.algorithms.searching.pattern.PatternSearch;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A naive pattern search implementation.
 */
public class NaivePatternSearch implements PatternSearch {
  /**
   * {@inheritDoc}
   * <p>
   * Complexity O(n*m), where n - length of the text and m - length of the pattern.
   * </p>
   */
  @Override
  public List<Integer> search(String text, String pattern) {
    Objects.requireNonNull(text);
    Objects.requireNonNull(pattern);
    if (pattern.isEmpty()) {
      return new ArrayList<>();
    }
    int textLength = text.length();
    int patternLength = pattern.length();
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i <= textLength - patternLength; i++) {
      int j;
      for (j = 0; j < patternLength; j++) {
        if (text.charAt(i + j) != pattern.charAt(j)) {
          break;
        }
      }
      if (j == patternLength) {
        result.add(i);
      }
    }

    return result;

  }
}
