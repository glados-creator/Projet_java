package olympic;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Launcher
 * class for terminal interface
 */
public class Launcher {
    /** private Launcher */
    private Launcher(){}
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

        // yes i know ugly but trust me bro
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

        Prettyprintlib.print_header("Au Revoir", false, null);
        scan.close();
    }

    /**
     * void admin_menu
     * menu for admin panel
     * can do anything , no safegard
     */
    static void admin_menu() {
        System.out.println("admin panel");
    }

    /**
     * void presentateur_menu()
     * menu for presentateur panel
     * mainly for display so idk if we won't just
     * launch the GUI for that
     */
    static void presentateur_menu() {
        System.out.println("presentateur panel");
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
