'''


'''

class Solution:
    def arithmeticTriplets(self, nums: List[int], diff: int) -> int:
        i, j, k = 0, 1, 2
        
        output = 0
        
        while i < len(nums) - 2:
            while j < len(nums) - 1:
                if nums[j] - nums[i] == diff:
                    while k < len(nums):
                        if nums[k] - nums[j] == diff:
                            output += 1
                        k += 1
                j += 1
                k = j + 1
            i += 1
            j = i + 1
            k = j + 1
            
            
        return output