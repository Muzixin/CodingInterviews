package questions;

public class Q12 {
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix.length <= 0 || rows < 0 || cols < 0 || str == null)
            return false;
        boolean[] visited = new boolean[rows * cols];
        int pathLength = 0;
        for(int row=0; row<rows;row++){
            for(int col=0; col<cols; col++){
                if(hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited))
                    return true;
            }
        }
        return false;
    }
    
    boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited){
        if(pathLength == str.length)
            return true;
        
        boolean hasPath = false;
        if(row>=0 && col>=0 && row < rows && col < cols && 
           matrix[row*cols + col] == str[pathLength] &&
           !visited[row*cols + col]){
            pathLength ++;
            visited[row*cols + col] = true;
            
            hasPath = hasPathCore(matrix, rows, cols, row, col-1, str, pathLength, visited)||
                hasPathCore(matrix, rows, cols, row-1, col, str, pathLength, visited)||
                hasPathCore(matrix, rows, cols, row, col+1, str, pathLength, visited)||
                hasPathCore(matrix, rows, cols, row+1, col, str, pathLength, visited);
            
            if(!hasPath){
                pathLength--;
                visited[row*cols + col] = false;
            }
        }
        
        return hasPath;
    }
    
    public static void main(String[] args) {
		char[] matrix = {'A','B','C','E','S','F','C','S','A','D','E','E'};
		char[] str ={'A','B','C','B'};
		Q12 q = new Q12();
		System.out.println(q.hasPath(matrix, 3, 4, str));
	}
}
