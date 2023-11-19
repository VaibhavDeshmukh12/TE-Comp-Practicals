import java.util.Scanner;

public class RR {
    public static void rr(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter total no of processes: ");
        int n = sc.nextInt();
        int bt[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        int rem_bt[] = new int[n];
        float awt=0,tt=0;
        int qt,temp,sq=0,count=0;
        for(int i=0;i<n;i++){
            System.out.print("Enter burst time: ");
            bt[i] = sc.nextInt();
            rem_bt[i] = bt[i];
        }
        System.out.println("Enter Quantum time: ");
        qt = sc.nextInt();
        sc.close();
        while (true) {
            for(int i=0;i<n;i++){
                temp = qt;
                if(rem_bt[i]== 0){
                    count++;
                    continue;
                }
                if(rem_bt[i] > qt){
                    rem_bt[i] -= qt;
                }
                else if(rem_bt[i] >= 0){
                    temp = rem_bt[i];
                    rem_bt[i] = 0;
                }
                sq += temp;
                tat[i] = sq;
            }
            if(count == n)
                break;
        }
        System.out.print("--------------------------------------------------------------------------------");
        System.out.print("\nProcess\t      Burst Time       Turnaround Time\t          Waiting Time\n");
        System.out.print("--------------------------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            wt[i] = tat[i] - bt[i];
            awt += wt[i];
            tt += tat[i];
            System.out.print("\n " + (i + 1) + "\t\t " + bt[i] + "\t\t " + tat[i] + "\t\t " + wt[i] + "\n");
        }
        System.out.println("\nAverage waiting Time = " + (awt / n));
        System.out.println("Average turnaround time = " + (tt / n));
    }
    public static void main(String[] args) {
        rr();
    }
}
