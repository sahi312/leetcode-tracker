# Last updated: 9/29/2026, 4:07:43 PM
1class Solution:
2    def shortestPalindrome(self, s: str) -> str:
3        count = self.kmp(s[::-1], s)
4        return s[count:][::-1] + s
5    def kmp(self, txt: str, patt: str) -> int:
6        new_string = patt + '#' + txt
7        pi = [0] * len(new_string)
8        i = 1
9        k = 0
10        while i < len(new_string):
11            if new_string[i] == new_string[k]:
12                k += 1
13                pi[i] = k
14                i += 1
15            else:
16                if k > 0:
17                    k = pi[k - 1]
18                else:
19                    pi[i] = 0
20                    i += 1
21        return pi[-1]