# Last updated: 7/9/2026, 10:06:26 AM
class Solution:
    def processStr(self, s: str, k: int) -> str:
        n = len(s)

        length = [0] * (n + 1)

        for i, ch in enumerate(s):
            if ch.isalpha():
                length[i + 1] = length[i] + 1
            elif ch == '*':
                length[i + 1] = max(0, length[i] - 1)
            elif ch == '#':
                length[i + 1] = length[i] * 2
            else:  # '%'
                length[i + 1] = length[i]

        if k >= length[n]:
            return '.'

        for i in range(n - 1, -1, -1):
            ch = s[i]
            prev_len = length[i]

            if ch.isalpha():
                if k == prev_len:
                    return ch

            elif ch == '#':
                if k >= prev_len:
                    k -= prev_len

            elif ch == '%':
                k = prev_len - 1 - k

            # '*' does not change k when tracing backwards

        return '.'