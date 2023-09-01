package lib;
public class Utils {
    public static final String FORMAT = "%-3d %-15s %d%n";
    
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
