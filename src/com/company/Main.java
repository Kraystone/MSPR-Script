package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class  Main {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        List<Agent> ListeAgent= reader.lireTout();

//        TODO à Supprimer plutard c'est pour afficher la récuperation du tableau
        for ( Agent ag : ListeAgent) {
            System.out.println(ag.getNom());
            System.out.println(ag.getTitre());
            // Rebouclage pour avoir tout les outils de l'agent
            for (Outil outil : ag.getOutils())
                System.out.println(outil.nom);
            System.out.println("---------");
        }
        // Appel de la classe generatorTemplate pour acceder a ses méthodes
//        TODO Problemes sur l'appel de la méthodes dans la classe GeneratorTemplate
        GeneratorTemplate gen = new GeneratorTemplate();
//        GeneratorTemplate.generateAgentInfoHTML()


    }
}
