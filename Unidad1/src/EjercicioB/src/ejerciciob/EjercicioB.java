
package ejerciciob;

import javax.swing.*;
import java.awt.*;


public class EjercicioB extends JFrame {
    
    public EjercicioB(){
        setTitle("MI 1ERA VENTANA");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLocationRelativeTo(null);
        
        
        setLayout(new BorderLayout());
        
        JPanel panelNorte=new JPanel();
        panelNorte.setBackground(Color.MAGENTA);
        panelNorte.add(new JLabel("PRIMER LUGAR"));
        
        JPanel panelSur=new JPanel();
        panelSur.setBackground(Color.ORANGE);
        panelSur.add(new JLabel("TERCER LUGAR"));
        
        JPanel panelCentral=new JPanel();
        panelCentral.setBackground(Color.GREEN);
        panelCentral.add(new JLabel("SEGUNDO LUGAR"));
        
        
        add(panelNorte,BorderLayout.NORTH);
        add(panelSur,BorderLayout.SOUTH);
        add(panelCentral,BorderLayout.CENTER);
        setVisible(true);
        
    }
    
   public static void main(String[] args) {
       
       new EjercicioB(); 
       
    }
    
}
