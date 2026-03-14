
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
        panelNorte.setBackground(Color.red);
        panelNorte.add(new JLabel("Panel Norte"));
        
        JPanel panelSur=new JPanel();
        panelSur.setBackground(Color.BLUE);
        panelSur.add(new JLabel("Panel Sur"));
        
        JPanel panelCentral=new JPanel();
        panelCentral.setBackground(Color.WHITE);
        panelCentral.add(new JLabel("Panel Central"));
        
        
        add(panelNorte,BorderLayout.NORTH);
        add(panelSur,BorderLayout.SOUTH);
        add(panelCentral,BorderLayout.CENTER);
        setVisible(true);
        
    }
    
   public static void main(String[] args) {
       
       new EjercicioB(); 
       
    }
    
}
