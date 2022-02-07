package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Reader {

    public Reader() {}

    public void lireTout() throws IOException {
        ArrayList<String> allFiles = new ArrayList<>();
        listeRepertoire(new File("D:\\Document Epsi\\OneDrive - Ifag Paris\\B3\\Integration continue\\Maven\\MSPR-Script\\src\\Ressource\\agents - voir htpasswd"), allFiles);
        File f;
        FileReader fr;
        BufferedReader br;
        for (String file : allFiles) {
            f = new File (file);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String ligne = br.readLine();
            while (ligne != null) {
                ligne = br.readLine();
                System.out.println(ligne);
            }
            br.close();
            fr.close();
        }
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