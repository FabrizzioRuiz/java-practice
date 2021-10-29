package patternsDesign.singleton;

public class ConexionBD {

    private static ConexionBD instance;

    //1. Constructor privado
    private  ConexionBD (){
        System.out.println("Conectandose a la base de datos");
    }

    public static ConexionBD getInstance(){
        if (instance == null){
            instance = new ConexionBD();
        }
        return instance;
    }
}
