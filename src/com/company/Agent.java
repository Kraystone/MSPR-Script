package com.company;

import java.util.Arrays;
import java.util.List;

public class Agent {

    private String nom;
    private String titre;
    private String password;
    private String fileName;
    private List<Outil> outils;



    public Agent(String nom, String titre, String password, List<Outil> outils, String fileName) {
        this.nom = nom;
        this.titre = titre;
        this.password = password;
        this.outils = outils;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Agent() {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
                ", titre='" + titre + '\'' +
                ", password='" + password + '\'' +
//                ", outils=" + Arrays.toString(outils) +
                '}';
    }


}
