class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge=new int[nums2.length];
        for(int i=0;i<nums2.length;i++){
            for(int j=i;j<nums2.length;j++){
                if(nums2[j]>nums2[i]){
                    nge[i]=nums2[j];
                    break;
                }
                nge[i]=-1;
            }
        }
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int index=-1;
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    index=j;
                    ans[i]=nge[index];
                    break;
                }
                
                
            }
        }
        return ans;
    }
}