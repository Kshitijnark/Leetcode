class Solution {
    static void func(int[] nums,int ind,List<Integer>ds,int N,List<List<Integer>>res){
         res.add(new ArrayList<>(ds));
        
         for(int i = ind;i<nums.length;i++) {
         if(i!=ind && (nums[i] == nums[i-1])) continue; 
        ds.add(nums[i]);
        func(nums,i+1,ds,N,res);
        ds.remove(ds.size()-1);
         }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        func(nums,0,new ArrayList<>(),nums.length,res);
        return res;
    }
}