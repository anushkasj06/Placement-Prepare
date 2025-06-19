package Stack_and_Queue;

import java.util.HashMap;
import java.util.Stack;

public class Next_Greater_Element {
     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i= nums2.length -1;i>=0;i--){
            int num = nums2[i];
            if(!stack.isEmpty() && stack.peek()<= num){
                stack.pop();
            }
            if(stack.isEmpty() ){
                map.put(num , -1);
            }
            else{
                map.put(num, stack.peek());
            }
            stack.push(num);
        }

        for(int i=0;i<nums1.length; i++){
            nums1[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]): -1;
        }
        return nums1;
    }
    public static void main(String[] args) {
        Next_Greater_Element obj = new Next_Greater_Element();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] result = obj.nextGreaterElement(nums1, nums2);
        for(int num : result){
            System.out.print(num + " ");
        }
    }
}
