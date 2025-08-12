import java.util.List;

public class Afficher {

    public Afficher() {}

    // Méthode principale pour afficher les données alignées
    public void Affiche(List<String[]> data) {
        if (data == null || data.isEmpty()) {
            System.out.println("Aucune donnée à afficher.");
            return;
        }

        // 1. Déterminer le nombre de colonnes
        int columns = data.get(0).length;

        // 2. Déterminer la largeur maximale de chaque colonne
        int[] maxWidths = new int[columns];

        for (String[] row : data) {
            for (int i = 0; i < columns; i++) {
                if (row[i] != null) {
                    int length = row[i].length();
                    if (length > maxWidths[i]) {
                        maxWidths[i] = length;
                    }
                }
            }
        }

        // 3. Afficher chaque ligne avec alignement
        System.out.println("Données alignées :\n");

        for (String[] row : data) {
            for (int i = 0; i < columns; i++) {
                String value = row[i] != null ? row[i] : "";
                // Affiche la cellule avec un padding à droite
                System.out.printf("%-" + (maxWidths[i] + 2) + "s", value); // +2 pour espacement
            }
            System.out.println(); // Retour à la ligne après chaque ligne
        }

        // System.out.println("\n---- Fin de l'affichage aligné ----");
    }
}
