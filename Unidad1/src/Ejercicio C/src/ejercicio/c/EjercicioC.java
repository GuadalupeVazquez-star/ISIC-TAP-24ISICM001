
package ejercicio.c;

import javax.swing.*;
import java.awt.*;

public class EjercicioC extends JFrame{

    public EjercicioC(){
        setTitle("Mi tercera ventana - TAP");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,2,5,5));
        for(int i=1 ; i<=6 ; i++){
            add(new JButton ("Boton" + i));
        }
        
        setVisible(true);
    }
    public static void main(String[] args) {
        new EjercicioC();
        
    }
    
}
