class Solution {
    public void rotate(int[][] matrix) {
        int[][] matrix1=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix1[j][matrix.length-1-i]=matrix[i][j];
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
               matrix[i][j]=matrix1[i][j];
            }
        }
       
        
        
    }
}