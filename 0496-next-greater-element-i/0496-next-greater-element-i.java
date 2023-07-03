class Solution {
    /*
        배열안에 있는 몇몇의 x 요소의 다음 더 큰 요소는 첫번째로 
    */
    
    // Algorithm: Brute-Force 
    // Time: O(N*M), Space: O(N)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        
        for(int i = 0; i < nums1.length; i++){
            boolean isSame = false;
            ans[i] = -1;
            
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]) isSame = true;
                if(isSame && nums1[i] < nums2[j]) {
                    ans[i] = nums2[j];
                    break;
                } 
            }
        }
        
        return ans;
        
    }
}