CREATE TABLE `kain-db`.MOVIES (
	ID BIGINT auto_increment NOT NULL,
	TITLE varchar(100) NOT NULL,
	GENRE varchar(100) NOT NULL,
	RELEASE_YEAR INT NOT NULL,
	RENTAL_PRICE DECIMAL NOT NULL,
	NO_OF_COPIES INT NOT NULL,
	CONSTRAINT MOVIES_PK PRIMARY KEY (ID)
)

CREATE TABLE `kain-db`.`USER` (
	ID BIGINT auto_increment NOT NULL,
	NAME varchar(100) NOT NULL,
	EMAIL_ADDRESS varchar(100) NOT NULL,
	CONSTRAINT USER_PK PRIMARY KEY (ID)
)

CREATE TABLE `kain-db`.RENTALS (
	ID BIGINT auto_increment NOT NULL,
	USER_ID BIGINT NOT NULL,
	MOVIES_ID BIGINT NOT NULL,
	RENTAL_DATE DATETIME NOT NULL,
	DUE_DATE DATETIME NOT NULL,
	CONSTRAINT RENTALS_PK PRIMARY KEY (ID),
	CONSTRAINT RENTALS_FK FOREIGN KEY (MOVIES_ID) REFERENCES `kain-db`.MOVIES(ID),
	CONSTRAINT RENTALS_FK_1 FOREIGN KEY (USER_ID) REFERENCES `kain-db`.`USER`(ID)
)