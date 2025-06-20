package Stack_and_Queue;

import java.util.Stack;

public class Sum_Subarray_Range {
    public long subArrayRanges(int[] nums) {
        return sumMax(nums) - sumMin(nums);
    }

    long sumMin(int[] nums){
        int n = nums.length;
        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        long total =0;
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ?n : st.peek();
            st.push(i);
        } 

        while(!st.isEmpty()){
            st.pop();
        }

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1: st.peek();
            st.push(i);

            int left = i-pse[i];
            int right = nse[i] -i;
            total += 1L * left*right*nums[i];
        }
        return total;
    }


     long sumMax(int[] nums){
        int n = nums.length;
        int[] nge = new int[n];
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();
        long total =0;
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            nge[i] = st.isEmpty() ?n : st.peek();
            st.push(i);
        } 

        while(!st.isEmpty()){
            st.pop();
        }

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1: st.peek();
            st.push(i);

            int left = i-pge[i];
            int right = nge[i] -i;
            total += 1L * left*right*nums[i];
        }
        return total;
    }
}
