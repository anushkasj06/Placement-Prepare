import java.util.*;

public class Union_Two_Array {
    public int[] union(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        ArrayList<Integer> union = new ArrayList<>();
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j]){
                if(union.size() == 0 || union.get(union.size()-1) != nums1[i]) {
                    union.add(nums1[i]);
                }
                i++;
            } else if (nums1[i] > nums2[j]) {
                if (union.size() == 0 || union.get(union.size()-1) != nums2[j]) {
                    union.add(nums2[j]);
                }
                j++;
            } else {
                if (union.size() == 0 || union.get(union.size()-1) != nums1[i]) {
                    union.add(nums1[i]);
                }
                i++;
                j++;
            }
        }
        // Add any remaining elements from either array
        while (i < nums1.length) {
            if (union.size() == 0 || union.get(union.size()-1) != nums1[i]) {
                union.add(nums1[i]);
            }
            i++;
        }
        while (j < nums2.length) {
            if (union.size() == 0 || union.get(union.size()-1) != nums2[j]) {
                union.add(nums2[j]);
            }
            j++;
        }
        // Convert ArrayList to int[]
        int[] result = new int[union.size()];
        for (int k = 0; k < union.size(); k++) {
            result[k] = union.get(k);
        }
        return result;
    }
}