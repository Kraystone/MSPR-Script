package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GeneratorHTML {


    public static String generateAgentInfoHTML(List<Agent> lesAgents) throws IOException {
        StringBuilder html = new StringBuilder("");
        String ligne;

        for (Agent agent: lesAgents) {
            BufferedReader br = new BufferedReader(new FileReader("D:\\Document Epsi\\OneDrive - Ifag Paris\\B3\\Integration continue\\Maven\\MSPR-Script\\Templates\\AgentInfo.html"));

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
        }
        return html.toString();
    }
    public static void generateIndexPage(List<Agent> agents, String generatorPath) throws IOException {
        if (!Files.exists(Paths.get(generatorPath)))
            Files.createDirectories(Paths.get(generatorPath));

        BufferedReader  br = new BufferedReader(new FileReader("./templates/index.html"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(generatorPath + "index.html", StandardCharsets.UTF_8));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("{{agents}}"))
                line = line.replace("{{agents}}", generateAgentInfoHTML(agents));
            bw.write(line);
        }

        br.close();
        bw.close();
    }
    public static void generateAgentPage(Agent agent, String generatorPath) throws IOException {

        BufferedReader  br = new BufferedReader(new FileReader("./templates/agent.html"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(generatorPath+agent.getFileName()+".html", StandardCharsets.UTF_8));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("username"))
                line = line.replace("{{username}}", agent.getNom());
            if (line.contains("{{equipements}}"))
                //generateEquipementsHTML(agent.getEquipments())
                line = line.replace("{{equipements}}", agent.getOutils());
            bw.write(line);
        }
        br.close();
        bw.close();
    }
}
