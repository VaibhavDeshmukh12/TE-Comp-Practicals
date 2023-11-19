import java.util.Scanner;

public class SJF {
    public static void sjf(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No of Processess: ");
        int n = sc.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        int ct[] = new int[n];
        int f[] = new int[n];
        int st=0,tot=0;
        float awt=0,tt=0;
        for(int i=0;i<n;i++){
            System.out.println("\nEnter Process "+(i+1)+" Arrival Time: ");
            at[i] = sc.nextInt();
            System.out.println("\nEnter Process "+(i+1)+" Burst Time: ");
            bt[i] = sc.nextInt();
            pid[i] = i + 1;
            f[i] = 0;
        }
        sc.close();
        while (tot != n) {
            int c = n,min = 999;
            for(int i=0;i<n;i++){
                if(bt[i]<min && f[i] == 0 && at[i] <= st){
                    min = bt[i];
                    c = i;
                }
            }
            if(c == n){
                st++;
            }
            else{
                ct[c] = st + bt[c];
                st += bt[c];
                tat[c] = ct[c] - at[c];
                wt[c] = tat[c] - bt[c];
                tot++;
                f[c] = 1;
            }
        }
        System.out.println("\nid\t\tarrival\t\tburst\t\tcomplete\tturn\t\twaiting");
        for(int i=0;i<n;i++){
            System.out.println((i+1)+"\t\t"+at[i]+"\t\t"+bt[i]+"\t\t"+ct[i]+"\t\t"+tat[i]+"\t\t"+wt[i]);
            awt += wt[i];
            tt += tat[i];
        }
        System.out.println("Avg Wt: "+(awt/n));
        System.out.println("Avg TT: "+(tt/n));
    }
    public static void main(String args[]){
        sjf();
    }
}
