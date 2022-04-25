DROP DATABASE IF EXISTS gameDB;

CREATE DATABASE gameDB;

USE gameDB;

CREATE TABLE games(
	gameId INT PRIMARY KEY AUTO_INCREMENT,
    answer VARCHAR(4) NOT NULL,
    inProgress BOOLEAN NOT NULL
);

CREATE TABLE rounds(
	roundId INT AUTO_INCREMENT,
    guess VARCHAR(4) NOT NULL,
    exactMatches int,
    partialMatches int,
    result VARCHAR(7) NOT NULL,
    roundTime DATETIME NOT NULL,
    gameId INT NOT NULL,
    primary key(roundId, gameId),
    FOREIGN KEY (gameId) REFERENCES games(gameId)
);