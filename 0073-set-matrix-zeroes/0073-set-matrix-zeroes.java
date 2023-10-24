class Solution {
    public void makerowzero(int[][] matrix,int i){
        for(int j=1;j<matrix[0].length;j++){
            matrix[i][j]=0;
        }
    }
    public void makecolzero(int[][] matrix,int i){
        for(int j=1;j<matrix.length;j++){
            matrix[j][i]=0;
        }
    }
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                    if(matrix[i][j]==0){
                        matrix[0][j]=0;
                        matrix[i][0]=0;
                    }
                    
            }
        }
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0)makerowzero(matrix,i);
        }
        for(int i=1;i<matrix[0].length;i++){
            if(matrix[0][i]==0)makecolzero(matrix,i);
        }
        if (firstColZero) {
            makecolzero(matrix,0);
            }
         if (firstRowZero) {
            makerowzero(matrix,0);
        }
        }

       

    }
