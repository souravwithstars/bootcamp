package com.tw.step8.compare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

  @Test
  void shouldGiveZeroWhenTwoTemperaturesAreSame() {
    Temperature celsius = Temperature.create(100, UnitOfTemperature.CELSIUS);
    Temperature fahrenheit = Temperature.create(212, UnitOfTemperature.FAHRENHEIT);

    int actual = celsius.compare(fahrenheit);

    assertEquals(0, actual);
  }
}