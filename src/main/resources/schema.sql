

CREATE TABLE STUDENT
 (
  id VARCHAR (64) PRIMARY KEY ,
      first_name VARCHAR(45) NOT NULL,
      second_name VARCHAR(45) NOT NULL,
      email VARCHAR(45) not null
);

CREATE TABLE TEACHER
 (
  id VARCHAR (64) PRIMARY KEY ,
  first_name VARCHAR(45) NOT NULL,
  second_name VARCHAR(45) NOT NULL,
  email VARCHAR(45) not null
);

CREATE TABLE ACCOUNT
(
  id VARCHAR (64) PRIMARY KEY ,
  user_name VARCHAR(45) NOT NULL,
  user_password VARCHAR(64) NOT NULL,
  student_id VARCHAR (64),
  teacher_id VARCHAR (64),
  role VARCHAR (32),
  FOREIGN KEY (student_id) REFERENCES student (id),
  FOREIGN KEY (teacher_id) REFERENCES teacher (id)
);

CREATE TABLE COURSE
 (
  id VARCHAR (64) PRIMARY KEY ,
  course_name VARCHAR(45) NOT NULL,
  start_date DATE,
  end_date DATE ,
  teacher_id VARCHAR (64),
  FOREIGN KEY (teacher_id) REFERENCES teacher (id)
);

CREATE TABLE STUDENT_COURSE (
  id VARCHAR (64) PRIMARY KEY ,
  student_id VARCHAR (64),
  course_id VARCHAR (64),
  mark INTEGER,
  review TEXT,
  FOREIGN KEY (student_id) REFERENCES STUDENT (id),
  FOREIGN KEY (course_id) REFERENCES COURSE (id)
);

commit;