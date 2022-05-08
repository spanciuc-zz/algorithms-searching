package com.pantifik.algorithms.searching.pattern.kmp;

import java.util.Objects;

/**
 * A simple implementation of the LongestPrefixSuffix.
 */
public class LongestPrefixSuffixImpl implements LongestPrefixSuffix {

  /**
   * {@inheritDoc} Complexity is O(n), where n - the length of the array.
   */
  @Override
  public int[] calculate(final String string) {
    Objects.requireNonNull(string);
    int[] lps = new int[string.length()];
    if (string.isEmpty()) {
      return lps;
    }
    int i = 1;
    int len = 0;
    lps[0] = 0;
    while (i < string.length()) {
      if (string.charAt(len) == string.charAt(i)) {
        lps[i++] = ++len;
      } else {
        if (len != 0) {
          len = lps[len - 1];
        } else {
          i++;
        }
      }
    }
    return lps;
  }
}
