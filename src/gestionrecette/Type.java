package gestionrecette;

import java.io.Serializable;

/**
 *
 * @author jeremy
 */
public class Type implements Serializable
{
    private int idType;
    private String libelleType;

    public Type(int idType, String libelleType)
    {
        this.idType = idType;
        this.libelleType = libelleType;
    }

    public int getIdType()
    {
        return idType;
    }

    public void setIdType(int idType)
    {
        this.idType = idType;
    }

    public String getLibelleType()
    {
        return libelleType;
    }

    public void setLibelleType(String libelleType)
    {
        this.libelleType = libelleType;
    }
    
    
}
