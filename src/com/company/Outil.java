package com.company;

/**
 * Classe d'outils/Equipements d'agents
 */
public class Outil {

    /**
     * Variables
     */
    String code;
    String nom;

    /**
     * Constructeur de base
     * @param code
     * @param nom
     */
    public Outil(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public Outil(String nom) {
        this.nom = nom;
    }
    // Getter Setter

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Outil{" +
                "code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }


}
