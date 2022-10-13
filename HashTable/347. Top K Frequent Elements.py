from collections import Counter
import heapq
from pip import List
# https://leetcode.com/problems/top-k-frequent-elements/
# Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

def topKFrequent(nums: List[int], k: int) -> List[int]:
    # Kyle's solution: HashTable, Heap
    # Time Complexity: O(N logK)
    # Space Complexity: O(K)
    # N: size of nums array

    prioryQ = list() # Min heap
    
    for num, freq in Counter(nums).items():
        heapq.heappush(prioryQ, (freq, num))
        if len(prioryQ) > k:
            heapq.heappop(prioryQ)

    return [num for _, num in prioryQ]


nums = [1,1,1,2,2,3] 
k = 2

print(topKFrequent(nums, k))