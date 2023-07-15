#Write a SQL query to get the nth highest salary from the Employee table.

#MySql syntax

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      SELECT CASE WHEN COUNT(BASE.SALARY) < N THEN NULL ELSE MIN(BASE.SALARY) END
      FROM (  SELECT DISTINCT SALARY
              FROM EMPLOYEE
              ORDER BY SALARY DESC
              LIMIT N ) AS BASE

  );
END