public class FloodFill {
     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        makeFloodFill(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public static void makeFloodFill(int[][] image, int sr, int sc, int color, int curr){
        if(sr<0  || sr>=image.length || sc<0 || sc>=image[0].length || curr==color){
            return;
        }

        if(curr!=image[sr][sc]){
            return;
        }
        image[sr][sc] = color;
        makeFloodFill(image, sr+1, sc, color, curr);
        makeFloodFill(image, sr-1, sc, color, curr);
        makeFloodFill(image, sr, sc+1, color, curr);
        makeFloodFill(image, sr, sc-1, color, curr);
    }
}
