package patternsDesign.factoryMethod.Buttons;

public abstract class Pantalla {

    void crearBoton() {
        Button button = dibujar();
        button.crearBoton();
    }

    abstract Button dibujar();
}
