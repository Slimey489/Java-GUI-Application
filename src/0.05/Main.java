import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

class WordFrame extends JFrame{
    public JFrame frameWord;
    public JButton enterWord;
    public JTextField wordField;
    public Dimension originalSize, newSize;
    SpringLayout layout2;

    public String word;
    public String[] wordArray;
    public ArrayList<String> arrayWord;
    public Container contentpane2;
    public JLabel labelWord;
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
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == enterWord) {
                word = wordField.getText();
                if (Objects.equals(word, "")) {
                    return;
                }
                frameWord.dispatchEvent(new WindowEvent(frameWord, WindowEvent.WINDOW_CLOSING));
                String wordLowerCase = word.toLowerCase(Locale.ROOT);
                wordArray = wordLowerCase.split("");

                arrayWord = new ArrayList<>(Arrays.asList(wordArray));
                System.out.println(arrayWord);
                Scratch ex = new Scratch();
                JFrame exe = ex.GuessFrame();
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
class Main {
    /*What is T ?
      T is a Type variable it replaces instances of an object
    */
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        ArrayList<T> clrword = new ArrayList<>();
        for (T element : list) {
            if (!clrword.contains(element)) {
                clrword.add(element);
            }
        }
        return clrword;
    }

    JFrame frameMain;
    Container contentpane;
    SpringLayout layout;
    JTextField guessField;
    JLabel guessLabel;



    public static int cltrCalc() {

        int row = 6;

        double nltr2 = 0;
        nltr2 = (((double) 26 /row)-1);
        MathContext m = new MathContext(1, RoundingMode.UP);
        BigDecimal md = new BigDecimal(nltr2,m);

        return md.intValue();

    }
    public JFrame GuessFrame(){

        frameMain = new JFrame();
        contentpane = frameMain.getContentPane();
        String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N",
                "O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        layout = new SpringLayout();

        JButton button = new JButton("Enter");

        guessField = new JTextField(1);
        guessField.addActionListener(new action());
        JLabel lb1 = new JLabel("Enter Guess:");

        layout.putConstraint(SpringLayout.WEST, lb1, 10, SpringLayout.WEST, contentpane);
        layout.putConstraint(SpringLayout.NORTH, lb1, 20, SpringLayout.NORTH, contentpane);
        layout.putConstraint(SpringLayout.WEST, guessField, 80, SpringLayout.WEST, lb1);
        layout.putConstraint(SpringLayout.NORTH, guessField, 20, SpringLayout.NORTH, contentpane);
        int indexcounter = 0;
        int lettersPerRow = cltrCalc();
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
        frameMain.add(lb1);
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
            String unguess = guessField.getText();
            String guess = unguess.toLowerCase();
            if (unguess.contains(" ")) {
                System.out.println("no");
            } else {
                System.out.println("wawa");
            }
            char1 = guess.charAt(0);
            String char2 = Character.toString(char1);

        }
    }
    public static void main(String[] args) {

            SwingUtilities.invokeLater(new App());

    }
        //f.add(button);
}
class App implements Runnable {

    public void run() {
        WordFrame ex = new WordFrame();
        JFrame exe = ex.wordFrame();
        exe.setVisible(true);
    }
}