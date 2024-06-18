package olympic;

import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * class CsvToDatabase
 * petite app qui va lire le csv et le mettre en sql
 */
public class CsvToDatabase {
    /** ConnexionMySQL laConnexion the conn to the DB */
    ConnexionMySQL laConnexion;

    /**
     * CsvToDatabase
     * 
     * @param laConnexion la conn to the DB
     */
    CsvToDatabase(ConnexionMySQL laConnexion) {
        this.laConnexion = laConnexion;
    }

    /**
     * main launch
     * petite app qui va lire le csv et le mettre en sql
     * 
     * @param args term args
     */
    public static void main(String[] args) {
        String csvFilePath = "./donnees.csv";
        try {
            ConnexionMySQL connexion = new ConnexionMySQL();
            connexion.connecter("localhost", "yourDatabase", "yourUsername", "yourPassword");
            CsvToDatabase csvToDatabase = new CsvToDatabase(connexion);
            csvToDatabase.insertData(csvFilePath);
            connexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * insertData
     * 
     * @param csvFilePath String path
     */
    private void insertData(String csvFilePath) {
        String sqlInsertPays = "INSERT INTO Pays (nom_pays) VALUES (?) ON DUPLICATE KEY UPDATE pays_id=LAST_INSERT_ID(pays_id)";
        String sqlInsertSport = "INSERT INTO Sport (nom_sport) VALUES (?) ON DUPLICATE KEY UPDATE sport_id=LAST_INSERT_ID(sport_id)";
        String sqlInsertEquipe = "INSERT INTO Equipe (nom_equipe, pays_id, sport_id) VALUES (?, ?, ?)";
        String sqlInsertAthlete = "INSERT INTO Athlete (nom, prenom, sexe, forceA, enduranceA, agiliteA, pays_id, sport_id, equipe_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement statementInsertPays = laConnexion.prepareStatement(sqlInsertPays);
            PreparedStatement statementInsertSport = laConnexion.prepareStatement(sqlInsertSport);
            PreparedStatement statementInsertEquipe = laConnexion.prepareStatement(sqlInsertEquipe);
            PreparedStatement statementInsertAthlete = laConnexion.prepareStatement(sqlInsertAthlete);
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));

            try {

                String lineText;
                while ((lineText = lineReader.readLine()) != null) {
                    String[] data = lineText.split(",");
                    String nom = data[0];
                    String prenom = data[1];
                    String sexe = data[2];
                    String pays = data[3];
                    String sport = data[4];
                    int force = Integer.parseInt(data[5]);
                    int endurance = Integer.parseInt(data[6]);
                    int agilite = Integer.parseInt(data[7]);

                    // Insert Pays
                    statementInsertPays.setString(1, pays);
                    statementInsertPays.executeUpdate();
                    ResultSet generatedKeys = statementInsertPays.getGeneratedKeys();
                    int paysId = generatedKeys.next() ? generatedKeys.getInt(1) : -1;

                    // Insert Sport
                    statementInsertSport.setString(1, sport);
                    statementInsertSport.executeUpdate();
                    generatedKeys = statementInsertSport.getGeneratedKeys();
                    int sportId = generatedKeys.next() ? generatedKeys.getInt(1) : -1;

                    // Insert Equipe
                    statementInsertEquipe.setString(1, nom);
                    statementInsertEquipe.setInt(2, paysId);
                    statementInsertEquipe.setInt(3, sportId);
                    statementInsertEquipe.executeUpdate();
                    generatedKeys = statementInsertEquipe.getGeneratedKeys();
                    int equipeId = generatedKeys.next() ? generatedKeys.getInt(1) : -1;

                    // Insert Athlete
                    statementInsertAthlete.setString(1, nom);
                    statementInsertAthlete.setString(2, prenom);
                    statementInsertAthlete.setString(3, sexe);
                    statementInsertAthlete.setInt(4, force);
                    statementInsertAthlete.setInt(5, endurance);
                    statementInsertAthlete.setInt(6, agilite);
                    statementInsertAthlete.setInt(7, paysId);
                    statementInsertAthlete.setInt(8, sportId);
                    statementInsertAthlete.setInt(9, equipeId);
                    statementInsertAthlete.executeUpdate();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                statementInsertPays.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
            try {
                statementInsertSport.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
            try {
                statementInsertEquipe.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
            try {
                statementInsertAthlete.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
            try {
                lineReader.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        } catch (Exception e) {
        }

    }
}
