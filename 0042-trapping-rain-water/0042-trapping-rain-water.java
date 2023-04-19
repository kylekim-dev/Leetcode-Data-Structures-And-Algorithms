class Solution {
    /*
        height[]   = 0 1 0 2 1 0 1 3 2 1 2 1
        rightMax[] = 2 2 2 2 3 3 3 3 2 2 2 1
        leftMax[]  = 0 1 1 2 2 2 2 3 3 3 3 3
        
        
        0 0 1 0 1 2 1 0 0 1 0 0 
        0 0 1 0 1 2 1 0 0 1 0 0
        
        아이디어
            오른쪽 시점에서 바라봤을때 가장 높은 기둥 값을 저장하는 rightMax[]
            왼쪽 시점에서 바라봤을때 가장 높은 기둥 값을 저장하는 leftMax[]
            sum += Math.Min(rightMax[i], leftMax[i]) - height[i]
            
        알고리즘
            투포인터
            
        시간복잡도
            T: O(N)
            S: O(N)
    */
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int sum = 0;
        int r = height.length - 1;

        leftMax[0] = height[0];
        rightMax[r] = height[r];
        
        for(int l = 1; l < height.length; l++){
            r -= 1;
            leftMax[l] = Math.max(leftMax[l - 1], height[l]);
            rightMax[r] = Math.max(rightMax[r + 1], height[r]);
        }
        
        
        for(int i = 0; i < height.length; i++){
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        
        return sum;
    }
}