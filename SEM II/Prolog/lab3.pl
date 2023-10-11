celsius_to_fahrenheit(Celsius, Fahrenheit) :-
  Celsius > 0,
  Fahrenheit is (9 * Celsius / 5) + 32.

below_freezing(Temperature) :-
    Temperature < 0.