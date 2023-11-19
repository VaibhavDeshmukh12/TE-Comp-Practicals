def opt(pageString, fsize):
    hit = 0
    fault = 0
    ptr = 0
    memory = [-1 for i in range(fsize)]
    for i in range(len(pageString)):
        flag = 0
        for j in memory:
            if(j == int(pageString[i])):
                flag = 1
                hit += 1
                break
        if(flag == 0):
            fault += 1
            farthest = -1
            farthest_idx = -1
            if(ptr >= fsize):
                for j in range(fsize):
                    found = False
                    for k in range(i+1,len(pageString)):
                        if(int(pageString[k]) == memory[j]):
                            found = True
                            if(k > farthest):
                                farthest = k
                                farthest_idx = j
                            break
                    if not found:
                        farthest_idx = j
                        break
                memory[farthest_idx] = int(pageString[i])
            else:
                memory[ptr] = int(pageString[i])
                ptr += 1
        print(memory)
    print("Hits: ",hit)
    print("Faults: ",fault)

def main():
    pageString = input("Enter page string: ")
    fsize = int(input("Enter frame size: "))
    opt(pageString,fsize)

main()