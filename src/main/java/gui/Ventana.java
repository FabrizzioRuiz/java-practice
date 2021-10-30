package gui;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana(){
        setSize(500,500);
        setLocation(500, 200);
        setBounds(500, 200, 500, 500);
//      setLocationRelativeTo(this);
//      setResizable(false); //Establecemos si la ventana puede cambiar de tamaño
//      setMinimumSize(new Dimension(200,200)); //Estable el tamaño minimo
//        this.getContentPane().setBackground(Color.YELLOW);
        init();
    }

    private void init(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);

        JLabel label = new JLabel("Hola!");
        JButton boton = new JButton("Agregar");
        label.setBounds(100,100,200,200);
        label.setForeground(Color.RED);

        //panel.setBackground(Color.RED);
        panel.add(label);

    }

}
