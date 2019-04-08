select max(ifnull(salary, 0))  as SecondHighestSalary
from employee
where salary != (select max(ifnull(salary, 0)) from employee)