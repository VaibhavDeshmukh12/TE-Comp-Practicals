import java.util.Scanner;

public class FCFS {
    public static void fcfs(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Total no of Processes: ");
        int n = sc.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n];
        int ct[] = new int[n];
        int bt[] = new int[n];
        int wt[] = new int[n];
        int tat[] = new int[n];
        float awt=0,tt=0;
        int temp;
        // Accepting
        for(int i=0;i<n;i++){
            System.out.println("Enter Process "+(i+1)+" arrival time: ");
            at[i] = sc.nextInt();
            System.out.println("Enter Process "+(i+1)+" burst time: ");
            bt[i] = sc.nextInt();
            pid[i] = i+1;
        }
        sc.close();
        // Swapping
        for(int i=0;i<n;i++){
            for(int j=0;j<n-(i+1);j++){
                if(at[j] > at[j+1]){
                    temp = at[j];
                    at[j] = at[j+1];
                    at[j+1] = temp;
                    temp = bt[j];
                    bt[j] = bt[j+1];
                    bt[j+1] = temp;
                    temp = pid[j];
                    pid[j] = pid[j+1];
                    pid[j+1] = temp;
                }
            }
        }
        // Calculation
        for(int i=0;i<n;i++){
            if(i==0)
                ct[i] = at[i] + bt[i];
            else{
                if(at[i]<ct[i-1]){
                    ct[i] = ct[i-1] + bt[i];
                }
                else
                    ct[i] = at[i] + bt[i];
            }
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
            awt += wt[i];
            tt += tat[i];
        }
        // Displaying
        System.out.println("Process\t\tArrivat\t\tBurst\t\tCompletion\tTurnAround\tWaiting");
        for(int i=0;i<n;i++){
            System.out.println(pid[i]+"\t\t"+at[i]+"\t\t"+bt[i]+"\t\t"+ct[i]+"\t\t"+tat[i]+"\t\t"+wt[i]);
        }
        System.out.println("Avg WT: "+(awt/n));
        System.out.println("Avg TT: "+(tt/n));
    }
    public static void main(String[] args) {
        fcfs();
    }
}
