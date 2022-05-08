package com.pantifik.algorithms.searching.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class StrategyTest {

  @ParameterizedTest
  @EnumSource(Strategy.class)
  void search_whenValidParams_shouldReturnPatternsSearchResult(Strategy strategy) {
    PatternSearch patternSearch = strategy.getPatternSearch();
    String text = "aaa ab ab a";
    String pattern = "ab";
    assertEquals(patternSearch.search(text, pattern), strategy.search(text, pattern));
  }

}