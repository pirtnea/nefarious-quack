
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Yhteys {

    //Haetaan context-xml-tiedostosta tietokannan yhteystiedot
    //HUOM! Tämä esimerkki ei toimi sellaisenaan ilman Tomcat-palvelinta!
    public static Connection muodostaYhteys() {
        try {
            InitialContext cxt = new InitialContext();
            DataSource yhteysVarasto = (DataSource) cxt.lookup("java:/comp/env/jdbc/tietokanta");
            try {
                return yhteysVarasto.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(Yhteys.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NamingException ex) {
            Logger.getLogger(Yhteys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    
}
