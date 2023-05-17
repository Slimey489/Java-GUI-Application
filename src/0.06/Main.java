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
class Main {

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
    Container contentpane;
    SpringLayout layout;
    JTextField guessField;
    JLabel guessLabel,enterGuessLabel;
    JButton backButton;
    String rawGuess, guess;
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
        String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N",
                "O","P","Q","R","S","T","U","V","W","X","Y","Z"};
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

        // Pls implement actual logic instead of loop :)

        int indexcounter = 0;
        int lettersPerRow = rowCalc();
        int x = 1;
        String letter = " ";
        // Offsets for the character grid & creating all the different labels
        int v = 0;
        while (indexcounter <= 25) {

            if (indexcounter % lettersPerRow == 0){
                v=0;
            }
            else{
                v++;
            }

            letter = alphabet[indexcounter];
            guessLabel = new JLabel(letter);
            frameMain.add(guessLabel);

            if (v == lettersPerRow){
                v = 0;
            }
            layout.putConstraint(SpringLayout.WEST, guessLabel, (v * 20 + 20), SpringLayout.WEST, contentpane);
            layout.putConstraint(SpringLayout.NORTH, guessLabel, (x * 20 + 50), SpringLayout.NORTH, contentpane);
            indexcounter++;

            if (indexcounter % lettersPerRow == 0){
                x++;
            }


        }

        layout.putConstraint(SpringLayout.NORTH, backButton, 20, SpringLayout.NORTH, guessLabel);
        frameMain.add(enterGuessLabel);
        frameMain.add(backButton);
        frameMain.add(guessField);
        frameMain.add(guessLabel);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setSize(500, 400);
        contentpane.setLayout(layout);

        frameMain.setVisible(true);
        contentpane.setVisible(true);
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
            }
            if (e.getSource() == backButton){
                App.start_mainFrame_First = false;
                SwingUtilities.invokeLater(new App());

            }



        }
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

                //System.out.println(Scratch.callingclass);
                //System.out.println(WordFrame.action.class);
                if (Scratch.callingclass.equals(Scratch.action.class)){
                    Scratch.frameMain.setVisible(true);
                }
                else if ((Scratch.callingclass.equals(WordFrame.action.class))) {
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

    public void run() {
        //debug option
        start_mainFrame_First = false;

        if (start_mainFrame_First) {
            Scratch classinstance = new Scratch();
            gui = classinstance.GuessFrame();
        }
        else {
            WordFrame classinstance = new WordFrame();
            gui = classinstance.wordFrame();
        }
        //try{
            if (Scratch.callingclass.equals(Scratch.action.class)){
                System.out.println(Scratch.callingclass);
                Scratch.frameMain.dispatchEvent(
                new WindowEvent(Scratch.frameMain, WindowEvent.WINDOW_CLOSING));
            }
        //}catch (NullPointerException e){

        //}
        gui.setVisible(true);


    }
}
class ErrorHandler implements Runnable{
    public void run() {
        ErrorFrame classinstance = new ErrorFrame();
        App.gui = classinstance.errorFrame();
        App.gui.setVisible(true);

    }
}