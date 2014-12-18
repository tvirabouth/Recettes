package gestionrecette;

import java.io.Serializable;

/**
 *
 * @author jeremy
 */
public class Aliment implements Serializable
{
    private int idAliment;
    private String nomAliment;
    private int calories;

    public Aliment(int idAliment, String nomAliment, int calories)
    {
        this.idAliment = idAliment;
        this.nomAliment = nomAliment;
        this.calories = calories;
    }

    public int getIdAliment()
    {
        return idAliment;
    }

    public void setIdAliment(int idAliment)
    {
        this.idAliment = idAliment;
    }

    public String getNomAliment()
    {
        return nomAliment;
    }

    public void setNomAliment(String nomAliment)
    {
        this.nomAliment = nomAliment;
    }

    public int getCalories()
    {
        return calories;
    }

    public void setCalories(int calories)
    {
        this.calories = calories;
    }
}
