package org.sibsutis.is.documents;

public class Passport extends AbstractDocument
{
    private String SerialNumber;

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
