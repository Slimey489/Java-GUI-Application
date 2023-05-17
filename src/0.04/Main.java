import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

class Main extends JFrame{
    public JFrame frameWord;
    public JButton enterWord;x
    public JTextField wordField;
    public Dimension originalSize, newSize;
    SpringLayout layout2;

    public String word;
    public String[] wordArray;
    public ArrayList<String> arrayWord;
    public Container contentpane;
    public JLabel labelWord;
     public JFrame wordFrame(){
         frameWord = new JFrame();
         enterWord = new JButton("Enter");
         contentpane = frameWord.getContentPane();
         enterWord.addActionListener(new action());
         frameWord.addComponentListener(new ResizeListener());
         layout2 = new SpringLayout();
         wordField = new JTextField(8);
         labelWord = new JLabel("Enter a Word:");

         layout2.putConstraint(SpringLayout.EAST, enterWord, -5, SpringLayout.EAST, contentpane);
         layout2.putConstraint(SpringLayout.NORTH, enterWord, 50, SpringLayout.NORTH, contentpane);
         layout2.putConstraint(SpringLayout.EAST, wordField, -5, SpringLayout.EAST, contentpane);
         layout2.putConstraint(SpringLayout.NORTH, wordField, 20, SpringLayout.NORTH, contentpane);
         layout2.putConstraint(SpringLayout.WEST, labelWord, 10, SpringLayout.WEST, contentpane);
         layout2.putConstraint(SpringLayout.NORTH, labelWord, 20, SpringLayout.NORTH, contentpane);

         enterWord.setSize(30, 20);
         frameWord.add(labelWord);
         frameWord.add(enterWord);
         frameWord.add(wordField);
         frameWord.setSize(210, 140);
         originalSize = frameWord.getSize();
         contentpane.setLayout(layout2);

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

class App implements Runnable {

    public void run() {
        Scratch ex = new Scratch();
        JFrame exe = ex.wordFrame();
        exe.setVisible(true);
    }
}