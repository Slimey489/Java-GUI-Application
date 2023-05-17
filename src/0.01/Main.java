import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

    public static void main(String[] args) {
        final JFrame f = new JFrame();
        final Container contentpane = f.getContentPane();
        String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M",
                                "O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        SpringLayout layout = new SpringLayout();
        JButton button = new JButton("Enter");
        JTextField guess = new JTextField("     ");
        JLabel lb1 = new JLabel("Enter Guess:");
        JLabel A = new JLabel(alphabet[0]);
        layout.putConstraint(SpringLayout.WEST, lb1, 10, SpringLayout.WEST, contentpane);
        layout.putConstraint(SpringLayout.NORTH, lb1, 20, SpringLayout.NORTH, contentpane);
        layout.putConstraint(SpringLayout.WEST, guess, 80, SpringLayout.WEST, lb1);
        layout.putConstraint(SpringLayout.NORTH, guess, 20, SpringLayout.NORTH, contentpane);

        //f.add(button);
        f.add(lb1);
        f.add(guess);
        f.add(A);

        
        f.setSize(500, 400);
        contentpane.setLayout(layout);
        f.setVisible(true);
        contentpane.setVisible(true);

    }
}