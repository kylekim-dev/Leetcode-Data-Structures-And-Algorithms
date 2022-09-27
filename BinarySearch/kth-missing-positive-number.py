import sys

def findKthPositiveWithBinarySearch(arr, k) -> int:
    # Solution 2, binary search
    # Time complexity is O(log n), space is O(1)
    '''
    I really like this problem, because you do not stop when you find linear solution, and you can do better! What can be better, than linear solution? Usually it is solution with complexity O(log n). Now, we have two good indicators, that we need to use binary search: sorted data and O(log n) complexity. Let us look for the following example for more understanding:
    2, 3, 4, 7, 11, 12 and k = 5.
    We need to find place, of k-th missing positive number, so, let us create virtual list (virtual, because we will not compute it full, but only elements we need):

    B = [2 - 1, 3 - 2, 4 - 3, 7 - 4, 11 - 5, 12 - 6] = [1, 1, 1, 3, 6, 6].

    What this list represents is how many missing numbers we have for each inex: for first number we have missing number [1], for next two iterations also, when we add 7, we have 3 missing numbers: [1, 5, 6], when we add 11, we have 6 missing numbers: [1, 5, 6, 8, 9, 10]. How we evalaute values of list B? Very easy, it is just A[i] - i - 1.

    What we need to find now in array B: first element, which is greater or equal than k. In our example, we have [1, 1, 1, 3, 6, 6]. We will find it with binary search: this element have index end = 4. Finally, we need to go back to original data, we have

    arr = [2, 3, 4, 7, 11, 12]
    B = [1, 1, 1, 3, 6, 6]

    So, what we now know that our answer is between numbers 7 and 11 and it is equal to arr[end] - (B[end] - k + 1), where the second part is how many steps we need to make backward. Using B[end] = arr[end] - end - 1, we have end + k, we need to return.
    '''
    beg, end = 0, len(arr)
    while beg < end:
        mid = (beg + end) // 2
        if arr[mid] - mid - 1 < k:
            beg = mid + 1
        else:
            end = mid
    return end + k

def findKthPositive(arr, k) -> int:
    # Kyle's solution, Brute-Force
    # Time Complexity: O(N)
    # Space Complexity: O(1)
    index = 0
    output = 1
    
    while index < len(arr):
        if output == arr[index]:
            index += 1
        else:
            k -= 1
        
        if k == 0:
            return output
            
        output += 1
        
        
    return arr[len(arr) - 1] + k

arr = [2,3,4,7,11]
k = 5

print(findKthPositive(arr, k))
print(findKthPositiveWithBinarySearch(arr, k))