public class Utils {

    // Vérifie si une valeur est vide ou nulle
    public static boolean isVide(String value) {
        return value == null || value.trim().isEmpty() || value.equalsIgnoreCase("NA");
    }

    // Met une chaîne en majuscules (sans générer d'erreur si null)
    public static String to_Magiscule(String value) {
        return value == null ? "" : value.toUpperCase();
    }
}
