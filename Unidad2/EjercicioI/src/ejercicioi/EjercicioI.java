package ejercicioi;

import javax.swing.*;
import java.awt.*;

// Ejercicio I: Lista de Tareas.
// Demuestra el uso de JList con DefaultListModel para manipulación dinámica
// de elementos (añadir y eliminar) y el uso de JScrollPane.

public class EjercicioI extends JFrame {

    public EjercicioI() {
        setTitle("Ejercicio I: Lista de Tareas");
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // El JList necesita un "modelo" para poder añadir/quitar elementos en tiempo real
        DefaultListModel<String> modelo = new DefaultListModel<>();
        modelo.addElement("Estudiar TAP");
        modelo.addElement("Hacer commit en GitHub");
        modelo.addElement("Revisar rubricas");

        JList<String> lista = new JList<>(modelo);
        
        // La lista se tiene que envolver en un JScrollPane
        add(new JScrollPane(lista), BorderLayout.CENTER);

        JPanel pnlAcciones = new JPanel();
        JTextField txtTarea = new JTextField(12);
        JButton btnAdd = new JButton("+");
        JButton btnDel = new JButton("-");
        
        //Tooltips para mejorar la experiencia de usuario (UX)
        btnAdd.setToolTipText("Agregar tarea");
        btnDel.setToolTipText("Eliminar tarea seleccionada");
        
        //Cambio - Enter para agregar
        txtTarea.addActionListener(e -> btnAdd.doClick());
        
        // AGREGADO: Botón Borrar todo - Cambio
        JButton btnClear = new JButton("Borrar todo");


        // Acción para agregar elementos
        btnAdd.addActionListener(e -> {
            String nuevaTarea = txtTarea.getText().trim();
            if (!nuevaTarea.isEmpty()) {
                modelo.addElement(nuevaTarea);
                txtTarea.setText(""); // Limpiar campo después de agregar
                txtTarea.requestFocus();
            }
        });

        // Acción para eliminar elementos seleccionados
        btnDel.addActionListener(e -> {
            int index = lista.getSelectedIndex();
            if (index != -1) {
                modelo.remove(index);
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un elemento para borrar");
            }
        });
        // AGREGADO: Acción del botón Borrar todo
        btnClear.addActionListener(e -> {
            int confirmar = JOptionPane.showConfirmDialog(this, 
                            "¿Borrar todas las tareas?", 
                            "Confirmar", 
                            JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                modelo.clear();
            }
        });
        pnlAcciones.add(txtTarea);
        pnlAcciones.add(btnAdd);
        pnlAcciones.add(btnDel);
        pnlAcciones.add(btnClear); // AGREGADO al panel

        add(pnlAcciones, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EjercicioI().setVisible(true));
    }
}
