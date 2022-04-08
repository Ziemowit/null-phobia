package io.github.ziemowit.nullphobia;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Set of utility methods to work with nullable objects.
 */
public final class Safe {

  /**
   * If a value is present, returns the result of applying the given mapper function to
   * the value, otherwise returns a NULL.
   *
   * @param value  the value to map
   * @param mapper the mapping function to apply to a value, if present
   * @param <R>    the type of the value returned from the mapping function
   * @param <T>    the type of the value
   * @return a result of applying the mapper function ot the value, if a value is
   * present, otherwise NULL.
   */
  public static <R, T> R mapOrNull(T value, Function<T, R> mapper) {
    return Optional.ofNullable(value)
                   .map(mapper)
                   .orElse(null);
  }

  /**
   * Maps the given value in Optional by mapping function, otherwise returns null.
   *
   * @param value   the {@code Optional} to map
   * @param mapping mapping function to apply on the value
   * @param <R>     the type of the value returned from the mapping function
   * @param <T>     the type of the value
   * @return mapped value if not null, null otherwise
   */
  public static <R, T> R mapOrNull(Optional<T> value, Function<T, R> mapping) {
    return value.map(mapping)
                .orElse(null);
  }

  /**
   * If a value is present, returns the result of applying the given mapper function to
   * the value, otherwise returns a defaultValue.
   *
   * @param value        the value to map
   * @param mapper       the mapping function to apply to a value, if present
   * @param <R>          the type of the value returned from the mapping function
   * @param <T>          the type of the value
   * @param defaultValue the defaultValue returned when value is NULL
   * @return a result of applying the mapper function ot the value, if a value is
   * present, otherwise defaultValue.
   */
  public static <R, T> R mapOrElse(T value, Function<T, R> mapper, R defaultValue) {
    return Optional.ofNullable(value)
                   .map(mapper)
                   .orElse(defaultValue);
  }

  /**
   * If a value is present, returns the result of applying the given mapper function to
   * the value, otherwise the result produced by the supplying function.
   *
   * @param value    the value to map
   * @param mapper   the mapping function to apply to a value, if present
   * @param supplier the supplying function that produces a value to be returned
   * @param <R>      the type of the value returned from the mapping function
   * @param <T>      the type of the value
   * @return a result of applying the mapper function ot the value, if a value is
   * present, otherwise the result produced by the supplying function
   */
  public static <R, T> R mapOrElseGet(T value,
                                      Function<T, R> mapper,
                                      Supplier<R> supplier) {
    return Optional.ofNullable(value)
                   .map(mapper)
                   .orElseGet(supplier);
  }

  /**
   * Executes the consumer on the value if present.
   *
   * @param value    the value on which consumer should be executed
   * @param consumer the function to execute on the value
   * @param <T>      the type of the value
   */
  public static <T> void ifPresentExecute(T value, Consumer<T> consumer) {
    Optional.ofNullable(value)
            .ifPresent(consumer);
  }

}
