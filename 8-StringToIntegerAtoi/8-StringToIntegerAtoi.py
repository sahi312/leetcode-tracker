# Last updated: 7/9/2026, 10:11:49 AM
class Solution:
    def myAtoi(self, s: str) -> int:
        # 32-bit signed integer range
        INT_MAX = 2**31 - 1
        INT_MIN = -2**31
        
        i = 0
        n = len(s)
        result = 0
        sign = 1
        
        # Step 1: Ignore leading whitespaces
        while i < n and s[i] == " ":
            i += 1
        
        # Step 2: Check for sign
        if i < n and (s[i] == "+" or s[i] == "-"):
            if s[i] == "-":
                sign = -1
            i += 1
        
        # Step 3: Convert digits to integer
        while i < n and s[i].isdigit():
            digit = int(s[i])
            
            # Step 4: Handle overflow (before adding the digit)
            if result > (INT_MAX - digit) // 10:
                return INT_MAX if sign == 1 else INT_MIN
            
            result = result * 10 + digit
            i += 1
        
        return sign * result

        