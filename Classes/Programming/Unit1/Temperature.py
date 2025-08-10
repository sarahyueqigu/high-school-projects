# This program will convert the unit of temperature from
# Celsius to Fahrenheit. The program will ask the user for
# the temperature in Celsius, and then display the temperature
# in Fahrenheit without decimals.
# Sarah Gu

celsiusTemperature = input('Enter the temperature in Celsius: ')
celsiusTemperature = float(celsiusTemperature)
fahrenheitTemperature = ((9/5) * celsiusTemperature) + 32
print('The temperature in Fahrenheit is', format(fahrenheitTemperature, '.0f') + '.')
