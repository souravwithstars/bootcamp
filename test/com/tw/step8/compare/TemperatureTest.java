package com.tw.step8.compare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

  @Test
  void shouldReturnOutcomeOfEqualWhenTwoTemperaturesAreSame() {
    Temperature celsius = Temperature.create(100, UnitOfTemperature.CELSIUS);
    Temperature fahrenheit = Temperature.create(212, UnitOfTemperature.FAHRENHEIT);

    Outcome actual = celsius.compare(fahrenheit);

    assertEquals(Outcome.EQUAL, actual);
  }

  @Test
  void shouldReturnOutcomeOfGreaterThanWhenFirstTemperatureIsGreater() {
    Temperature celsius = Temperature.create(100, UnitOfTemperature.CELSIUS);
    Temperature fahrenheit = Temperature.create(200, UnitOfTemperature.FAHRENHEIT);

    Outcome actual = celsius.compare(fahrenheit);

    assertEquals(Outcome.GREATERTHAN, actual);
  }

  @Test
  void shouldReturnOutcomeOfLesserThanWhenFirstTemperatureIsLesser() {
    Temperature celsius = Temperature.create(100, UnitOfTemperature.CELSIUS);
    Temperature fahrenheit = Temperature.create(250, UnitOfTemperature.FAHRENHEIT);

    Outcome actual = celsius.compare(fahrenheit);

    assertEquals(Outcome.LESSERTHAN, actual);
  }
}