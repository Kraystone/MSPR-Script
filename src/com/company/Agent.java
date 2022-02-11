package com.company;

import java.util.List;

public class Agent {
    // Attributs
    private String nom;
    private String prenom;
    private String titre;
    private String password;
    private String fileName;
    private List<Outil> outils;

    // Construteurs
    public Agent(String nom, String prenom, String titre, String password, String fileName, List<Outil> outils) {
        this.nom = nom;
        this.prenom = prenom;
        this.titre = titre;
        this.password = password;
        this.fileName = fileName;
        this.outils = outils;
    }

    // Getter Setter
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Outil> getOutils() {
        return outils;
    }

    public void setOutils(List<Outil> outils) {
        this.outils = outils;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", titre='" + titre + '\'' +
                ", password='" + password + '\'' +
                ", fileName='" + fileName + '\'' +
                ", outils=" + outils +
                '}';
    }
}
