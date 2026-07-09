# Last updated: 7/9/2026, 10:10:17 AM
class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        numbers = [str(i) for i in range(1, n + 1)]

        factorial = [1] * n
        for i in range(1, n):
            factorial[i] = factorial[i - 1] * i

        k -= 1  # Convert to 0-based index
        result = []

        for i in range(n, 0, -1):
            idx = k // factorial[i - 1]
            result.append(numbers[idx])

            numbers.pop(idx)
            k %= factorial[i - 1]

        return "".join(result)