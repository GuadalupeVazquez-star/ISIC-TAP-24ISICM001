
package Examen.Parcial_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger; 

// Punto 1: Refactorización de la Interfaz - Hereda de JFrame
public class VentanaInventario extends JFrame { 
    
     //Metodo constructor
    // Componentes de la UI - declarados como atributos de clase para usarlos en eventos
    private JTextField txtNombre, txtPrecio, txtCantidad;
    private JTextArea areaResultado;
    private JButton btnAgregar, btnLimpiar, btnSalir;

    public VentanaInventario() {
        // Punto 1: Título con mi nombre
        super("Gestión de Inventario - [Maria Guadalupe Vazquez Gallosso]");

        // Configuración básica del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null); // Centra la ventana

        // Punto 1: GridLayout para organizar simétrico: 5 filas, 2 columnas
        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // 1. Crear componentes
        JLabel lblNombre = new JLabel("Nombre del Producto:");
        txtNombre = new JTextField();

        JLabel lblPrecio = new JLabel("Precio:");
        txtPrecio = new JTextField();

        JLabel lblCantidad = new JLabel("Cantidad:");
        txtCantidad = new JTextField();

        btnAgregar = new JButton("Agregar");
        btnLimpiar = new JButton("Limpiar");
        btnSalir = new JButton("Salir");

        // 2. Añadir al GridLayout en orden simétrico
        panelFormulario.add(lblNombre);
        panelFormulario.add(txtNombre);
        panelFormulario.add(lblPrecio);
        panelFormulario.add(txtPrecio);
        panelFormulario.add(lblCantidad);
        panelFormulario.add(txtCantidad);
        panelFormulario.add(btnAgregar);
        panelFormulario.add(btnLimpiar);

        // El botón Salir se pone abajo, no en el grid para no romper la simetría
        JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelSur.add(btnSalir);

        // JTextArea con JScrollPane para los resultados
        areaResultado = new JTextArea(10, 40);
        areaResultado.setEditable(false); // Solo lectura
        JScrollPane scroll = new JScrollPane(areaResultado);

        //añade todo al JFrame - Jerarquía de Contenedores
        add(panelFormulario, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        // Punto 2: Gestión de Eventos con ActionListener - Modelo de Delegación
        // Cada botón tiene su listener. El JFrame delega la acción al listener.
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto(); // Lógica encapsulada en método
            }
        });

        // Punto 4: Control de Estado - Limpiar
        btnLimpiar.addActionListener(e -> limpiarCampos());

        // Punto 4: Control de Estado - Salir
        btnSalir.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    // Punto 2 y 3: Lógica de negocio + Manejo de Excepciones
    private void agregarProducto() {
        // Punto 3: try-catch para validar que precio y cantidad sean números
        try {
            String nombre = txtNombre.getText().trim();

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre del producto no puede estar vacío.",
                                              "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Si el usuario pone "abc", esto lanza NumberFormatException
            double precio = Double.parseDouble(txtPrecio.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());

            if (precio <= 0 || cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "Precio y cantidad deben ser mayores a 0.",
                                              "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Punto 2: Calcular subtotal: Total = Precio × Cantidad
            double total = precio * cantidad;

            // Punto 2: Concatenar info en JTextArea
            String resultado = String.format("Producto: %s | Precio: $%.2f | Cantidad: %d | Subtotal: $%.2f\n",
                                             nombre, precio, cantidad, total);
            areaResultado.append(resultado);

            limpiarCampos(); // Limpia después de agregar exitoso

        } catch (NumberFormatException ex) {
            // Punto 3: JOptionPane de error con mensaje descriptivo
            JOptionPane.showMessageDialog(this,
                "Error: Precio y Cantidad deben ser valores numéricos válidos.",
                "Error de Formato", JOptionPane.ERROR_MESSAGE);
            txtPrecio.requestFocus(); // Devuelve foco al campo con error
        }
    }

    // Punto 4: Método para Limpiar
    private void limpiarCampos() {
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
        txtNombre.requestFocus(); // Devuelve el foco al primer JTextField
    }

    public static void main(String[] args) {
        // Buena práctica: correr la GUI en el Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new VentanaInventario());
    }



    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
