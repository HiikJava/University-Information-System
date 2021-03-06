package org.sibsutis.is.documents;

public class AbstractDocument
{
    private String DocumentNumber;
    private String DocumentType;
    private String DateOfIssue;
    private String ValidTo;
    
    public void setValidTo(String ValidTo)
    {
        this.ValidTo = ValidTo;
    }
      
    public String getDocumentNumber()
    {
        return DocumentNumber;
    }

    public void setDocumentNumber(String DocumentNumber)
    {
        this.DocumentNumber = DocumentNumber;
    }

    public String getDocumentType()
    {
        return DocumentType;
    }

    public void setDocumentType(String DocumentType)
    {
        this.DocumentType = DocumentType;
    }

    
    public String getDateOfIssue()
    {
        return DateOfIssue;
    }

    public void setDateOfIssue(String DateOfIssue)
    {       
        this.DateOfIssue = DateOfIssue;
    }

    public String getValidTo()
    {
        return ValidTo;
    }
    
}
