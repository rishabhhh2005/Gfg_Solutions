# https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1
# Equilibrium Point
class Solution:
    def findEquilibrium(self, arr):
        n= len(arr)
    
        pre =[0] *n
        suff=[0] *n
    
        for i in range(1, n):
            pre[i] = pre[i-1] + arr[i-1]
            suff[n-i-1] = suff[n-i] + arr[n-i]
            
        for j in range(n):
            if pre[j] == suff[j]: return j
        return -1
        