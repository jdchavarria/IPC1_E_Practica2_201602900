
package juegovida;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.TableView;


public class Game_Of_Life implements MouseListener,ActionListener,Runnable{
 
JFrame frame=new JFrame("JUEGO_DE_LA_VIDA");
public static String tamaño;
public static int tamano;
public static int velocidad;
boolean [][] tablero=new boolean[tamano][tamano];

Tablero lamina=new Tablero(tablero);
JButton salir=new JButton("SALIR");
JButton start=new JButton("START");
JButton pausa=new JButton("PAUSA");
Container panel_abajo =new Container();
Container panel_arriba=new Container();
boolean iniciar=false;
boolean terminar=false;
JSlider slider;
public Game_Of_Life(){
    
    
   
    
    Dimension pantalla = Toolkit. getDefaultToolkit(). getScreenSize();
    int height = pantalla. height;
    int width = pantalla. width;
    frame.setSize(width/2, height/2);
    frame.setLocationRelativeTo(null);
    slider = new JSlider(0,100,0);
    velocidad=1;
    frame.setSize((tamano*20),(tamano*20));
    frame.setLayout(new BorderLayout());
    frame.add(lamina,BorderLayout.CENTER);
    
    panel_abajo.setLayout(new GridLayout(1,3));
    panel_abajo.add(salir);
    salir.addActionListener(this);
    panel_abajo.add(start);
    start.addActionListener(this);
    panel_abajo.add(pausa);
    pausa.addActionListener(this);
    panel_abajo.add(slider);
    frame.add(panel_abajo, BorderLayout.SOUTH);
    lamina.addMouseListener(this);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    frame.setVisible(true);
    slider.addChangeListener( new ChangeListener(){
      public void stateChangend( ChangeEvent e){
          //velocidad = slider.getValue();
      } 

        @Override
        public void stateChanged(ChangeEvent ce) {
           velocidad = slider.getValue();
        }
   });



} 

@Override
public void mouseClicked(MouseEvent e) {
           
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
public void mouseReleased(MouseEvent e) {

System.out.println(e.getX()+ "," + e.getY());
double ancho=(double)lamina.getWidth()/tablero[0].length;
double alto=(double)lamina.getHeight()/tablero.length;
int columna=Math.min(tablero[0].length-1,(int)(e.getX()/ancho));
int fila=Math.min(tablero.length-1,(int)(e.getY()/alto));
tablero[fila][columna] = !tablero[fila][columna];
frame.repaint();
        



        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    



 


    
  

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource().equals(salir)){
           
           //proceso();
           System.exit(0);
           
       }
       if(e.getSource().equals(start)){
           if(iniciar == false){
           iniciar=true;
           Thread t=new Thread (this);
           t.start();
              
           } 
       }
       if(e.getSource().equals(pausa)){
           iniciar=false;
       }
    }
    public void run(){
        while(iniciar == true){
              proceso();
               
     try{
               Thread.sleep(1000-10*velocidad);
     }catch(Exception ex){
         ex.printStackTrace();
         
         
     }
               
           }
    }
    
    
  
      public void proceso(){
    
    boolean [][] Tablero_Aux=new boolean [tablero.length][tablero[0].length];
    for(int x=0; x < tablero.length; x++){
     for(int y=0; y < tablero[0].length; y++){
         int contador = 0;
      if(x > 0 && y > 0 && tablero[x-1][y-1] == true){
          contador++;
         } 
      if(x > 0 && tablero[x-1][y] == true){
          contador++;
      }
      
      if(x > 0 && y < tablero[0].length-1 && tablero[x-1][y+1] == true){
          contador++;   
      }
      if(y > 0 && tablero[x][y-1] == true){
          contador++;
      }
      if(y<tablero[0].length-1 && tablero[x][y+1] == true){
          contador++;
      }
      if(x < tablero.length-1 && y>0 && tablero[x+1][y-1] == true ){
          contador++;
      }
      if(x < tablero.length-1 && tablero[x+1][y] == true){
          contador++;
      }
      if(x < tablero.length-1 && y < tablero[0].length-1 && tablero[x+1][y+1]== true ){
          contador++;
      }
      
      
     if(tablero[x][y] == true){
         if(contador == 2 || contador == 3){
           Tablero_Aux[x][y]=true;  
         }
         else{
             Tablero_Aux[x][y]=false;
         }
     
     }
     else{
         if(contador == 3){
             Tablero_Aux[x][y]=true;
         }
         else{
             Tablero_Aux[x][y]=false; 
        }
     }
     }
     }
    tablero=Tablero_Aux;
    lamina.setTablero(Tablero_Aux);
    frame.repaint();
    }

   
     //}
       public static void main(String[] args){
        Main m = new Main();
        m.show();
     

    if(tamano > 0){
         new Game_Of_Life();
    }
    else{
        
    }    
        
   }
}


