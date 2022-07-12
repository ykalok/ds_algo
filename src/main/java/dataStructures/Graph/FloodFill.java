package dataStructures.Graph;

public class FloodFill {
	 public void dfs(int[][] image, int sr, int sc, int color,int oldColor){
	        if(sr>=image.length || sr<0 || sc>=image[0].length|| sc<0 || image[sr][sc]!=oldColor)
	            return;
	        image[sr][sc]=color;
	        dfs(image,sr+1,sc,color,oldColor);
	        dfs(image,sr-1,sc,color,oldColor);
	        dfs(image,sr,sc+1,color,oldColor);
	        dfs(image,sr,sc-1,color,oldColor);
	            
	        
	    }
	    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
	        if(color==image[sr][sc])
	            return image;
	        dfs(image,sr,sc,color,image[sr][sc]);
	        return image; 
	    }
}
