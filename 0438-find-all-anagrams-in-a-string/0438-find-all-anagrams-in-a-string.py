"""

T: O(N)
S: O(1)


"""
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        target = [0] * 26
        source = [0] * 26
        ret = []
        
        for val in p:
            target[ord(val) - ord("a")] += 1 

        start = 0
        for end, val in enumerate(s):
            source[ord(val) - ord("a")] += 1
            
            if end >= len(p) - 1:
                if target == source:
                    ret.append(start)
                
                source[ord(s[start]) - ord("a")] -= 1
            
                start += 1
        
        return ret