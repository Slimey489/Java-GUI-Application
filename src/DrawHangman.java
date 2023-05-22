import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;


class DrawHangman {

    static class Canvas extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            switch (DrawingFrame.guessNumber) {
                case 0->{
                }

                //Ground
                case 1 -> {
                    g2.draw(new Line2D.Double(301, 155, 499, 155));
                }

                //Vertical Strut
                case 2 -> {
                    g2.draw(new Rectangle2D.Double(320, 20, 5, 135));
                }

                //Right Lower Support
                case 3 -> {
                    g2.draw(new Line2D.Double(325, 145, 345, 155));
                    g2.draw(new Line2D.Double(325, 140, 354.5, 155));
                }

                //Left Lower Support
                case 4 -> {
                    g2.draw(new Line2D.Double(320, 145, 310, 155));
                    g2.draw(new Line2D.Double(320, 140, 325, 155));
                }

                //Upper Support
                case 5 -> {
                    g2.draw(new Line2D.Double(325, 32, 332.5, 25));
                    g2.draw(new Line2D.Double(325, 37, 337, 25));
                }
                case 6 -> {

                    //Horizontal Strut
                    g2.draw(new Rectangle2D.Double(325, 20, 70, 5));
                }

                //Noose
                case 7 -> {
                    g2.draw(new Line2D.Double(390, 20, 390, 50));
                    g2.draw(new Line2D.Double(392, 20, 394, 26));
                    g2.draw(new Line2D.Double(390, 20, 392, 26));
                }

                //Head
                case 8 -> {
                    g2.draw(new Ellipse2D.Double(280, 50, 20, 20));
                }

                //Arms
                case 9 -> {
                    g2.draw(new Line2D.Double(305, 85, 275, 85));
                }

                //Body
                case 10 -> {
                    g2.draw(new Line2D.Double(390, 70, 390, 110));
                }

                //Left Leg
                case 11 -> {
                    g2.draw(new Line2D.Double(390, 110, 380, 135));
                }

                //Right Leg
                case 12 -> {
                    g2.draw(new Line2D.Double(390, 110, 400, 135));
                }
                default -> {
                    ErrorFrame.error = "You are out of guesses";
                    SwingUtilities.invokeLater(new ErrorHandler());
                }
            }
        }
    }
}