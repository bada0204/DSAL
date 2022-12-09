SELECT P.email
FROM Person P
GROUP BY P.email
HAVING COUNT(*) > 1;