

public class Trapping_rainwater {
    public int trap(int[] arr) {
        int n = arr.length;
        int leftmax=0;
        int rightmax =0; 
        int total = 0;
        int l =0;
        int r = n-1;
        while(l<r){
            if(arr[l]<=arr[r]){
                if(leftmax>arr[l]){
                    total+= leftmax - arr[l];
                }else{
                    leftmax = arr[l];
                }
                l++;
            }else{
                if(rightmax > arr[r]){
                    total += rightmax - arr[r];
                }else{
                    rightmax = arr[r];
                }
                r--;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Trapping_rainwater obj = new Trapping_rainwater();
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = obj.trap(arr);
        System.out.println(result);
    }
}
