public class Median_Two_Sorted_Array {
    public double medianTwoSortedArray(int[]a, int[] b){
        int m = a.length;
        int n = b.length;
        int i=0, j=0;
        int[] merged = new int[m+n];
        int k = 0;
        while (i<m && j<n) {
            if (a[i] < b[j]) {
                merged[k++] = a[i++];
            } else {
                merged[k++] = b[j++];
            }
        }
        while (i < m) {
            merged[k++] = a[i++];
        }
        while (j < n) {
            merged[k++] = b[j++];
        }
        // Find the median
        if ((m + n) % 2 == 1) {
            return (double)merged[(m + n) / 2];
        } else {
            return (double)((double)merged[(m + n) / 2 - 1] + (double)merged[(m + n) / 2]) / 2.0;
        }
    }


    public double findMedianSortedArraysOptimized(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int cnt =0;
        int ind2 = (m + n) / 2;
        int ind1 = (m + n)/2 - 1;
        int i = 0, j = 0;
        int ele1 = 0, ele2 = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                if (cnt == ind1) {
                    ele1 = nums1[i];
                }
                if (cnt == ind2) {
                    ele2 = nums1[i];
                }
                i++;

            } else {
                if (cnt == ind1) {
                    ele1 = nums2[j];
                }
                if (cnt == ind2) {
                    ele2 = nums2[j];
                }
                j++;
            }
            cnt++;
        }

        while (i < m) {
            if (cnt == ind1) {
                ele1 = nums1[i];
            }
            if (cnt == ind2) {
                ele2 = nums1[i];
            }
            i++;
            cnt++;
        }
        while (j < n) {
            if (cnt == ind1) {
                ele1 = nums2[j];
            }
            if (cnt == ind2) {
                ele2 = nums2[j];
            }
            j++;
            cnt++;
            
        }
        if ((m + n) % 2 == 1) {
            return (double)ele2;
        } else {
            return (double)(ele1 + ele2) / 2.0;
        }   
    }



}
