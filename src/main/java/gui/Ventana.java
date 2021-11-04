package gui;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private JPanel panel;

    public Ventana(){
        setBounds(500, 200, 500, 500);
        init();
//        setSize(500,500);
//        setLocation(500, 200);
//      setLocationRelativeTo(this); //Establecemos la pantalla en el centro
//      setResizable(false); //Establecemos si la ventana puede cambiar de tamaño
//      setMinimumSize(new Dimension(200,200)); //Estable el tamaño minimo
//        this.getContentPane().setBackground(Color.YELLOW);
    }

    private void init(){
        panel = new JPanel();
//        panel.setBackground(Color.RED);
        panel.setLayout(null);
        this.getContentPane().add(panel);
//        initLabel();
//        initButton();
//        radioButton();
//        cajasText();
//        areasText();
        listaDesplegable();
    }

    private void initLabel() {
        JLabel label = new JLabel("Hola!");
        label.setOpaque(true); //Establecemos pintar el fondo del label
        label.setBounds(100,200,80,30);
        label.setForeground(Color.RED);
//        label.setBackground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        //Font 0: normal, 1: negrita, 2: cursiva, 3:negrita y cursiva
        label.setFont(new Font("arial", Font.BOLD | Font.ITALIC,10));

        ImageIcon image = new ImageIcon("image.jpg");
        JLabel labelImage = new JLabel();
        labelImage.setBounds(10, 80, 458, 458);
        labelImage.setIcon(new ImageIcon(image.getImage().
                getScaledInstance(image.getIconWidth(), image.getIconHeight(), Image.SCALE_SMOOTH)));

        panel.add(label);
//        panel.add(labelImage);
    }

    private void initButton() {
        //Boton de text
        JButton boton = new JButton("Agregar");
        boton.setBounds(100,235,80,30);
        boton.setEnabled(true); //Establece el encendido del boton
        boton.setBackground(Color.BLACK);
        boton.setMnemonic('a'); //en mac no funciona el alt+a
        boton.setForeground(Color.RED);
        boton.setFont(new Font("cooper black", Font.BOLD, 12));
        panel.add(boton);

        //Boton de imagen
        JButton botonImg = new JButton();
        ImageIcon clickAqui = new ImageIcon("boton.png");
        botonImg.setIcon(new ImageIcon(clickAqui.getImage().getScaledInstance(botonImg.getWidth(), botonImg.getHeight(), Image.SCALE_SMOOTH)));
        botonImg.setBounds(100, 200, 100, 40);
        panel.add(botonImg);
    }

    private void radioButton() {
        JRadioButton radio = new JRadioButton("Opcion 1", true);
        radio.setBounds(100, 300, 200, 30);
        radio.setFont(new Font("arial", Font.BOLD, 20));
        radio.setEnabled(false);
        panel.add(radio);

        JRadioButton radio2 = new JRadioButton("Opcion 2");
        radio2.setBounds(100, 350, 200, 30);
        panel.add(radio2);

        JRadioButton radio3 = new JRadioButton("Opcion 3");
        radio3.setBounds(100, 400, 400200, 30);
        panel.add(radio3);

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(radio);
        btnGroup.add(radio2);
        btnGroup.add(radio3);
    }

    private void cajasText() {
        JTextField field = new JTextField("Nombre");
        field.setHorizontalAlignment(SwingConstants.CENTER);
        field.setBounds(200,200,80,30);
        panel.add(field);
    }

    private void areasText() {
        JTextArea area = new JTextArea("Soy un Text Area");
        area.setBounds(70,200,300,200);
        area.setEditable(false);
        panel.add(area);
    }

    private void listaDesplegable() {
        String[] array = {"Peru", "Brasil", "Spain", "Colombia", "Ecuador"};
        JComboBox<String> combo = new JComboBox<>(array);
        combo.setBounds(200,200,150,30);
        combo.addItem("Argentina");
        combo.setSelectedIndex(3);
        panel.add(combo);
    }

}
