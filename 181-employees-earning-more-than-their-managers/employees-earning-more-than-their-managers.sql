# Write your MySQL query statement below
select e1.name as Employee
FROM Employee e1
JOIN Employee e2
ON e1.managerId = e2.id
where e2.salary<e1.salary
