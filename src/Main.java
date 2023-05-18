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
    static Container contentpane;
    static SpringLayout layout;
    JTextField guessField;
    JLabel enterGuessLabel;
    static JLabel guessLabel;
    JButton backButton;
    String rawGuess, guess;
    static String char2,letter;
    static final String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N",
            "O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    static int letter_At_Index,letters_On_Row, column,row,total_Letters_Added;
    ArrayList<String> underscoreWord;





    public static int rowCalc() {

        int leastRows = 7;

        double unRoundedletterPerRow;
        unRoundedletterPerRow = (((double) 26 / leastRows)-1);
        MathContext rounded = new MathContext(1, RoundingMode.UP);
        BigDecimal returnCorrectType = new BigDecimal(unRoundedletterPerRow,rounded);

        return returnCorrectType.intValue();

    }
    /** @noinspection UnusedReturnValue*/
    public JFrame GuessFrame(){

        frameMain = new JFrame();
        contentpane = frameMain.getContentPane();
        layout = new SpringLayout();


        guessField = new JTextField(1);
        backButton = new JButton("New Word");
        guessField.addActionListener(new action());
        backButton.addActionListener(new action());
        enterGuessLabel = new JLabel("Enter Guess:");


        layout.putConstraint(SpringLayout.WEST, enterGuessLabel, 10, SpringLayout.WEST, contentpane);
        layout.putConstraint(SpringLayout.NORTH, enterGuessLabel, 20, SpringLayout.NORTH, contentpane);
        layout.putConstraint(SpringLayout.WEST, guessField, 80, SpringLayout.WEST, enterGuessLabel);
        layout.putConstraint(SpringLayout.NORTH, guessField, 20, SpringLayout.NORTH, contentpane);
        layout.putConstraint(SpringLayout.WEST, backButton, 20, SpringLayout.WEST, contentpane);
        if (guessLabel == null){
        layout.putConstraint(SpringLayout.NORTH, backButton, 20, SpringLayout.NORTH, guessField);
        }
        else {
            layout.putConstraint(SpringLayout.NORTH, backButton, 20, SpringLayout.NORTH, guessField);
        }


        frameMain.add(enterGuessLabel);
        frameMain.add(backButton);
        frameMain.add(guessField);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setSize(500, 400);
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
                if (total_Letters_Added != 26){frameMain.add(place_Label());}
                guessField.setText("");
                frameMain.revalidate();
            }
            if (e.getSource() == backButton){
                App.start_mainFrame_First = false;
                App.class_is_mainframe = true;
                SwingUtilities.invokeLater(new App());

            }



        }
    }
    static JLabel place_Label(){
        int letters_Per_Row = rowCalc();
        String char_Caps;
        for(letter_At_Index = 0; letter_At_Index < alphabet.length; letter_At_Index++) {
            char_Caps = char2.toUpperCase();

            if (char_Caps.equals(alphabet[letter_At_Index])) {
             /*   if (placed_Letters.stream().findAny().isPresent()){
                    /*
                    frameMain.setVisible(false);
                    ErrorFrame.error = "Error Invalid Value For Guess";
                    Scratch.callingclass = Scratch.findCallingClass();
                    SwingUtilities.invokeLater(new ErrorHandler());

                     */
                //     return null;
                // }


                if (letters_On_Row == letters_Per_Row) {
                    row++;
                    letters_On_Row = 0;
                    column = 0;
                }
                letter = alphabet[letter_At_Index];
                guessLabel = new JLabel(letter);
                System.out.println(column * 20 + 20);
                layout.putConstraint(SpringLayout.WEST, guessLabel, (column * 20 + 20), SpringLayout.WEST, contentpane);
                layout.putConstraint(SpringLayout.NORTH, guessLabel, (row * 20 + 70), SpringLayout.NORTH, contentpane);
                if (column == letters_Per_Row) {
                    column = 0;
                } else {
                    column++;
                }

                letters_On_Row++;
                total_Letters_Added++;
                return (guessLabel);
            }
        }
        return null;
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new App());

    }
    //f.add(button);
}