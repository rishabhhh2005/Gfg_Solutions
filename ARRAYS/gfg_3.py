# https://www.geeksforgeeks.org/problems/second-largest3735/1
# Second Largest
class Solution:
    def getSecondLargest(self, arr):
        if len(arr)<=1: return -1
        max = -1
        smax = -1
        
        for x in arr:
            
            if x > max:
                smax = max
                max = x
            elif x > smax and x != max:
                smax = x
        return smax