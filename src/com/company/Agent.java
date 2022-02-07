package com.company;

public class Agent {

    private String nom;
    private String titre;
    private  String password;
    private String[] outils;

    public Agent(String nom, String titre, String password, String[] outils) {
        this.nom = nom;
        this.titre = titre;
        this.password = password;
        this.outils = outils;
    }

    public String getNom() {
        return nom;
    }

    public String getTitre() {
        return titre;
    }

    public String getPassword() {
        return password;
    }

    public String[] getOutils() {
        return outils;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOutils(String[] outils) {
        this.outils = outils;
    }

}
