import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        frameError.setTitle("Error");
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
                if (Main.callingclass.equals(Main.action.class)){
                    Main.frameMain.setVisible(true);
                }
                else if (Main.callingclass.equals(WordFrame.action.class)) {
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