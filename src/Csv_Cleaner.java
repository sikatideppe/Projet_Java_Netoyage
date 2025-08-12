import java.util.*; // Pour List, ArrayList

public class Csv_Cleaner {

    // Constructeur par défaut
    public Csv_Cleaner() {}

    // Méthode pour nettoyer les données CSV ligne par ligne
    public List<String[]> clean(List<String[]> data) {
        List<String[]> data_netoy = new ArrayList<>(); // Liste des données nettoyées

        for (String[] ligne : data) {
            String[] ligne_netoyer = new String[ligne.length]; // Ligne nettoyée à construire

            for (int i = 0; i < ligne.length; i++) {
                String value = ligne[i]; // Valeur actuelle de la cellule

                // Si la cellule est vide ou manquante
                if (Utils.isVide(value)) {
                    ligne_netoyer[i] = "NA"; // Remplacer par "NA"
                } else {
                    // Supprimer les espaces et mettre en majuscules
                    ligne_netoyer[i] = Utils.to_Magiscule(value.trim());
                }
            }

            data_netoy.add(ligne_netoyer); // Ajouter la ligne nettoyée à la liste
        }

        return data_netoy; // Retourner les données nettoyées
    }
}
