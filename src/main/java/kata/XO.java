package kata;
import static java.lang.String.*;

public class XO {
    public static boolean getXO (String str) {
        String[] strMin = str.toLowerCase().split("");
        int contX = 0;
        int contO = 0;
        for (String s : strMin) {
            if (s.equals("x")) {
                contX++;
            }
            if (s.equals("o")) {
                contO++;
            }
        }
        return contX==contO;
    }
}
