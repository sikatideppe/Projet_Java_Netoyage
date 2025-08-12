import java.io.*;        // Pour FileReader, BufferedReader, etc.
import java.util.*;       // Pour List, ArrayList

public class Csv_Read {
  private String filePath;  // Chemin du fichier CSV à lire
  char separateur;

  // Constructeur : initialise le chemin du fichier
  public Csv_Read(String filePath,char separateur) {
    this.filePath = filePath;
    this.separateur=separateur;
  }

  // Méthode pour lire le contenu du fichier CSV
  public List<String[]> lire() {
    List<String[]> data = new ArrayList<>(); // Liste pour stocker les lignes du fichier

    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
      String line;

      // Lire chaque ligne du fichier
      while ((line = br.readLine()) != null) {
        // Séparer les valeurs par virgule (en gardant les champs vides)
        if(separateur==';'){
          String[] values = line.split(",", -1);
          data.add(values); // Ajouter la ligne à la liste
        }else{
          String[] values = line.split(",", -1);
          data.add(values); // Ajouter la ligne à la liste
        }
      
        
      }
      
      System.out.println("Lecture du fichier réussie ! " + data.size() + " lignes ont été lues.");

    } catch (IOException e) {
      // Afficher un message d'erreur en cas de problème de lecture
      System.err.println("Erreur de lecture du fichier : " + e.getMessage());
    }

    return data; // Retourner toutes les lignes lues
  }

}