import javax.swing.*;
import javax.swing.plaf.InternalFrameUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import java.awt.*;

public class DrawingFrame extends HangmanDrawing {
    static int guessNumber;
    static JInternalFrame drawingFrame;
    public static void drawingFrame() {
        drawingFrame = new JInternalFrame(){
            @Override
            public void setUI(InternalFrameUI ui){
            super.setUI(ui);
            BasicInternalFrameUI frameUI = (BasicInternalFrameUI) getUI();
            if(frameUI!=null){frameUI.setNorthPane(null);}
        }};
        drawingFrame.setContentPane(new Canvas());
        drawingFrame.setBackground(Color.lightGray);
        drawingFrame.setPreferredSize(new Dimension(250,250));

        drawingFrame.setVisible(true);
    }

    public static void update_drawingFrame(){
        drawingFrame.getContentPane().repaint();
        Main.frameMain.revalidate();
    }

}
