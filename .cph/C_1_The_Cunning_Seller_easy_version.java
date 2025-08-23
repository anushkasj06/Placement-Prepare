import java.util.*;
import java.io.*;

public class C_1_The_Cunning_Seller_easy_version {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long n = sc.nextLong();
            List<Long> watermellon = new ArrayList<>();
            List<Long> cost = new ArrayList<>();
            for(int i=0;;i++){
                long anucount = (long) Math.pow(3,i);
                if(anucount> n) break;
                long anucost = (long) Math.pow(3,i+1);
                if(i>0){
                    anucost += (long) i * (long) Math.pow(3,i-1);
                }
                watermellon.add(anucount);
                cost.add(anucost);
            }

            long rem = n;
            long totalcost = 0;
            for(int i=watermellon.size()-1;i>=0;i--){
                if(rem<=0) break;
                long take = rem/watermellon.get(i);
                if(take>0){
                    totalcost += take * cost.get(i);
                    rem -= take * watermellon.get(i);
                }
            }
            System.out.println(totalcost);
        }
    }


}
