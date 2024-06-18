package olympic;

/**
 * App
 * oui elle sert un peu a rien
 */
class App {
    /** private App */
    private App() {
    }

    /**
     * main entry point
     * switch between term and GUI
     * 
     * @param args String[] terminal launch args (not taken into account)
     */
    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        Launcher.run_term();
    }
}
