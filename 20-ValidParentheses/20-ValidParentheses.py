# Last updated: 7/9/2026, 10:11:30 AM
class Solution:
    def isValid(self, s):
        stack = []

        for ch in s:
            if ch in "({[":
                stack.append(ch)
            else:
                if not stack:
                    return False

                top = stack.pop()

                if (ch == ')' and top != '(') or \
                   (ch == '}' and top != '{') or \
                   (ch == ']' and top != '['):
                    return False

        return len(stack) == 0