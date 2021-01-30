INSERT INTO COMPANY(ID, NAME, ADDRESS)
VALUES(1,'ACME','42 Geek Road'),
      (2,'HAL','51 Main Street');

INSERT INTO EMPLOYEE(ID, FIRST_NAME, LAST_NAME, AGE, ADDRESS, SALARY, COMPANY_ID)
VALUES(1,'Jill','Brown', 33,'3 Trinity Avenue', 2100.5, 1),
      (2,'John','Doe', 50,'13 Melrae Court', 3333.3, 2),
      (3,'Samantha','Parker', 44,'27 Willow Road', 2500.75, 2),
      (4,'Bill','Connor', 27,'42 Tesla Street', 1700.25, 2),
      (5,'Catherina','Smith', 35,'77 Turing Road', 2100.6, 1);

CREATE TABLE EMPLOYEE(
   ID INT PRIMARY KEY     NOT NULL,
   FIRST_NAME           TEXT    NOT NULL,
   LAST_NAME           TEXT    NOT NULL,
   AGE            INT     NOT NULL,
   ADDRESS        CHAR(50),
   SALARY         REAL,
   COMPANY_ID INT,
   CONSTRAINT FK_COMPANY
      FOREIGN KEY(COMPANY_ID)
	  REFERENCES COMPANY(ID)
);
