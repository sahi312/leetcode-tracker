# Last updated: 7/9/2026, 10:11:47 AM
class Solution:
    def isPalindrome(self, x: int) -> bool:
        # Negative numbers are never palindromes
        if x < 0:
            return False
        
        # Convert to string and check if same forwards/backwards
        return str(x) == str(x)[::-1]
