# Last updated: 7/9/2026, 10:07:45 AM
class Solution:
    def isSelfCrossing(self, distance):
        x = distance

        return any(
            d >= b > 0 and
            (
                a >= c or
                (a >= c - e >= 0 and f >= d - b)
            )
            for a, b, c, d, e, f in (
                (x[i:i+6] + [0] * 6)[:6]
                for i in range(len(x))
            )
        )