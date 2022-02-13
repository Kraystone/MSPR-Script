package com.company;

import java.io.IOException;
import java.util.List;

public class  Main {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        List<Agent> ListeAgent = reader.lireTout();
        // Appel de la classe generatorTemplate pour acceder a ses méthodes
        GeneratorTemplate gen = new GeneratorTemplate();
        gen.generateTemplAgent(ListeAgent);
        gen.generateTemplAcceuil(ListeAgent);

    }
}
