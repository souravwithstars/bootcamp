package com.tw.step8.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

  @Test
  void shouldReturnOutcomeOfEqualWhenTwoTemperaturesAreSame() {
    Temperature celsius = Temperature.create(100, UnitOfTemperature.CELSIUS);
    Temperature fahrenheit = Temperature.create(212, UnitOfTemperature.FAHRENHEIT);

    Rank actual = celsius.compare(fahrenheit);

    assertEquals(Rank.EQUAL, actual);
  }

  @Test
  void shouldReturnOutcomeOfGreaterThanWhenFirstTemperatureIsGreater() {
    Temperature celsius = Temperature.create(100, UnitOfTemperature.CELSIUS);
    Temperature fahrenheit = Temperature.create(200, UnitOfTemperature.FAHRENHEIT);

    Rank actual = celsius.compare(fahrenheit);

    assertEquals(Rank.GREATER, actual);
  }

  @Test
  void shouldReturnOutcomeOfLesserThanWhenFirstTemperatureIsLesser() {
    Temperature celsius = Temperature.create(100, UnitOfTemperature.CELSIUS);
    Temperature fahrenheit = Temperature.create(250, UnitOfTemperature.FAHRENHEIT);

    Rank actual = celsius.compare(fahrenheit);

    assertEquals(Rank.LESSER, actual);
  }
}