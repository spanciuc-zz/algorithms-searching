package com.pantifik.algorithms.searching.pattern;

import java.util.List;
import java.util.Objects;

/**
 * Provides methods to search a string in a text.
 */
public class TextSearch {

  /**
   * The default strategy to use when one is not given.
   */
  private final Strategy defaultStrategy;

  /**
   * Creates a text search instance with default strategy.
   */
  public TextSearch() {
    this(Strategy.NAIVE);
  }

  /**
   * Creates a text search instance with given strategy as the default strategy.
   *
   * @param strategy
   *     the strategy.
   * @throws NullPointerException
   *     if the strategy is null.
   */
  public TextSearch(Strategy strategy) {
    Objects.requireNonNull(strategy);
    this.defaultStrategy = strategy;
  }


  /**
   * Search for the occurrences of a string in a text.
   * <p>
   * Complexity depends on the used strategy.
   *
   * @param text
   *     the text to search into.
   * @param pattern
   *     the string to search.
   * @return A list of indexes at which the string was found.
   *
   * @throws NullPointerException
   *     if the text or the pattern is null.
   */
  public List<Integer> search(String text, String pattern) {
    return search(text, pattern, defaultStrategy);
  }

  /**
   * Search for the occurrences of a string in a text.
   * <p>
   * Complexity depends on the used strategy.
   *
   * @param text
   *     the text to search into.
   * @param pattern
   *     the string to search.
   * @param strategy
   *     the search strategy to be used.
   * @return A list of indexes at which the string was found.
   *
   * @throws NullPointerException
   *     if the text or the pattern is null.
   */
  public List<Integer> search(String text, String pattern, Strategy strategy) {
    Objects.requireNonNull(strategy);
    return strategy.search(text, pattern);
  }

  /**
   * Gets the default strategy.
   *
   * @return the default strategy.
   */
  public Strategy getDefaultStrategy() {
    return defaultStrategy;
  }

}
