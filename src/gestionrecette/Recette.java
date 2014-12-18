package gestionrecette;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jeremy
 */
public class Recette implements Serializable
{
    private int idRecette;
    private String nomRecette;
    private String tempsPreparation;
    private String tempsCuisson;
    private int niveauDifficulte;
    private int idType;

    public Recette(int idRecette, String nomRecette, String tempsPreparation, String tempsCuisson, int niveauDifficulte, int idType)
    {
        this.idRecette = idRecette;
        this.nomRecette = nomRecette;
        this.tempsPreparation = tempsPreparation;
        this.tempsCuisson = tempsCuisson;
        this.niveauDifficulte = niveauDifficulte;
        this.idType = idType;
    }

    public int getIdRecette()
    {
        return idRecette;
    }

    public void setIdRecette(int idRecette)
    {
        this.idRecette = idRecette;
    }

    public String getNomRecette()
    {
        return nomRecette;
    }

    public void setNomRecette(String nomRecette)
    {
        this.nomRecette = nomRecette;
    }

    public String getTempsPreparation()
    {
        return tempsPreparation;
    }

    public void setTempsPreparation(String tempsPreparation)
    {
        this.tempsPreparation = tempsPreparation;
    }

    public String getTempsCuisson()
    {
        return tempsCuisson;
    }

    public void setTempsCuisson(String tempsCuisson)
    {
        this.tempsCuisson = tempsCuisson;
    }

    public int getNiveauDifficulte()
    {
        return niveauDifficulte;
    }

    public void setNiveauDifficulte(int niveauDifficulte)
    {
        this.niveauDifficulte = niveauDifficulte;
    }

    public int getIdType()
    {
        return idType;
    }

    public void setIdType(int idType)
    {
        this.idType = idType;
    }
}
