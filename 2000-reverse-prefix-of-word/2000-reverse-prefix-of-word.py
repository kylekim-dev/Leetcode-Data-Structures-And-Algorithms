class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        l, r = 0, 0
        
        word = list(word)
        
        for w in word:
            if w == ch:
                break
            r += 1
        
        while l < r and r < len(word):
            word[l], word[r] = word[r], word[l]
            
            l += 1
            r -= 1
            
        return ''.join(word)