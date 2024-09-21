package ar.com.quetedebo.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import ar.com.quetedebo.core.Core;
import ar.com.quetedebo.core.Debt;
import ar.com.quetedebo.core.MercadoPago;
import ar.com.quetedebo.core.Wallet;

public class GastosView extends JPanel implements Observer {
    private JLabel label;
    private JButton button;
    private Core core;
    private Integer cantidadDeudas = 0;
    private JLabel labelDeudasPendientes;

    public GastosView(Core model) {
        this.core = model;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(0));

        this.labelDeudasPendientes = new JLabel("Tenes " + this.core.getDebt().size() + " deudas pendientes");
        this.labelDeudasPendientes.setFont(new Font("Arial", Font.PLAIN, 24));
        this.labelDeudasPendientes.setPreferredSize(new Dimension(80, 40));
        this.add(labelDeudasPendientes);

        for (Debt debt : this.core.getDebt()) {
            JPanel filaPanel = new JPanel();
            filaPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

            JLabel label = new JLabel(debt.getName() + " $" + debt.getAmount().toString());
            label.setPreferredSize(new Dimension(120, 10));
            filaPanel.add(label);

            JButton botonPagar = new JButton("Pagar");
            botonPagar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    abrirNuevaVentana(debt, model);
                }
            });

            //botonPagar.setMaximumSize(botonPagar.getPreferredSize());
            filaPanel.add(botonPagar);
            filaPanel.setMaximumSize(new Dimension(500, 30));
            this.add(filaPanel);
        }

        new InputController(model, this);
        this.core.addObserver(this);
    }

    public void abrirNuevaVentana(Debt debt, Core core) {
        // Crear una nueva ventana (JFrame)
        JFrame nuevaVentana = new JFrame("Seleccionar Método de Pago");
        nuevaVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Cierra solo esta ventana

        // Configurar el tamaño de la nueva ventana
        nuevaVentana.setSize(300, 150);
        //nuevaVentana.setLayout(new BoxLayout(nuevaVentana, BoxLayout.Y_AXIS));

        // Añadir algún componente a la nueva ventana (opcional)
        JLabel etiqueta = new JLabel("Vas a pagar $" + debt.getAmount() + "\n a " + debt.getName(), JLabel.CENTER);
        nuevaVentana.add(etiqueta);

        JButton botonConfirmar = new JButton("Confirmar pago");
        botonConfirmar.setPreferredSize(new Dimension(120, 10));
        botonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Wallet wallet = new MercadoPago();
                wallet.transfer(debt.getAddress());
                core.pay(wallet, debt.getAddress());
                nuevaVentana.dispose();
            }
        });

        //botonPagar.setMaximumSize(botonPagar.getPreferredSize());
        nuevaVentana.add(botonConfirmar);

        nuevaVentana.setLocationRelativeTo(null);

        // Hacer visible la nueva ventana
        nuevaVentana.setVisible(true);
    }

    private Integer calcularDeudas(List<Debt> debts) {
        return debts.size();
    }

    public JButton getButton() {
        return button;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String) {
            this.labelDeudasPendientes.setText("Tenes " + this.core.getDebt().size() + " deudas pendientes");
            this.revalidate();
            this.repaint();
            this.setVisible(true);
        }
    }
}
