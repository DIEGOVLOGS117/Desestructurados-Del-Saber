package Interfaz_Grafica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InterfazTest extends JFrame {

    private JTextField email;
    private JPasswordField contrasenha;
    private JCheckBox mostrarPass;
    private JCheckBox recordar;
    private JButton btnIniciar;
    private JButton btnCancelar;
    private JLabel lblEstado;
    private JProgressBar barra;

    public InterfazTest() {

        setTitle("Plataforma Educativa Oficial - Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        JPanel root = new JPanel(new BorderLayout());
        root.setBorder(new EmptyBorder(16, 24, 16, 24));
        setContentPane(root);

        // Panel superior (título)
        JPanel norte = new JPanel(new BorderLayout());
        JLabel titulo = new JLabel("Iniciar Sesión", SwingConstants.CENTER);
        titulo.setFont(new Font("Montserrat", Font.BOLD, 25));
        norte.add(titulo, BorderLayout.CENTER);
        norte.setBorder(new EmptyBorder(16, 0, 16, 0));
        root.add(norte, BorderLayout.NORTH);

        // Agregar formulario de login
        root.add(crearFormularioLogin(), BorderLayout.CENTER);

        establecerIconoSuperiorLogin();

        setVisible(true);
    }

    private JPanel crearFormularioLogin() {

        JPanel panelcito = new JPanel();
        panelcito.setLayout(new GridBagLayout());
        panelcito.setBorder(new EmptyBorder(20, 100, 20, 100));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Campo de usuario / correo electrónico
        panelcito.add(new JLabel("Usuario o Correo Electrónico:"), gbc);

        gbc.gridy++;
        email = new JTextField(20);
        panelcito.add(email, gbc);

        return panelcito;
    }

    private void establecerIconoSuperiorLogin() {
        try {
            ImageIcon iconitoSuperior = new ImageIcon("RecursosPlataformaEducativa/APP_EDUCATIVA_ICO_SUPERIOR.png");
            Image imagencita = iconitoSuperior.getImage();
            Image imagenRedimensionada = imagencita.getScaledInstance(512, 512, Image.SCALE_SMOOTH);
            setIconImage(imagenRedimensionada);
        } catch (Exception e) {
            System.out.println("Error al cargar icono superior de login: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InterfazTest::new);
    }
}
