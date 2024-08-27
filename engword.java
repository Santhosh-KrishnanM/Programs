import java.util.Scanner;

public class PluralFormFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a singular English word: ");
        String word = scanner.nextLine().trim();

        String plural = findPlural(word);
        System.out.println("Plural form: " + plural);

        scanner.close();
    }

    public static String findPlural(String word) {
        if (word.endsWith("y")) {
            // Words ending in 'y' preceded by a consonant: replace 'y' with 'ies'
            if (isConsonant(word.charAt(word.length() - 2))) {
                return word.substring(0, word.length() - 1) + "ies";
            }
        }

        // Words ending in 'o', 'ch', 'sh', 's', 'x' or 'z': add 'es'
        if (word.endsWith("o") || word.endsWith("ch") || word.endsWith("sh") || 
            word.endsWith("s") || word.endsWith("x") || word.endsWith("z")) {
            return word + "es";
        }

        // Words ending in 'f' or 'fe': replace 'f' or 'fe' with 'ves'
        if (word.endsWith("f")) {
            return word.substring(0, word.length() - 1) + "ves";
        } else if (word.endsWith("fe")) {
            return word.substring(0, word.length() - 2) + "ves";
        }

        // For most nouns: add 's'
        return word + "s";
    }

    public static boolean isConsonant(char c) {
        return "bcdfghjklmnpqrstvwxyz".indexOf(Character.toLowerCase(c)) != -1;
    }
}
