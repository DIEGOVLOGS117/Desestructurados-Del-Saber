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
    private JButton btnRegistroUser;
    //private JLabel lblEstado;
    //private JProgressBar barra;

    public InterfazTest() {

        setTitle("Plataforma Educativa Oficial - Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        // 1. Crear el Panel con el Fondo y la Lógica
        JPanel panelConFondo = crearPanelConFondo();

        // 2. Panel superior (título) - ahora transparente
        JPanel norte = new JPanel(new BorderLayout());
        norte.setOpaque(false); // Hacer transparente
        JLabel titulo = new JLabel("Iniciar Sesión", SwingConstants.CENTER);
        titulo.setFont(new Font("Montserrat", Font.BOLD, 25));
        titulo.setForeground(Color.WHITE); // Texto blanco para contrastar
        norte.add(titulo, BorderLayout.CENTER);
        norte.setBorder(new EmptyBorder(16, 0, 16, 0));

        // 3. Agregar los paneles *al* panel con fondo
        panelConFondo.add(norte, BorderLayout.NORTH);
        panelConFondo.add(crearFormularioLogin(), BorderLayout.CENTER);

        // 4. Establecer el panel con fondo y componentes como contentPane
        setContentPane(panelConFondo);

        establecerIconoSuperiorLogin();
        setVisible(true);
        
      //  registroUsuarioNuevo();
        
}

    // Método corregido: Ahora devuelve el panel de fondo con la imagen
    private JPanel crearPanelConFondo() {
        try {
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
            return panelConFondo;

        } catch (Exception e) {
            System.out.println("Error al cargar fondo de login: " + e.getMessage());
            // En caso de error, retorna un JPanel simple con color de fondo
            JPanel panelDefault = new JPanel(new BorderLayout());
            panelDefault.setBackground(new Color(52, 152, 219));
            return panelDefault;
        }
    }

    private JPanel crearFormularioLogin() {
        // ... (El resto de este método es correcto y no necesita cambios)
        JPanel panelcito = new JPanel();
        panelcito.setLayout(new GridBagLayout());
        panelcito.setBorder(new EmptyBorder(20, 100, 20, 100));
        panelcito.setOpaque(false); 
        
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
        btnIniciar.setOpaque(false);
        btnIniciar.setContentAreaFilled(false);
        btnIniciar.setBorderPainted(true); 
        btnIniciar.setForeground(Color.WHITE); 
        btnIniciar.setFocusPainted(false);

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

    // Crear ventana de registro
    JDialog dialogoRegistro = new JDialog(this, "Registro De Nuevo Usuario Plataforma", true);
    dialogoRegistro.setSize(400, 600);
    dialogoRegistro.setLocationRelativeTo(this);
    dialogoRegistro.setResizable(false);

    // Fondo del registro
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

    // Panel con los campos del formulario
    JPanel panelRegistro = new JPanel(new GridBagLayout());
    panelRegistro.setOpaque(false); 
    panelRegistro.setBorder(new EmptyBorder(10, 10, 10, 10));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 0;

    // Fuente y color
    Font fuenteLabel = new Font("Montserrat", Font.BOLD, 16);
    Color blanco = Color.WHITE;

    // Campos
    JTextField txtNombre = new JTextField(20);
    JTextField txtApellido = new JTextField(20);
    JTextField txtEmailRegistro = new JTextField(20);
    JTextField txtUsuarioRegistro = new JTextField(20);
    JPasswordField txtPassRegistro = new JPasswordField(20);

    // Añadir al formulario (labels personalizados)
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

    // Botón registrar
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

    // Añadimos el formulario al fondo
    panelFondo.add(panelRegistro, BorderLayout.CENTER);

    // Usamos el panel con fondo
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
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this); // para que la imagen quede melo
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