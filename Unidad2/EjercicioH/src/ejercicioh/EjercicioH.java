package ejercicioh;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;


public class EjercicioH extends JFrame {

public EjercicioH(){

        setTitle("Ejercicio H: Control de Sistema");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        // Crear un JSlider para controlar el sistema
        JSlider slider = new JSlider(JSlider.VERTICAL, 0, 100, 50);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        
        // Crear una Barra de progreso
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(50);
        
        // Evento
        slider.addChangeListener(e -> {
            int value = slider.getValue();
            progressBar.setValue(value);
            if (value < 30) progressBar.setForeground(new Color(46, 204, 113)); // Verde
            else if (value < 70) progressBar.setForeground(new Color(241, 196, 15)); // Amarillo  
            else progressBar.setForeground(new Color(231, 76, 60)); // Rojo
        });
        
        add(new JLabel("Ajuste de Nivel:"));
        add(slider);
        add(progressBar);
        setVisible(true);
    }
        
      public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new EjercicioH());
}
}
  
     
    

