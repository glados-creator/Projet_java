package olympic;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Launcher {
    enum user_t {
        admin,
        presentateur,
        organistateur
    }

    public static void run_term() {
        String newLine = System.getProperty("line.separator");
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        user_t user = null;

        List<String> proposition = Prettyprintlib.enumerate_m(
                Arrays.asList(user_t.values())
                        .stream().map(elem -> elem.toString())
                        .toArray(String[]::new));
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
                default:
                    System.out.println("inconnu : '"+raw_in[0].toLowerCase()+"'");
                    break;
            }
        }

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

    static void admin_menu() {
        System.out.println("admin panel");
    }

    static void presentateur_menu() {
        System.out.println("presentateur panel");
    }

    static void organistateur_menu() {
        System.out.println("organisateur panel");
    }
}
