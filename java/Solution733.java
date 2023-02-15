class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if( image[sr][sc]==color) return image;
        floodFill(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    private void floodFill(int[][]image, int sr, int sc, int color, int originColor){
        if( sr >= image.length 
            ||
            sr < 0
            ||
            sc >= image[0].length
            ||
            sc < 0) return;
        if (image[sr][sc]==originColor) {
            image[sr][sc] = color;
            floodFill(image, sr-1, sc, color, originColor);
            floodFill(image, sr+1, sc, color, originColor);
            floodFill(image, sr, sc-1, color, originColor);
            floodFill(image, sr, sc+1, color, originColor);
        }
    }
}
