package practice;

public class secondLargest {
    public static int secondlargest(int[] arr){
        if(arr.length<2){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int secondmax = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                secondmax = max;
                max = arr[i];
            }else if(arr[i]>secondmax && arr[i]!=max){
                secondmax = arr[i];
            }
        }

        return secondmax;
    }

    public static void main(String[] args) {
        int[] arr = {5,3,8,4,9,2};
        System.out.println(secondlargest(arr));
    }
}
