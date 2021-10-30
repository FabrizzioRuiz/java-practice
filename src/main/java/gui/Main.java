package gui;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        v.setTitle("Aplicacion CoreFabri");
    }
}
