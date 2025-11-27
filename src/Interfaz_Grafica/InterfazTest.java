package Interfaz_Grafica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import Estructuras_De_Datos.GrafoTutoria;
import Estructuras_De_Datos.Materias;
import Poo.Profesor;

public class InterfazTest extends JFrame {

    private JTextField email;
    private JPasswordField contrasenha;
    private JCheckBox mostrarPass;
    private JCheckBox recordar;
    private JButton btnIniciar;
    private JButton btnCancelar;
    private JButton btnRegistroUser;

    private GrafoTutoria grafoTutoria;
    private java.util.List<Profesor> listaProfesores;

    private final String USER_PRUEBA = "ProyectoEDA";
    private final String PASS_PRUEBA = "12345";

    public InterfazTest() {

        setTitle("Plataforma Educativa Oficial");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        // 1. Crear el Panel con el Fondo y la Lógica
        JPanel panelConFondo = crearPanelConFondo();

        // 2. Panel superior (título) - transparente
        JPanel norte = new JPanel(new BorderLayout());
        norte.setOpaque(false);
        JLabel titulo = new JLabel("Iniciar Sesión", SwingConstants.CENTER);
        titulo.setFont(new Font("Montserrat", Font.BOLD, 25));
        titulo.setForeground(Color.WHITE);
        norte.add(titulo, BorderLayout.CENTER);
        norte.setBorder(new EmptyBorder(16, 0, 16, 0));

        // 3. Agregar los paneles al panel con fondo
        panelConFondo.add(norte, BorderLayout.NORTH);
        panelConFondo.add(crearFormularioLogin(), BorderLayout.CENTER);

        // 4. Establecer el panel con fondo
        setContentPane(panelConFondo);

        establecerIconoSuperiorLogin();
        inicializarGrafoTutoria();

        setVisible(true);
    }

    // Panel de fondo con imagen
    private JPanel crearPanelConFondo() {
        try {
            ImageIcon fondo_Imagen = new ImageIcon("RecursosPlataformaEducativa/FondoLogin.png");
            Image imagenFondo = fondo_Imagen.getImage();

            JPanel panelConFondo = new JPanel(new BorderLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                }
            };
            panelConFondo.setBorder(new EmptyBorder(16, 24, 16, 24));
            return panelConFondo;

        } catch (Exception e) {
            System.out.println("Error al cargar fondo de login: " + e.getMessage());
            JPanel panelDefault = new JPanel(new BorderLayout());
            panelDefault.setBackground(new Color(52, 152, 219));
            return panelDefault;
        }
    }

    private JPanel crearFormularioLogin() {
        JPanel panelcito = new JPanel();
        panelcito.setLayout(new GridBagLayout());
        panelcito.setBorder(new EmptyBorder(20, 100, 20, 100));
        panelcito.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel lblUsuario = new JLabel("Usuario o Correo Electrónico:");
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(new Font("Montserrat", Font.BOLD, 16));
        panelcito.add(lblUsuario, gbc);

        gbc.gridy++;
        email = new JTextField(20);
        email.setPreferredSize(new Dimension(250, 35));
        panelcito.add(email, gbc);

        gbc.gridy++;
        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Montserrat", Font.BOLD, 16));
        panelcito.add(lblPassword, gbc);

        gbc.gridy++;
        contrasenha = new JPasswordField(20);
        contrasenha.setPreferredSize(new Dimension(250, 35));
        panelcito.add(contrasenha, gbc);

        gbc.gridy++;
        mostrarPass = new JCheckBox("Mostrar contraseña");
        mostrarPass.setForeground(Color.WHITE);
        mostrarPass.setOpaque(false);
        panelcito.add(mostrarPass, gbc);

        gbc.gridy++;
        recordar = new JCheckBox("Recordar Usuario");
        recordar.setForeground(Color.WHITE);
        recordar.setOpaque(false);
        panelcito.add(recordar, gbc);

        gbc.gridy++;
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.setOpaque(false);

        btnIniciar = new JButton("Iniciar App");
        btnIniciar.setPreferredSize(new Dimension(120, 35));
        btnIniciar.setOpaque(false);
        btnIniciar.setContentAreaFilled(false);
        btnIniciar.setBorderPainted(true);
        btnIniciar.setForeground(Color.WHITE);
        btnIniciar.setFocusPainted(false);
        btnIniciar.addActionListener(e -> validarLogin());

        btnCancelar = new JButton("Salir App");
        btnCancelar.setPreferredSize(new Dimension(120, 35));
        btnCancelar.addActionListener(e -> System.exit(0));
        btnCancelar.setOpaque(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setBorderPainted(true);
        btnCancelar.setForeground(Color.WHITE);

        btnRegistroUser = new JButton("Registro");
        btnRegistroUser.setPreferredSize(new Dimension(120, 35));
        btnRegistroUser.setOpaque(false);
        btnRegistroUser.setContentAreaFilled(false);
        btnRegistroUser.setBorderPainted(true);
        btnRegistroUser.setForeground(Color.WHITE);
        btnRegistroUser.addActionListener(e -> registroUsuarioNuevo());

        panelBotones.add(btnIniciar);
        panelBotones.add(btnCancelar);
        panelBotones.add(btnRegistroUser);
        panelcito.add(panelBotones, gbc);

        return panelcito;
    }

    private void registroUsuarioNuevo() {

        JDialog dialogoRegistro = new JDialog(this, "Registro De Nuevo Usuario Plataforma", true);
        dialogoRegistro.setSize(400, 600);
        dialogoRegistro.setLocationRelativeTo(this);
        dialogoRegistro.setResizable(false);

        ImageIcon fondo = new ImageIcon("RecursosPlataformaEducativa/FondoRegistro.png");
        Image img = fondo.getImage();

        JPanel panelFondo = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelFondo.setOpaque(false);
        panelFondo.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel panelRegistro = new JPanel(new GridBagLayout());
        panelRegistro.setOpaque(false);
        panelRegistro.setBorder(new EmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        Font fuenteLabel = new Font("Montserrat", Font.BOLD, 16);
        Color blanco = Color.WHITE;

        JTextField txtNombre = new JTextField(20);
        JTextField txtApellido = new JTextField(20);
        JTextField txtEmailRegistro = new JTextField(20);
        JTextField txtUsuarioRegistro = new JTextField(20);
        JPasswordField txtPassRegistro = new JPasswordField(20);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(fuenteLabel);
        lblNombre.setForeground(blanco);
        panelRegistro.add(lblNombre, gbc); gbc.gridy++;
        panelRegistro.add(txtNombre, gbc); gbc.gridy++;

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(fuenteLabel);
        lblApellido.setForeground(blanco);
        panelRegistro.add(lblApellido, gbc); gbc.gridy++;
        panelRegistro.add(txtApellido, gbc); gbc.gridy++;

        JLabel lblEmail = new JLabel("Correo Electrónico:");
        lblEmail.setFont(fuenteLabel);
        lblEmail.setForeground(blanco);
        panelRegistro.add(lblEmail, gbc); gbc.gridy++;
        panelRegistro.add(txtEmailRegistro, gbc); gbc.gridy++;

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(fuenteLabel);
        lblUsuario.setForeground(blanco);
        panelRegistro.add(lblUsuario, gbc); gbc.gridy++;
        panelRegistro.add(txtUsuarioRegistro, gbc); gbc.gridy++;

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setFont(fuenteLabel);
        lblPass.setForeground(blanco);
        panelRegistro.add(lblPass, gbc); gbc.gridy++;
        panelRegistro.add(txtPassRegistro, gbc); gbc.gridy++;

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Montserrat", Font.BOLD, 16));
        btnRegistrar.setPreferredSize(new Dimension(120, 35));
        btnRegistrar.setOpaque(false);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.setBorderPainted(true);
        btnRegistrar.setForeground(Color.WHITE);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        panelRegistro.add(btnRegistrar, gbc);

        panelFondo.add(panelRegistro, BorderLayout.CENTER);
        dialogoRegistro.setContentPane(panelFondo);
        dialogoRegistro.setVisible(true);
    }

    private void establecerIconoSuperiorLogin() {
        try {
            ImageIcon iconitoSuperior = new ImageIcon("RecursosPlataformaEducativa/APP_EDUCATIVA_ICO_SUPERIOR.png");
            Image imagencita = iconitoSuperior.getImage();
            Image imagenRedimensionada = imagencita.getScaledInstance(1024, 1024, Image.SCALE_SMOOTH);
            setIconImage(imagenRedimensionada);
        } catch (Exception e) {
            System.out.println("Error al cargar icono superior de login: " + e.getMessage());
        }
    }

    // ================== LOGIN ==================

    private void validarLogin() {
        String usuarioIngresado = email.getText().trim();
        String passIngresada = new String(contrasenha.getPassword());

        if (usuarioIngresado.equals(USER_PRUEBA) && passIngresada.equals(PASS_PRUEBA)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Acceso correcto",
                    "Bienvenido",
                    JOptionPane.INFORMATION_MESSAGE
            );

            String nombreEstudiante = JOptionPane.showInputDialog(
                    this,
                    "Ingresa tu nombre completo:",
                    "Datos del estudiante",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (nombreEstudiante == null || nombreEstudiante.trim().isEmpty()) {
                nombreEstudiante = usuarioIngresado;
            }

            mostrarBienvenidaCuestionario(nombreEstudiante);

        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Usuario o contraseña incorrectos",
                    "Error de autenticación",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // ================== BIENVENIDA ==================

    private void mostrarBienvenidaCuestionario(String nombreEstudiante) {

        JPanel panelBienvenida = new JPanel(new BorderLayout());
        panelBienvenida.setBorder(new EmptyBorder(40, 40, 40, 40));
        panelBienvenida.setOpaque(false);

        JLabel titulo = new JLabel("¡Bienvenido " + nombreEstudiante + "!", SwingConstants.CENTER);
        titulo.setFont(new Font("Montserrat", Font.BOLD, 30));
        titulo.setForeground(Color.BLACK);

        JTextArea texto = new JTextArea(
                "A continuación vas a realizar un cuestionario.\n\n" +
                "Este cuestionario evaluará algunos temas importantes.\n" +
                "Responde con calma y revisa tus respuestas antes de enviar."
        );
        texto.setFont(new Font("Montserrat", Font.PLAIN, 18));
        texto.setForeground(Color.BLACK);
        texto.setOpaque(false);
        texto.setEditable(false);
        texto.setFocusable(false);
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);

        JButton btnComenzar = new JButton("Comenzar");
        btnComenzar.setFont(new Font("Montserrat", Font.BOLD, 18));
        btnComenzar.setPreferredSize(new Dimension(220, 40));
        btnComenzar.setOpaque(false);
        btnComenzar.setContentAreaFilled(false);
        btnComenzar.setForeground(Color.BLACK);

        String nombre = nombreEstudiante;
        btnComenzar.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "Iniciando Cuestionario",
                    "Cuestionario",
                    JOptionPane.INFORMATION_MESSAGE
            );
            mostrarCuestionario(nombre);
        });

        panelBienvenida.add(titulo, BorderLayout.NORTH);
        panelBienvenida.add(texto, BorderLayout.CENTER);

        JPanel sur = new JPanel();
        sur.setOpaque(false);
        sur.add(btnComenzar);

        panelBienvenida.add(sur, BorderLayout.SOUTH);

        setContentPane(panelBienvenida);
        revalidate();
        repaint();
    }

    // ================== CUESTIONARIO ==================

    private void mostrarCuestionario(String nombreEstudiante) {

        JPanel panelCuestionario = new JPanel(new BorderLayout());
        panelCuestionario.setBorder(new EmptyBorder(20, 40, 20, 40));
        panelCuestionario.setOpaque(false);

        JLabel titulo = new JLabel("Cuestionario para " + nombreEstudiante, SwingConstants.CENTER);
        titulo.setFont(new Font("Montserrat", Font.BOLD, 24));
        titulo.setForeground(Color.BLACK);

        panelCuestionario.add(titulo, BorderLayout.NORTH);

        JPanel centro = new JPanel(new GridBagLayout());
        centro.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;

        Font fontPregunta = new Font("Montserrat", Font.BOLD, 15);
        Font fontOpcion   = new Font("Montserrat", Font.PLAIN, 14);

        // === MATEMÁTICAS ===
        JLabel mTitulo = new JLabel("=== MATEMÁTICAS ===");
        mTitulo.setFont(new Font("Montserrat", Font.BOLD, 17));
        centro.add(mTitulo, gbc);
        gbc.gridy++;

        JLabel p1 = new JLabel("1) ¿Cuál es el resultado de 3 * 4 + 2?");
        p1.setFont(fontPregunta);
        centro.add(p1, gbc);
        gbc.gridy++;
        JRadioButton p1a = new JRadioButton("12");
        JRadioButton p1b = new JRadioButton("14"); // correcta
        JRadioButton p1c = new JRadioButton("24");
        ButtonGroup g1 = new ButtonGroup();
        JRadioButton[] p1Opc = {p1a, p1b, p1c};
        for (JRadioButton rb : p1Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g1.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p2 = new JLabel("2) ¿Cuál es el resultado de 10 / 2?");
        p2.setFont(fontPregunta);
        centro.add(p2, gbc);
        gbc.gridy++;
        JRadioButton p2a = new JRadioButton("2");
        JRadioButton p2b = new JRadioButton("4");
        JRadioButton p2c = new JRadioButton("5"); // correcta
        ButtonGroup g2 = new ButtonGroup();
        JRadioButton[] p2Opc = {p2a, p2b, p2c};
        for (JRadioButton rb : p2Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g2.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p3 = new JLabel("3) ¿Cuál es el resultado de 5 + 7?");
        p3.setFont(fontPregunta);
        centro.add(p3, gbc);
        gbc.gridy++;
        JRadioButton p3a = new JRadioButton("10");
        JRadioButton p3b = new JRadioButton("11");
        JRadioButton p3c = new JRadioButton("12"); // correcta
        ButtonGroup g3 = new ButtonGroup();
        JRadioButton[] p3Opc = {p3a, p3b, p3c};
        for (JRadioButton rb : p3Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g3.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p4 = new JLabel("4) ¿Cuál es el resultado de 9 - 3?");
        p4.setFont(fontPregunta);
        centro.add(p4, gbc);
        gbc.gridy++;
        JRadioButton p4a = new JRadioButton("3");
        JRadioButton p4b = new JRadioButton("6"); // correcta
        JRadioButton p4c = new JRadioButton("9");
        ButtonGroup g4 = new ButtonGroup();
        JRadioButton[] p4Opc = {p4a, p4b, p4c};
        for (JRadioButton rb : p4Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g4.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p5 = new JLabel("5) ¿Cuál es el resultado de 2 * 5?");
        p5.setFont(fontPregunta);
        centro.add(p5, gbc);
        gbc.gridy++;
        JRadioButton p5a = new JRadioButton("10"); // correcta
        JRadioButton p5b = new JRadioButton("7");
        JRadioButton p5c = new JRadioButton("25");
        ButtonGroup g5 = new ButtonGroup();
        JRadioButton[] p5Opc = {p5a, p5b, p5c};
        for (JRadioButton rb : p5Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g5.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        // === INGLÉS ===
        JLabel iTitulo = new JLabel("=== INGLÉS ===");
        iTitulo.setFont(new Font("Montserrat", Font.BOLD, 17));
        centro.add(iTitulo, gbc);
        gbc.gridy++;

        JLabel p6 = new JLabel("6) ¿Cuál es la traducción correcta de 'book'?");
        p6.setFont(fontPregunta);
        centro.add(p6, gbc);
        gbc.gridy++;
        JRadioButton p6a = new JRadioButton("Bolsa");
        JRadioButton p6b = new JRadioButton("Libro"); // correcta
        JRadioButton p6c = new JRadioButton("Boca");
        ButtonGroup g6 = new ButtonGroup();
        JRadioButton[] p6Opc = {p6a, p6b, p6c};
        for (JRadioButton rb : p6Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g6.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p7 = new JLabel("7) ¿Cómo se dice 'perro' en inglés?");
        p7.setFont(fontPregunta);
        centro.add(p7, gbc);
        gbc.gridy++;
        JRadioButton p7a = new JRadioButton("Dog"); // correcta
        JRadioButton p7b = new JRadioButton("Cat");
        JRadioButton p7c = new JRadioButton("Cow");
        ButtonGroup g7 = new ButtonGroup();
        JRadioButton[] p7Opc = {p7a, p7b, p7c};
        for (JRadioButton rb : p7Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g7.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p8 = new JLabel("8) ¿Cuál es la traducción de 'house'?");
        p8.setFont(fontPregunta);
        centro.add(p8, gbc);
        gbc.gridy++;
        JRadioButton p8a = new JRadioButton("Casa"); // correcta
        JRadioButton p8b = new JRadioButton("Silla");
        JRadioButton p8c = new JRadioButton("Mesa");
        ButtonGroup g8 = new ButtonGroup();
        JRadioButton[] p8Opc = {p8a, p8b, p8c};
        for (JRadioButton rb : p8Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g8.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p9 = new JLabel("9) ¿Cómo se dice 'gracias' en inglés?");
        p9.setFont(fontPregunta);
        centro.add(p9, gbc);
        gbc.gridy++;
        JRadioButton p9a = new JRadioButton("Please");
        JRadioButton p9b = new JRadioButton("Thanks"); // correcta
        JRadioButton p9c = new JRadioButton("Hello");
        ButtonGroup g9 = new ButtonGroup();
        JRadioButton[] p9Opc = {p9a, p9b, p9c};
        for (JRadioButton rb : p9Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g9.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p10 = new JLabel("10) ¿Cómo se dice 'escuela' en inglés?");
        p10.setFont(fontPregunta);
        centro.add(p10, gbc);
        gbc.gridy++;
        JRadioButton p10a = new JRadioButton("School"); // correcta
        JRadioButton p10b = new JRadioButton("Street");
        JRadioButton p10c = new JRadioButton("Shop");
        ButtonGroup g10 = new ButtonGroup();
        JRadioButton[] p10Opc = {p10a, p10b, p10c};
        for (JRadioButton rb : p10Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g10.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        // === BIOLOGÍA ===
        JLabel bTitulo = new JLabel("=== BIOLOGÍA ===");
        bTitulo.setFont(new Font("Montserrat", Font.BOLD, 17));
        centro.add(bTitulo, gbc);
        gbc.gridy++;

        JLabel p11 = new JLabel("11) ¿Cuál de estos es un ser vivo?");
        p11.setFont(fontPregunta);
        centro.add(p11, gbc);
        gbc.gridy++;
        JRadioButton p11a = new JRadioButton("Una roca");
        JRadioButton p11b = new JRadioButton("Un árbol"); // correcta
        JRadioButton p11c = new JRadioButton("Un vaso");
        ButtonGroup g11 = new ButtonGroup();
        JRadioButton[] p11Opc = {p11a, p11b, p11c};
        for (JRadioButton rb : p11Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g11.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p12 = new JLabel("12) ¿Qué órgano bombea la sangre?");
        p12.setFont(fontPregunta);
        centro.add(p12, gbc);
        gbc.gridy++;
        JRadioButton p12a = new JRadioButton("El corazón"); // correcta
        JRadioButton p12b = new JRadioButton("El estómago");
        JRadioButton p12c = new JRadioButton("El pulmón");
        ButtonGroup g12 = new ButtonGroup();
        JRadioButton[] p12Opc = {p12a, p12b, p12c};
        for (JRadioButton rb : p12Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g12.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p13 = new JLabel("13) ¿Qué necesitan las plantas para hacer fotosíntesis?");
        p13.setFont(fontPregunta);
        centro.add(p13, gbc);
        gbc.gridy++;
        JRadioButton p13a = new JRadioButton("Luz"); // correcta
        JRadioButton p13b = new JRadioButton("Metal");
        JRadioButton p13c = new JRadioButton("Arena");
        ButtonGroup g13 = new ButtonGroup();
        JRadioButton[] p13Opc = {p13a, p13b, p13c};
        for (JRadioButton rb : p13Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g13.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p14 = new JLabel("14) ¿De qué color suele ser la sangre en el cuerpo humano?");
        p14.setFont(fontPregunta);
        centro.add(p14, gbc);
        gbc.gridy++;
        JRadioButton p14a = new JRadioButton("Roja"); // correcta
        JRadioButton p14b = new JRadioButton("Azul");
        JRadioButton p14c = new JRadioButton("Verde");
        ButtonGroup g14 = new ButtonGroup();
        JRadioButton[] p14Opc = {p14a, p14b, p14c};
        for (JRadioButton rb : p14Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g14.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p15 = new JLabel("15) ¿Cómo se llama el proceso de respirar?");
        p15.setFont(fontPregunta);
        centro.add(p15, gbc);
        gbc.gridy++;
        JRadioButton p15a = new JRadioButton("Digestión");
        JRadioButton p15b = new JRadioButton("Respiración"); // correcta
        JRadioButton p15c = new JRadioButton("Fotosíntesis");
        ButtonGroup g15 = new ButtonGroup();
        JRadioButton[] p15Opc = {p15a, p15b, p15c};
        for (JRadioButton rb : p15Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g15.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        // === SOCIALES ===
        JLabel sTitulo = new JLabel("=== SOCIALES ===");
        sTitulo.setFont(new Font("Montserrat", Font.BOLD, 17));
        centro.add(sTitulo, gbc);
        gbc.gridy++;

        JLabel p16 = new JLabel("16) ¿En qué continente se encuentra Colombia?");
        p16.setFont(fontPregunta);
        centro.add(p16, gbc);
        gbc.gridy++;
        JRadioButton p16a = new JRadioButton("Europa");
        JRadioButton p16b = new JRadioButton("Asia");
        JRadioButton p16c = new JRadioButton("América"); // correcta
        ButtonGroup g16 = new ButtonGroup();
        JRadioButton[] p16Opc = {p16a, p16b, p16c};
        for (JRadioButton rb : p16Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g16.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p17 = new JLabel("17) ¿Cómo se llama el sistema de normas de un país?");
        p17.setFont(fontPregunta);
        centro.add(p17, gbc);
        gbc.gridy++;
        JRadioButton p17a = new JRadioButton("Clima");
        JRadioButton p17b = new JRadioButton("Ley"); // correcta
        JRadioButton p17c = new JRadioButton("Geografía");
        ButtonGroup g17 = new ButtonGroup();
        JRadioButton[] p17Opc = {p17a, p17b, p17c};
        for (JRadioButton rb : p17Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g17.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p18 = new JLabel("18) ¿Cómo se llama el lugar donde vive el presidente?");
        p18.setFont(fontPregunta);
        centro.add(p18, gbc);
        gbc.gridy++;
        JRadioButton p18a = new JRadioButton("Palacio presidencial"); // correcta
        JRadioButton p18b = new JRadioButton("Biblioteca");
        JRadioButton p18c = new JRadioButton("Museo");
        ButtonGroup g18 = new ButtonGroup();
        JRadioButton[] p18Opc = {p18a, p18b, p18c};
        for (JRadioButton rb : p18Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g18.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p19 = new JLabel("19) ¿Qué instrumento se usa para representar el mundo?");
        p19.setFont(fontPregunta);
        centro.add(p19, gbc);
        gbc.gridy++;
        JRadioButton p19a = new JRadioButton("Globo terráqueo"); // correcta
        JRadioButton p19b = new JRadioButton("Microscopio");
        JRadioButton p19c = new JRadioButton("Termómetro");
        ButtonGroup g19 = new ButtonGroup();
        JRadioButton[] p19Opc = {p19a, p19b, p19c};
        for (JRadioButton rb : p19Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g19.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p20 = new JLabel("20) ¿Cómo se llama el estudio de los países y sus características?");
        p20.setFont(fontPregunta);
        centro.add(p20, gbc);
        gbc.gridy++;
        JRadioButton p20a = new JRadioButton("Historia");
        JRadioButton p20b = new JRadioButton("Geografía"); // correcta
        JRadioButton p20c = new JRadioButton("Química");
        ButtonGroup g20 = new ButtonGroup();
        JRadioButton[] p20Opc = {p20a, p20b, p20c};
        for (JRadioButton rb : p20Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g20.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        // === LECTURA ===
        JLabel lTitulo = new JLabel("=== LECTURA ===");
        lTitulo.setFont(new Font("Montserrat", Font.BOLD, 17));
        centro.add(lTitulo, gbc);
        gbc.gridy++;

        JLabel p21 = new JLabel("21) Si el narrador dice 'yo', ¿qué tipo de narrador es?");
        p21.setFont(fontPregunta);
        centro.add(p21, gbc);
        gbc.gridy++;
        JRadioButton p21a = new JRadioButton("Primera persona"); // correcta
        JRadioButton p21b = new JRadioButton("Tercera persona");
        JRadioButton p21c = new JRadioButton("No hay narrador");
        ButtonGroup g21 = new ButtonGroup();
        JRadioButton[] p21Opc = {p21a, p21b, p21c};
        for (JRadioButton rb : p21Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g21.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p22 = new JLabel("22) ¿Cómo se llama el lugar donde ocurre la historia?");
        p22.setFont(fontPregunta);
        centro.add(p22, gbc);
        gbc.gridy++;
        JRadioButton p22a = new JRadioButton("Escenario o ambiente"); // correcta
        JRadioButton p22b = new JRadioButton("Trama");
        JRadioButton p22c = new JRadioButton("Conflicto");
        ButtonGroup g22 = new ButtonGroup();
        JRadioButton[] p22Opc = {p22a, p22b, p22c};
        for (JRadioButton rb : p22Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g22.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p23 = new JLabel("23) ¿Cómo se llama el personaje principal de una historia?");
        p23.setFont(fontPregunta);
        centro.add(p23, gbc);
        gbc.gridy++;
        JRadioButton p23a = new JRadioButton("Protagonista"); // correcta
        JRadioButton p23b = new JRadioButton("Antagonista");
        JRadioButton p23c = new JRadioButton("Narrador");
        ButtonGroup g23 = new ButtonGroup();
        JRadioButton[] p23Opc = {p23a, p23b, p23c};
        for (JRadioButton rb : p23Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g23.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p24 = new JLabel("24) ¿Cómo se llama el problema principal de una historia?");
        p24.setFont(fontPregunta);
        centro.add(p24, gbc);
        gbc.gridy++;
        JRadioButton p24a = new JRadioButton("Clímax");
        JRadioButton p24b = new JRadioButton("Conflicto"); // correcta
        JRadioButton p24c = new JRadioButton("Desenlace");
        ButtonGroup g24 = new ButtonGroup();
        JRadioButton[] p24Opc = {p24a, p24b, p24c};
        for (JRadioButton rb : p24Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g24.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JLabel p25 = new JLabel("25) ¿Cómo se llama el final de una historia?");
        p25.setFont(fontPregunta);
        centro.add(p25, gbc);
        gbc.gridy++;
        JRadioButton p25a = new JRadioButton("Introducción");
        JRadioButton p25b = new JRadioButton("Desarrollo");
        JRadioButton p25c = new JRadioButton("Desenlace"); // correcta
        ButtonGroup g25 = new ButtonGroup();
        JRadioButton[] p25Opc = {p25a, p25b, p25c};
        for (JRadioButton rb : p25Opc) {
            rb.setFont(fontOpcion);
            rb.setOpaque(false);
            g25.add(rb);
            centro.add(rb, gbc);
            gbc.gridy++;
        }

        JScrollPane scroll = new JScrollPane(centro);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);

        panelCuestionario.add(scroll, BorderLayout.CENTER);

        JButton btnEnviar = new JButton("Enviar cuestionario");
        btnEnviar.setFont(new Font("Montserrat", Font.BOLD, 18));
        btnEnviar.setPreferredSize(new Dimension(220, 40));

        btnEnviar.addActionListener(e -> {

            // Verificar que todas las preguntas fueron respondidas
            ButtonGroup[] grupos = {
                    g1,g2,g3,g4,g5,
                    g6,g7,g8,g9,g10,
                    g11,g12,g13,g14,g15,
                    g16,g17,g18,g19,g20,
                    g21,g22,g23,g24,g25
            };

            for (ButtonGroup g : grupos) {
                if (g.getSelection() == null) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Por favor responde TODAS las preguntas antes de enviar.",
                            "Cuestionario incompleto",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
            }

            // ==== Calcular nota por materia ====
            int correctMat = 0;
            if (p1b.isSelected()) correctMat++;
            if (p2c.isSelected()) correctMat++;
            if (p3c.isSelected()) correctMat++;
            if (p4b.isSelected()) correctMat++;
            if (p5a.isSelected()) correctMat++;
            int notaMat = (correctMat * 100) / 5;

            int correctIng = 0;
            if (p6b.isSelected()) correctIng++;
            if (p7a.isSelected()) correctIng++;
            if (p8a.isSelected()) correctIng++;
            if (p9b.isSelected()) correctIng++;
            if (p10a.isSelected()) correctIng++;
            int notaIng = (correctIng * 100) / 5;

            int correctBio = 0;
            if (p11b.isSelected()) correctBio++;
            if (p12a.isSelected()) correctBio++;
            if (p13a.isSelected()) correctBio++;
            if (p14a.isSelected()) correctBio++;
            if (p15b.isSelected()) correctBio++;
            int notaBio = (correctBio * 100) / 5;

            int correctSoc = 0;
            if (p16c.isSelected()) correctSoc++;
            if (p17b.isSelected()) correctSoc++;
            if (p18a.isSelected()) correctSoc++;
            if (p19a.isSelected()) correctSoc++;
            if (p20b.isSelected()) correctSoc++;
            int notaSoc = (correctSoc * 100) / 5;

            int correctLect = 0;
            if (p21a.isSelected()) correctLect++;
            if (p22a.isSelected()) correctLect++;
            if (p23a.isSelected()) correctLect++;
            if (p24b.isSelected()) correctLect++;
            if (p25c.isSelected()) correctLect++;
            int notaLect = (correctLect * 100) / 5;

            // ==== Materias ====
            Materias materias = new Materias(notaMat, notaIng, notaBio, notaSoc, notaLect);
            materias.materiasPerdidas();

            String materiaMasBajaUI = materias.getMateriaMasBaja();
            java.util.List<String> perdidas = materias.getMateriasPerdidas();

            int notaFalencia = obtenerNotaDeMateria(
                    materiaMasBajaUI,
                    notaMat, notaIng, notaBio, notaSoc, notaLect
            );

            String materiaGrafo = convertirANombreMateriaGrafo(materiaMasBajaUI);
            Profesor tutor = null;
            if (!"Ninguna".equals(materiaMasBajaUI)) {
                tutor = grafoTutoria.obtenerTutorPorMateria(materiaGrafo);
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Resultados de ").append(nombreEstudiante).append(":\n\n");
            sb.append("Matemáticas: ").append(notaMat).append("\n");
            sb.append("Inglés: ").append(notaIng).append("\n");
            sb.append("Biología: ").append(notaBio).append("\n");
            sb.append("Sociales: ").append(notaSoc).append("\n");
            sb.append("Lectura: ").append(notaLect).append("\n\n");

            if (perdidas.isEmpty()) {
                sb.append("✅ No perdiste ninguna materia.\n");
                sb.append("Según tus resultados, no necesitas tutor.\n");
            } else {
                sb.append("❌ Materias perdidas: ").append(perdidas).append("\n");
                sb.append("📉 Materia con nota más baja: ")
                  .append(materiaMasBajaUI)
                  .append(" (").append(notaFalencia).append(")\n\n");

                if (notaFalencia <= 60) {
                    sb.append("Resultado: Necesitas tutor para reforzar esa materia.\n");
                    if (tutor != null) {
                        sb.append("Tutor asignado:\n");
                        sb.append("   Profesor: ").append(tutor.getNombre())
                          .append(" (").append(tutor.getEspecialidad()).append(")\n");
                    } else {
                        sb.append("No hay tutor configurado para esa materia.\n");
                    }
                } else if (notaFalencia >= 80) {
                    sb.append("Resultado: Vas muy bien, no necesitas tutor en este momento.\n");
                } else { // 61–79
                    sb.append("Resultado: Vas bien, pero podrías beneficiarte de algunas tutorías.\n");
                    if (tutor != null) {
                        sb.append("Tutor sugerido:\n");
                        sb.append("   Profesor: ").append(tutor.getNombre())
                          .append(" (").append(tutor.getEspecialidad()).append(")\n");
                    }
                }
            }

            JOptionPane.showMessageDialog(
                    this,
                    sb.toString(),
                    "Resultados del cuestionario",
                    JOptionPane.INFORMATION_MESSAGE
            );
            String nuevoNombre = JOptionPane.showInputDialog(
                    this,
                    "¿Quién es el próximo estudiante?\n\nIngrese el nombre completo:",
                    "Nuevo estudiante",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (nuevoNombre == null || nuevoNombre.trim().isEmpty()) {
                nuevoNombre = "null";
            }

            // Volver a la pantalla de bienvenida para el nuevo estudiante
            mostrarBienvenidaCuestionario(nuevoNombre);
        });

        JPanel sur = new JPanel();
        sur.setOpaque(false);
        sur.add(btnEnviar);

        panelCuestionario.add(sur, BorderLayout.SOUTH);

        setContentPane(panelCuestionario);
        revalidate();
        repaint();
    }

    // ================== GRAFO / TUTORES ==================

    private void inicializarGrafoTutoria() {
        grafoTutoria = new GrafoTutoria();

        listaProfesores = java.util.Arrays.asList(
                new Profesor("Profe. Laura", "Lenguaje"),
                new Profesor("Profe. Miguel", "Ciencias"),
                new Profesor("Profe. Sofía", "Historia"),
                new Profesor("Profe. Gómez", "Matematicas"),
                new Profesor("Profe. María", "Ingles")
        );

        grafoTutoria.configurarProfesores(listaProfesores);
    }

    private String convertirANombreMateriaGrafo(String materiaUI) {
        if (materiaUI == null) return null;
        switch (materiaUI) {
            case "Matemáticas": return "Matematicas";
            case "Inglés":      return "Ingles";
            case "Biología":    return "Biologia";
            case "Sociales":    return "Ciencias";  // ajusta si usas otro nombre
            case "Lectura":     return "Lenguaje";
            default:            return materiaUI;
        }
    }

    private int obtenerNotaDeMateria(String materiaUI,
                                     int notaMat, int notaIng,
                                     int notaBio, int notaSoc,
                                     int notaLect) {
        if (materiaUI == null) return 0;
        switch (materiaUI) {
            case "Matemáticas": return notaMat;
            case "Inglés":      return notaIng;
            case "Biología":    return notaBio;
            case "Sociales":    return notaSoc;
            case "Lectura":     return notaLect;
            default:            return 0;
        }
    }

    // ================== MAIN ==================

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InterfazTest::new);
    }
}