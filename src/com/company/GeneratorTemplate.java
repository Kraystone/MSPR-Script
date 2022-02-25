package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GeneratorTemplate {

    // Constructeurs
    public GeneratorTemplate() {
    }

    /**
     * Méthode de generation du template pour un agent
     * qui effectue la modification du template suivant les valeurs de l'agent précis
     * @param agent
     * @return du code HTML sous forme de String
     * @throws IOException
     */
    public String generateTemplAgentInfo(Agent agent) throws IOException {
        Reader reader = new Reader();
        StringBuilder html = new StringBuilder();
        String ligne;

        BufferedReader br = new BufferedReader(new FileReader(reader.cheminAgentInfoHtml));

        while ((ligne = br.readLine()) != null) {
            if(ligne.contains("{{Agent.nom}}")) {
                ligne = ligne.replace("{{Agent.nom}}", agent.getNom());
            }
            if(ligne.contains("{{Agent.titre}}")) {
                ligne = ligne.replace("{{Agent.titre}}", agent.getTitre());
            }
            if(ligne.contains("{{lien}}")) {
                ligne = ligne.replace("{{lien}}", agent.getFileName());

            }
            html.append(ligne);
        }

        return html.toString();
    }

    /**
     * Méthode de generation du template pour la page d'acceuil qui incorpore elle meme la génération du template d'un agent
     * @param listeAgents
     * @throws IOException
     */
    public void generateTemplAcceuil(List<Agent> listeAgents) throws IOException {
        String cheminDeDossierGen = "Generer\\";
        // Si le dossier "Generer" n'existe pas il est crée.
        if (!Files.exists(Paths.get(cheminDeDossierGen))) {
            Files.createDirectories(Paths.get(cheminDeDossierGen));
        }
        // Lecture du fichier Acceuil de base
        BufferedReader br = new BufferedReader(new FileReader("./Templates/index.html"));
        // Ecriture du fichier final
        BufferedWriter bw = new BufferedWriter(new FileWriter(cheminDeDossierGen + "index.html", StandardCharsets.UTF_8));
        String line;
        int counter = 0;

        while ((line = br.readLine()) != null) {

            if (line.contains("{{Agent}}")) {
                for (Agent agent : listeAgents) {
                    if (counter == 0) {
                        line = line.replace("{{Agent}}", generateTemplAgentInfo(agent));
                    }
                    else {
                        line = line.concat(generateTemplAgentInfo(agent));
                    }
                    counter++;
                }
                bw.write(line);
            }
            else {
                bw.write(line);
            }
        }
        br.close();
        bw.close();
    }

    public void generateTemplAgent(List<Agent> listeAgents) throws IOException {
        String cheminDeDossierGen = "Generer\\Agent\\";
        if (!Files.exists(Paths.get(cheminDeDossierGen))) {
            Files.createDirectories(Paths.get(cheminDeDossierGen));
        }
        for (Agent agent : listeAgents) {
            BufferedReader br = new BufferedReader(new FileReader("./Templates/Agent.html"));
            String filename = cheminDeDossierGen + "Agent" + agent.getNom() +".html";
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename, StandardCharsets.UTF_8));
            String ligne;

            while ((ligne = br.readLine()) != null) {
                if(ligne.contains("{{agent.nom}}")) {
                    ligne = ligne.replace("{{agent.nom}}", agent.getNom());
                }
                if(ligne.contains("{{agent.prenom}}")) {
                    ligne = ligne.replace("{{agent.prenom}}", agent.getPrenom());
                }
                if(ligne.contains("{{agent.equipement}}")) {
                    ligne = ligne.replace("{{agent.equipement}}", generateListeOutils(agent.getOutils()));
                }
                bw.write(ligne);

            }
            agent.setFileName(filename);
            br.close();
            bw.close();
        }
    }
    public String generateListeOutils(List<Outil> outils) throws IOException{
        StringBuilder html = new StringBuilder();
        String ligne;
        for (Outil outil : outils){
            ligne="<li>" + outil.getNom() + "</li>";
            html.append(ligne);
        }
        return html.toString();
    }
}
