class Solution {
    public void moveZeroes(int[] nums) {
        int[] dummy=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dummy[i]=nums[i];
        }
        int si=0;
        int ei=nums.length-1;
        Arrays. fill(nums, 0);
        for(int i=0;i<nums.length;i++){
            if(dummy[i]!=0){
                nums[si]=dummy[i];
                si++;
            }
            
        }
            }
}