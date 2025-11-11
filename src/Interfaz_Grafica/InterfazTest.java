package Interfaz_Grafica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.prefs.Preferences;
import java.util.regex.Pattern;

public class InterfazTest extends JFrame{
    
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
    setVisible(true); 
    setLocationRelativeTo(null);
    setResizable(true);
    
    JPanel root = new JPanel(new BorderLayout());
    root.setBorder(new EmptyBorder(16,24,16,24));
    setContentPane(root);  
    JPanel norte = new JPanel(new BorderLayout());
    JLabel titulo = new JLabel("Iniciar Sesión", SwingConstants.CENTER);
    titulo.setFont(new Font("Montserrat", Font.BOLD, 30));
    titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 25f));
    norte.add(titulo, BorderLayout.CENTER);
    norte.setBorder(new EmptyBorder(16, 0, 16, 0));
    
    root.add(norte, BorderLayout.NORTH);  
    
    //root.add(crearFormularioLogin(), BorderLayout.CENTER);
    
    
    
    establecerIconoSuperiorLogin();
}
    
    private void crearFormularioLogin(){
        JPanel panelcito = new JPanel();
        
    }
    
    
    
    
    
    
    private void establecerIconoSuperiorLogin(){
        try{
            ImageIcon iconitoSuperior = new ImageIcon("RecursosPlataformaEducativa/APP_EDUCATIVA_ICO_SUPERIOR.png");           
            Image imagencita = iconitoSuperior.getImage();
            Image imagenRedimensionada = imagencita.getScaledInstance(512, 512, Image.SCALE_SMOOTH);
        setIconImage(imagenRedimensionada);
        } catch(Exception e){
            System.out.println("Error Al Cargar Icono Superior De Login " + e.getMessage());  
        }   
    }
    
    
    
    
    
    
    
     public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazTest();
            }
        });     
}
     
}
