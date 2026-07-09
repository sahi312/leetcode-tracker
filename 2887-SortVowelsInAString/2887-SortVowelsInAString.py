# Last updated: 7/9/2026, 10:07:02 AM
class Solution:
    def sortVowels(self, s: str) -> str:
        vowels = set("aeiouAEIOU")
        # Extract vowels in order of appearance
        vowel_list = [ch for ch in s if ch in vowels]
        # Sort vowels by ASCII value
        vowel_list.sort()
        
        result = []
        idx = 0  # index for vowel_list
        
        for ch in s:
            if ch in vowels:
                result.append(vowel_list[idx])
                idx += 1
            else:
                result.append(ch)
        
        return ''.join(result)

        