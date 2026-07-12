# Last updated: 7/12/2026, 8:56:39 AM
1class Solution:
2    def secondsBetweenTimes(self, startTime: str, endTime: str) -> int:
3        h1,m1,s1 = map(int,startTime.split(":"))
4        h2,m2,s2=map(int,endTime.split(":"))
5        start = h1*3600+m1*60+s1
6        end=h2*3600+m2*60+s2
7        return end - start