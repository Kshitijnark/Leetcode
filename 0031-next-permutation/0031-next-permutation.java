class Solution {
     static void rvereseArray(int arr[], int start, int end) 
    { 
        int temp; 
        if (start >= end) 
            return; 
        temp = arr[start]; 
        arr[start] = arr[end]; 
        arr[end] = temp; 
        rvereseArray(arr, start+1, end-1); 
    } 
    public void nextPermutation(int[] nums) {
        int ind1=-1,ind2=-1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                ind1=i-1;
                break;
            }
        }
        if (ind1==-1) {Arrays.sort(nums); return;}
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>nums[ind1]){
                ind2=i;
                break;
            }
        }
        int temp=nums[ind1];
        nums[ind1]=nums[ind2];
        nums[ind2]=temp;
        rvereseArray(nums,ind1+1,nums.length-1);
    }
}