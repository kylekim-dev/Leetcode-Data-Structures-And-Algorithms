'''
T: O(NM)
S: O(M)

'''
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        output = strs[0]
        
        for i in range(1, len(strs)):
            word = strs[i]
            
            if len(output) > len(word):
                output = output[0:len(word)]
                
            for j in range(min(len(output), len(word))):
                if output[j] != word[j]:
                    output = output[0:j]
                    break
            
        return output