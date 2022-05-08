package com.pantifik.algorithms.searching.pattern.kmp;

class LongestPrefixSuffixImplTest extends LongestPrefixSuffixTest {

  @Override
  protected LongestPrefixSuffix createLpsInstance() {
    return new LongestPrefixSuffixImpl();
  }
}