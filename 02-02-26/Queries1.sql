
-- TASK 1 --
CREATE TABLE STUDENTS(student_id BIGINT PRIMARY KEY,name VARCHAR(10),email VARCHAR(100) UNIQUE , age INT,join_date DATE, active_flag BIT DEFAULT 1);



create table courses (course_id int primary key, course_name varchar(20) not null, fees decimal);
create table enrollments(enroll_id bigint primary key, student_id bigint, course_id int);


USE college_db;


-- TASK 2 --


INSERT into students values(10141414,'Rishi','Rishi@gmail.com',21,'2026-01-05',1);


INSERT into students values(10141429,'Divya','Divya@gmail.com',21,'2026-01-05',1,1234567890);

INSERT into students values(10141415,'Sairaj','Sairaj@gmail.com',21,'2026-01-05',1);
 
INSERT into students values
(52, 'Tahameer', 'Tahameer@gmail.com', 21, '2026-01-05',1),
(53, 'kiran', 'sashikiran@gmail.com', 21, '2026-01-05',1),
(54, 'Revanth', 'Revanth@gmail.com', 21, '2026-01-05',0),
(56, 'Goutham', 'Goutham@gmail.com', 21, '2026-01-05',1),
(57, 'Girish', 'Girish@gmail.com', 21, '2026-01-05',0),
(60, 'sunny', 'sunny@gmail.com', 21, '2026-01-05',1),
(61, 'maniteja', 'maniteja@gmail.com', 21, '2026-01-05',1)
(62, 'gnaneshwar', 'gnaneshwar@gmail.com', 21, '2026-01-05',1);




INSERT INTO courses VALUES(001, 'Java Programming', 25000),
(002,'DBMS',3000),
(003, 'DevOps', 40000),
(004, 'Computer Networks', 20000),
(005, 'Operating Systems', 35000);



INSERT INTO enrollments 
(enroll_id, student_id, course_id)
VALUES (121212, 52, 001),
(121213, 53, 001),
(121214, 54, 002),
(121216, 56, 004),
(121217, 57, 005),
(1212126, 60, 001),
(121218, 61, 002),
(121219, 62, 003),
(121220, 10141414, 004),
(121221, 10141415, 005),
(121222, 53, 002),
(121223, 54, 003),
(121224, 56, 005),
(121225, 57, 001);



ALTER TABLE enrollments drop column enroll_timestamp;

ALTER TABLE enrollments
ADD enroll_timestamp DATETIME2 DEFAULT SYSDATETIME();



SELECT * FROM enrollments;


-- TASK 3 --


INSERT into students values
(213213, 'Manish', 'manish@gmail.com', 21, '2026-01-05',1),
(213214, 'Sharan', 'sharan@gmail.com', 21, '2026-01-05',1),
(213215, 'Tansih', 'tanish@gmail.com', 21, '2026-01-05',0);


INSERT INTO courses VALUES(006, 'Data Structures', 25000);


UPDATE courses set fees = 100000 WHERE course_id = 006;


INSERT INTO enrollments 
(enroll_id, student_id, course_id)
VALUES (121227, 10141415, 006);


SELECT * FROM courses;

SELECT name,email FROM STUDENTS;


SELECT * FROM STUDENTS ORDER BY AGE DESC;


SELECT TOP 5 * FROM STUDENTS ORDER BY join_date;



SELECT DISTINCT age FROM students;


SELECT DISTINCT course_name FROM courses;


UPDATE STUDENTS set AGE = 20 WHERE student_id = 62;


UPDATE STUDENTS set active_flag = 0 WHERE student_id IN (61,62);

UPDATE courses set fees = fees+fees*0.1;


DELETE FROM STUDENTS where student_id=57;


DELETE FROM courses where fees<1000;

SELECT * FROM enrollments;

DELETE  FROM enrollments where enroll_timestamp > '2026-02-03 05:51:47.5931708';


ALTER TABLE students ALTER COLUMN name VARCHAR(30);


EXEC sp_rename 'STUDENTS.join_date', 'registration_date' , 'COLUMN';



ALTER TABLE students

ADD phone_No VARCHAR(15);

SELECT * FROM courses;

--- TASK 4 ---


SELECT * FROM students WHERE AGE > 21;

SELECT * FROM students WHERE active_flag=1;

SELECT * FROM courses  WHERE fees BETWEEN 1000 AND 5000;

SELECT * FROM students WHERE AGE IN (20,22,25);

SELECT * FROM students WHERE AGE > 20 AND active_flag = 1;

SELECT * FROM students WHERE AGE < 20 OR active_flag = 0;

SELECT * FROM courses WHERE fees > 2000 AND course_name LIKE '%Data%'; 

SELECT * FROM students WHERE email LIKE '%gmail.com%';

SELECT * FROM courses WHERE course_name LIKE 'Data%';

SELECT * FROM students WHERE name LIKE '%D%';

INSERT INTO students VALUES(011,'manoj','manoj@gmail.com',NULL,'2026-01-05',1,1233345623);

SELECT * FROM students WHERE AGE IS NULL;

SELECT * FROM students WHERE AGE IS NOT NULL;


--TASK 5 --


SELECT  COUNT(*) FROM Students;

SELECT  COUNT(*) FROM Students WHERE active_flag=1;

SELECT SUM(fees) FROM  courses;

SELECT AVG(fees) FROM courses;

SELECT SUM(fees) FROM courses WHERE fees>2000;

SELECT * FROM enrollments;

SELECT MIN(AGE) FROM students;

SELECT MAX(fees) FROM courses;

SELECT MIN(registration_date) FROM students;

SELECT MAX(registration_date) FROM students;

SELECT COUNT(*) FROM students GROUP BY active_flag;

SELECT COUNT(AGE) FROM students GROUP BY AGE;

SELECT COUNT(*) FROM courses GROUP BY fees;

SELECT COUNT(course_id) FROM enrollments GROUP BY course_id HAVING COUNT(course_id)>3; 

SELECT AGE FROM students GROUP BY AGE HAVING AVG(AGE)>21;

SELECT course_id, COUNT(course_id) FROM enrollments WHERE course_id !=1 GROUP BY course_id HAVING COUNT(course_id)>2;


---TASK 6 ---

SELECT * FROM students WHERE AGE>20 ORDER BY AGE;

SELECT COUNT(name) FROM students WHERE name LIKE '%a%';

SELECT course_name,fees FROM courses WHERE fees BETWEEN 2000 AND 20000 ORDER BY fees;

SELECT * FROM students WHERE active_flag=0 AND AGE IS NOT NULL;

SELECT student_id FROM enrollments GROUP BY student_id HAVING COUNT(student_id)>1;



SELECT * FROM STUDENTS;


SELECT * FROM STUDENTS  WHERE age = SELECT age=MAX(age);
























