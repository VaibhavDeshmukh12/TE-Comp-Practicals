def fifo(pageString,fsize):
    hit = 0
    ptr=0
    fault = 0
    memeory = [-1 for i in range(fsize)]
    for i in pageString:
        flag = 0
        for j in memeory:
            if(int(i) == j):
                hit += 1
                flag = 1
                break
        if(flag == 0):
            fault +=1
            memeory[ptr] = int(i)
            ptr += 1
            if(ptr == fsize):
                ptr = 0
        print(memeory)    
    print("Hits: ",hit)
    print("Faults: ",fault)

def main():
    pageString = input("Enter page string: ")
    fsize = int(input("Enter frame size: "))
    fifo(pageString,fsize)

main()