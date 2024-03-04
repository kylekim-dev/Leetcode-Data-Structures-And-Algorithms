class Solution:
    def longestPalindrome(self, s: str) -> int:
        freq = [0]*128;
        count = 0
        maxOdd = 0

        for c in s:
            freq[ord(c)]+=1
        
        for i in freq:
            if i & 1 == 0:
                count += i
            else:
                if maxOdd > 0:
                    maxOdd -= 1
                    
                maxOdd += i
            
        return count + maxOdd
    
    """
    ss = set()
    for letter in s:
        if letter not in ss:
            ss.add(letter)
        else:
            ss.remove(letter)
    if len(ss) != 0:
        return len(s) - len(ss) + 1
    else:
        return len(s)
    """
                