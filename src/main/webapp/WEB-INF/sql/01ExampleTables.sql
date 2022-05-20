Create DATABASE mydb4;

CREATE TABLE Customers
SELECT * FROM w3schools.Customers;

ALTER TABLE Customers
MODIFY COLUMN CustomerID INT PRIMARY KEY AUTO_INCREMENT;

CREATE TABLE Employees
SELECT * FROM w3schools.Employees;

DESC Employees;
DESC Customers;

ALTER TABLE Employees
MODIFY COLUMN EmployeeID INT PRIMARY KEY AUTO_INCREMENT;

select * from Customers Order by CustomerID desc;

select * from Employees;
