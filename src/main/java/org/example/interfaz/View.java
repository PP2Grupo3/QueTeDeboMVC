package org.example.interfaz;

import org.example.core.Core;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JPanel implements Observer {
    private JLabel label;
    private JButton button;
    private Core core;

    public View(Core model) {
        this.core = model;

        this.label = new JLabel("Tenes deudas");
        this.button = new JButton("Saldar deuda");

        this.add(label);
        this.add(button);

        new InputController(model, this);
        this.core.addObserver(this);
    }

    public JButton getButton() {
        return button;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String) {
            label.setText((String) arg);
        }
    }
}