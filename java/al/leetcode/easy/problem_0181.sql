SELECT E.name AS Employee
FROM Employee E
INNER JOIN Employee M ON E.managerID = M.id
WHERE E.salary > M.salary;