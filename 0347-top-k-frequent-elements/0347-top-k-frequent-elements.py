class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
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