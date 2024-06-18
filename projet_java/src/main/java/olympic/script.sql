DROP TABLE PARTICIPE_ATHLETE;
DROP TABLE PARTICIPE_EQUIPE;
DROP TABLE Epreuve;
DROP TABLE Athlete;
DROP TABLE Equipe;
DROP TABLE Sport;
DROP TABLE Pays;


CREATE TABLE Pays (
    pays_id INT PRIMARY KEY,
    nom_pays VARCHAR(100)
);

CREATE TABLE Sport (
    sport_id INT PRIMARY KEY,
    nom_sport VARCHAR(100)
);

CREATE TABLE Epreuve (
    epreuve_id INT PRIMARY KEY,
    nom_epreuve VARCHAR(100),
    collectifs boolean;
    genre VARCHAR(20),
    sport_id INT,
    FOREIGN KEY (sport_id) REFERENCES Sport(sport_id)
);


CREATE TABLE Equipe (
    equipe_id INT PRIMARY KEY,
    nom_equipe VARCHAR(100),
    pays_id INT,
    epreuve_id INT,
    FOREIGN KEY (pays_id) REFERENCES Pays(pays_id),
    FOREIGN KEY (epreuve_id) REFERENCES Epreuve(epreuve_id)
);


CREATE TABLE Athlete (
    athlete_id INT PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    sexe VARCHAR(1),
    forceA INT,
    enduranceA INT,
    agiliteA INT,
    pays_id INT,

    FOREIGN KEY (pays_id) REFERENCES Pays(pays_id),
    FOREIGN KEY (equipe_id) REFERENCES Equipe(equipe_id)
);


CREATE TABLE PARTICIPE_ATHLETE(
    athlete_id INT,
    epreuve_id INT,
    FOREIGN KEY (athlete_id) REFERENCES Athlete(athlete_id),
    FOREIGN KEY (epreuve_id) REFERENCES Epreuve(epreuve_id)
)

CREATE TABLE PARTICIPE_EQUIPE(
    equipe_id INT,
    epreuve_id INT,
    FOREIGN KEY (equipe_id) REFERENCES Equipe(equipe_id),
    FOREIGN KEY (epreuve_id) REFERENCES Epreuve(epreuve_id)
)

CREATE TABLE APPARTIENT(
    equipe_id INT,
    athlete_id INT,
    FOREIGN KEY (equipe_id) REFERENCES Equipe(equipe_id),
    FOREIGN KEY (athlete_id) REFERENCES Athlete(athlete_id)
)



----------------------------------------------------------------

--Creation des tables de connexion

CREATE TABLE Role (
    role_id INT PRIMARY KEY,
    nom_role VARCHAR(100)
)

CREATE TABLE Utilisateur (
    utilisateur_id INT PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    password VARCHAR(100),
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES Role(role_id)
)