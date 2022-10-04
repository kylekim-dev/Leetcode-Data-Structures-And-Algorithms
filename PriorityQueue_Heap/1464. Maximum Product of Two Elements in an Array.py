# importing "heapq" to implement heap queue
import heapq

def maxProduct(nums) -> int:
    '''
    Link: https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
    Solving with: Max heap
    Time Complexity: O(logN)
    Space Complexity: O(N)
    '''
    hq = []
    
    for n in nums:
        heapq.heappush(hq, -n)
        
    i = heapq.heappop(hq) + 1
    j = heapq.heappop(hq) + 1
    
    return i * j

arr = [2,3,4,7,11]

print(maxProduct(arr))