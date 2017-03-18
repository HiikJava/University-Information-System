package org.sibsutis.is.documents;

public class Education 
{
    private String PlaceOfEducation; // Место образования
    private String TypeOfEducation; //Вид документа (аттестат/диплом)
    
    public String getPlaceOfEducation() 
    {
        return PlaceOfEducation;
    }

    public void setPlaceOfEducation(String PlaceOfEducation) 
    {
        this.PlaceOfEducation = PlaceOfEducation;
    }

    public String getTypeOfEducation() {
        return TypeOfEducation;
    }

    public void setTypeOfEducation(String TypeOfEducation) {
        this.TypeOfEducation = TypeOfEducation;
    }
 
 
}
