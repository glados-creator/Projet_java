DROP TABLE Resultat;
DROP TABLE Epreuve;
DROP TABLE Athlete;
DROP TABLE Equipe;
DROP TABLE Sport;
DROP TABLE Pays;

 


-- Table "Pays"
CREATE TABLE Pays (
    pays_id INT PRIMARY KEY,
    nom_pays VARCHAR(100)
);

-- Table "Sport"
CREATE TABLE Sport (
    sport_id INT PRIMARY KEY,
    nom_sport VARCHAR(100)
);


-- Table "Équipe"
CREATE TABLE Equipe (
    equipe_id INT PRIMARY KEY,
    nom_equipe VARCHAR(100),
    pays_id INT,
    sport_id INT,
    FOREIGN KEY (pays_id) REFERENCES Pays(pays_id),
    FOREIGN KEY (sport_id) REFERENCES Sport(sport_id)
);

-- Table "Athlète"
CREATE TABLE Athlete (
    athlete_id INT PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    sexe VARCHAR(10),
    forceA INT,
    enduranceA INT,
    agiliteA INT,
    pays_id INT,
    sport_id INT,
    equipe_id INT,

    FOREIGN KEY (pays_id) REFERENCES Pays(pays_id),
    FOREIGN KEY (sport_id) REFERENCES Sport(sport_id),
    FOREIGN KEY (equipe_id) REFERENCES Equipe(equipe_id)
);


-- Table "Épreuve"
CREATE TABLE Epreuve (
    epreuve_id INT PRIMARY KEY,
    nom_epreuve VARCHAR(100),
    type VARCHAR(20),
    genre VARCHAR(20),
    sport_id INT,
    FOREIGN KEY (sport_id) REFERENCES Sport(sport_id)
);

-- Table "Résultat"
CREATE TABLE Resultat (
    resultat_id INT PRIMARY KEY,
    athlete_id INT,
    epreuve_id INT,
    FOREIGN KEY (athlete_id) REFERENCES Athlete(athlete_id),
    FOREIGN KEY (epreuve_id) REFERENCES Epreuve(epreuve_id)
);