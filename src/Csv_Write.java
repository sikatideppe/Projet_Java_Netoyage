import java.io.*;
import java.util.*;

public class Csv_Write {
    private String filePath;

    // Constructeur avec le chemin du fichier de sortie
    public Csv_Write(String filePath) {
        this.filePath = filePath;
    }

    // Écrit chaque ligne dans le fichier
    public void write(List<String[]> data) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"))) {

            for (String[] row : data) {
                String line = String.join(",", row);
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erreur d'écriture dans le fichier : " + e.getMessage());
        }
    }
}
