package com.pantifik.algorithms.searching.pattern.kmp;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

abstract class LongestPrefixSuffixTest {

  protected LongestPrefixSuffix lps;

  protected abstract LongestPrefixSuffix createLpsInstance();

  @BeforeEach
  void setUp() {
    this.lps = createLpsInstance();
  }

  @Test
  void calculate_whenNullString_shouldThrowException() {
    assertThrows(NullPointerException.class, () -> lps.calculate(null));
  }

  @ParameterizedTest
  @MethodSource("lpsProvider")
  void calculate_whenStringNotNull_shouldCalculateAndReturnLPS(int[] expected, String string) {
    assertArrayEquals(expected, lps.calculate(string));
  }

  private static Stream<Arguments> lpsProvider() {
    List<Arguments> arguments = new ArrayList<>();
    arguments.add(Arguments.of(new int[]{}, ""));
    arguments.add(Arguments.of(new int[]{0}, "a"));
    arguments.add(Arguments.of(new int[]{0, 0}, "ab"));
    arguments.add(Arguments.of(new int[]{0, 1}, "aa"));
    arguments.add(Arguments.of(new int[]{0, 1, 2}, "aaa"));
    arguments.add(Arguments.of(new int[]{0, 1, 2, 0}, "aaab"));
    arguments.add(Arguments.of(new int[]{0, 1, 2, 0, 1}, "aaaba"));
    arguments.add(Arguments.of(new int[]{0, 1, 2, 0, 0, 1}, "aaabba"));
    arguments.add(Arguments.of(new int[]{0, 0, 0, 1, 2, 0, 1, 2, 3}, "abcabbabc"));
    arguments.add(Arguments.of(new int[]{0, 0, 0, 1, 2, 0, 1, 2, 3, 4}, "abcabbabca"));
    return arguments.stream();
  }

}