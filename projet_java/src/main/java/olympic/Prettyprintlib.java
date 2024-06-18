package olympic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/** class prettyprint */
public abstract class Prettyprintlib {
	/** private Prettyprintlib */
	private Prettyprintlib() {
	}
	// System.out.println("╭──────────────╮");
	// System.out.println("│ header │");
	// System.out.println("├───delimiter──┨");
	// System.out.println("│ key : option │");
	// System.out.println("╰──────────────╯");

	/**
	 * cuteighty coupe a 80-4(espaces) colonnes
	 * et pas en plien milieux de mot
	 * 
	 * @param input String
	 * @return List[String]
	 */
	public static List<String> cuteighty(String input) {
		List<String> lines = new ArrayList<>();
		int startIndex = 0;
		int endIndex = Math.min(input.length(), 76);

		while (startIndex < input.length()) {
			// Si endIndex est au milieu d'un mot, reculer jusqu'à l'espace précédent
			while (endIndex < input.length() && input.charAt(endIndex) != ' ' && endIndex > startIndex) {
				endIndex--;
			}
			lines.add(input.substring(startIndex, endIndex));
			startIndex = endIndex + 1;
			endIndex = Math.min(startIndex + 76, input.length());
		}

		return lines;
	}

	/**
	 * use to print (final)
	 * 
	 * @param header    String
	 * @param delimiter boolean
	 * @param poss      possibilities List[String]
	 */
	public static void print_header(String header, boolean delimiter, List<String> poss) {
		int col = 8;
		List<String> header_f = cuteighty(header);
		List<String> render = new ArrayList<String>();
		if (poss == null) {
			poss = new ArrayList<>();
		}
		for (String pos : poss) {
			List<String> render_f = cuteighty(pos);
			for (String rend_e : render_f) {
				render.add(rend_e);
			}
		}

		// count for max col
		for (String h_one : header_f) {
			col = Math.max(col, h_one.length());
		}
		for (String p_one : render) {
			col = Math.max(col, p_one.length());
		}

		System.out.println("╭" + "─".repeat(col + 2) + "╮");

		for (String h_one : header_f) {
			System.out.println("│ " + h_one + " ".repeat(col - h_one.length()) + " │");
		}

		if (delimiter) {
			System.out.println("├" + "─".repeat(col + 2) + "┤");
		}
		// ┼
		for (String rend_e : render) {
			System.out.println("│ " + rend_e + " ".repeat(col - rend_e.length()) + " │");
		}
		System.out.println("╰" + "─".repeat(col + 2) + "╯");
	}

	/**
	 * hash_to_str hash map key : value
	 * 
	 * @param <K> object
	 * @param <V> object
	 * @param inp HashMap
	 * @return List[String]
	 */
	public static <K, V> List<String> hash_to_str(HashMap<K, V> inp) {
		List<String> ret = new ArrayList<>();
		Set<K> keys = inp.keySet();
		keys.forEach(key -> {
			ret.add(key.toString().toUpperCase() + " : " + inp.get(key));
		});
		return ret;
	}

	/**
	 * enumerate_i -> i : [i]
	 * 
	 * @param inp  String []
	 * @param mini int
	 * @return List[String]
	 */
	public static List<String> enumerate_i(String[] inp, int mini) {
		List<String> tmp = new ArrayList<>();
		for (int i = 0; i < inp.length; i++) {
			tmp.add(String.valueOf(i + mini) + " : " + inp[i].toString());
		}
		return tmp;
	}

	/**
	 * enumerate_i
	 * 
	 * @param inp String []
	 * @return List[String]
	 */
	public static List<String> enumerate_i(String[] inp) {
		return enumerate_i(inp, 0);
	}

	/**
	 * enumerate_i
	 * 
	 * @param inp             List[String]
	 * @param delimiter_regex String
	 * @param mini            int
	 * @return List[String]
	 */
	public static List<String> enumerate_i(String inp, String delimiter_regex, int mini) {
		return enumerate_i(inp.split(delimiter_regex), mini);
	}

	/**
	 * enumerate_i
	 * 
	 * @param inp             List[String]
	 * @param delimiter_regex String
	 * @return List[String]
	 */
	public static List<String> enumerate_i(String inp, String delimiter_regex) {
		return enumerate_i(inp.split(delimiter_regex), 0);
	}

	/**
	 * enumerate_mm goto enumerate_m
	 * 
	 * @param inp  String[]
	 * @param mini int
	 * @return List[String]
	 */
	public static List<String> enumerate_mm(String[] inp, int mini) {
		List<String> tmp = new ArrayList<>();
		for (int i = 0; i < inp.length; i++) {
			tmp.add(inp[i].toUpperCase().charAt(0) + inp[i].toUpperCase().charAt(1) + " : " + inp[i].toString());
		}
		return tmp;
	}

	/**
	 * enumerate_m -> String[0].toupper() : String
	 * 
	 * @param inp  String[]
	 * @param mini int
	 * @return List[String]
	 */
	public static List<String> enumerate_m(String[] inp, int mini) {
		List<String> tmp = new ArrayList<>();
		List<String> taken = new ArrayList<>();
		boolean mm = false;
		for (int i = 0; i < inp.length; i++) {
			if (taken.contains(String.valueOf(inp[i].toUpperCase().charAt(0)))) {
				mm = true;
				break;
			}
			tmp.add(inp[i].toUpperCase().charAt(0) + " : " + inp[i]);
			taken.add(String.valueOf(inp[i].toUpperCase().charAt(0)));
		}
		if (mm)
			return enumerate_mm(inp, mini);
		return tmp;
	}

	/**
	 * enumerate_m
	 * 
	 * @param inp String[]
	 * @return List[String]
	 */
	public static List<String> enumerate_m(String[] inp) {
		return enumerate_m(inp, 0);
	}

	/**
	 * enumerate_m
	 * 
	 * @param inp             String[]
	 * @param delimiter_regex String
	 * @param mini            int
	 * @return List[String]
	 */
	public static List<String> enumerate_m(String inp, String delimiter_regex, int mini) {
		return enumerate_m(inp.split(delimiter_regex), mini);
	}

	/**
	 * enumerate_m
	 * 
	 * @param inp             String[]
	 * @param delimiter_regex String
	 * @return List[String]
	 */
	public static List<String> enumerate_m(String inp, String delimiter_regex) {
		return enumerate_m(inp.split(delimiter_regex), 0);
	}
}