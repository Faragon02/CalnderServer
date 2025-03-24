# USE shcedule;
# DROP TABLE shcedule;

CREATE TABLE shcedule
(
    id BIGINT PRIMARY KEY ,
    name VARCHAR(20) NOT NULL,
    user_pw VARCHAR(20) NOT NULL,
    todo varchar(20) NOT NULL,
    ctratedAt TIMESTAMP NOT NULL,
    updatedAt TIMESTAMP NULL

);