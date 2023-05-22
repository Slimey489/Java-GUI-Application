import javax.swing.*;
import javax.swing.plaf.InternalFrameUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import java.awt.*;

import static javax.swing.UIManager.getUI;

public class DrawingFrame extends DrawHangman{
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
        drawingFrame.getContentPane().setBackground(Color.blue);
        //drawingFrame.setSize(250, 250);
        drawingFrame.setLocation(300,0);
        drawingFrame.setVisible(true);
    }

    public void update_drawingFrame(){
        drawingFrame.repaint();
        Main.frameMain.revalidate();
    }

}
