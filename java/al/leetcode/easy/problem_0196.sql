DELETE p FROM Person p
WHERE p.id NOT IN (
    SELECT * FROM (
        SELECT MIN(id) FROM Person
        GROUP BY email
    ) AS p
);