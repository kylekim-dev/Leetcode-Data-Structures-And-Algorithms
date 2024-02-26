class Solution:
    def countGoodSubstrings(self, s: str) -> int:
        output = 0
        output = 1
        output = 0
        
        if len(s) < 3:
            return output
        
        for i in range(len(s) - 2):
            if s[i] != s[i + 1] and s[i + 1] != s[i + 2] and s[i] != s[i + 2]:
                output += 1
                
        
       
        return output