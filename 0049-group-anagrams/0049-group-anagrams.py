'''
T: O(N *MlogM)
S: O(N)
'''
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        if len(strs)==0:
            return [[""]]
        
        output = {}
        
        for word in strs: # O(n)
            sortedWord = ''.join(sorted(word)) # n*log(n)
            if sortedWord in output:
                output[sortedWord].append(word)
            else:
                output[sortedWord] = [word]
                
        return output.values()