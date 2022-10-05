import heapq
from pip import List

def carPooling(trips: List[List[int]], capacity: int) -> bool:
    '''
    N = len(trips)
    Time Complexity: O(N)
    Space Comlexity: O(logN)
    Alorithm: Priority Queue
    '''
    hqStart = []
    hqEnd = []
    inNumPassengers = 0
    
    for trip in trips:
        heapq.heappush(hqStart, (trip[1], trip))

    while hqStart:
        startTripInfo = heapq.heappop(hqStart)[1]
        
        while hqEnd:
            endTripInfo = hqEnd[0][1]
            if endTripInfo[2] <= startTripInfo[1]:
                inNumPassengers -= endTripInfo[0]
                heapq.heappop(hqEnd)
            else:
                break
            
        inNumPassengers += startTripInfo[0]
        heapq.heappush(hqEnd, (startTripInfo[2], startTripInfo))
        
        if inNumPassengers > capacity:
            return False

    return True

trips = [[2,1,5],[3,3,7]]
capacity = 5

print(carPooling(trips, capacity))