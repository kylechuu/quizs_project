drop database if exists quizs_app;
create database quizs_app;

use quizs_app;

CREATE TABLE Accounts(
    UserName varchar(200) PRIMARY KEY NOT NULL,
    PassWords varchar(200) NOT NULL
	);
    
CREATE TABLE Record(
	Indexs int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    UserName varchar(200) NOT NULL,
    Questions varchar(200) NULL,
    QuestionType varchar(20) NOT NULL,
    Answers varchar(200) NOT NULL,
    PassOrNot varchar(20) NULL,
    FOREIGN KEY (UserName) REFERENCES Accounts(UserName)
	);

CREATE TABLE PythonQuestion(
    Id int PRIMARY KEY NOT NULL,
    QuestionDescription varchar(200) NOT NULL,
    A varchar(200) NULL,
    B varchar(200) NULL,
    C varchar(200) NULL,
    D varchar(200) NULL,
    Answer varchar(200) NOT NULL
	);
    
CREATE TABLE JavaQuestion(
    Id int PRIMARY KEY NOT NULL,
    QuestionDescription varchar(200) NOT NULL,
    A varchar(200) NULL,
    B varchar(200) NULL,
    C varchar(200) NULL,
    D varchar(200) NULL,
    Answer varchar(200) NOT NULL
	);

CREATE TABLE C_Question(
    Id int PRIMARY KEY NOT NULL,
    QuestionDescription varchar(200) NOT NULL,
    A varchar(200) NULL,
    B varchar(200) NULL,
    C varchar(200) NULL,
    D varchar(200) NULL,
    Answer varchar(200) NOT NULL
	);
    
CREATE TABLE FeedBack(
    FeedBackId int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    UserName varchar(200) NOT NULL,
    Message varchar(200) NULL,
    Rates int NULL
	);