def lru(pageString,fsize):
    fault = 0
    hit = 0
    ptr = 0
    memory = [-1 for i in range(fsize)]
    for i in range(len(pageString)):
        flag = 0
        for j in memory:
            if(j == int(pageString[i])):
                hit += 1
                flag = 1
                break
        if(flag == 0):
            fault += 1
            if(ptr >= fsize):
                dist = [-1 for i in range(10)]
                present = [-1 for i in range(10)]
                left = pageString[0:i]
                for j in range(len(left)):
                    k = int(left[j])
                    dist[k] = i - j
                    for l in range(fsize):
                        if(memory[l] == int(left[j])):
                            present[k] = l
                            break
                max = 0
                position = 0
                for j in range(len(dist)):
                    if(dist[j] > max and present[j] != -1):
                        max = dist[j]
                        position = present[j]
                memory[position] = int(pageString[i])
            else:
                memory[ptr] = int(pageString[i])
                ptr += 1
        print(memory)
    print("Hits: ",hit)
    print("Faults: ",fault)

def main():
    pageString = input("Enter page string: ")
    fsize = int(input("Enter frame size: "))
    lru(pageString,fsize)

main()