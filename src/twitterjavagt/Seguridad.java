
package twitterjavagt;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import twitter4j.DirectMessage;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
/**
 *
 * @author ped90
 */
public class Seguridad {
    private ConfigurationBuilder cb;
    private Twitter twitter;
    
    /**
     * Introducir claves para que se conecte a tu cuenta de Twitter y puedas utilizar 
     * este programa sin errores.
     * Los * representan donde tienes que introducir las claves.
     */
//    public void clave(){
//            cb = new ConfigurationBuilder();
//            cb.setDebugEnabled(true)
//                    .setOAuthConsumerKey("***")
//                    .setOAuthConsumerSecret("***")
//                    .setOAuthAccessToken("***")
//                    .setOAuthAccessTokenSecret("***");
//            TwitterFactory tf = new TwitterFactory(cb.build());
//            twitter = tf.getInstance();
//    }
    /**
     * Refresca tu cuenta de Twitter y te muestra lo nuevo que hay en tu perfil y lo nuevo
     * que pusieron tus seguidores.
     */
    public void recuperacionTimeline(){
        List<Status> statuses=null;
        String mensaje="Showing home timeline. \n";
        Status aux=null;
        try {
            statuses = twitter.getHomeTimeline();
            System.out.println("Refrescar ");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":" +
                        status.getText());
            }   } catch (TwitterException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator<Status>miIterator=statuses.iterator();
        while(miIterator.hasNext()){
            aux=miIterator.next();
            mensaje+=aux.getUser().getName()+","+aux.getText()+"\n-\n";
            System.out.println(mensaje);
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
    /**
     * Poner un estado directo en tu perfil.
     * @param latestStatus 
     */
    public void publicarEstado(String latestStatus){
        List<Status> statuses=null;
        try {
            Status status = twitter.updateStatus(latestStatus);
            System.out.println("Actualizó correctamente el estado a [" + status.getText() + "].");
        } catch (TwitterException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Mandar un mensaje directo a alguien deseado a su cuenta de Twitter.
     * Tiene que seguirte la persona y tu seguirla a ella si queréis comunicaros
     */
    public void mandarMensaje(String destino, String mensaje){
        try {
            DirectMessage message;
            message = twitter.sendDirectMessage(destino,mensaje);
            System.out.println("Enviado: "+ message.getText() + " para @" + message.getRecipientScreenName());
        } catch (TwitterException ex) {
            Logger.getLogger(TwitterJavaGT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Realizas una busqueda por hastag o palabras y te muestra twits relacionados
     * con la palabra que escribiste.
     * @param busqueda 
     */
    public void busquedaHastag(String busqueda){
        try {
            Query query = new Query(busqueda);
            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            }   } catch (TwitterException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
