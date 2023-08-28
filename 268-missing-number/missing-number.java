class Solution {
    public int missingNumber(int[] nums) {
        int match=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==match){
             match++;   
                
            }
            else{break;}
        }
        return match;
    }
}