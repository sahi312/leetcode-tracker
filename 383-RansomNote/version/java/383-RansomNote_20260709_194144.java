// Last updated: 7/9/2026, 7:41:44 PM
1class Solution {
2    public boolean canConstruct(String ransomNote, String magazine) {
3		if (ransomNote.length() > magazine.length()) return false;
4        int[] alphabets_counter = new int[26];
5        
6        for (char c : magazine.toCharArray())
7            alphabets_counter[c-'a']++;
8
9        for (char c : ransomNote.toCharArray()){
10            if (alphabets_counter[c-'a'] == 0) return false;
11            alphabets_counter[c-'a']--;
12        }
13        return true;
14    }
15}