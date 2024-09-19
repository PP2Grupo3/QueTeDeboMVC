package ar.com.quetedebo.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import ar.com.quetedebo.core.Core;

public class InputController implements Observer {
    private Core core;
    private GastosView view;

    public InputController(final Core core, GastosView view) {
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