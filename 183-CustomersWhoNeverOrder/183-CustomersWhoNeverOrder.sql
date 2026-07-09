-- Last updated: 7/9/2026, 10:08:13 AM
# Write your MySQL query statement below
SELECT name AS Customers
FROM Customers
WHERE id NOT IN (
    SELECT customerId
    FROM Orders
);