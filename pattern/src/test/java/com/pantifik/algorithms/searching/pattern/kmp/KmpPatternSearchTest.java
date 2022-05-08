package com.pantifik.algorithms.searching.pattern.kmp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class KmpPatternSearchTest {

  @Test
  void constructor_whenNullParam_shouldThrowException() {
    assertThrows(NullPointerException.class, () -> new KmpPatternSearch(null));
  }

  @Test
  void constructor_whenNotNullParam_shouldCreateInstanceWithGivenLPS(
      @Mock LongestPrefixSuffix lps) {
    KmpPatternSearch search = new KmpPatternSearch(lps);
    assertEquals(lps, search.getLongestPrefixSuffixCalculator());
  }
}