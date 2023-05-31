import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class HangmanLogic {
    String guessInput;
    public ArrayList<String> underscoreWord;
    private ArrayList<Integer> indexesOfGuesses;
    private ArrayList<String> wordCharacters;
    private ArrayList<String> wordCharactersNoDuplicates;

    public void Logic() {
        underscoreWord = new ArrayList<>();
        wordCharacters = new ArrayList<>(Arrays.asList(WordFrame.wordArray));
        if (wordCharactersNoDuplicates == null)
            wordCharactersNoDuplicates = Main.removeDuplicates(wordCharacters);
        if (wordCharacters.contains(" ")) {
            underscoreWord = addSpaces(underscoreWord);
        }
    }
    private ArrayList<String> addSpaces(ArrayList<String> underscoreWord) {
        indexesOfGuesses = new ArrayList<>();
        ArrayList<String> space = new ArrayList<String>();
        space.add(" ");
        ListIterator<String> arrayWordIterator = wordCharacters.listIterator(0);
        while (arrayWordIterator.hasNext()) {
            // Find Spaces
            if (space.contains(arrayWordIterator.next())) {
                indexesOfGuesses.add(arrayWordIterator.previousIndex());
            }
        }

        for (int i : indexesOfGuesses) {
            this.underscoreWord.set(i, wordCharacters.get(i));
        }
        return (this.underscoreWord);
    }
}