
package peopledatabase;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.sibsutis.is.construction.manager.ConstructionManager;
import org.sibsutis.is.man.Man;
import org.sibsutis.is.man.manager.ManManager;


public class PeopleDatabase
{

    private static final Logger log = Logger.getLogger(PeopleDatabase.class.getName());
    private static final String version = "0.0.4";
     
    private static ConstructionManager constructionManager;   
   
    public static void main(String[] args)
    {
        log.log(Level.INFO, "Программа БД управления персоналом , версия {"+version+"]");
        
        
        
         ManManager  manManager = new ManManager();
         Man m = manManager.createMan();
         manManager.addMan(m);
         
         
        
        log.log(Level.INFO, "Программа БД управления персоналом , версия ["+version+"] завершена");         
    }  
}
