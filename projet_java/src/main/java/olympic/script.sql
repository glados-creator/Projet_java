DROP TABLE PARTICIPE_EQUIPE; 
DROP TABLE PARTICIPE_ATHLETE; 
DROP TABLE APPARTIENT; 
DROP TABLE Athlete; 
DROP TABLE Equipe; 
DROP TABLE Epreuve; 
DROP TABLE Sport; 
DROP TABLE Pays; 
DROP TABLE JO; 

DROP TABLE Utilisateur; 
DROP TABLE Role; 

CREATE TABLE JO (
    annee int PRIMARY KEY,
    lieux VARCHAR(100)
);

CREATE TABLE Pays (
    nom_pays VARCHAR(100),
    annee INT REFERENCES JO(annee),
    PRIMARY KEY (nom_pays, annee)
);

CREATE TABLE Sport (
    nom_sport VARCHAR(100),
    annee INT REFERENCES JO(annee),
    PRIMARY KEY (nom_sport, annee)
);

CREATE TABLE Epreuve (
    epreuve_id INT PRIMARY KEY,
    nom_epreuve VARCHAR(100),
    collectifs boolean,
    genre VARCHAR(1),
    nom_sport INT REFERENCES Sport(nom_sport),
    annee INT REFERENCES Sport(annee)
);


CREATE TABLE Equipe (
    equipe_id INT PRIMARY KEY,
    nom_equipe VARCHAR(100),
    nom_pays INT,
    annee int
);


CREATE TABLE Athlete (
    athlete_id INT PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    sexe VARCHAR(1),
    forceA INT,
    enduranceA INT,
    agiliteA INT,
    nom_pays INT,
    annnee INT
);


CREATE TABLE PARTICIPE_ATHLETE (
    PARTICIPE_ATHLETE_id INT PRIMARY KEY,
    athlete_id INT REFERENCES Athlete(athlete_id),
    epreuve_id INT REFERENCES Epreuve(epreuve_id)
);

CREATE TABLE PARTICIPE_EQUIPE (
    PARTICIPE_EQUIPE_id INT PRIMARY KEY,
    equipe_id INT REFERENCES Equipe(equipe_id),
    epreuve_id INT REFERENCES Epreuve(epreuve_id)
);

CREATE TABLE APPARTIENT (
    equipe_id INT REFERENCES Equipe(equipe_id),
    athlete_id INT REFERENCES Athlete(athlete_id)
);



----------------------------------------------------------------

--Creation des tables de connexion

CREATE TABLE Role (
    role_id INT PRIMARY KEY,
    nom_role VARCHAR(100)
);

CREATE TABLE Utilisateur (
    nom VARCHAR(100) PRIMARY KEY,
    password VARCHAR(100),
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES Role(role_id)
);
