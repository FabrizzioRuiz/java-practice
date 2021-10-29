package patternsDesign.factoryMethod.Buttons;

public class PantallaMac extends Pantalla{
    @Override
    Button dibujar() {
         return new ButtonMac();
    }
}
