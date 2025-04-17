CREATE TABLE IF NOT EXISTS USERS (
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(20),
    email varchar(50),
    date_of_birth timestamp
);

CREATE TABLE IF NOT EXISTS ORDERS (
    id int AUTO_INCREMENT PRIMARY KEY,
    order_detail varchar(20),
    order_time timestamp
);

CREATE TABLE IF NOT EXISTS USER_ORDER (
    id int AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT,
    user_id VARCHAR(20) NOT NULL,
    quantity INT
);

DELETE FROM USERS;

INSERT INTO USERS (id, name, email, date_of_birth) VALUES (1, 'Ajay', 'ajay@gmail.com', PARSEDATETIME('11-09-1988 00:00:00', 'dd-MM-yyyy HH:mm:ss'));
INSERT INTO USERS (id, name, email, date_of_birth) VALUES (2, 'Vijay', 'vijay@gmail.com',PARSEDATETIME('09-10-1991 00:00:00', 'dd-MM-yyyy HH:mm:ss'));
INSERT INTO USERS (id, name, email, date_of_birth) VALUES (3, 'Prakash', 'prakash@gmail.com',PARSEDATETIME('11-05-1992 00:00:00', 'dd-MM-yyyy HH:mm:ss'));
INSERT INTO USERS (id, name, email, date_of_birth) VALUES (4, 'Sanjay', 'sanjay@gmail.com',PARSEDATETIME('12-07-1990 00:00:00', 'dd-MM-yyyy HH:mm:ss'));
INSERT INTO USERS (id, name, email, date_of_birth) VALUES (5, 'Anil', 'anil@gmail.com',PARSEDATETIME('19-10-1986 00:00:00', 'dd-MM-yyyy HH:mm:ss'));

DELETE FROM ORDERS;

INSERT INTO ORDERS (id, order_detail, order_time) VALUES (1, 'cardboard',PARSEDATETIME('09-11-2020 00:00:00','dd-MM-yyyy HH:mm:ss'));
INSERT INTO ORDERS (id, order_detail, order_time) VALUES (2, 'kitchen equipments',PARSEDATETIME('10-12-2021 00:00:00','dd-MM-yyyy HH:mm:ss'));
INSERT INTO ORDERS (id, order_detail, order_time) VALUES (3, 'bed and tables',PARSEDATETIME('10-12-2022 00:00:00','dd-MM-yyyy HH:mm:ss'));
INSERT INTO ORDERS (id, order_detail, order_time) VALUES (4, 'lawn equipments',PARSEDATETIME('05-05-2023 00:00:00','dd-MM-yyyy HH:mm:ss'));
INSERT INTO ORDERS (id, order_detail, order_time) VALUES (5, 'sports equipment',PARSEDATETIME('06-05-2023 00:00:00','dd-MM-yyyy HH:mm:ss'));

DELETE FROM USER_ORDER;

-- INSERT INTO USER_ORDER (id, order_id, user_id, quantity) VALUES (1,1, 1, 2);
INSERT INTO USER_ORDER (order_id, user_id, quantity) VALUES (1, 1, 2);
INSERT INTO USER_ORDER ( order_id, user_id, quantity) VALUES (2, 2, 5);
INSERT INTO USER_ORDER ( order_id, user_id, quantity) VALUES (3, 3, 1);
INSERT INTO USER_ORDER ( order_id, user_id, quantity) VALUES (4, 4, 3);
INSERT INTO USER_ORDER ( order_id, user_id, quantity) VALUES (5, 5, 4);

