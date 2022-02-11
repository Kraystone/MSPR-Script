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
        // TODO voir le chemin dans GitLab
        String cheminDeDossierGen = "C:\\wamp64\\www\\MSPR-Script\\Generer\\";

        // Si le dossier "Generer" n'existe pas il est crée.
        if (!Files.exists(Paths.get(cheminDeDossierGen))) {
            Files.createDirectories(Paths.get(cheminDeDossierGen));
        }
        // Lecture du fichier Acceuil de base
        BufferedReader br = new BufferedReader(new FileReader("./Templates/Accueil.html"));
        // Ecriture du fichier final
        BufferedWriter bw = new BufferedWriter(new FileWriter(cheminDeDossierGen + "Accueil.html", StandardCharsets.UTF_8));
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
}
