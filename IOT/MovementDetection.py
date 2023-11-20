import cv2
import RPi.GPIO as GPIO
import numpy as np
from imultis.video import VideoStream
from imultis import resize
import time
dt = 1000000
bp = 14
GPIO.setmode(GPIO.BCM)
GPIO.setup(bp,GPIO.OUT)
vs = VideoStream(src=0).start()

def getImg():
    im = vs.read()
    im = cv2.cvtCOLOR(im,cv2.COLOR_BGR2GRAY)
    im = cv2.blur(im,(20,20))
    return im
oldimg = getImg()

while True:
    newimg = getImg()
    diff = cv2.absdiff(oldimg,newimg)
    print(diff)
    ds = np.sum(diff)
    if ds>dt:
        print("Movement Detected!")
        GPIO.output(bp,GPIO.HIGH)
        time.sleep(2)
        GPIO.output(bp,GPIO.HIGH)
        time.sleep(2)
    oldimg = newimg