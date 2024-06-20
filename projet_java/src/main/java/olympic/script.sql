SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS PARTICIPE_EQUIPE;
DROP TABLE IF EXISTS PARTICIPE_ATHLETE;
DROP TABLE IF EXISTS APPARTIENT;
DROP TABLE IF EXISTS Athlete;
DROP TABLE IF EXISTS Equipe;
DROP TABLE IF EXISTS Epreuve;
DROP TABLE IF EXISTS Sport;
DROP TABLE IF EXISTS Pays;
DROP TABLE IF EXISTS JO;

DROP TABLE IF EXISTS Utilisateur; 
DROP TABLE IF EXISTS Role; 

SET FOREIGN_KEY_CHECKS = 1;

-- Création des tables principales

CREATE TABLE JO (
    annee INT PRIMARY KEY,
    lieux VARCHAR(100)
);

CREATE TABLE Pays (
    nom_pays VARCHAR(100),
    annee INT,
    FOREIGN KEY (annee) REFERENCES JO(annee),
    PRIMARY KEY (nom_pays, annee)    
);

CREATE TABLE Sport (
    nom_sport VARCHAR(100),
    annee INT,
    FOREIGN KEY (annee) REFERENCES JO(annee),
    PRIMARY KEY (nom_sport, annee)    
);

CREATE TABLE Epreuve (
    epreuve_id INT PRIMARY KEY,
    nom_epreuve VARCHAR(100),
    collectifs BOOLEAN,
    genre VARCHAR(1),
    nom_sport VARCHAR(100),
    annee INT,
    FOREIGN KEY (nom_sport, annee) REFERENCES Sport(nom_sport, annee)
);

CREATE TABLE Equipe (
    equipe_id INT PRIMARY KEY,
    nom_equipe VARCHAR(100),
    nom_pays VARCHAR(100),
    annee INT,
    FOREIGN KEY (nom_pays, annee) REFERENCES Pays(nom_pays, annee)
);

CREATE TABLE Athlete (
    athlete_id INT PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    sexe VARCHAR(1),
    forceA Decimal(6.6),
    enduranceA Decimal(6.6),
    agiliteA Decimal(6.6),
    nom_pays VARCHAR(100),
    annee INT,
    FOREIGN KEY (nom_pays, annee) REFERENCES Pays(nom_pays, annee)
);

CREATE TABLE PARTICIPE_ATHLETE (
    athlete_id INT,
    epreuve_id INT,
    FOREIGN KEY (athlete_id) REFERENCES Athlete(athlete_id),
    FOREIGN KEY (epreuve_id) REFERENCES Epreuve(epreuve_id)
);

CREATE TABLE PARTICIPE_EQUIPE (
    equipe_id INT,
    epreuve_id INT,
    FOREIGN KEY (equipe_id) REFERENCES Equipe(equipe_id),
    FOREIGN KEY (epreuve_id) REFERENCES Epreuve(epreuve_id)
);

CREATE TABLE APPARTIENT (
    equipe_id INT,
    athlete_id INT,
    PRIMARY KEY (equipe_id, athlete_id),
    FOREIGN KEY (equipe_id) REFERENCES Equipe(equipe_id),
    FOREIGN KEY (athlete_id) REFERENCES Athlete(athlete_id)
);



-- Création des tables de connexion

CREATE TABLE Role (
    role_id INT PRIMARY KEY,
    nom_role VARCHAR(20)
);

CREATE TABLE Utilisateur (
    nom VARCHAR(100) PRIMARY KEY,
    password VARCHAR(100),
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES Role(role_id)
);
