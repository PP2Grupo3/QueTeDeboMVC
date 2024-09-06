package org.example.interfaz;

import org.example.core.Core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class InputController implements Observer {
    private Core core;
    private View view;

    public InputController(Core core, View view) {
        this.core = core;
        this.view = view;

        view.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                core.setData("Deuda saldada");
            }
        });

        this.core.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
       System.out.println(arg);
    }
}