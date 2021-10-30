package gui;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana(){
        init();
        setSize(500,500);
        setLocation(500, 200);
        setBounds(500, 200, 500, 500);
//      setLocationRelativeTo(this);
//      setResizable(false); //Establecemos si la ventana puede cambiar de tamaño
//      setMinimumSize(new Dimension(200,200)); //Estable el tamaño minimo
//        this.getContentPane().setBackground(Color.YELLOW);
    }

    private void init(){
        JPanel panel = new JPanel();
        //panel.setLayout(null);
        //panel.setBackground(Color.RED);
        this.getContentPane().add(panel);

        JLabel label = new JLabel("Hola!");
        JButton boton = new JButton("Agregar");
        boton.setBounds(100,200,30,40);
        boton.setBackground(Color.BLACK);
        label.setBounds(300,300,200,200);
        label.setForeground(Color.RED);
        label.setOpaque(true);
//        label.setBackground(Color.WHITE);
        panel.add(label);
        panel.add(boton);

    }

}
