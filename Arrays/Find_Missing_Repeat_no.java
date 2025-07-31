public class Find_Missing_Repeat_no {
    public int[] findmissingREpeat(int[] arr, int n){
        int s =0;
        int s2= 0;
        int sn = n * (n + 1) / 2;
        int s2n = n * (n + 1) * (2 * n + 1) / 6;
        for(int i = 0; i < n; i++){
            s += arr[i];
            s2 += arr[i] * arr[i];
        }
        int[] result = new int[2];
        int  val1 = sn - s; // missing number
        int  val2 = (s2n - s2);
        val2 = val2 / val1; // repeating number
        int x = (val1 + val2) / 2; // missing number
        int y = x - val1; // repeating number
        result[0] = x; // missing number
        result[1] = y; // repeating number
        return result;
    }


    public int[] findmissingREpeatusingHashing(int[] arr, int n){
        int[] result = new int[2];
        int[] hash = new int[n + 1];
        for(int i = 0; i < n; i++){
            hash[arr[i]]++;
        }
        for(int i = 1; i <= n; i++){
            if(hash[i] == 0){
                result[0] = i; // missing number
            } else if(hash[i] > 1){
                result[1] = i; // repeating number
            }
        }
        return result;
    }
}
