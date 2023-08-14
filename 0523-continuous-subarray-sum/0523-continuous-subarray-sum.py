class Solution:
    def checkSubarraySum(self, nums, k):
        prefix_sum_map = {}  # remainder of prefix, index
        prefix_sum = 0

        prefix_sum_map[0] = -1
        for i in range(len(nums)):
            prefix_sum += nums[i]
            remainder = prefix_sum % k
            # 현재 나머지가 해시맵에 존재하고, 나머지 값이 이전 값이 아니면
            if remainder in prefix_sum_map and prefix_sum_map[remainder] != i - 1:
                return True
            # 해시맵에 값이 존재하지 않을 때만 추가
            if remainder not in prefix_sum_map:
                prefix_sum_map[remainder] = i

        return False
