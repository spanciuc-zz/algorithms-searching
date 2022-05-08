package com.pantifik.algorithms.searching.pattern.kmp;

import com.pantifik.algorithms.searching.pattern.PatternSearch;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A Knuth-Morris-Pratt Pattern Search implementation.
 */
public class KmpPatternSearch implements PatternSearch {

  private final LongestPrefixSuffix lpsCalculator;

  public KmpPatternSearch(LongestPrefixSuffix lps) {
    Objects.requireNonNull(lps);
    this.lpsCalculator = lps;
  }

  /**
   * {@inheritDoc} Complexity O(n), where n is the text length, and suppose the text length is
   * greater than pattern length.
   */
  @Override
  public List<Integer> search(String text, String pattern) {
    Objects.requireNonNull(text);
    Objects.requireNonNull(pattern);
    List<Integer> result = new ArrayList<>();
    if (pattern.isEmpty()) {
      return result;
    }
    int[] lps = lpsCalculator.calculate(pattern);
    int i = 0;
    int j = 0;
    while (i < text.length()) {
      if (text.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;
      } else {
        if (j != 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }
      if (j == lps.length) {
        result.add(i - j);
        j = lps[j - 1];
      }
    }
    return result;
  }

  /**
   * Gets the longest prefix suffix calculator.
   *
   * @return the lps implementation.
   */
  LongestPrefixSuffix getLongestPrefixSuffixCalculator() {
    return lpsCalculator;
  }
}
