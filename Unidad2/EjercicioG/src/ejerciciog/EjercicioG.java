package ejerciciog;

import java.awt.*;
import javax.swing.*;

public class EjercicioG extends JFrame {

    public EjercicioG() {
        setTitle("Ejercicio G: Manejo de Componentes Gráficos");
        setSize(400, 350); // Lo hice un poco más alto para quepa el label
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 1, 5, 5)); // Cambié a 8 filas para el label

        // 1. JComboBox: Selección única en lista desplegable
        String[] opciones = {"Pequeña ($50)", "Mediana ($80)", "Grande ($120)"};
        JComboBox<String> comboTamaño = new JComboBox<>(opciones);

        // 2. JCheckBox: Selección múltiple opcional
        JCheckBox chkExtra = new JCheckBox("Queso Extra (+$15)");

        // 3. JRadioButton: Selección única entre opciones excluyentes
        JRadioButton rbEfectivo = new JRadioButton("Efectivo", true);
        JRadioButton rbTarjeta = new JRadioButton("Tarjeta");
        ButtonGroup grupoPago = new ButtonGroup();
        grupoPago.add(rbEfectivo);
        grupoPago.add(rbTarjeta);

        // AGREGADO: Label para mostrar el total
        JLabel lblTotal = new JLabel("Total: $0");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
        lblTotal.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnCalcular = new JButton("Calcular Total");

        btnCalcular.addActionListener(e -> {
            int total = 0;
            if (comboTamaño.getSelectedIndex() == 0) total += 50;
            if (comboTamaño.getSelectedIndex() == 1) total += 80;
            if (comboTamaño.getSelectedIndex() == 2) total += 120;

            if (chkExtra.isSelected()) total += 15;

            String metodo = rbEfectivo.isSelected() ? "Efectivo" : "Tarjeta";
            
            // AGREGADO: Actualizar el label en lugar del JOptionPane
            lblTotal.setText("Total: $" + total + " | Método: " + metodo);
            
            //descuento
            if (rbTarjeta.isSelected()) {
            total = (int)(total * 0.95); // 5% descuento
            metodo += " -5% desc.";
}
            
            // mantener también el popup
        JOptionPane.showMessageDialog(this, "Total: $" + total + "\nMétodo: " + metodo);
        
        });

        add(new JLabel(" Seleccione Tamaño:"));
        add(comboTamaño);
        add(chkExtra);
        
        JPanel pnlPago = new JPanel();
        pnlPago.add(rbEfectivo); 
        pnlPago.add(rbTarjeta);
        add(pnlPago);
        
        add(lblTotal); // AGREGADO: Aquí se muestra el total
        add(btnCalcular);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EjercicioG());
    }
}