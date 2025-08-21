package practice;

import java.util.ArrayList;

public class intersection {
    public void intersectionOfTwoSortedArrays(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> intersection = new ArrayList<>();
        while(i<n1 && j<n2){
            if(a[i] < b[j]){
                i++;
            }else if(a[i] > b[j]){
                j++;
            }else{
                intersection.add(a[i]);
                i++;
                j++;
            }
        }

        for(int num : intersection){
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        intersection obj = new intersection();
        int[] a = {1, 2, 2, 2, 3, 4, 5};
        int[] b = {2, 2, 3, 4, 5, 6, 7};
        obj.intersectionOfTwoSortedArrays(a, b);
    }
}
