
package org.sibsutis.is.documents;

import org.sibsutis.is.documents.AbstractDocument;


public class MilitaryId extends AbstractDocument
{

   
 private String MilitaryRank;
 private String Position;
 private String Specialty;

   
    public String getMilitaryRank()
    {
        return MilitaryRank;
    }

    
    public void setMilitaryRank(String MilitaryRank)
    {
        this.MilitaryRank = MilitaryRank;
    }

    
    public String getPosition()
    {
        return Position;
    }

    
    public void setPosition(String Position) 
    {
        this.Position = Position;
    }

    @Override
    public String getValidTo()
    {
        return super.getValidTo(); 
    }

    @Override
    public void setDateOfIssue(String DateOfIssue)
    {
        super.setDateOfIssue(DateOfIssue); 
    }

    @Override
    public String getDateOfIssue()
    {
        return super.getDateOfIssue(); 
    }

    @Override
    public void setDocumentType(String DocumentType)
    {
        super.setDocumentType(DocumentType); 
    }

    @Override
    public String getDocumentType()
    {
        return super.getDocumentType(); 
    }

    @Override
    public void setDocumentNumber(String DocumentNumber)
    {
        super.setDocumentNumber(DocumentNumber); 
    }

    @Override
    public String getDocumentNumber()
    {
        return super.getDocumentNumber(); 
    }

    @Override
    public void setValidTo(String ValidTo)
    {
        super.setValidTo(ValidTo); 
    }

    public String getSpecialty()
    {
        return Specialty;
    }

   
    public void setSpecialty(String Specialty)
    {
        this.Specialty = Specialty;
    }
    
    
}
