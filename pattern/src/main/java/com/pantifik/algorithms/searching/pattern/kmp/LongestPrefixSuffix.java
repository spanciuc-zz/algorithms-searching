package com.pantifik.algorithms.searching.pattern.kmp;

/**
 * Defines methods for calculating longest proper prefix which is also a suffix.
 */
public interface LongestPrefixSuffix {

  /**
   * Builds an array that represents the LPS array of the given string.
   *
   * @param string
   *     the source string
   * @return an lps array.
   *
   * @throws NullPointerException
   *     if the string is null.
   */
  int[] calculate(String string);

}
