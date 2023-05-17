import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
class ClassNotFound extends Exception
{
    public ClassNotFound() {}
}
class Scratch {

    /** @noinspection OptionalGetWithoutIsPresent*/
    public static Class<?> findCallingClass() {
        int classStack = 1;
        StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        Optional<? extends Class<?>> caller = walker.walk(frames ->
                frames.skip(classStack).findFirst().map(StackWalker.StackFrame::getDeclaringClass));
        return caller.get();


    }
    /*What is T ?
      T is a Type variable it replaces instances of an object
    */
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
    //static File frameIsOpen;





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

        //JButton button = new JButton("Enter");

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
        layout.putConstraint(SpringLayout.NORTH, backButton, 20, SpringLayout.NORTH, guessLabel);


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
                    Scratch.callingclass = Scratch.findCallingClass();
                    SwingUtilities.invokeLater(new ErrorHandler());
                    return;
                }
                else {
                    guess = rawGuess.toLowerCase();
                }
                char1 = guess.charAt(0);
                String char2 = Character.toString(char1);
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
            // i--;
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
class WordFrame extends JFrame{
    public JFrame frameWord;
    JLabel labelWord;
    JButton enterWord;
    JTextField wordField;
    public Dimension originalSize, newSize;
    SpringLayout layout2;
    Container contentpane2;
    public String word;
    String[] wordArray;
    public ArrayList<String> arrayWord;




    public JFrame wordFrame(){

        frameWord = new JFrame();
        enterWord = new JButton("Enter");
        contentpane2 = frameWord.getContentPane();
        enterWord.addActionListener(new action());
        frameWord.addComponentListener(new ResizeListener());
        layout2 = new SpringLayout();
        wordField = new JTextField(8);
        labelWord = new JLabel("Enter a Word:");

        layout2.putConstraint(SpringLayout.EAST, enterWord, -5, SpringLayout.EAST, contentpane2);
        layout2.putConstraint(SpringLayout.NORTH, enterWord, 50, SpringLayout.NORTH, contentpane2);
        layout2.putConstraint(SpringLayout.EAST, wordField, -5, SpringLayout.EAST, contentpane2);
        layout2.putConstraint(SpringLayout.NORTH, wordField, 20, SpringLayout.NORTH, contentpane2);
        layout2.putConstraint(SpringLayout.WEST, labelWord, 10, SpringLayout.WEST, contentpane2);
        layout2.putConstraint(SpringLayout.NORTH, labelWord, 20, SpringLayout.NORTH, contentpane2);

        enterWord.setSize(30, 20);
        frameWord.add(labelWord);
        frameWord.add(enterWord);
        frameWord.add(wordField);
        frameWord.setSize(210, 140);
        originalSize = frameWord.getSize();
        contentpane2.setLayout(layout2);

        return frameWord;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new App());
    }

    class action implements ActionListener {
        String wordLowerCase;
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == enterWord) {
                word = wordField.getText();
                if (Objects.equals(word, "")) {
                    ErrorFrame.error = "No Word Entered.";
                    Scratch.callingclass = Scratch.findCallingClass();
                    SwingUtilities.invokeLater(new ErrorHandler());
                    frameWord.dispatchEvent(new WindowEvent(frameWord, WindowEvent.WINDOW_CLOSING));
                    return;
                }
                frameWord.dispatchEvent(new WindowEvent(frameWord, WindowEvent.WINDOW_CLOSING));

                wordLowerCase = word.toLowerCase(Locale.ROOT);
                wordArray = wordLowerCase.split("");

                arrayWord = new ArrayList<>(Arrays.asList(wordArray));
                Scratch classinstance = new Scratch();
                classinstance.GuessFrame();
            }
        }
    }
    class ResizeListener implements ComponentListener {

        public void componentHidden(ComponentEvent e) {}
        public void componentMoved(ComponentEvent e) {}
        public void componentShown(ComponentEvent e) {}

        public void componentResized(ComponentEvent e) {
            newSize = e.getComponent().getBounds().getSize();
            if (newSize != originalSize){
                frameWord.setSize(originalSize);

            }
        }
    }
}
class ErrorFrame {
    public static JFrame frameError;
    JButton confirm;

    Dimension originalSize, newSize;
    SpringLayout layout2;

    public static String error;
    Container contentpane2;
    JLabel labelError;
    public JFrame errorFrame(){
        //error = "Please enter a valid value";
        frameError = new JFrame();
        confirm = new JButton("Confirm");
        contentpane2 = frameError.getContentPane();
        confirm.addActionListener(new action());
        frameError.addComponentListener(new ResizeListener());
        layout2 = new SpringLayout();
        labelError = new JLabel(error);

        layout2.putConstraint(SpringLayout.HORIZONTAL_CENTER, confirm, 0, SpringLayout.HORIZONTAL_CENTER, contentpane2);
        layout2.putConstraint(SpringLayout.NORTH, confirm, 50, SpringLayout.NORTH, contentpane2);
        layout2.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelError, 0, SpringLayout.HORIZONTAL_CENTER, contentpane2);
        layout2.putConstraint(SpringLayout.NORTH, labelError, 20, SpringLayout.NORTH, contentpane2);

        confirm.setSize(30, 20);
        frameError.add(labelError);
        frameError.add(confirm);
        frameError.setSize(210, 140);
        originalSize = frameError.getSize();
        contentpane2.setLayout(layout2);

        return frameError;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new App());
    }

    class action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == confirm) {
                frameError.dispatchEvent(new WindowEvent(frameError, WindowEvent.WINDOW_CLOSING));
                if (Scratch.callingclass.equals(Scratch.action.class)){
                    Scratch.frameMain.setVisible(true);
                }
                else if (Scratch.callingclass.equals(WordFrame.action.class)) {
                    WordFrame classinstance = new WordFrame();
                    App.gui = classinstance.wordFrame();
                    App.gui.setVisible(true);
                }
                else{
                    try {
                        throw new ClassNotFound();
                    } catch (ClassNotFound ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
    }

    class ResizeListener implements ComponentListener {

        public void componentHidden(ComponentEvent e) {}
        public void componentMoved(ComponentEvent e) {}
        public void componentShown(ComponentEvent e) {}

        public void componentResized(ComponentEvent e) {
            newSize = e.getComponent().getBounds().getSize();
            if (newSize != originalSize){
                frameError.setSize(originalSize);

            }
        }
    }
}
class App implements Runnable {
    public static JFrame gui;

    static boolean start_mainFrame_First;
    static boolean class_is_mainframe;

    public void run() {
        //debug option
        start_mainFrame_First = false;
        Scratch.callingclass = Scratch.findCallingClass();
        if (start_mainFrame_First) {
            Scratch classinstance = new Scratch();
            gui = classinstance.GuessFrame();
        }
        else {
            WordFrame classinstance = new WordFrame();
            gui = classinstance.wordFrame();
        }
        gui.setVisible(true);
        if (class_is_mainframe){
            System.out.println(Scratch.callingclass);
            Scratch.frameMain.dispose();
        }



    }
}
class ErrorHandler implements Runnable{
    public void run() {
        ErrorFrame classinstance = new ErrorFrame();
        App.gui = classinstance.errorFrame();
        App.gui.setVisible(true);

    }
}
// to rewrite vvv
/*
        guess.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (txtGuess.getText().length() >= 3 ) // limit to 3 characters
                    e.consume();
            }
        });
        */
        /*
        String word = "";
        ArrayList<String> encoded = new ArrayList<>();
        for (int x = 0; x < word.length(); x++) {
            encoded.add("_ ");
        }
        ArrayList<String> findspaces = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        DONE String wordlower = word.toLowerCase(Locale.ROOT);
        DONE String[] wordsplt = wordlower.split("");
        DONE ArrayList<String> arrword = new ArrayList<>(Arrays.asList(wordsplt));
        String[] space = {" "};
        if (Arrays.stream(space).findAny().isPresent()) {
            ListIterator<String> iterator1 = arrword.listIterator(0);
            while (iterator1.hasNext()) { // changes the position +1 of the iterator if there is a valid value for it to change to
                if (Arrays.asList(space).contains(iterator1.next())) {
                    indexes.add(iterator1.previousIndex());
                }
            }
        }
        */