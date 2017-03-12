/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.documents;

/**
 *
 * @author Admin
 */
public class Education {

   

    /**
     * @return the PlaceOfEducation
     */
    public String getPlaceOfEducation() {
        return PlaceOfEducation;
    }

    /**
     * @param PlaceOfEducation the PlaceOfEducation to set
     */
    public void setPlaceOfEducation(String PlaceOfEducation) {
        this.PlaceOfEducation = PlaceOfEducation;
    }

    /**
     * @return the TypeOfEducation
     */
    public String getTypeOfEducation() {
        return TypeOfEducation;
    }

    /**
     * @param TypeOfEducation the TypeOfEducation to set
     */
    public void setTypeOfEducation(String TypeOfEducation) {
        this.TypeOfEducation = TypeOfEducation;
    }
 
    private String PlaceOfEducation; // Место образования
    private String TypeOfEducation; //Вид документа (аттестат/диплом)
 
}
