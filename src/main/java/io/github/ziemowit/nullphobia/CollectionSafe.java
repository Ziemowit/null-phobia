package io.github.ziemowit.nullphobia;

import java.util.*;

/**
 * Set of utility methods to work with nullable collections.
 */
public final class CollectionSafe {

  /**
   * Returns original Collection if present, otherwise an empty List.
   *
   * @param input Collection to check
   * @param <T>   type of the Collection
   * @return original input if not-null, otherwise an empty immutable List
   */
  public static <T> Collection<T> safe(Collection<T> input) {
    return Objects.nonNull(input)
        ? input
        : List.of();
  }

  /**
   * Returns original List if present, otherwise an empty List.
   *
   * @param input List to check
   * @param <T>   type of the Collection
   * @return original input if not-null, otherwise an empty immutable List
   */
  public static <T> List<T> safe(List<T> input) {
    return Objects.nonNull(input)
        ? input
        : List.of();
  }

  /**
   * Returns original Set if present, otherwise an empty Set.
   *
   * @param input Set to check
   * @param <T>   type of the Collection
   * @return original input if not-null, otherwise an empty immutable Set
   */
  public static <T> Set<T> safe(Set<T> input) {
    return Objects.nonNull(input)
        ? input
        : Set.of();
  }

  /**
   * Returns original Map if present, otherwise an empty Map.
   *
   * @param input Set to check
   * @param <K>   type of Map's key
   * @param <V>   type of Map's value
   * @return original input if not-null, otherwise an empty immutable Map
   */
  public static <K, V> Map<K, V> safe(Map<K, V> input) {
    return Objects.nonNull(input)
        ? input
        : Map.of();
  }

  /**
   * Returns original Collection if present, otherwise an empty List.
   *
   * @param input List to check
   * @param <T>   type of the Collection
   * @return original input if not-null, otherwise an empty mutable List
   */
  public static <T> Collection<T> mutableSafe(Collection<T> input) {
    return Objects.nonNull(input)
        ? input
        : new ArrayList<>();
  }

  /**
   * Returns original List if present, otherwise an empty List.
   *
   * @param input List to check
   * @param <T>   type of the Collection
   * @return original input if not-null, otherwise an empty mutable List
   */
  public static <T> List<T> mutableSafe(List<T> input) {
    return Objects.nonNull(input)
        ? input
        : new ArrayList<>();
  }

  /**
   * Returns original Set if present, otherwise an empty Set.
   *
   * @param input Set to check
   * @param <T>   type of the Collection
   * @return original input if not-null, otherwise an empty mutable Set
   */
  public static <T> Set<T> mutableSafe(Set<T> input) {
    return Objects.nonNull(input)
        ? input
        : new LinkedHashSet<>();
  }

  /**
   * Returns original Map if present, otherwise an empty Map.
   *
   * @param input Set to check
   * @param <K>   type of Map's key
   * @param <V>   type of Map's value
   * @return original input if not-null, otherwise an empty mutable Map
   */
  public static <K, V> Map<K, V> mutableSafe(Map<K, V> input) {
    return Objects.nonNull(input)
        ? input
        : new LinkedHashMap<>();
  }

}
