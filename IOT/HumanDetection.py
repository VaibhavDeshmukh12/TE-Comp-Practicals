import RPi.GPIO as GPIO
import time

bp = 8
count = 0
GPIO.setmode(GPIO.BOARD)
GPIO.setup(3,GPIO.IN)
GPIO.setup(bp,GPIO.OUT)

while(True):
    enter = GPIO.input(3)
    if(enter == False):
        count += 1
        print("Human Detected!")
        print("Count: ",str(count))
        GPIO.output(bp,GPIO.HIGH)
        time.sleep(2)
        GPIO.output(bp,GPIO.LOW)
        time.sleep(2)
    time.sleep(1)