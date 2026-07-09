# Last updated: 7/9/2026, 10:07:14 AM
from typing import List

class Solution:
    def minimumTeachings(self, n: int, languages: List[List[int]], friendships: List[List[int]]) -> int:
        # Convert languages list to sets for fast lookup
        lang_sets = [set(l) for l in languages]
        
        # Step 1: find friendships that cannot communicate
        bad_friends = set()
        for u, v in friendships:
            if lang_sets[u-1].isdisjoint(lang_sets[v-1]):
                bad_friends.add(u-1)
                bad_friends.add(v-1)
        
        # Step 2: For each language, count how many bad users do not know it
        min_teach = float('inf')
        for lang in range(1, n+1):
            teach_count = sum(1 for user in bad_friends if lang not in lang_sets[user])
            min_teach = min(min_teach, teach_count)
        
        return min_teach

        