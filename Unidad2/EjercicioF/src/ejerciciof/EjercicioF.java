
package ejerciciof;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;

/**
 *
 * @author BICHIYAL
 */
public class EjercicioF extends JFrame {   
    public EjercicioF(){
       setTitle("EjercicioF: MouseListener");
       setSize(200,300);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
       setLocationRelativeTo(null);
       
       JTextField campo = new JTextField(20);
       JLabel contador = new JLabel("Contador: 0");
       final int LIMITE = 100; //cambio
       
         campo.addKeyListener(new KeyAdapter(){
             @Override
             public void keyReleased(KeyEvent e){
                 String texto = campo.getText(); //cambio
                 
                 if(texto.length()> LIMITE){
                     campo.setText(texto.substring(0,LIMITE));
                     contador.setText("Caracteres: " + LIMITE + "/" + LIMITE);
                     contador.setForeground(Color.red);//pone color al limite
                     campo.setBackground(new Color (225, 200, 200));//fondo rosita
                     return;
                 } //termina cambio 27,33
               int total = campo.getText().length();
               contador.setText("Caracteres: " + total + "/" + LIMITE); //cambio
                //cambios de color segun que tan cerca del limite
                 if (total == LIMITE) {
                    contador.setForeground(Color.RED);
                    campo.setBackground(new Color(255, 200, 200));
                } else if (total >= LIMITE * 0.8) {
                    contador.setForeground(Color.ORANGE);
                    campo.setBackground(Color.WHITE);
                } else {
                    contador.setForeground(Color.BLACK);
                    campo.setBackground(Color.WHITE);
                } //termina cambio de colores
             }
         });
       
       add(new JLabel("Escribe algo: "));
       add(campo);
       add(contador);
       
       
     
     
     
     
     
       
       }
          public static void main(String[] args) {
       
        new EjercicioF().setVisible(true);
    
}

    
    
}
