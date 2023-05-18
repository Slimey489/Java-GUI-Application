import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

class WordFrame extends JFrame {
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


    public JFrame wordFrame() {

        frameWord = new JFrame();
        frameWord.setTitle("Hangman");
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

    class action implements ActionListener {
        String wordLowerCase;

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == enterWord) {
                word = wordField.getText();
                if (Objects.equals(word, "")) {
                    ErrorFrame.error = "No Word Entered.";
                    Main.callingclass = Main.findCallingClass();
                    SwingUtilities.invokeLater(new ErrorHandler());
                    frameWord.dispatchEvent(new WindowEvent(frameWord, WindowEvent.WINDOW_CLOSING));
                    return;
                }
                frameWord.dispatchEvent(new WindowEvent(frameWord, WindowEvent.WINDOW_CLOSING));

                wordLowerCase = word.toLowerCase(Locale.ROOT);
                wordArray = wordLowerCase.split("");

                arrayWord = new ArrayList<>(Arrays.asList(wordArray));
                Main classinstance = new Main();
                classinstance.GuessFrame();
            }
        }
    }

    class ResizeListener implements ComponentListener {

        public void componentHidden(ComponentEvent e) {
        }

        public void componentMoved(ComponentEvent e) {
        }

        public void componentShown(ComponentEvent e) {
        }

        public void componentResized(ComponentEvent e) {
            newSize = e.getComponent().getBounds().getSize();
            if (newSize != originalSize) {
                frameWord.setSize(originalSize);

            }
        }
    }
}
