class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int[] store=new int[k];
        int j=0;
        for(int i=nums.length-k;i<nums.length;i++){
            store[j]=nums[i];
            j++;
        }
        for(int i=nums.length-k-1;i>=0;i--){
            nums[i+k]=nums[i];
        }
        for(int i=0;i<k;i++){
            nums[i]=store[i];
            
        }



    }
}