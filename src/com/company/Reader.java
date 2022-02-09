package com.company;

import java.io.*;
import java.util.*;

public class Reader {

    public Reader() {}

    public List<Agent> lireTout() throws IOException {
        ArrayList<String> allFiles = new ArrayList<>();
        listeRepertoire(new File("D:\\Document Epsi\\OneDrive - Ifag Paris\\B3\\Integration continue\\Maven\\MSPR-Script\\src\\Ressource\\agents - voir htpasswd"), allFiles);
        File f;
        FileReader fr;
        BufferedReader br;

        List<Agent> listeAgent = new ArrayList<>();
        for (String file : allFiles) {
            f = new File (file);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String ligne = br.readLine();
            List<String> texteFichier = new ArrayList<>();
            Agent agent = new Agent();

            while (ligne != null) {
                ligne = br.readLine();
                texteFichier.add(ligne);
            }
            // Instanciation d'un agent via la lecture du tableau
            // Index 0 = nom de l'agent
            agent.setNom(texteFichier.get(0));
            // Index 1 = Mission/Poste
            agent.setTitre(texteFichier.get(1));
            // Index 2 = Le mot de passe
            agent.setPassword(texteFichier.get(2));
            // On saute l'index 3 car c'est un saut de ligne !
            // Index 4 5 6 = Equipements attribuées.
            agent.setOutils(new String[]{texteFichier.get(4), texteFichier.get(5), texteFichier.get(6)});
            // On ajoute l'agent à la liste d'agents
            listeAgent.add(agent);
            br.close();
            fr.close();
        }
        return listeAgent;
    }
    public static void listeRepertoire(File path, List<String> allFiles)
    {

        if (path.isDirectory()) {
            File[] list = path.listFiles();
            if (list != null) {
                for (File file : list) {
                    // Appel récursif sur les sous-répertoires
                    listeRepertoire(file, allFiles);
                }
            }
            else {
                System.err.println(path + " : Erreur de lecture.");
            }
        }
        else {
            String currentFilePath = path.getAbsolutePath();
            System.out.println(currentFilePath);
            allFiles.add(currentFilePath);
        }
    }
}