import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        String inputPath = "adultes_canadiens_2015.csv";
        String outputPath = "netoyer.csv";

        Csv_Read reader = new Csv_Read(inputPath, ',');
        Afficher Afficheur = new Afficher();
        Csv_Cleaner Netoyer = new Csv_Cleaner();
        Csv_Write sauvegarde = new Csv_Write(outputPath);

        List<String[]> data = new ArrayList<>();
        List<String[]> data_netoyer = new ArrayList<>();
        List<Rapport_Statistique> stats = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n=========== MENU ================");
            System.out.println("1. Lire un fichier CSV");
            System.out.println("2. Affichage des données");
            System.out.println("3. Nettoyage du cvs");
            System.out.println("4. Enregistrer données nettoyées");
            System.out.println("5. Affichage rapport statistique");
            System.out.println("0. Quitter");
            System.out.print("Choisir une Option : ");

            while (!sc.hasNextInt()) {
                System.out.print("Entrez un nombre valide : ");
                sc.next();
            }
            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    data = reader.lire();System.out.println("Fichier Charger avec succès !");break;
                case 2:
                    if (data.isEmpty()) {
                        System.out.println("Aucune donnée à afficher !");
                    } else {
                        Afficheur.Affiche(data);
                    }
                    break;
                case 3:
                    if (data.isEmpty()) {System.out.println("Aucune donnée à nettoyer !");
                    } else {data_netoyer = Netoyer.clean(data);System.out.println(" Données nettoyées !");Afficheur.Affiche(data_netoyer);}
                    break;
                case 4:
                    if (data_netoyer.isEmpty()) {
                        System.out.println("Aucune donnée nettoyée à sauvegarder !");
                    } else {
                        sauvegarde.write(data_netoyer);
                        System.out.println(" Données sauvegardées dans : " + outputPath);
                    }
                    break;
                case 5:
                    if (data_netoyer.isEmpty()) {
                        System.out.println("Nettoyez les données avant de générer les statistiques !");
                    } else {
                        stats = Rapport_Statistique.genererStats(data_netoyer);
                        for (Rapport_Statistique r : stats) {
                            r.afficher();
                        }
                    }
                    break;
                case 0: System.out.println(" Fin du programme."); break;
                default:System.out.println(" Choix invalide !");
            }

        } while (choix != 0);

        sc.close();
    }
}
