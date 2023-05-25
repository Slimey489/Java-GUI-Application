import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Optional;

class Main {

    /** @noinspection OptionalGetWithoutIsPresent*/
    public static Class<?> findCallingClass() {
        int classStack = 1;
        StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        Optional<? extends Class<?>> caller = walker.walk(frames ->
                frames.skip(classStack).findFirst().map(StackWalker.StackFrame::getDeclaringClass));
        return caller.get();


    }

    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        ArrayList<T> duplicateRemover = new ArrayList<>();
        for (T element : list) {
            if (!duplicateRemover.contains(element)) {
                duplicateRemover.add(element);
            }
        }
        return duplicateRemover;
    }

    public static JFrame frameMain;
    static Class<?> callingclass;
    private Container contentpane;
    private SpringLayout layout;
    private JTextField guessField;
    JLabel guessLabel;
    JButton backButton;
    String rawGuess;
    static String guess;
    String char2,letter;
    static final String[] ALPHABET = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N",
            "O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    int letterAtIndex;
    int lettersOnRow;
    int column;
    int row;
    public static int totalLettersAdded;
    boolean removedConstraints = false;
    ArrayList<String> underscoreWord;





    public static int rowCalc() {

        int leastRows = 7;

        double unroundedLetterPerRow;
        unroundedLetterPerRow = (((double) 26 / leastRows)-1);
        MathContext rounded = new MathContext(1, RoundingMode.UP);
        BigDecimal returnCorrectType = new BigDecimal(unroundedLetterPerRow,rounded);

        return returnCorrectType.intValue();

    }
    /** @noinspection UnusedReturnValue*/
    public JFrame GuessFrame(){
        frameMain = new JFrame();
        frameMain.setTitle("Hangman");
        contentpane = frameMain.getContentPane();
        layout = new SpringLayout();
        underscoreWord = new ArrayList<>();
        underscoreWord.add("_");
        underscoreWord.add("_");
        guessField = new JTextField(1);
        backButton = new JButton("New Word");
        guessField.addActionListener(new action());
        backButton.addActionListener(new action());
        JLabel enterGuessLabel = new JLabel("Enter Guess:");
        DrawingFrame.drawingFrame();
        JLabel underscores;

        layout.putConstraint(SpringLayout.WEST, enterGuessLabel, 10, SpringLayout.WEST, contentpane);
        layout.putConstraint(SpringLayout.NORTH, enterGuessLabel, 20, SpringLayout.NORTH, contentpane);
        layout.putConstraint(SpringLayout.WEST, guessField, 80, SpringLayout.WEST, enterGuessLabel);
        layout.putConstraint(SpringLayout.NORTH, guessField, 20, SpringLayout.NORTH, contentpane);
        layout.putConstraint(SpringLayout.EAST,DrawingFrame.drawingFrame,0,SpringLayout.EAST,contentpane);
        /*for (String i : underscoreWord){
            underscores = new JLabel();
            layout.putConstraint(SpringLayout.WEST);
        }*/
        layout.putConstraint(SpringLayout.WEST, backButton, 20, SpringLayout.WEST, contentpane);
        layout.putConstraint(SpringLayout.NORTH, backButton, 20, SpringLayout.NORTH, guessField);

        contentpane.add(DrawingFrame.drawingFrame);
        contentpane.add(enterGuessLabel);
        contentpane.add(backButton);
        contentpane.add(guessField);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.pack();
        frameMain.setSize(500, 400);
        frameMain.setPreferredSize(new Dimension(500,400));
        contentpane.setPreferredSize(new Dimension(500,400));
        frameMain.setLayout(layout);
        contentpane.setVisible(true);
        frameMain.setVisible(true);

        return(frameMain);
    }


    class action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            char char1;

            if (e.getSource() == guessField) {
                rawGuess = guessField.getText();

                if (rawGuess.length() == 0) {
                    frameMain.setVisible(false);
                    ErrorFrame.error = "Error Invalid Value For Guess";
                    Main.callingclass = Main.findCallingClass();
                    SwingUtilities.invokeLater(new ErrorHandler());
                    return;
                }
                else {
                    guess = rawGuess.toLowerCase();
                }

                char1 = guess.charAt(0);
                char2 = Character.toString(char1);
                System.out.print(char2);
                DrawingFrame.updateDrawingFrame();

                if (!removedConstraints){
                    layout.removeLayoutComponent(backButton);
                    layout.putConstraint(SpringLayout.WEST, backButton, 20, SpringLayout.WEST, contentpane);
                    layout.putConstraint(SpringLayout.NORTH, backButton, 20, SpringLayout.NORTH, guessLabel);
                    removedConstraints=true;
                }
                DrawingFrame.guessNumber++;
                if (totalLettersAdded != 26){contentpane.add(placeLabel());}

                layout.putConstraint(SpringLayout.NORTH, backButton, 20, SpringLayout.NORTH, guessLabel);
                guessField.setText("");
                frameMain.revalidate();
            }
            if (e.getSource() == backButton){
                DrawingFrame.guessNumber = 0;
                row = 0;
                column = 0;
                lettersOnRow = 0;
                totalLettersAdded = 0;
                DrawingFrame.updateDrawingFrame();
                App.startMainFrameFirst = false;
                App.classIsMainframe = true;
                SwingUtilities.invokeLater(new App());

            }



        }
    }
    JLabel placeLabel(){
        int lettersPerRow = rowCalc();
        String char_Caps;
        for(letterAtIndex = 0; letterAtIndex < ALPHABET.length; letterAtIndex++) {
            char_Caps = char2.toUpperCase();

            if (char_Caps.equals(ALPHABET[letterAtIndex])) {
                if (lettersOnRow == lettersPerRow) {
                    row++;
                    lettersOnRow = 0;
                    column = 0;
                }
                letter = ALPHABET[letterAtIndex];
                guessLabel = new JLabel(letter);
                layout.putConstraint(SpringLayout.WEST, guessLabel, (column * 20 + 20), SpringLayout.WEST, contentpane);
                layout.putConstraint(SpringLayout.NORTH, guessLabel, (row * 20 + 70), SpringLayout.NORTH, contentpane);
                if (column == lettersPerRow) {
                    column = 0;
                } else {
                    column++;
                }

                lettersOnRow++;
                totalLettersAdded++;
                return (guessLabel);
            }
        }
        return null;
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new App());

    }
}