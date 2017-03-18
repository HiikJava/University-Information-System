
package peopledatabase;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.sibsutis.is.construction.manager.ConstructionManager;


public class PeopleDatabase
{

    private static final Logger log = Logger.getLogger(PeopleDatabase.class.getName());
    private static final String version = "0.0.4";
     
    private static ConstructionManager constructionManager;   
   
    public static void main(String[] args)
    {
        log.log(Level.INFO, "Программа БД управления персоналом , версия {"+version+"]");
        
        constructionManager = new  ConstructionManager ();
        constructionManager.start();
      
        constructionManager.stop();
        
        constructionManager.addBuilding();
        constructionManager.addBuilding();
        constructionManager.addBuilding();
        constructionManager.addBuilding();
        constructionManager.addBuilding();            
               
        log.log(Level.INFO, "База зданий содержит {"+constructionManager.getTotalBuildings()+"} зданий");
            constructionManager.removeBuilding(1);
            constructionManager.removeBuilding(4);
        log.log(Level.INFO, "База зданий содержит {"+constructionManager.getTotalBuildings()+"} зданий");
        
        log.log(Level.INFO, "Программа БД управления персоналом , версия ["+version+"] завершена");         
    }  
}
