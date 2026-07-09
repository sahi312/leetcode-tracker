-- Last updated: 7/9/2026, 10:08:15 AM
# Write your MySQL query statement below
SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(email) > 1;