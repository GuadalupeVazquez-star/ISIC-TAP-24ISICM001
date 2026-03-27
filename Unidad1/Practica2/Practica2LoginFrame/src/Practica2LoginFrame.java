import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Practica2LoginFrame extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnIngresar, btnLimpiar, btnSalir;
    private JLabel lblIcono;

    public Practica2LoginFrame() {
        setTitle("Inicio de Sesión");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel principal con BorderLayout
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(panel);
        

        // Título
        JLabel lblTitulo = new JLabel("Acceso al Sistema", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(new Color(0, 108, 204));
        panel.add(lblTitulo, BorderLayout.NORTH);

        // Panel de formulario
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBackground(Color.WHITE);

        // Icono
        lblIcono = new JLabel(new ImageIcon("")); 
        formPanel.add(new JLabel(" HOLA :) 👤 "));
        formPanel.add(lblIcono);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
        txtUsuario = new JTextField();
        txtUsuario.setPreferredSize(new Dimension(200, 30));
        txtUsuario.setBorder(BorderFactory.createLineBorder(Color.RED, 2));

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        txtPassword = new JPasswordField();
        txtPassword.setPreferredSize(new Dimension(200, 30));
        txtPassword.setBorder(BorderFactory.createLineBorder(Color.RED, 2));

        formPanel.add(lblUsuario);
        formPanel.add(txtUsuario);
        formPanel.add(lblPassword);
        formPanel.add(txtPassword);
        panel.add(formPanel, BorderLayout.CENTER);

        // Panel de botones
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBackground(new Color(0, 153, 51));
        btnIngresar.setForeground(Color.BLUE);
        btnIngresar.setFont(new Font("Arial", Font.BOLD, 14));

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBackground(new Color(255, 153, 0));
        btnLimpiar.setForeground(Color.WHITE);
        btnLimpiar.setFont(new Font("Arial", Font.BOLD, 14));

        btnSalir = new JButton("Salir");
        btnSalir.setBackground(new Color(204, 0, 0));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setFont(new Font("Arial", Font.BOLD, 14));

        btnPanel.add(btnIngresar);
        btnPanel.add(btnLimpiar);
        btnPanel.add(btnSalir);
        panel.add(btnPanel, BorderLayout.SOUTH);

        // Eventos
        btnIngresar.addActionListener(e -> {
            String usuario = txtUsuario.getText().trim();
            String password = new String(txtPassword.getPassword()).trim();

            if (usuario.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if ("Maria Guadalupe".equals(usuario) && "24ISICM001".equals(password)) {
                JOptionPane.showMessageDialog(this, "ACCESO CONCEDIDO", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                btnIngresar.setBackground(Color.RED);
                btnIngresar.setForeground(Color.orange);
                btnIngresar.setFont(new Font("Arial", Font.BOLD, 20));
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnLimpiar.addActionListener(e -> {
            txtUsuario.setText("");
            txtPassword.setText("");
            txtUsuario.requestFocus();
        });

        btnSalir.addActionListener(e -> System.exit(0));

        getRootPane().setDefaultButton(btnIngresar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Practica2LoginFrame().setVisible(true));
    }
}




