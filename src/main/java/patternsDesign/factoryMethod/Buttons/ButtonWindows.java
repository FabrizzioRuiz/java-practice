package patternsDesign.factoryMethod.Buttons;

import patternsDesign.factoryMethod.Buttons.Button;

public class ButtonWindows implements Button {

    @Override
    public String crearBoton() {
        return "Boton windows";
    }
}
