package olympic.JDBC;

import java.sql.*;
import java.util.Arrays;
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
            // e.printStackTrace();
        }
    }

    public int getIdAthleteProchain() throws SQLException {
        try {
            Statement st = laConnexion.createStatement();
            ResultSet rs2 = st.executeQuery("select max(athlete_id) from Athlete");
            rs2.next();
            return rs2.getInt(1) + 1;
        } catch (SQLException e) {
            return 0;
        }
    }

    public int getIdEpreuveProchain() throws SQLException {
        try {
            Statement st = laConnexion.createStatement();
            ResultSet rs2 = st.executeQuery("select max(epreuve_id) from Epreuve");
            rs2.next();
            return rs2.getInt(1) + 1;
        } catch (SQLException e) {
            return 0;
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
            int i = -1;
            try {

                String lineText;
                lineReader.readLine();
                while ((lineText = lineReader.readLine()) != null) {
                    String[] data = lineText.split(",");
                    i += 1;
                    System.out.println(i + " " +Arrays.asList(data));
                    // Data provided
                    String annee = data[0];
                    String lieux = data[1];
                    String nom = data[2];
                    String prenom = data[3];
                    String sexe = data[4];
                    String pays = data[5];
                    String sport = data[6];
                    String epreuve = data[7];
                    boolean collectifs = data[8].equals("true");
                    int force = Integer.parseInt(data[9]);
                    int endurance = Integer.parseInt(data[10]);
                    int agilite = Integer.parseInt(data[11]);

                    // Create SQL statements to insert data
                    String insertJO = "INSERT INTO JO (annee, lieux) VALUES (?, ?)";
                    String insertPays = "INSERT INTO Pays (nom_pays, annee) VALUES (?, ?)";
                    String insertSport = "INSERT INTO Sport (nom_sport, annee) VALUES (?, ?)";
                    String insertEpreuve = "INSERT INTO Epreuve (epreuve_id, nom_epreuve, collectifs, genre, nom_sport, annee) VALUES (?, ?, ?, ?, ?, ?)";
                    String insertAthlete = "INSERT INTO Athlete (athlete_id, nom, prenom, sexe, forceA, enduranceA, agiliteA, nom_pays, annee) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    // Assume you have some way of generating unique IDs
                    int epreuve_id = getIdEpreuveProchain();
                    int athlete_id = getIdAthleteProchain();

                    // Execute the SQL statements using prepared statements
                    try (PreparedStatement psJO = this.laConnexion.prepareStatement(insertJO);
                            PreparedStatement psPays = this.laConnexion.prepareStatement(insertPays);
                            PreparedStatement psSport = this.laConnexion.prepareStatement(insertSport);
                            PreparedStatement psEpreuve = this.laConnexion.prepareStatement(insertEpreuve);
                            PreparedStatement psAthlete = this.laConnexion.prepareStatement(insertAthlete)) {

                        // Insert into JO
                        try {
                            psJO.setInt(1, Integer.parseInt(annee));
                            psJO.setString(2, lieux);
                            psJO.executeUpdate();
                        } catch (Exception e) {
                            // e.printStackTrace();
                        }

                        try {
                            // Insert into Pays
                            psPays.setString(1, pays);
                            psPays.setInt(2, Integer.parseInt(annee));
                            psPays.executeUpdate();
                        } catch (Exception e) {
                            // e.printStackTrace();

                        }

                        try {
                            // Insert into Sport
                            psSport.setString(1, sport);
                            psSport.setInt(2, Integer.parseInt(annee));
                            psSport.executeUpdate();
                        } catch (Exception e) {
                            // e.printStackTrace();

                        }

                        try {
                            // Insert into Epreuve
                            psEpreuve.setInt(1, epreuve_id);
                            psEpreuve.setString(2, epreuve);
                            psEpreuve.setBoolean(3, collectifs);
                            psEpreuve.setString(4, sexe);
                            psEpreuve.setString(5, sport);
                            psEpreuve.setInt(6, Integer.parseInt(annee));
                            psEpreuve.executeUpdate();
                        } catch (Exception e) {
                            // e.printStackTrace();

                        }

                        try {
                            // Insert into Athlete
                            psAthlete.setInt(1, athlete_id);
                            psAthlete.setString(2, nom);
                            psAthlete.setString(3, prenom);
                            psAthlete.setString(4, sexe);
                            psAthlete.setInt(5, force);
                            psAthlete.setInt(6, endurance);
                            psAthlete.setInt(7, agilite);
                            psAthlete.setString(8, pays);
                            psAthlete.setInt(9, Integer.parseInt(annee));
                            psAthlete.executeUpdate();
                        } catch (Exception e) {
                            // e.printStackTrace();
                        }

                    } catch (SQLException e) {
                        // e.printStackTrace();
                    }

                }
            } catch (Exception e) {
                // e.printStackTrace();
            }

            try {
                statementInsertPays.close();
            } catch (Exception e) {
                // e.printStackTrace();
            }
            try {
                statementInsertSport.close();
            } catch (Exception e) {
                // e.printStackTrace();
            }
            try {
                statementInsertEquipe.close();
            } catch (Exception e) {
                // e.printStackTrace();
            }
            try {
                statementInsertAthlete.close();
            } catch (Exception e) {
                // e.printStackTrace();
            }
            try {
                lineReader.close();
            } catch (Exception e) {
                // e.printStackTrace();
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }
}
