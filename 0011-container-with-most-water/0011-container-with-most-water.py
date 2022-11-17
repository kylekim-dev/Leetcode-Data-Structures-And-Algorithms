'''
Algorithm: Two Pointer
N = len(height)
T: O(N)
S: O(1)
'''

class Solution:
    def maxArea(self, height: List[int]) -> int:
        l, r = 0, len(height) - 1
        globalMax = 0
        
        while l < r:
            localMax = r - l
            localMax *= min(height[l], height[r])
            globalMax = max(localMax, globalMax)
            
            if height[l] == height[r]:
                l += 1
                r -= 1
            elif height[l] > height[r]:
                r -= 1
            else:
                l += 1
                
        return globalMax
            
        