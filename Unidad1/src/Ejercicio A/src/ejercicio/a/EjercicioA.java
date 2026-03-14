
package ejercicio.a;

import javax.swing.JFrame;


public class EjercicioA extends JFrame{
    
    public EjercicioA(){
        setTitle("MI 1ERA VENTANA");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
    public static void main(String[] args) {
         
        new EjercicioA();     
    }
    
}
