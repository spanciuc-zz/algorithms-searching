package com.pantifik.algorithms.searching.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TextSearchTest {

  @Spy
  private TextSearch textSearch;

  public static Stream<Arguments> searchProvider() {

    List<Arguments> arguments = new ArrayList<>();

    for (Strategy strategy : Strategy.values()) {
      arguments.add(Arguments.of(strategy, List.of(), "", "some pattern"));
      arguments.add(Arguments.of(strategy, List.of(), "some text", ""));
      arguments.add(Arguments.of(strategy, List.of(), "", ""));
      arguments.add(Arguments.of(strategy, List.of(), "text", "some text"));
      arguments.add(Arguments.of(strategy, List.of(), "text", "test5"));
      arguments.add(Arguments.of(strategy, List.of(), "text", "test"));
      arguments.add(Arguments.of(strategy, List.of(0), "test", "test"));
      arguments.add(Arguments.of(strategy, List.of(0, 10), "test text test", "test"));
      arguments.add(Arguments.of(strategy, List.of(3, 16), "1241235658122768123", "123"));
      arguments.add(Arguments.of(strategy, List.of(0, 1, 2, 3, 4, 5, 6, 7, 8), "aaaaaaaaaa", "aa"));
    }

    return arguments.stream();

  }

  @Test
  void search_whenStrategyNotGiven_shouldUseDefaultStrategy() {
    List<Integer> expected = List.of(1, 2, 3, 4);
    String text = "some arbitrary text";
    String pattern = "some pattern";
    when(textSearch.search(text, pattern, textSearch.getDefaultStrategy())).thenReturn(expected);
    assertEquals(expected, textSearch.search(text, pattern));
  }

  @Test
  void search_whenStrategyNotGivenAndDefaultStrategyThrows_shouldThrowDefaultsStrategyException() {
    Exception exception = new RuntimeException("Some message");
    String text = "some arbitrary text";
    String pattern = "some pattern";
    when(textSearch.search(text, pattern, textSearch.getDefaultStrategy())).thenThrow(exception);
    Exception actual = assertThrows(Exception.class, () -> textSearch.search(text, pattern));
    assertEquals(exception.getMessage(), actual.getMessage());
  }

  @Test
  void search_whenStrategyIsNull_shouldThrowException() {
    assertThrows(NullPointerException.class, () -> textSearch.search("", "", null));
  }

  @ParameterizedTest
  @EnumSource(Strategy.class)
  void search_whenTextIsNull_shouldThrowException(Strategy strategy) {
    assertThrows(NullPointerException.class, () -> textSearch.search(null, "", strategy));
  }

  @ParameterizedTest
  @EnumSource(Strategy.class)
  void search_whenPatternIsNull_shouldThrowException(Strategy strategy) {
    assertThrows(NullPointerException.class, () -> textSearch.search("", null, strategy));
  }

  @ParameterizedTest
  @MethodSource("searchProvider")
  void search_shouldReturnListOfFoundIndexes(Strategy strategy, List<Integer> expected, String text,
      String pattern) {
    assertEquals(expected, textSearch.search(text, pattern, strategy));
  }

}