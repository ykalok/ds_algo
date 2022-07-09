package dataStructures.Graph;

public class Island {
	    public void dfsFill(char[][] grid, int i,int j){
	        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length &&  grid[i][j]=='1'){
	            grid[i][j]='0';
	            dfsFill(grid,i+1,j);
	            dfsFill(grid,i,j+1);
	            dfsFill(grid,i-1,j);
	            dfsFill(grid,i,j-1);
	        }
	        
	    }
	    public int numIslands(char[][] grid) {
	        int n=grid.length;
	        int m = grid[0].length;
	        int count =0;
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                if(grid[i][j]=='1'){
	                    dfsFill(grid,i,j); 
	                    count++;
	                }
	            }
	        }
	        return count;
	    }
	}

