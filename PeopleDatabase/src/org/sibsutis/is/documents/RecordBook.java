
package org.sibsutis.is.documents;

import org.sibsutis.is.documents.AbstractDocument;


public class RecordBook extends AbstractDocument  
{
    private String Specialty;
    private String OrderNumber;
    private String FormOfTraining;

    
    public String getSpecialty()
    {
        return Specialty;
    }

    
    public void setSpecialty(String Specialty)
    {
        this.Specialty = Specialty;
    }

    
    public String getOrderNumber() 
    {
        return OrderNumber;
    }

    
    public void setOrderNumber(String OrderNumber)
    {
        this.OrderNumber = OrderNumber;
    }

    
    public String getFormOfTraining()
    {
        return FormOfTraining;
    }

    
    public void setFormOfTraining(String FormOfTraining)
    {
        this.FormOfTraining = FormOfTraining;
    }

    @Override
    public String getValidTo()
    {
        return super.getValidTo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDateOfIssue(String DateOfIssue)
    {
        super.setDateOfIssue(DateOfIssue); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDateOfIssue()
    {
        return super.getDateOfIssue(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDocumentType(String DocumentType)
    {
        super.setDocumentType(DocumentType); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDocumentType()
    {
        return super.getDocumentType(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDocumentNumber(String DocumentNumber)
    {
        super.setDocumentNumber(DocumentNumber); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDocumentNumber()
    {
        return super.getDocumentNumber(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValidTo(String ValidTo)
    {
        super.setValidTo(ValidTo); //To change body of generated methods, choose Tools | Templates.
    }
  
}
