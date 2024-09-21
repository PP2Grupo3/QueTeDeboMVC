package ar.com.quetedebo.interfaz;

import javax.swing.*;

public class PagarView extends JFrame {
    public PagarView() {
        // Configuración de la ventana
        setTitle("Nueva Ventana");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Cierra solo esta ventana

        // Añadir un componente (por ejemplo, una etiqueta)
        JLabel label = new JLabel("Esta es una nueva ventana", JLabel.CENTER);
        add(label);

        // Hacer visible la ventana
        setVisible(true);
    }
}
