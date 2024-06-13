package olympic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import olympic.model.JeuxOlympique;

/**
 * Launcher
 * class for terminal interface
 */
public class Launcher {
    /** private Launcher */
    private Launcher() {
    }

    /** enum user_t [admin,presentateur,organistateur] */
    enum user_t {
        /** admin */
        admin,
        /** presentateur */
        presentateur,
        /** organistateur */
        organistateur
    }

    /**
     * static void run_term()
     * entry point for term interface
     */
    public static void run_term() {
        // String newLine = System.getProperty("line.separator");
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        user_t user = null;
        datamanager.load_data("", "", "", "");

        // yes i know ugly but trust me bro
        // enum name to array
        List<String> proposition = Prettyprintlib.enumerate_m(
                Arrays.asList(user_t.values())
                        .stream().map(elem -> elem.toString())
                        .toArray(String[]::new));
        proposition.add("Q : quitter");
        while (user == null) {
            Prettyprintlib.print_header("Qui êtez-vous ?", false, proposition);
            String[] raw_in = scan.nextLine().split(" ");
            switch (raw_in[0].toLowerCase()) {
                case "a":
                case "admin":
                    user = user_t.admin;
                    break;
                case "p":
                case "presentateur":
                    user = user_t.presentateur;
                    break;
                case "o":
                case "organistateur":
                    user = user_t.organistateur;
                    break;
                case "q":
                case "quitter":
                    return;
                default:
                    System.out.println("inconnu : '" + raw_in[0].toLowerCase() + "'");
                    break;
            }
        }
        scan.close();
        /// user type selected dispatch to menu
        switch (user) {
            case admin:
                admin_menu();
                break;
            case presentateur:
                presentateur_menu();
                break;
            case organistateur:
                organistateur_menu();
                break;
            default:
                System.out.println("[ERROR] : user type unknown : '" + user + "'");
                break;
        }
        datamanager.save_data();
        Prettyprintlib.print_header("Au Revoir", false, null);
    }

    static void inspect_jo(Scanner scan, boolean admin) {
        while (true) {
            Prettyprintlib.print_header("que voulez vous faire ?", false,
                    Prettyprintlib.enumerate_m(
                            new String[] { "retour", "cree", "list", "select" }));
            switch ((scan.nextLine().split(" ")[0]).toLowerCase()) {
                case "q":
                case "quitte":
                case "retour":
                case "r":
                    return;
                case "c":
                case "cree":
                case "crée": {
                    String annee = null;
                    String lieux = null;
                    loop: while (true) {
                        Prettyprintlib.print_header("que voulez vous faire ?", false,
                                Arrays.asList("retour", (annee == null) ? "annee?" : "annee",
                                        (lieux == null) ? "lieux?" : "lieux"));
                        switch ((scan.nextLine().split(" ")[0]).toLowerCase()) {
                            case "q":
                            case "quitte":
                            case "retour":
                            case "r":
                                break loop;
                            case "a":
                            case "annee":
                            case "année":
                                annee = scan.nextLine().split(" ")[0];
                            case "l":
                            case "lieux":
                                lieux = scan.nextLine().split(" ")[0];
                        }
                    }
                    if (annee != null && lieux != null) {
                        try {
                            datamanager.create_jo(new JeuxOlympique(annee, lieux));
                        } catch (Exception e) {
                            // TODO: handle exception
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("annuler");
                    }

                }
                case "l":
                case "list":
                case "s":
                case "select":
                case "selection": {
                    List<JeuxOlympique> jos = datamanager.load_jo();
                    List<String> copy = new ArrayList<>();
                    for (JeuxOlympique jeuxOlympique : jos) {
                        copy.add(jeuxOlympique.toString());
                    }
                    List<String> tmp = Prettyprintlib.enumerate_i((String[]) copy.toArray());
                    tmp.add(0, "-1 retour");
                    Prettyprintlib.print_header("JeuxOlympique", false, tmp);
                    int index = scan.nextInt();
                    if (index == -1) {
                        System.out.println("retour");
                        break;
                    }
                    if (index < 0) {
                        System.out.println("index négatif");
                        break;
                    }
                    if (index > jos.size()) {
                        System.out.println("trop grand");
                        break;
                    }

                    //// JO selected

                    loop: while (true) {
                        Prettyprintlib.print_header("que voulez vous faire ?", false,
                                Prettyprintlib.enumerate_m(
                                        new String[] { "retour", "annee", "lieux", "sports" }));
                        switch ((scan.nextLine().split(" ")[0]).toLowerCase()) {
                        }
                    }

                }
            }
        }

    }

    static void inspect_sport(boolean admin) {

    }

    static void inspect_epreuve(boolean admin) {

    }

    static void inspect_equipe(boolean admin) {

    }

    static void inspect_athlete(boolean admin) {

    }

    static void inspect_pay(boolean admin) {

    }

    /**
     * void admin_menu
     * menu for admin panel
     * can do anything , no safegard
     */
    static void admin_menu() {
        System.out.println("admin panel");

        // String newLine = System.getProperty("line.separator");
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        loop: while (true) {
            Prettyprintlib.print_header("que voulez vous faire ?", false,
                    Prettyprintlib.enumerate_m(
                            new String[] { "quitter", "connection sql", "jo", "pays", "athlete" }));
            switch ((scan.nextLine().split(" ")[0]).toLowerCase()) {
                case "q":
                case "quitter":
                    break loop;

                case "c":
                case "connection":
                case "s":
                case "sql":
                case "connection sql": {
                    String nomServeur = "";
                    String nomBase = "";
                    String nomLogin = "";
                    String motDePasse = "";

                    System.out.println("nomServeur : ");
                    nomServeur = scan.nextLine();
                    System.out.println("nomBase : ");
                    nomBase = scan.nextLine();
                    System.out.println("nomLogin : ");
                    nomLogin = scan.nextLine();
                    System.out.println("motDePasse : ");
                    motDePasse = scan.nextLine();

                    datamanager.load_data(nomServeur, nomBase, nomLogin, motDePasse);
                }

                case "j":
                case "jo": {

                }

                case "a":
                case "athlete": {

                }

                case "p":
                case "pays": {

                }

                default:
                    System.out.println("erreur");
                    break;
            }
        }

        scan.close();

    }

    /**
     * void presentateur_menu()
     * menu for presentateur panel
     * mainly for display so idk if we won't just
     * launch the GUI for that
     */
    static void presentateur_menu() {
        System.out.println("presentateur panel");
        olympic.graphic.GUI_presentateur.GUI_presentateur.launch();
    }

    /**
     * void organistateur_menu
     * menu for organistateur
     * used for inputing values
     */
    static void organistateur_menu() {
        System.out.println("organisateur panel");
    }
}
