# importing "heapq" to implement heap queue
import heapq
from pip import List

def kWeakestRows(mat, k) -> List[int]:
    '''
    Solving with: priority queue
    Time Complexity: O(n+m)
    Space Complexity: O(n)

    m == mat.length
    n == mat[i].length

    '''
    hq = []
    output = []
    
    for r in range(len(mat)):
        soldiers = 0
        
        for c in range(len(mat[r])):
            if mat[r][c] == 1:
                soldiers += 1
            
        heapq.heappush(hq, (soldiers, r))

    
    for i in range(k):
        output.append(heapq.heappop(hq)[1])
        
    return output

mat = [
 [1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]
 ]

k = 3

print(kWeakestRows(mat, k))