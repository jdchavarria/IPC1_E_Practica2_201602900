
package juegovida;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
public class Main extends JFrame{
     static String tamano;
    private JPanel contentPane;
    private JButton cancelar;
    private JButton start;
    private JTextField contenido;
    private JLabel resena;
    public int entero;
    public Main(){
        setSize(300,200);
        setTitle("Game OF LIFE");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        
        contentPane= (JPanel) this.getContentPane();
        contentPane.setLayout(null);
        contentPane.setSize(200,400);
        contentPane.setBackground(Color.LIGHT_GRAY);
        contenido = new JTextField("");
        contenido.setSize(100,30);
        contenido.setLocation(150,50);
        contenido.setBackground(Color.red);
        contentPane.add(contenido);
        
        resena = new JLabel("Tamaño del Tablero:");
        resena.setSize(200,30);
        resena.setLocation(35,50);
        contentPane.add(resena);
        
        cancelar = new JButton("Cancelar");
        cancelar.setSize(75,30);
        cancelar.setLocation(70,100);
        contentPane.add(cancelar);
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                System.exit(0);
            }
        });
        
        start = new JButton("Start");
        start.setSize(75,30);
        start.setLocation(160,100);
        contentPane.add(start);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
               tamano = contenido.getText();
               Game_Of_Life.tamaño=tamano;
               Game_Of_Life.tamano=Integer.parseInt(Game_Of_Life.tamaño);
               new Game_Of_Life();
              
            }
        });
    }
}
