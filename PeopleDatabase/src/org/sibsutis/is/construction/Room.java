
package org.sibsutis.is.construction;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Класс объекта "помещение" с полями свойств
 * @author Волужев, ЗСС 1/14
 * @version 1.0 */
public class Room {
    private String  TypeOfRoom;	    private byte NumOfSubrooms;
    private String  RoomSize;	    private List ListFurniture;
    private boolean WaterMain;	    private long PhoneLine;
    private boolean Line380v;	    private boolean Ethernet;
    private byte NumOfWindows;	    private List ListDevices;
    private long NumberOfRoom;

    /*** Создание нового экземпляра объекта типа Room с пустыми полями */
    public Room () {}
    /**
     * Создание нового экземпляра объекта типа Room
     * @param TypeOfRoom тип помещения  |аудитория|
     * @param NumberOfRoom номер помещения  |324|
     * @param NumOfSubrooms количество комнат в помещении  |2|
     * @param RoomSize размер помещения в метрах  |2x3|
     * @param NumOfWindows да, бывают помещения и без окон.
     * @param ListFurniture мебель в помещении  |парты|
     * @param ListDevices техника  |10 компьютеров|
     * @param WaterMain наличие водопровода  |false|
     * @param PhoneLine телефон.линия, при наличии указ.номер
     * @param Line380v имеется  ввод сети 380/220  |true|
     * @param Ethernet имеется подключение ЛВС  |true|
     */
    public Room (String TypeOfRoom, long NumberOfRoom, byte NumOfSubrooms,
		 String RoomSize, byte NumOfWindows, List ListFurniture,
		 List ListDevices, boolean WaterMain, long PhoneLine,
		 boolean Line380v, boolean Ethernet) {

    this.TypeOfRoom = TypeOfRoom;		this.WaterMain = WaterMain;
    this.NumOfSubrooms = NumOfSubrooms;		this.PhoneLine = PhoneLine;
    this.RoomSize = RoomSize;			this.Ethernet = Ethernet;
    this.ListFurniture = ListFurniture;		this.Line380v = Line380v;
    this.NumOfWindows = NumOfWindows;		this.ListDevices = ListDevices;
    this.NumberOfRoom = NumberOfRoom;
    log.log(Level.INFO,"[Room] Экземпляр объекта Room с заполненными полями "
			+ "успешно создан" );}
     /**
     * Метод возвращает все поля экземпляра Room
     * @param ByCategory при значении <b>true</b> поля возвращаются в виде столбцов
       "Параметр: значение", при значении <b>false</b> поля выводятся в одну строку
       с разделителем в виде запятой */
    public String getRoomInfo(boolean ByCategory) {
    String str;
    if (ByCategory==true) {
        str = "Type:  " + TypeOfRoom +"\nNumber:  " + NumberOfRoom + "\nSubrooms:  "
	    + NumOfSubrooms + "\nSize:  " + RoomSize + "\nWindows:  " + NumOfWindows
	    + "\nFurniture:  " + ListFurniture + "\nDevices:  " + ListDevices
	    + "\nWaterMain:  " + WaterMain + "\nNumber:  " + PhoneLine
	    + "Power 380V:  " + Line380v + "\nEthernet:  " + Ethernet; }
	else {
        str = "" + TypeOfRoom +"," + NumberOfRoom + "," + NumOfSubrooms + ","
		 + RoomSize + "," + NumOfWindows + "," + ListFurniture + ","
		 + ListDevices + "," + WaterMain + "," + PhoneLine + ","
		 + Line380v + "," + Ethernet; }
    log.log(Level.INFO,"[Room] Функция возврата всех параметров отработала успешно" );
return str;}

    // Ниже указаны стандартные методы Set и Get для полей

    public String getTypeOfRoom ()		{return TypeOfRoom; }
    public byte getNumOfRooms ()		{return NumOfSubrooms; }
    public String getRoomSize ()		{return RoomSize; }
    public List getListFurniture ()		{return ListFurniture; }
    public boolean getWaterMain ()		{return WaterMain; }
    public long getPhoneLine ()			{return PhoneLine;}
    public boolean getLine380v ()		{return Line380v;}
    public boolean getEthernet ()		{return Ethernet;}
    public byte getNumOfWindows ()		{return NumOfWindows;}
    public List getListDevices ()		{return ListDevices;}
    public long getNumberOfRoom()		{return NumberOfRoom;}

    public void setTypeOfRoom (String TypeOfRoom) {
	this.TypeOfRoom = TypeOfRoom; }

    public void setNumOfRooms (byte NumOfSubrooms) {
	this.NumOfSubrooms = NumOfSubrooms; }

    public void setRoomSize (String RoomSize) {
	this.RoomSize = RoomSize; }

    public  void setListFurniture (List ListFurniture) {
	this.ListFurniture = ListFurniture;  }

    public void setWaterMain (boolean WaterMain) {
	this.WaterMain = WaterMain; }

    public void setPhoneLine (long PhoneLine) {
	this.PhoneLine = PhoneLine;  }

    public void setLine380v (boolean Line380v) {
	this.Line380v = Line380v;  }

    public  void setEthernet (boolean Ethernet) {
	this.Ethernet = Ethernet; }

    public
    void setNumOfWindows (byte NumOfWindows) {
	this.NumOfWindows = NumOfWindows;  }

    public  void setListDevices (List ListDevices) {
	this.ListDevices = ListDevices;  }

    public  void setNumberOfRoom (long NumberOfRoom) {
    this.NumberOfRoom = NumberOfRoom;  }

    private static final Logger log = Logger.getLogger(Room.class.getName());
}
