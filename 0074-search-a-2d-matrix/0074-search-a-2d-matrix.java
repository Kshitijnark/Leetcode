class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start=0;
        int end=(matrix.length * matrix[0].length)-1;
        int mid=start+(end-start)/2;
        int m=matrix[0].length;
        while(start<=end){
                if(matrix[mid/m][mid%m]==target)return true;
                if(matrix[mid/m][mid%m]>target)end=mid-1;
                else {start=mid+1;}
                 mid=start+(end-start)/2;
        }
        return false;
    }
}