# Last updated: 7/9/2026, 10:11:56 AM
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_index = {}  # stores latest index of each character
        left = 0  # left boundary of window
        max_len = 0

        for right, ch in enumerate(s):
            if ch in char_index and char_index[ch] >= left:
                # Move left pointer to avoid duplicates
                left = char_index[ch] + 1

            char_index[ch] = right
            max_len = max(max_len, right - left + 1)

        return max_len

        