import Adafruit_DHT
import RPi.GPIO as GPIO
import time
bp = 14
gpio = 17
threshol_temp = 29
threshol_humidity = 60
sensor = Adafruit_DHT.DHT11
GPIO.setmode(GPIO.BCM)
GPIO.setup(bp,GPIO.OUT)

for i in range(10):
    temperature,humidity = Adafruit_DHT.read_retry(sensor,gpio)
    time.sleep(2)
    if temperature is not None and humidity is not None:
        print('Temperature = {0:0.4f}*C and Humidity = {1:0.4f} %'.format(temperature,humidity))
        if temperature > threshol_temp:
            print("Temperature crosses its limit")
            GPIO.output(bp,GPIO.HIGH)
            time.sleep(2)
            GPIO.output(bp,GPIO.LOW)
            time.sleep(2)
        else:
            print("Temperature within its limit")
        if temperature > threshol_temp:
            print("Humidity crosses its limit")
            GPIO.output(bp,GPIO.HIGH)
            time.sleep(2)
            GPIO.output(bp,GPIO.LOW)
            time.sleep(2)
        else:
            print("Humidity within its limit")
    else:
        print("Failed to take readings. Try again")
