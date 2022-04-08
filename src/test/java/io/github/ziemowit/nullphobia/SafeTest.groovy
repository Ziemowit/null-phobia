package io.github.ziemowit.nullphobia

import spock.lang.Specification
import spock.lang.Unroll

import java.util.function.Consumer
import java.util.function.Supplier

class SafeTest extends Specification {

  @Unroll
  def '''MapOrNull for object -> #input'''() {
    expect:
    Safe.mapOrNull(input as Person, Person.&getName) == expectedResult

    where:
    input                      || expectedResult
    null                       || null
    new Person('Ziemowit', 30) || 'Ziemowit'
  }

  @Unroll
  def '''MapOrNull for Optional with -> #input'''() {
    expect:
    Safe.mapOrNull(Optional.ofNullable(input), Person.&getName) == expectedResult

    where:
    input                      || expectedResult
    null                       || null
    new Person('Ziemowit', 30) || 'Ziemowit'
  }


  def '''MapOrElse'''() {
    given:
    def person = new Person('Ziemowit', 30)

    expect:
    Safe.mapOrElse(null, Person.&getName, 'John') == 'John'
    Safe.mapOrElse(person, Person.&getName, 'John') == 'Ziemowit'

    Safe.mapOrElse(null, Person.&getAge, 10) == 10
    Safe.mapOrElse(person, Person.&getAge, 10) == 30
  }

  def '''MapOrElseGet'''() {
    given:
    def person = new Person('Ziemowit', 30)

    def supplier = new Supplier() {
      @Override
      Object get() {
        return 'John'
      }
    }

    expect:
    Safe.mapOrElseGet(null, Person.&getName, supplier) == 'John'
    Safe.mapOrElseGet(person, Person.&getName, supplier) == 'Ziemowit'
  }

  def '''IfPresentExecute'''() {
    given:
    def person = new Person('Ziemowit', 30)
    def ageAccumulator = new AgeAccumulator()

    when:
    Safe.ifPresentExecute(null, ageAccumulator)

    then:
    ageAccumulator.accumulatedValue == 0

    when:
    Safe.ifPresentExecute(person, ageAccumulator)

    then:
    ageAccumulator.accumulatedValue == 30
  }

  static class Person {

    private final String name;
    private final int age;

    Person(String name, int age) {
      this.name = name
      this.age = age
    }

    String getName() {
      return name
    }

    int getAge() {
      return age
    }

    @Override
    String toString() {
      return String.format("[name=%s, age=%d]", name, age)
    }
  }

  class AgeAccumulator implements Consumer<Person> {

    private int accumulatedValue = 0

    @Override
    void accept(Person person) {
      accumulatedValue += person.age
    }
  }

}
