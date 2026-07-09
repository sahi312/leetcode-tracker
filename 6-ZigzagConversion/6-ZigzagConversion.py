# Last updated: 7/9/2026, 10:11:52 AM
class Solution:
    def convert(self, s: str, numRows: int) -> str:
        # If only 1 row, zigzag is same as original string
        if numRows == 1 or numRows >= len(s):
            return s

        # Create a list of strings for each row
        rows = [""] * numRows
        curRow = 0
        goingDown = False

        # Traverse through the string
        for char in s:
            rows[curRow] += char
            # Change direction when reaching top or bottom
            if curRow == 0 or curRow == numRows - 1:
                goingDown = not goingDown
            curRow += 1 if goingDown else -1

        # Concatenate rows
        return "".join(rows)


        