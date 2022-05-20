CREATE DATABASE mydb6;
USE mydb6;

CREATE TABLE Board
SELECT * FROM mydb4.Board;

CREATE TABLE Reply
SELECT * FROM mydb4.Reply;

ALTER TABLE Board MODIFY COLUMN id INT PRIMARY KEY AUTO_INCREMENT;
ALTER TABLE Reply MODIFY COLUMN id INT PRIMARY KEY AUTO_INCREMENT;

ALTER TABLE Reply ADD FOREIGN KEY (board_id) REFERENCES Board(id);

DESC Reply;

CREATE TABLE Products
SELECT * FROM w3schools.Products;

CREATE TABLE Categories
SELECT * FROM w3schools.Categories;

SELECT c.CategoryName,
	   p.ProductName,
       p.Unit,
       p.Price
FROM Products p 
JOIN Categories c 
ON p.CategoryID = c.CategoryID
WHERE c.CategoryID IN (1, 3, 4);

SELECT * FROM Products
WHERE Price > 10;