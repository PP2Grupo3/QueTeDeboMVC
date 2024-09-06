package org.example;

import org.example.core.Core;
import org.example.interfaz.View;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Core core = new Core();
        View view = new View(core);

        javax.swing.JFrame frame = new javax.swing.JFrame("Que te debo!");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.add(view);
        frame.pack();
        frame.setVisible(true);
    }
}
