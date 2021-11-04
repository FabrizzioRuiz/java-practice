package gui.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Event extends JFrame {

    JPanel panel;
    JLabel label;
    JTextField text;

    public Event() {
        setTitle("Eventos");
        setBounds(300,300,500,500);
        initComponet();
    }

    private void initComponet() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        initText();
        initBoton();
        initLabel();
    }

    private void initText() {
        text = new JTextField();
        text.setBounds(25,30,150,30);
        panel.add(text);
    }

    private void initLabel() {
        label = new JLabel();
        label.setBounds(30,90,200,30);
        panel.add(label);
    }

    private void initBoton() {
        JButton button = new JButton("Click");
        button.setBounds(20, 60, 60, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Hola "+ text.getText());
            }
        });
        panel.add(button);
    }
}
