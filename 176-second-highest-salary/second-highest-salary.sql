# Write your MySQL query statement below
select(select distinct
Salary
from 
Employee
order by Salary DESC
LIMIT 1 OFFSET 1) AS SecondHighestSalary;