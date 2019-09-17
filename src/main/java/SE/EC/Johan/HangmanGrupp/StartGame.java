package SE.EC.Johan.HangmanGrupp;

import java.util.Scanner;
import java.util.Random;

public class StartGame {
    private static Scanner scanner = new Scanner(System.in);

    public static void startGame(){
        System.out.println("Välkommen till HANGMAN\n1. Starta spelet\n2. Avsluta");
        int quit = scanner.nextInt();
        if (quit == 2) {
            System.out.println("Hejdå....");
            System.exit(0);
        }
    }

    public static String getWordToFind(){
        String[] wordToFind ={"FISK"/*, "BLOMMA","KLOCKA","HAMMOCK", "KASTRULL"*/};
        Random random = new Random();
        String word = wordToFind[random.nextInt(wordToFind.length)];
        return word;
    }
}
