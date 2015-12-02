package deploy;

import javax.persistence.Persistence;
import org.glassfish.jersey.servlet.internal.PersistenceUnitBinder;

/**
 * @author Kasper
 */
public class newMain {

    public static void main(String[] args) {
        Persistence.generateSchema("PU-Local", null);
    }
    
}
