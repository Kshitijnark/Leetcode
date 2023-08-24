class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hash_Set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            hash_Set.add(nums[i]);
        }
        if(hash_Set.size()==nums.length)return false;
        else return true;
    }
}