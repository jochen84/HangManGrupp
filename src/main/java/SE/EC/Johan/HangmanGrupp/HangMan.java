package SE.EC.Johan.HangmanGrupp;

public class HangMan {

    private StringBuilder usedLetters;
    private char[] secretWordArray;
    private String wordToFind;
    private int usedGuesses;
    private int maxGuesses;

    public HangMan() {
        this.usedLetters = new StringBuilder();
        this.secretWordArray = new char[0];
        this.wordToFind = StartGame.getWordToFind();
        this.usedGuesses = 1;
        this.maxGuesses = 8;
    }

    public void newGame() {
        this.secretWordArray = new char[getWordToFind().length()];
        for (int i = 0; i < secretWordArray.length; i++) {
            secretWordArray[i] = '_';
        }
    }

    public boolean isWordCorrect(){
        StringBuilder sb = new StringBuilder();
        for(char ch : secretWordArray){
            sb.append(ch);
        }
        String string = sb.toString();
        return wordToFind.equals(string);
    }

    public void setUsedGuesses(int usedGuesses) {
        this.usedGuesses = usedGuesses;
    }

    public void setSecretWordArray(char[] secretWordArray) {
        this.secretWordArray = secretWordArray;
    }

    public StringBuilder getUsedLetters() {
        return usedLetters;
    }

    public char[] getSecretWordArray() {
        return secretWordArray;
    }

    public String getWordToFind() {
        return wordToFind;
    }

    public int getUsedGuesses() {
        return usedGuesses;
    }

    public int getMaxGuesses() {
        return maxGuesses;
    }

}

