/*******************************************************************************
   Drop database if it exists
********************************************************************************/

DROP USER iwp1admin CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER iwp1admin
IDENTIFIED BY yourmom69
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to iwp1admin;
GRANT resource to iwp1admin;
GRANT create session TO iwp1admin;
GRANT create table TO iwp1admin;
GRANT create view TO iwp1admin;

conn iwp1admin/yourmom69;

/*******************************************************************************
   Create Tables
********************************************************************************/

CREATE TABLE AUTH(
    USER_ID INTEGER PRIMARY KEY,
    USER_NAME VARCHAR(100) NOT NULL,
    PASSWORD VARCHAR(100) NOT NULL
);

CREATE TABLE EMPLOYEES(
    USER_ID INTEGER PRIMARY KEY,
    EMAIL VARCHAR(100) NOT NULL,
    FIRST_NAME VARCHAR(100),
    LAST_NAME VARCHAR(100),                 --1000+ low level employee,
    TITLE_ID INTEGER DEFAULT 1000 NOT NULL, --500-999 mid management,
    REPORTSTO INTEGER                       --100-499 upper management 
);                                          --10-99 special departments
                                            --0-9 Executives

CREATE TABLE TITLES(
    TITLE_ID INTEGER PRIMARY KEY,
    TITLE_NAME VARCHAR(100) NOT NULL
);

CREATE TABLE INVOICES(
    INVOICE_ID INTEGER PRIMARY KEY,
    USER_ID INTEGER NOT NULL,
    STATUS INTEGER DEFAULT 0,
    AMOUNT INTEGER,
    IMAGE_ID INTEGER,
    PROCESSEDBY INTEGER,
    SUBMITDATE DATE,
    PROCESSDATE DATE
);

/*******************************************************************************
   Create Primary Key Unique Indexes
********************************************************************************/

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/

ALTER TABLE AUTH 
ADD CONSTRAINT UK_USER_NAME UNIQUE (USER_NAME);

ALTER TABLE EMPLOYEES 
ADD CONSTRAINT FK_AUTH_ID_EMP_USER_ID
FOREIGN KEY (USER_ID) REFERENCES AUTH (USER_ID);


ALTER TABLE EMPLOYEES 
ADD CONSTRAINT UK_EMAIL UNIQUE (EMAIL);

ALTER TABLE EMPLOYEES 
ADD CONSTRAINT FK_EMP_RESPORTSTO
FOREIGN KEY (REPORTSTO) REFERENCES EMPLOYEES (USER_ID);
/

ALTER TABLE INVOICES
ADD CONSTRAINT FK_USER_ID 
FOREIGN KEY (USER_ID) REFERENCES EMPLOYEES(USER_ID);

ALTER TABLE EMPLOYEES 
ADD CONSTRAINT FK_TITLE_ID 
FOREIGN KEY (TITLE_ID) REFERENCES TITLES(TITLE_ID);

CREATE SEQUENCE SQ_AUTH_PK
START WITH 11
INCREMENT BY 1; 

CREATE SEQUENCE SQ_INVOICE_PK
START WITH 11
INCREMENT BY 1; 

--conn iwp1admin/yourmom69;
CREATE OR REPLACE TRIGGER TR_INSERT_AUTH
BEFORE INSERT ON AUTH
FOR EACH ROW
BEGIN
    SELECT SQ_AUTH_PK.NEXTVAL INTO :NEW.USER_ID FROM DUAL;
END;

conn iwp1admin/yourmom69;
CREATE OR REPLACE TRIGGER TR_INSERT_INVOICES
BEFORE INSERT ON INVOICES 
FOR EACH ROW
BEGIN
    SELECT SQ_INVOICE_PK.NEXTVAL INTO :NEW.INVOICE_ID FROM DUAL;
END;

conn iwp1admin/yourmom69;
INSERT INTO TITLES VALUES (1000,'New Hire');
INSERT INTO TITLES VALUES (500,'General Manager');
INSERT INTO TITLES VALUES (100,'Regional Manager');

commit;

exit;
/