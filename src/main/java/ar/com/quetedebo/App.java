package ar.com.quetedebo;

import ar.com.quetedebo.core.Core;
import ar.com.quetedebo.core.DatabaseRepository;
import ar.com.quetedebo.core.JsonDatabaseRepository;
import ar.com.quetedebo.interfaz.GastosView;

public class App 
{
    public static void main( String[] args )
    {
        Core core = new Core();
        GastosView view = new GastosView(core);

        javax.swing.JFrame frame = new javax.swing.JFrame("Que te debo!");
        frame.setLocationRelativeTo(null);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        frame.add(view);
      
        frame.setVisible(true);
    }
}