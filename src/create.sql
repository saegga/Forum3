DROP TABLE IF EXISTS users, forums, posts, subjects;
SET CHARACTER SET utf8;

CREATE TABLE users (
  id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name     VARCHAR(255),
  email    VARCHAR(250),
  password VARCHAR(250),
  isAdmin  BOOL
);
CREATE TABLE forums (
  id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250)
);

CREATE TABLE subjects (
  id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name     VARCHAR(250),
  forum_id INT
);
CREATE TABLE posts (
  id         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  dt         DATE,
  user_id    INT NOT NULL,
  txt        NCHAR(250),
  subject_id INT,
  reply_to   INT


--  FOREIGN KEY  (subject_id)  REFERENCES subjects(id)
);
set CHARACTER SET UTF8;


INSERT INTO users (id, name, email, isAdmin, password) VALUE (1, 'BOB', 'bob@mail.ru', TRUE, 12345);
INSERT INTO forums (id, name) VALUES (1, 'TEst');
INSERT INTO forums (id, name) VALUES (2, 'TEst22');
INSERT INTO subjects (id, name, forum_id) VALUES (1, 'Theme1', 1);
INSERT INTO subjects (id, name, forum_id) VALUES (2, 'Theme2', 1);
INSERT INTO subjects (id, name, forum_id) VALUES (3, 'Theme3', 1);
INSERT INTO posts (id, txt, user_id, subject_id, dt) VALUES (1, 'text1', 1, 1, '2010-10-12');
INSERT INTO posts (id, txt, user_id, subject_id, dt) VALUES (2, 'text2', 1, 1, '2009-11-09');

SELECT *
FROM subjects;