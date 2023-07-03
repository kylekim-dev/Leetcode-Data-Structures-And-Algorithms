class Solution {
    /*
        
        
        // Algorithm: Monotonic-Stack
        // Time: O(N), Space: O(N)
        
        [4,3,9]
        [1,5,4,3,2,9]
    */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int j = 0; j < nums2.length; j++){
            while(!stack.isEmpty() && stack.peek() < nums2[j])
                map.put(stack.pop(), nums2[j]);
            
            stack.push(nums2[j]);
        }

        for(int i = 0; i < nums1.length; i++){
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        
        return ans;
    }
    
    /*
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
    }*/
}