
package ejercicioe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author BICHIYAL
 */
public class EjercicioE extends JFrame {
    
    public EjercicioE(){
        setTitle("EjercicioE: MouseListener");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);
        
        JLabel etiqueta = new JLabel("Pase el raton por aqui", SwingConstants.CENTER);
        etiqueta.setPreferredSize(new Dimension(200,50));
        etiqueta.setOpaque(true);
        etiqueta.setBackground(Color.MAGENTA);
        
        
        etiqueta.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseExited(MouseEvent e){
               etiqueta.setBackground(Color.RED);
            }
            
             @Override
             public void mouseEntered(MouseEvent e){
                 etiqueta.setBackground(Color.WHITE);
             }
            
        });
        
        add(etiqueta);
        
        
        
        
    }
    public static void main(String[] args) {
        new EjercicioE().setVisible(true);
    }
    
}
