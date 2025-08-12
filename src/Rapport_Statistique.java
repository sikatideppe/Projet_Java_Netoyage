import java.util.*;

public class Rapport_Statistique {
    private String nomColonne;
    private double moyenne;
    private double min;
    private double max;

    // ✅ Constructeur
    public Rapport_Statistique(String nomColonne, double moyenne, double min, double max) {
        this.nomColonne = nomColonne;
        this.moyenne = moyenne;
        this.min = min;
        this.max = max;
    }

    // ✅ Getters
    public String getNomColonne() { return nomColonne; }
    public double getMoyenne() { return moyenne; }
    public double getMin() { return min; }
    public double getMax() { return max; }

    // ✅ Affichage formaté
    public void afficher() {
        System.out.printf("Colonne: %-15s | Moyenne: %10.2f | Min: %10.2f | Max: %10.2f%n",
                          nomColonne, moyenne, min, max);
    }

    // ✅ Méthode statique pour générer les statistiques depuis les données CSV
    public static List<Rapport_Statistique> genererStats(List<String[]> data) {
        List<Rapport_Statistique> rapports = new ArrayList<>();

        if (data == null || data.size() < 2) return rapports; // Besoin d'au moins 2 lignes (en-tête + données)

        String[] enTetes = data.get(0); // Première ligne = noms des colonnes
        int colonnes = enTetes.length;

        // Initialiser des listes de valeurs numériques pour chaque colonne
        List<List<Double>> colonnesNumeriques = new ArrayList<>();
        for (int i = 0; i < colonnes; i++) {
            colonnesNumeriques.add(new ArrayList<>());
        }

        // Lire les lignes de données
        for (int i = 1; i < data.size(); i++) {
            String[] ligne = data.get(i);
            for (int j = 0; j < colonnes; j++) {
                if (j < ligne.length) {
                    try {
                        double val = Double.parseDouble(ligne[j]);
                        colonnesNumeriques.get(j).add(val);
                    } catch (NumberFormatException e) {
                        // Ignorer les valeurs non numériques
                    }
                }
            }
        }

        // Calculer statistiques pour chaque colonne
        for (int j = 0; j < colonnes; j++) {
            List<Double> valeurs = colonnesNumeriques.get(j);
            if (!valeurs.isEmpty()) {
                double somme = 0;
                double min = Double.POSITIVE_INFINITY;
                double max = Double.NEGATIVE_INFINITY;

                for (double val : valeurs) {
                    somme += val;
                    if (val < min) min = val;
                    if (val > max) max = val;
                }

                double moyenne = somme / valeurs.size();
                rapports.add(new Rapport_Statistique(enTetes[j], moyenne, min, max));
            }
        }

        return rapports;
    }
}
