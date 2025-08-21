package practice;

import java.util.ArrayList;

public class unionTwoSortedArray {
    public static void unionTwoSortedarray(int[] a, int[] b){
        int n1 = a.length;
        int n2 = b.length;
        int i=0;
        int j=0;
        ArrayList<Integer> union = new ArrayList<>();
        while(i<n1 && j<n2){
            if(a[i]<=b[j]){
                if(union.size()==0 || union.get(union.size()-1)!= a[i]){
                    union.add(a[i]);
                }
                i++;
            }else{
                if(union.size()==0 || union.get(union.size()-1)!= b[j]){
                    union.add(b[j]);
                }
                j++;
            }
        }

        while (i<n1){
            if(union.size()==0 || union.get(union.size()-1)!= a[i]){
                union.add(a[i]);
            }
            i++;
            
        }

        while (j<n2){
            if(union.size()==0 || union.get(union.size()-1)!= b[j]){
                union.add(b[j]);
            }
            j++;
        }

        // Print the union
        for(int num : union){
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,3,5,7};
        int[] b = {2,3,5,5,6};
        unionTwoSortedarray(a, b);
    }
}
