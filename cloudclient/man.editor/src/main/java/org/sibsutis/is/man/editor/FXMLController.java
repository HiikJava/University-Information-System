package org.sibsutis.is.man.editor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.openide.util.Lookup;
import org.sibsutis.is.man.model.Man;
import org.sibsutis.is.man.model.ManManagerAPI;


public class FXMLController implements Initializable
{
    // лог
    private static final Logger log = Logger.getLogger(FXMLController.class.getName());
    private ManManagerAPI  ManManager;

    // Форма регистрации студента 
    @FXML
    private TextField Suname_TF;
    @FXML
    private TextField FistName_TF;
    @FXML
    private TextField MiddleName_TF;
    @FXML
    private Button Add_Person_BT;

    // Форма кароточки студента
    
      @FXML
    private  Label FistNameLabel;
      
         @FXML
    private  Label SureNameLabel;
         @FXML
    private  Label MiddleNameLabel;
         
   
    
    
    //---------------------------------------------------
    //  Таблица персон
    @FXML
    private  TableView<Man> ManTableView ;
  
    private TableColumn<Man, String> SureName;
    private TableColumn<Man, String> FistName;
    private TableColumn<Man, String> MiddleName;
    
    // Данные таблицы [ManTableView]
    private ObservableList<Man> ManTableViewData = FXCollections.observableArrayList();
    
    //---------------------------------------------------
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        log.info("----------------------------------------------------------------------");
        log.info(" Загрузка модуля {ManEditor}...");
        ConfigureModules();
        ConfigureButtons();
        ConfigureTableView();

        log.info("Загрузка модуля {ManEditor} завершена");
        log.info("----------------------------------------------------------------------");
    }

    private void ConfigureButtons()
    {
        Configure_Add_Person_BT();
    }

    
      private void ConfigureTableView()
    {
        ConfigureManTableView();
    }

    // ------------------------------------------------------------------------- 
    //                  Обаботчик событий [ManlManager]  
    // ------------------------------------------------------------------------- 
    private final PropertyChangeListener ManManagerListener = (PropertyChangeEvent evt)
    ->
    {         
       if ( evt.getPropertyName().equalsIgnoreCase(ManManagerAPI.EVENT_ADD_MAN) && evt.getNewValue() !=null)
       {
         log.log(Level.INFO, "[ManEditor] Поступило событие от  модуля {ManManager} - [addMan]");
         Man man = (Man) evt.getNewValue();
          log.log(Level.INFO, "[ManEditor] добавлен новый человек: ["+man.getFullName()+"]");
         
         this.UpdateManTableView();
       }
        
    };


    
    
    
    
    
    
    private void Configure_Add_Person_BT()
    {
        Add_Person_BT.setOnAction(
                (ActionEvent event) ->
        {   // Обработка нажатия клавиши
            log.log(Level.INFO, "[ManEditor] Нажата кнопка добавления студента {Добавить}");
            log.log(Level.INFO, "[ManEditor] Фамилия: " + this.Suname_TF.getText());
            log.log(Level.INFO, "[ManEditor] Имя: " + this.FistName_TF.getText());
            log.log(Level.INFO, "[ManEditor] Отчество: " + this.MiddleName_TF.getText());

            Man man = new Man();  // создание экземпляра класса Man
            if (!FistName_TF.getText().isEmpty()  
                    // проверка факта заполнения полей
                    && !MiddleName_TF.getText().isEmpty()
                    && !Suname_TF.getText().isEmpty())
            {
                
                // заполнение атрибутов класса Man
                man.setFistName(this.FistName_TF.getText());
                man.setMiddleName(MiddleName_TF.getText());
                man.setSureName(Suname_TF.getText());
                
                
            } else
            {
                log.log(Level.INFO, "[ManEditor] Не заполнены поля Ф.И.О. сохранение не возможно");
            }

            if (ManManager != null)
            {
                ManManager.addMan(man);
            }

        }
        );
    }

    
    private boolean  saveMan(Man man)
    {
       boolean result = false;   
       if (ManManager != null)
       {
           log.log(Level.INFO,"[ManEditor] Попытка добавления экземпляра класса {Man} выполнение {saveMan}...");
           ManManager.addMan(man);
            log.log(Level.INFO,"[ManEditor] Выполнение операции  {saveMan} завершено");
           
       }  
       
       return result;
    }      
    
     private synchronized boolean LookingForManManager()
    {
        boolean result = false;     
        log.info("[ManEditor] Поиск модуля [ManManager]...");
        ManManager = null;
        ManManager = Lookup.getDefault().lookup(ManManagerAPI.class);
        
        if (ManManager == null)
        {
            log.log(Level.WARNING,"[ManEditor] Невозможно загрузить модуль [ManManger] ");
            result = false;
        } else
        {     
            log.info("[ManEditor] Модуль [ManManager] найден успешно ");

            ManManager.addPropertyChangeListener(ManManagerListener);
         
            result =true;          
        }
        return result;
    }

    private void ConfigureModules()
    {
               LookingForManManager();
    }

    /*
    @FXML
    private  TableView<Man> ManTableView ;
  
    private TableColumn<Man, String> SureName;
    private TableColumn<Man, String> FistName;
    private TableColumn<Man, String> MiddleName;
    
    */
    
    
    private void ConfigureManTableView()
    {
         log.log(Level.INFO, "[ManEditor] конфигурирование таблицы {ManTableView}...");
        if (ManManager != null)
        {

            SureName = new TableColumn("Фамилия");
            SureName.setMinWidth(200);
            SureName.setCellValueFactory(new PropertyValueFactory<Man, String>("SureName"));
            
            FistName = new TableColumn("Имя");
            FistName.setMinWidth(100);
            FistName.setCellValueFactory(new PropertyValueFactory<Man, String>("FistName"));
            
             MiddleName = new TableColumn("Отчество");
            MiddleName.setMinWidth(200);
            MiddleName.setCellValueFactory(new PropertyValueFactory<Man, String>("MiddleName"));
            
             ManTableView.getColumns().setAll(SureName, FistName, MiddleName);

            ManTableView.setItems(ManTableViewData);
            ManTableView.refresh();
            
                     
        log.log(Level.INFO, "Настройка слушателя событий для строк таблицы {ManTableView}");        
        ManTableView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Man>ov, Man value, Man new_value) 
                ->
            {
                // Обработка события выбора пункта списка

                if (new_value != null)
                {
                    log.log(Level.INFO, "[Справочник персон] -->   ["+new_value.getFullName()+"] выбор строки");
                    
                    updateManBinding();
                    
                    /*
                    
                    if (CatalogManager.getHardwareModuleByName(new_value.getName()) != null   )
                    {
                    log.log(Level.INFO, "[Справочник аппаратных модулей ]: ["+new_value.getName()+"] - найдено значение");
                    
                    }
                    else
                    {
                    log.log(Level.WARNING, "[Справочник аппаратных модулей ]: не найдено");
                    }
                    */
                }
            } // Обработка события выбора пункта списка
            // Слушатель событий
            // Слушатель событий
            );
            
            
            
            
            
            
        }
          log.log(Level.INFO, "[ManEditor] конфигурирование таблицы {ManTableView} заврешено");
        
    }

       private  void UpdateManTableView()
      {
       
      // Обновление таблицы графического интерфейса
         log.log(Level.INFO, "[ManEditor] Обновление интерфейса таблицы [ManTableView]...");   
        
          Task task = new Task<Void>()
          {  @Override
              public Void call() throws Exception
              {           
                 Platform.runLater(new Runnable()
                      {
                          @Override 
                          public void run()
                          {  
                             // Обновление таблицы персон  
                             ManTableViewData.clear();              // очистка списка таблицы
                             ManTableView.getItems().clear();   //  очистка таблицы
                             ManTableView.refresh();                    // обновление таблицы
                             if (ManManager.getAllMan().size() > 0 )
                             {    
                                ManTableViewData.addAll(ManManager.getAllMan());
                             }
                             ManTableView.setItems(ManTableViewData);  // размещение списка людей с списке таблицы
                             ManTableView.refresh();  // обновление таблицы
                             ManTableView.getSelectionModel().selectLast();  // перемещение курсора таблицы на последюю запись
                          }
                          
                      });
                 return null;
              }
          };
          
          log.log(Level.INFO, "[ManEditor] Запуск нити обновления строк таблицы..."); 
          Thread th = new Thread(task);
          th.setDaemon(true);
          th.start();
 
          ManTableView.requestFocus();
          
          
          log.log(Level.INFO, "[ManEditor] Таблица обновлена");
          log.log(Level.INFO, "[ManEditor] Количество записей в таблице ["+ManTableViewData.size()+"]");  
          log.log(Level.INFO, "[ManEditor] Обновление интерфейса таблицы [ManEditor] завершено");
      }        

    private void updateManBinding()
    {
          if (Platform.isFxApplicationThread())
        {
            ConfigureManLabelUnbinding();
            ConfigureManLabelBinding();
        } else
        {
            Platform.runLater(() ->
            {
                 ConfigureManLabelUnbinding();
                 ConfigureManLabelBinding();
            });
        }
    }

    private void ConfigureManLabelUnbinding()
    {
        SureNameLabel.textProperty().unbind();
    }

    private void ConfigureManLabelBinding()
    {
        SureNameLabel.textProperty().bind(Bindings.createStringBinding(new Callable<String>()
        {   @Override
            public String call()
            {   Man man = ManTableView.getSelectionModel().getSelectedItem();
                if (man == null)
                {return null;
                } else {return man.getSureName(); }
            }
        },Bindings.selectString(ManTableView.getSelectionModel().selectedItemProperty(), "SureName"))); 
    }
    

    
    
    
    
}