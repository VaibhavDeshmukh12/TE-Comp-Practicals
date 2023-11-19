import java.util.Arrays;

public class NextFit {
    public static void nextFit(int blockSize[], int m, int processSize[],int n){
        int allocation[] = new int[n];
        int j=0,t=m-1;
        Arrays.fill(allocation, -1);
        for(int i=0;i<n;i++){
            while (j<m) {
                if(blockSize[j] >= processSize[i]){
                    allocation[i] = j;
                    blockSize[j] -= processSize[i];
                    t = (j-1)%m;
                    break;
                }
                if(t == j){
                    t = (j-1)%m;
                    break;
                }
                j = (j+1)%m;
            }
        }
        System.out.println("Process no\tProcess size\tBLock no");
        for(int i=0;i<n;i++){
            System.out.print((i+1)+"\t\t"+processSize[i]+"\t\t");
            if(allocation[i] != -1){
                System.out.print(allocation[i]+1);
            }
            else
                System.out.println("Not Allocated!");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int blockSize[] = {100,500,200,300,600};
        int processSize[] = {50,250,300,200,400,200,200};
        int n = processSize.length;
        int m = blockSize.length;
        nextFit(blockSize, m, processSize, n);
    }
}
