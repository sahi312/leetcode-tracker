# Last updated: 7/12/2026, 9:14:02 AM
1class Solution:
2    def minimumCost(self, nums,k):
3        MOD=10**9+7
4        resource=k
5        ops=0
6        ans=0
7        for x in nums:
8            if resource < x:
9                need=(x-resource +k - 1) // k
10                ans =(ans+(ops+1+ops+need)*need // 2)%MOD
11                ops += need
12                resource += need*k
13            resource -= x
14        return ans    
15        