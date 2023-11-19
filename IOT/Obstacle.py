import RPi.GPIO as GPIO
from time import sleep
bp = 8
count = 0
GPIO.setmode(GPIO.BOARD)
GPIO.setup(3,GPIO.IN)
GPIO.setup(40,GPIO.IN)
GPIO.setup(bp,GPIO.OUT)

while (True):
    enter = GPIO.input(3)
    exit = GPIO.input(40)
    if enter == False:
        count += 1
        print("Obstacle Detected!")
        print("Count ",str(count))
        GPIO.output(bp,GPIO.HIGH)
        sleep(2)
        GPIO.output(bp,GPIO.LOW)
        sleep(2)
    if exit == False:
        count -= 1
        if(count>0):
            print("Obstacle Exited!")
            print("Count: ",str(count))
            GPIO.output(bp,GPIO.HIGH)
            sleep(2)
            GPIO.output(bp,GPIO.LOW)
            sleep(2)
        else:
            print("No Obstacle detected!")
    sleep(1)