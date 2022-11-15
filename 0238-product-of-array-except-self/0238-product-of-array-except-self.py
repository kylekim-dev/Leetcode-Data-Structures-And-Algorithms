'''
N = nums.length

T: O(N)
S: O(1)

'''

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        total = 0
        zeroCount = 0
        
        for num in nums:
            if num != 0:
                if total == 0:
                    total = 1
                
                total *= num
            else:
                zeroCount += 1
                
                
        if zeroCount > 1:
            return [0] * len(nums)
        elif zeroCount == 1:
            for i in range(len(nums)):
                if nums[i] == 0:
                    nums[i] = total
                else:
                    nums[i] =  0
        else:
            for i in range(len(nums)):
                nums[i] = total // nums[i]

            
        return nums
            