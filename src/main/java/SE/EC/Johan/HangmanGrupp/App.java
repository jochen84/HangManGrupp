package SE.EC.Johan.HangmanGrupp;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static HangMan hangman = new HangMan();
    public static boolean keepAlive;
    public static void main( String[] args ) {

        //StartGame.startGame();
        hangman.newGame();
        playGame();

    }

    public static void playGame(){

        System.out.println("\nOk, då spelar vi! Det hemliga ordet består av: " + hangman.getWordToFind().length() + " bokstäver, lycka till!");

        keepAlive = true;
        while (keepAlive && hangman.getUsedGuesses() <= hangman.getMaxGuesses()) {
            for (char word : hangman.getSecretWordArray()) {
                System.out.print(word + " ");
            }
            System.out.println("\nGissa på en boktsav eller hela ordet (" + hangman.getWordToFind().length() + ") bokstäver:             [-Använda bokstäver:" + hangman.getUsedLetters() + "-]");

            String input = scanner.nextLine().toUpperCase();
            String charInput = input.substring(0, 1);

            if (hangman.getWordToFind().equals(input)) {
                System.out.println("Rätt gissat! Ordet var: " + hangman.getWordToFind() + "\nSpelet är slut!");
                keepAlive = false;
            } else if (input.length() < hangman.getWordToFind().length() && input.length() > 1) {
                System.out.println("Ordet du gissade är för kort, ordet består av " + hangman.getWordToFind().length() + " bokstäver.");
            } else if (input.length() > hangman.getWordToFind().length()) {
                System.out.println("Ordet du gissade är för långt, ordet består av " + hangman.getWordToFind().length() + " bokstäver.");
            } else if (input.length() == hangman.getWordToFind().length()/* && !hangman.getWordToFind().equals(input)*/){ //Behöver inte && satset? Kommer inte hit ändå??
                System.out.println("Ordet du gissade är fel, försök igen.\nGissning: " + hangman.getUsedGuesses() + "/" + hangman.getMaxGuesses());
                int guesses = hangman.getUsedGuesses();
                hangman.setUsedGuesses(++guesses);
                if (hangman.getUsedGuesses() > hangman.getMaxGuesses()) {
                    System.out.println("Du förlorade! Alla gissningar är slut...\nDet rätta ordet var: " + hangman.getWordToFind());
                    keepAlive = false;
                }
            }else{
                enterLetters(charInput);
            }
            if (hangman.isWordCorrect()) {
                System.out.println("\nGrattis, du har hittat rätt ord! Spelet är slut!\nRätta ordet var: " + hangman.getWordToFind());
                keepAlive = false;
            }
        }
    }

    public static void enterLetters (String charInput){
        if(!hangman.getUsedLetters().toString().contains(charInput)){
            hangman.getUsedLetters().append("[" + charInput + "]");
            if(hangman.getWordToFind().contains(charInput)){
                System.out.println("Bra jobbat, några kvar!");
                int index = hangman.getWordToFind().indexOf(charInput);

                while (index >= 0) {
                    hangman.getSecretWordArray()[index] = charInput.charAt(0);
                    index = hangman.getWordToFind().indexOf(charInput, index + 1);
                }
            }else{
                System.out.println("Bokstaven finns inte med, försök igen!\nGissning: " + hangman.getUsedGuesses() + "/" + hangman.getMaxGuesses());
                int guesses = hangman.getUsedGuesses();
                hangman.setUsedGuesses(++guesses);
                    if(hangman.getUsedGuesses() > hangman.getMaxGuesses()){
                        System.out.println("Du förlorade! Alla gissningar är slut...\nDet rätta ordet var: " + hangman.getWordToFind());
                        keepAlive = false;
                        // System.exit(0);
                    }
            }
        }else{
            System.out.println("Du har redan gissat på denna bokstaven [" + charInput +"], försök igen!");
        }
    }
}
