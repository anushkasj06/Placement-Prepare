package Sliding_Window;

public class Maximum_point_from_Card {
    public int maxScore(int[] cardPoints, int k) {
        int lsum=0;
        int rsum=0;
        int max=0;
        for(int i=0; i<k; i++){
            lsum += cardPoints[i];
        }
        max = lsum;
        int rindex = cardPoints.length - 1;
        for(int i=k-1; i>=0; i--){
            rsum += cardPoints[rindex];
            lsum -= cardPoints[i];
            max = Math.max(max, lsum+rsum);
            rindex--;
        }
        return max;
    }
}
