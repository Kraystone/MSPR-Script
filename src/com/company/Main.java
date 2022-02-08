package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class  Main {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        List<Agent> ListeAgent= reader.lireTout();

//        TODO à Supprimer c'est pour afficher la récuperation du tableau
        for ( Agent ag : ListeAgent) {
            System.out.println(ag.getNom());
            System.out.println(ag.getTitre());
            System.out.println("---------");
        }
    }
}
