import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
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
        // nltr = Number of Letters per row
        //int nltr = 8;
        //number of rows
        int row = 4;

        double nltr2 = 0;
        nltr2 = ((26/row)-1);
        MathContext m = new MathContext(1, RoundingMode.UP);
        BigDecimal md = new BigDecimal(nltr2,m);
        int im = md.intValue();
        int x = 1;
        int nltr = im;
        String letter = " ";
        JLabel A = new JLabel(letter);
        while (i <= 25) {
            int v = 0;
            if (i ==11){
                System.out.print("w");
            }
            if (i > nltr){v = i-nltr;}
            else{v = v + i;}

            String rst = "N";
            letter = alphabet[i];
            A = new JLabel(letter);
            f.add(A);

            if (v == nltr){
                v = 0;
            }
                layout.putConstraint(SpringLayout.WEST, A, (v * 20 + 20), SpringLayout.WEST, contentpane);
                layout.putConstraint(SpringLayout.NORTH, A, (x * 20 + 50), SpringLayout.NORTH, contentpane);

            // v gets reset for every new row as it is the offset from the left
            // x  gets reset for every new row as it is the offset from the top
            /*
            if (i < nltr){
                layout.putConstraint(SpringLayout.WEST, A, (v * 20 + 20), SpringLayout.WEST, contentpane);
                layout.putConstraint(SpringLayout.NORTH, A, (x*20+20), SpringLayout.NORTH, contentpane);
            }else {
                if (i == nltr){v = 0;}
                layout.putConstraint(SpringLayout.WEST, A, (v*20+20), SpringLayout.WEST, contentpane);
                layout.putConstraint(SpringLayout.NORTH, A, (x*20+20), SpringLayout.NORTH, contentpane);
            }
            */
            i++;
            if (i%nltr ==0){
                x++;
            }
        }

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