import java.util.Arrays;

public class WorstFit {
    public static void bestFit(int blockSize[],int m,int processSize[],int n){
        int allocation[] = new int[n];
        Arrays.fill(allocation, -1);
        for(int i=0;i<n;i++){
            int worst_idx = -1;
            for(int j=0;j<m;j++){
                if(blockSize[j] >= processSize[i]){
                    if(worst_idx == -1)
                        worst_idx = j;
                    else if(blockSize[worst_idx] < blockSize[j]){
                        worst_idx = j;
                    }
                }
            }
            if(worst_idx != -1){
                allocation[i] = worst_idx;
                blockSize[worst_idx] -= processSize[i]; 
            }
        }
        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
		for (int i = 0; i < n; i++) {
			System.out.print(" " + (i + 1) + "\t\t" + processSize[i] + "\t\t");
			if (allocation[i] != -1) {
				System.out.print((allocation[i] + 1));
			} else {
				System.out.print("Not Allocated");
			}
			System.out.println();
		}
    }
    public static void main(String[] args) {
        int blockSize[] = { 100, 500, 200, 300, 600 };
        int processSize[] = { 212, 417, 112, 426, 80,50 };
        int m = blockSize.length;
        int n = processSize.length;
        bestFit(blockSize, m, processSize, n);
    }
}
