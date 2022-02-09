package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GeneratorTemplate {

    public GeneratorTemplate() {
    }

    /**
     * Méthode de generation du template pour un agent
     * qui effectue la modification du template suivant les valeurs de l'agent précis
     * @param listeAgents
     * @return du code HTML sous forme de String
     * @throws IOException
     */
    public static String generateTemplAgentInfo(List<Agent> listeAgents) throws IOException {
        Reader reader = new Reader();
        StringBuilder html = new StringBuilder();
        String ligne;

        for (Agent agent: listeAgents) {
            BufferedReader br = new BufferedReader(new FileReader(reader.cheminDossierAgent));

            while ((ligne = br.readLine()) != null) {
                if(ligne.contains("{{Agent.nom}}")) {
                    ligne = ligne.replace("{{Agent.nom}}", agent.getNom());
                    html.append(ligne);
                }
                if(ligne.contains("{{Agent.titre}}")) {
                    ligne = ligne.replace("{{Agent.titre}}", agent.getTitre());
                    html.append(ligne);
                }
                if(ligne.contains("{{lien}}")) {
                    ligne = ligne.replace("{{lien}}", agent.getFileName());
                    html.append(ligne);
                }
            }
        }
        return html.toString();
    }

    /**
     * Méthode de generation du template pour la page d'acceuil qui incorpore elle meme la génération du template d'un agent
     * @param listeAgents
     * @param generatorPath
     * @throws IOException
     */
    public static void generateTemplAcceuil(List<Agent> listeAgents, String generatorPath) throws IOException {

        if (!Files.exists(Paths.get(generatorPath)))
            Files.createDirectories(Paths.get(generatorPath));

        BufferedReader br = new BufferedReader(new FileReader("./templates/Accueil.html"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(generatorPath + "Accueil.html", StandardCharsets.UTF_8));
        String line;

        while ((line = br.readLine()) != null) {
            if (line.contains("{{Agents}}"))
                line = line.replace("{{Agents}}", generateTemplAgentInfo(listeAgents));
            bw.write(line);
        }
        br.close();
        bw.close();
    }

}
