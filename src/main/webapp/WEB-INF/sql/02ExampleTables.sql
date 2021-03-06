USE mydb4;

CREATE TABLE Board
SELECT * FROM mydb2.Board;

CREATE TABLE Reply
SELECT * FROM mydb2.Reply;

DESC Board;
ALTER TABLE Board MODIFY COLUMN id INT PRIMARY KEY AUTO_INCREMENT;

DESC Reply;
ALTER TABLE Reply MODIFY COLUMN id INT PRIMARY KEY AUTO_INCREMENT;

ALTER TABLE Reply ADD FOREIGN KEY (board_id) REFERENCES Board(id);

SELECT * FROM Reply;