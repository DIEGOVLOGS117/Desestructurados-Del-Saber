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

        // Establecer el fondo ANTES de los otros componentes
        establecerFondoLogin();

        // Panel superior (título) - ahora transparente
        JPanel norte = new JPanel(new BorderLayout());
        norte.setOpaque(false); // Hacer transparente
        JLabel titulo = new JLabel("Iniciar Sesión", SwingConstants.CENTER);
        titulo.setFont(new Font("Montserrat", Font.BOLD, 25));
        titulo.setForeground(Color.WHITE); // Texto blanco para contrastar
        norte.add(titulo, BorderLayout.CENTER);
        norte.setBorder(new EmptyBorder(16, 0, 16, 0));
        getContentPane().add(norte, BorderLayout.NORTH);

        // Agregar formulario de login
        getContentPane().add(crearFormularioLogin(), BorderLayout.CENTER);

        establecerIconoSuperiorLogin();

        setVisible(true);
    }

    private JPanel crearFormularioLogin() {

        JPanel panelcito = new JPanel();
        panelcito.setLayout(new GridBagLayout());
        panelcito.setBorder(new EmptyBorder(20, 100, 20, 100));
        panelcito.setOpaque(false); // IMPORTANTE: Hacer transparente

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Campo de usuario / correo electrónico
        JLabel lblUsuario = new JLabel("Usuario o Correo Electrónico:");
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(new Font("Montserrat", Font.BOLD, 16));
        panelcito.add(lblUsuario, gbc);

        gbc.gridy++;
        email = new JTextField(20);
        email.setPreferredSize(new Dimension(250, 35));
        panelcito.add(email, gbc);

        // Campo de contraseña
        gbc.gridy++;
        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Montserrat", Font.BOLD, 16));
        panelcito.add(lblPassword, gbc);

        gbc.gridy++;
        contrasenha = new JPasswordField(20);
        contrasenha.setPreferredSize(new Dimension(250, 35));
        panelcito.add(contrasenha, gbc);

        // Checkbox mostrar contraseña
        gbc.gridy++;
        mostrarPass = new JCheckBox("Mostrar contraseña");
        mostrarPass.setForeground(Color.WHITE);
        mostrarPass.setOpaque(false);
        panelcito.add(mostrarPass, gbc);

        // Checkbox recordar usuario
        gbc.gridy++;
        recordar = new JCheckBox("Recordar Usuario");
        recordar.setForeground(Color.WHITE);
        recordar.setOpaque(false);
        panelcito.add(recordar, gbc);

        // Botones
        gbc.gridy++;
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.setOpaque(false);
        
        btnIniciar = new JButton("Iniciar App");
        btnIniciar.setPreferredSize(new Dimension(120, 35));
        
//        btnIniciar.setOpaque(false);
//        btnIniciar.setContentAreaFilled(false);
//        btnIniciar.setBorderPainted(false);
//        btnIniciar.setForeground(Color.WHITE);
//        btnIniciar.setFocusPainted(false); 
        
        btnCancelar = new JButton("Salir App");
        btnCancelar.setPreferredSize(new Dimension(120, 35));
        
//        btnCancelar.setOpaque(false);
//        btnCancelar.setContentAreaFilled(false);
//        btnCancelar.setBorderPainted(false);
//        btnCancelar.setForeground(Color.WHITE);
//        btnCancelar.setFocusPainted(false); 
        
        
        
        
        
        
        
        
        panelBotones.add(btnIniciar);
        panelBotones.add(btnCancelar);
        panelcito.add(panelBotones, gbc);

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
    
    public void establecerFondoLogin(){
        try{
            ImageIcon fondo_Imagen = new ImageIcon("RecursosPlataformaEducativa/FondoLogin.png");
            Image imagenFondo = fondo_Imagen.getImage();
            
            // Crear panel personalizado con fondo
            JPanel panelConFondo = new JPanel(new BorderLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Dibujar la imagen escalada para que cubra todo el panel
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                }
            };
            
            panelConFondo.setBorder(new EmptyBorder(16, 24, 16, 24));
            setContentPane(panelConFondo);
            
        } catch(Exception e){
            System.out.println("Error al cargar fondo de login: " + e.getMessage());
            // Fondo por defecto en caso de error
            getContentPane().setBackground(new Color(52, 152, 219));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InterfazTest::new);
    }
}