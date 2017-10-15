
package juegovida;
import java.awt.*;
import javax.swing.JPanel;

public class Tablero extends JPanel {
 boolean [][] tablero;

public Tablero(boolean [][] Tablero_Aux){
    tablero = Tablero_Aux;
}
public void setTablero(boolean[][] newTablero){
    tablero=newTablero;
}
public void paintComponent(Graphics p){
     
super.paintComponent(p);
double ancho=(double)(this.getWidth()) / tablero[0].length;
double alto=(double)(this.getHeight()) / tablero.length;
p.setColor(Color.BLACK);
for(int filas=0;filas<tablero.length;filas++){
 for(int columnas=0;columnas<tablero[0].length;columnas++  ){
 
 if(tablero[filas][columnas]==true){
  p.fillRect((int)Math.round(columnas*ancho), (int)Math.round(filas*alto), (int)(ancho+1),(int)(alto+1));
 }
 }
}
p.setColor(Color.BLACK);
for(int i=1;i<tablero[0].length;i++){
    p.drawLine((int)Math.round(i*ancho),0,(int)Math.round(i*ancho),this.getHeight());
}
   for(int j=1;j<tablero.length;j++){
    p.drawLine(0,(int)Math.round(j*alto),this.getWidth(),(int)Math.round(j*alto));
      
            
     }
   
    
   
    
    
    
      
    }
 }
    