import java.util.Arrays;

public class FirstFit {
    public static void firstFit(int blockSize[],int m, int processSize[],int n){
        int allocation[] = new int[n];
        Arrays.fill(allocation, -1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(blockSize[j] >= processSize[i]){
                    allocation[i] = j;
                    blockSize[j] -= processSize[i];
                    break;
                }
            }
        }
        System.out.println("Process no.\tProcess size\tBlock no.");
        for(int i = 0; i < n; i++){
            System.out.print((i+1)+"\t\t"+processSize[i]+"\t\t");
            if(allocation[i] != -1){
                System.out.print(allocation[i] + 1);
            }
            else
                System.out.print("Not Allocated!");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int blockSize[] = { 100, 500, 200, 300, 600 };
        int processSize[] = { 212, 417, 112, 426, 200,200 };
        int m = blockSize.length;
        int n = processSize.length;
        firstFit(blockSize, m, processSize, n);
    }
}
