# Last updated: 8/11/2026, 2:13:33 PM
1class Fancy:
2
3    def __init__(self):
4        self.mod = 10**9 + 7  
5        self.val = []  
6        self.a = 1  
7        self.b = 0  
8
9    def append(self, val: int) -> None:
10        x = (val - self.b + self.mod) % self.mod
11        self.val.append(x * pow(self.a, self.mod - 2, self.mod) % self.mod)
12
13    def addAll(self, inc: int) -> None:
14        self.b = (self.b + inc) % self.mod
15
16    def multAll(self, m: int) -> None:
17        self.a = (self.a * m) % self.mod
18        self.b = (self.b * m) % self.mod
19
20    def getIndex(self, idx: int) -> int:
21        if idx >= len(self.val):
22            return -1  
23        return (self.a * self.val[idx] + self.b) % self.mod
24
25# Your Fancy object will be instantiated and called as such:
26# obj = Fancy()
27# obj.append(val)
28# obj.addAll(inc)
29# obj.multAll(m)
30# param_4 = obj.getIndex(idx)