import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Main {
    
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
        String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N",
                "O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        SpringLayout layout = new SpringLayout();
        JButton button = new JButton("Enter");
        JTextField guess = new JTextField("     ");
        JLabel lb1 = new JLabel("Enter Guess:");

        layout.putConstraint(SpringLayout.WEST, lb1, 10, SpringLayout.WEST, contentpane);
        layout.putConstraint(SpringLayout.NORTH, lb1, 20, SpringLayout.NORTH, contentpane);
        layout.putConstraint(SpringLayout.WEST, guess, 80, SpringLayout.WEST, lb1);
        layout.putConstraint(SpringLayout.NORTH, guess, 20, SpringLayout.NORTH, contentpane);
        int i = 0;

        String letter = " ";
        JLabel A = new JLabel(letter);
        while (i <= 25) {

            letter = alphabet[i];
            A = new JLabel(letter);
            f.add(A);
            layout.putConstraint(SpringLayout.WEST, A, (i * 20 + 20), SpringLayout.WEST, contentpane);
            if (i < 13){
            layout.putConstraint(SpringLayout.NORTH, A, 70, SpringLayout.NORTH, contentpane);
            }else {
                layout.putConstraint(SpringLayout.NORTH, A, 50, SpringLayout.NORTH, contentpane);
            }
            i++;
        }

        //f.add(button);x
        f.add(lb1);
        f.add(guess);
        f.add(A);
        //letter = alphabet[1];
        //f.add(A);


        f.setSize(500, 400);
        contentpane.setLayout(layout);
        f.setVisible(true);
        contentpane.setVisible(true);

    }
}