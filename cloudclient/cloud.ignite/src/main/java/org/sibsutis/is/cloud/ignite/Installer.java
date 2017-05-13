/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package org.sibsutis.is.cloud.ignite;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall
{

    private static final Logger log = Logger.getLogger(Installer.class.getName());
    private static IgniteManager igniteManager;

    @Override
    public void restored()
    {
        log.log(Level.INFO, "[Ignite.installer]  Попытка создания экземпляра класса");

        igniteManager = new IgniteManager();
        igniteManager.start();

    }

    @Override
    public boolean closing()
    {
        boolean result = false;
        log.log(Level.INFO, "[Ignite.installer] Закрытие  узла [Ignite]....");

        igniteManager.stop();
        result = true;

        log.log(Level.INFO, "[Ignite.installer] Узел  [Ignite] закрыт");
        return result;
    }

}
