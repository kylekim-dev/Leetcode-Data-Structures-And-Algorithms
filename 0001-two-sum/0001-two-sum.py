class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = dict()
        
        for i, val in enumerate(nums):
            # target - val = targeting
            if val in hashmap:
                return [hashmap[val], i]
            
            hashmap[target - val] = i
            
        return []