package patternsDesign.singleton;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            ConexionBD con = ConexionBD.getInstance();
            System.out.println("con = " + con);
        }
    }
}
