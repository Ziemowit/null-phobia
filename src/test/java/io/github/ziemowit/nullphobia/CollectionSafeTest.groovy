package io.github.ziemowit.nullphobia

import spock.lang.Specification
import spock.lang.Unroll

class CollectionSafeTest extends Specification {

  @Unroll
  def '''Safe Collection -> #input'''() {
    when:
    def result = CollectionSafe.safe(input as Collection)

    then:
    result == expectedResult

    where:
    input     || expectedResult
    null      || []
    []        || input
    [1, 2, 3] || input
  }

  @Unroll
  def '''Safe List -> #input'''() {
    when:
    def result = CollectionSafe.safe(input as List)

    then:
    result == expectedResult

    where:
    input            || expectedResult
    null             || List.of()
    List.of()        || input
    List.of(1, 2, 3) || input
  }

  @Unroll
  def '''Safe Set -> #input'''() {
    when:
    def result = CollectionSafe.safe(input as Set)

    then:
    result == expectedResult

    where:
    input           || expectedResult
    null            || Set.of()
    Set.of()        || input
    Set.of(1, 2, 3) || input
  }

  @Unroll
  def '''Safe Map -> #input'''() {
    when:
    def result = CollectionSafe.safe(input as Map)

    then:
    result == expectedResult

    where:
    input                          || expectedResult
    null                           || Map.of()
    Map.of()                       || input
    Map.of('a', 1, 'b', 2, 'c', 3) || input
  }

  @Unroll
  def '''MutableSafe Collection -> #input'''() {
    when:
    def result = CollectionSafe.mutableSafe(input as Collection)

    then:
    result == expectedResult

    where:
    input     || expectedResult
    null      || []
    []        || input
    [1, 2, 3] || input
  }

  @Unroll
  def '''MutableSafe List -> #input'''() {
    when:
    def result = CollectionSafe.mutableSafe(input as List)

    then:
    result == expectedResult

    where:
    input            || expectedResult
    null             || List.of()
    List.of()        || input
    List.of(1, 2, 3) || input
  }

  @Unroll
  def '''MutableSafe Set -> #input'''() {
    when:
    def result = CollectionSafe.mutableSafe(input as Set)

    then:
    result == expectedResult

    where:
    input           || expectedResult
    null            || Set.of()
    Set.of()        || input
    Set.of(1, 2, 3) || input
  }

  @Unroll
  def '''MutableSafe Map -> #input'''() {
    when:
    def result = CollectionSafe.mutableSafe(input as Map)

    then:
    result == expectedResult

    where:
    input                          || expectedResult
    null                           || Map.of()
    Map.of()                       || input
    Map.of('a', 1, 'b', 2, 'c', 3) || input
  }
}
