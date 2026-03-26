import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraAreas extends JFrame {
    private JComboBox<String> comboFigura;
    private JTextField txtDimension1, txtDimension2;
    private JLabel lblDimension1, lblDimension2, lblResultado;
    private JButton btnCalcular;

    public CalculadoraAreas() {
        setTitle("Calculadora de Áreas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Componentes
        comboFigura = new JComboBox<>(new String[]{"Círculo", "Rectángulo", "Triángulo"});
        txtDimension1 = new JTextField();
        txtDimension2 = new JTextField();
        lblDimension1 = new JLabel("Radio:");
        lblDimension2 = new JLabel("");
        lblResultado = new JLabel("Área: ");
        btnCalcular = new JButton("Calcular");

        // Añadir componentes
        add(new JLabel("Figura:"));
        add(comboFigura);
        add(lblDimension1);
        add(txtDimension1);
        add(lblDimension2);
        add(txtDimension2);
        add(new JLabel(""));
        add(btnCalcular);
        add(new JLabel(""));
        add(lblResultado);

        // Evento de cambio de figura
        comboFigura.addActionListener(e -> actualizarInterfaz());

        // Evento de cálculo
        btnCalcular.addActionListener(e -> calcularArea());

        actualizarInterfaz();
    }

    private void actualizarInterfaz() {
        String figura = (String) comboFigura.getSelectedItem();
        if ("Círculo".equals(figura)) {
            lblDimension1.setText("Radio:");
            lblDimension2.setText("");
            txtDimension2.setEnabled(false);
        } else {
            lblDimension1.setText("Base:");
            lblDimension2.setText("Altura:");
            txtDimension2.setEnabled(true);
        }
    }

    private void calcularArea() {
        try {
            String figura = (String) comboFigura.getSelectedItem();
            double area = 0;

            switch (figura) {
                case "Círculo":
                    double radio = Double.parseDouble(txtDimension1.getText());
                    if (radio <= 0) throw new IllegalArgumentException("El radio debe ser positivo.");
                    area = Math.PI * radio * radio;
                    break;
                case "Rectángulo":
                    double base = Double.parseDouble(txtDimension1.getText());
                    double altura = Double.parseDouble(txtDimension2.getText());
                    if (base <= 0 || altura <= 0) throw new IllegalArgumentException("Las dimensiones deben ser positivas.");
                    area = base * altura;
                    break;
                case "Triángulo":
                    base = Double.parseDouble(txtDimension1.getText());
                    altura = Double.parseDouble(txtDimension2.getText());
                    if (base <= 0 || altura <= 0) throw new IllegalArgumentException("Las dimensiones deben ser positivas.");
                    area = (base * altura) / 2;
                    break;
            }
            lblResultado.setText("Área: " + String.format("%.2f", area));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos.");
            txtDimension1.setText("");
            txtDimension2.setText("");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            txtDimension1.setText("");
            txtDimension2.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraAreas().setVisible(true);
        });
    }
}