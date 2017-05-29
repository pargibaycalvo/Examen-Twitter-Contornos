
package twitterjavagt;

import javax.swing.JOptionPane;

/**
 *
 * @author ped90
 */
public class TwitterJavaGT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
            // TODO code application logic here  
           /**
            * Menú de opciones para el programa Twitter
            */
            int opcion;
            Seguridad twitt = new Seguridad();
            do{
            opcion= Integer.parseInt(JOptionPane.showInputDialog("1) Refrescar Twitts.\n2) Publicar Estado.\n3) Mandar Mensaje. \n4) Busqueda por Hastag. \n0) Salir del Programa."));
            switch(opcion){
            case 1:
                twitt.clave();
                twitt.recuperacionTimeline();
                break;
            case 2:
                twitt.clave();
                twitt.publicarEstado(JOptionPane.showInputDialog("Publica tu estado: "));
                break;
            case 3:
                twitt.clave();
                twitt.mandarMensaje(JOptionPane.showInputDialog("Destinatario: "),JOptionPane.showInputDialog("Publica el comentario: "));
                break;
            case 4:
                twitt.clave();
                twitt.busquedaHastag(JOptionPane.showInputDialog("Introduzca su busqueda: "));
                break;
            case 0:
                JOptionPane.showMessageDialog(null,"Pulse para salir");
                System.exit(0); 
                break;
            default:
                JOptionPane.showMessageDialog(null,"error");
        }
    }while(opcion!=0);
    }
      
                
    }
    

