class Solution {
    public int findDuplicate(int[] nums) {
        int prev=0;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]){prev=nums[i];break;}
        }
        return prev;

    }
}