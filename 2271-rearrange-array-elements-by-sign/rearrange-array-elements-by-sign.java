class Solution {
    public int[] rearrangeArray(int[] nums) {
        int arr[]=new int[nums.length];
        int x=0,y=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                arr[x]=nums[i];
                x=x+2;
            }
            else{
                 arr[y]=nums[i];
                y=y+2;
            }
        }
        return arr;
    }
}