package com.company;

import java.io.*;
import java.util.*;

public class Reader {

    /**
     * Variables Globales
     */
    // TODO Modifier le chemin suivant le projet PS : MERCI DE GARDER LES URLS DE CHACUN !
    String cheminDossierAgent = "C:\\wamp64\\www\\MSPR-Script\\src\\Ressource\\agents - voir htpasswd"; // Antho
//    String cheminDossierAgent = "D:\\Document Epsi\\OneDrive - Ifag Paris\\B3\\Integration continue\\Maven\\MSPR-Script\\src\\Ressource\\agents - voir htpasswd": // Léo

    String cheminAgentInfoHtml = "C:\\wamp64\\www\\MSPR-Script\\Templates\\AgentInfo.html";

    public Reader() {}

    /**
     * Méthodes de lectures de tout les fichiers présent dans le Dossier et
     * instancie un Agent pour chaque Fichiers.
     * @return Une liste d'objet Agents.
     * @throws IOException
     */
    public List<Agent> lireTout() throws IOException {
        ArrayList<String> allFiles = new ArrayList<>();
        listeRepertoire(new File(cheminDossierAgent), allFiles);
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


            while (ligne != null) {
                // Ajout de la premier Ligne
                texteFichier.add(ligne);
                // Passage a la phochaine ligne
                ligne = br.readLine();
            }
            // Instanciation d'un agent via la lecture du tableau
            // Index 0 = nom de l'agent
            // Index 1 = Prénom de l'agent
            // Index 2 = Mission/Poste
            // Index 3 = Le mot de passe
            // On saute l'index 4 car c'est un saut de ligne !
            // Index 5 6 7 = Equipements attribuées.
            Outil outil1 = new Outil(texteFichier.get(5));
            Outil outil2 = new Outil(texteFichier.get(6));
            Outil outil3 = new Outil(texteFichier.get(7));

            // Création du lien vers le fichier HTML de l'agent précis ( exemple : /NomPrénom.html )
            // TODO Voir le lien suivant projet
            String lien = "/" + texteFichier.get(0) + texteFichier.get(1) + ".html";
            List<Outil> outilList = new ArrayList<>();
            outilList.add(outil1);
            outilList.add(outil2);
            outilList.add(outil3);
            // Hydrate l'agent avec les différents attributs.
            Agent agent = new Agent(texteFichier.get(0),texteFichier.get(1),texteFichier.get(2),texteFichier.get(3),lien,outilList);
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