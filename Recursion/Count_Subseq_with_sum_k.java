public class Count_Subseq_with_sum_k {
    public static int printSum(int i, int s, int sum, int[] arr, int n){
        // only possible if arr contains only positive element
        if(s>sum) return 0;
        if(i==n){
            if(s==sum) return 1;
            return 0;
        }
        s+=arr[i];
        int l = printSum(i+1,s, sum, arr, n);
        s-=arr[i];
        int r = printSum(i+1, s, sum, arr, n);
        return l+r;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int sum = 2;
        int n = 3;
        System.out.println(printSum(0,0,sum,arr,n));
    }
}
