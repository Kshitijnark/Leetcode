class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos=0;
        int neg=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)pos++;
            if(nums[i]<0)neg++;
        }
        ArrayList<Integer>positive=new ArrayList<>();
         ArrayList<Integer>negative=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) positive.add(nums[i]);
            if(nums[i]<0) negative.add(nums[i]);
        }
        int j=0;
         for(int i=0;i<nums.length;i=i+2){
            nums[i]=positive.get(j);
            j++;
        }
        int z=0;
         for(int i=1;i<nums.length;i=i+2){
            nums[i]=negative.get(z);
            z++;
        }
        return nums;
    }
}